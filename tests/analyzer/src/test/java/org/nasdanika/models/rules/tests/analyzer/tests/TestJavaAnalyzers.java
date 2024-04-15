package org.nasdanika.models.rules.tests.analyzer.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Test;
import org.nasdanika.common.Context;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.models.coverage.ModuleCoverage;
import org.nasdanika.models.java.CompilationUnit;
import org.nasdanika.models.java.Type;
import org.nasdanika.models.java.util.JavaParserResourceFactory;
import org.nasdanika.models.java.util.ModuleCoverageProvider;
import org.nasdanika.models.rules.Action;
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.NotifierInspector;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.Severity;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.models.rules.java.CreateCompilationUnitAction;
import org.nasdanika.ncore.Tree;
import org.nasdanika.ncore.TreeItem;
import org.nasdanika.ncore.util.DirectoryContentFileURIHandler;
/**
 * Tests of java analyzers
 */
public class TestJavaAnalyzers {
	
	protected void consumeInspectionResult(Notifier target, InspectionResult inspectionResult) {
		System.out.println("[" + inspectionResult.eClass().getName() +"] " + inspectionResult.getName());
		System.out.println("\tTarget: " + target);
		System.out.println("\tRule: " + inspectionResult.getRule().getName());
		Severity severity = inspectionResult.getRule().getSeverity();
		if (severity != null) {
			System.out.println("\tSeverity: " + severity.getId() + " " + severity.getDescription());
		}
		System.out.println("\tRule set: " + ((RuleSet) inspectionResult.getRule().eContainer()).getName());
		
		if (inspectionResult instanceof Violation) {
			Violation violation = (Violation) inspectionResult;
			for (Action va: violation.getActions()) {
				if (va instanceof CreateCompilationUnitAction) {
					CreateCompilationUnitAction ccua = (CreateCompilationUnitAction) va;
					CompilationUnit cu = ccua.getCompilationUnit();
					System.out.println(cu.generate());
				}
			}
		}
	}
	
	@Test
	public void testGenerateTestsForLowCoverage() throws IOException {
		// Copying graph sources to target
		File projectDir = new File("../../../coverage/model/testData").getCanonicalFile();
		File targetProjectDir = new File("target/test-data");
		targetProjectDir.mkdirs();
		org.nasdanika.common.Util.copy(projectDir, targetProjectDir, true, null);
				
		File jacocoExec = new File(targetProjectDir, "target/jacoco.exec");
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ModuleCoverage moduleCoverage = ModuleCoverage.loadJacoco("org.nasdanika.graph", jacocoExec, new File(targetProjectDir, "target/classes"));
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("java", new JavaParserResourceFactory(new ModuleCoverageProvider(moduleCoverage)));		
		URIHandler fileDirectoryURIHandler = new DirectoryContentFileURIHandler();
		resourceSet.getURIConverter().getURIHandlers().add(0, fileDirectoryURIHandler);
		
		URI sourceDirURI = URI.createFileURI(new File(targetProjectDir, "src/main/java").getCanonicalPath()).appendSegment("");		
		Resource dirResource = resourceSet.getResource(sourceDirURI, true);
		
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		Inspector<Object> inspector = Inspector.load(null, progressMonitor);
		
		// Visiting only Java 
		Predicate<Notifier> predicate = obj -> {
			if (obj instanceof TreeItem) {
				return obj instanceof Tree || ((TreeItem) obj).getName().endsWith(".java");
			}
			return true;
		};
		
		Map<Notifier, Collection<InspectionResult>> results = new LinkedHashMap<>();
		
		NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
		notifierInspector
			.asContentsInspector(false, predicate)
			.inspect(
					dirResource, 
					(target, result) -> results.computeIfAbsent(target, t -> new ArrayList<>()).add(result), 
					Context.EMPTY_CONTEXT, 
					progressMonitor);
						
		// Grouping compilation units by package and name and then merging (reducing)
		List<CompilationUnit> compilationUnitsToCreate = results
			.values()
			.stream()
			.flatMap(Collection::stream)
			.filter(Violation.class::isInstance)
			.map(Violation.class::cast)
			.flatMap(v -> v.getActions().stream())
			.filter(CreateCompilationUnitAction.class::isInstance)
			.map(CreateCompilationUnitAction.class::cast)
			.map(CreateCompilationUnitAction::getCompilationUnit)
			.toList();
			
		for (Entry<String, List<CompilationUnit>> packageEntry:  Util.groupBy(compilationUnitsToCreate, CompilationUnit::getPackageName).entrySet()) {
			for (Entry<String, List<CompilationUnit>> compilationUnitEntry: Util.groupBy(packageEntry.getValue(), CompilationUnit::getName).entrySet()) {
				CompilationUnit mergedCompilationUnit = compilationUnitEntry.getValue().stream().reduce(this::merge).get();
				File mergedCompilationUnitFile = new File("target/generated-tests/" + mergedCompilationUnit.getPackageName().replace('.', '/') + "/" + mergedCompilationUnit.getName());
				mergedCompilationUnitFile.getParentFile().mkdirs();
				Resource mergedCompilationUnitResource = resourceSet.createResource(URI.createFileURI(mergedCompilationUnitFile.getAbsolutePath()));
				mergedCompilationUnitResource.getContents().add(mergedCompilationUnit);
				mergedCompilationUnitResource.save(null);
			}
		}			
	}
	
	protected CompilationUnit merge(CompilationUnit a, CompilationUnit b) {
		if (b == null) {
			return a;
		}
		
		if (a == null) {
			return b;
		}
		
		CompilationUnit ret = EcoreUtil.copy(a);
		
		// Merge imports
		for (String bImport: b.getImports()) {
			EList<String> retImports = ret.getImports();
			if (!retImports.contains(bImport)) {
				retImports.add(bImport);
			}
		}
		
		// Merge Types
		Z: for (Type bType: b.getTypes()) {
			for (Type retType: ret.getTypes()) {
				if (bType.getName().equals(retType.getName())) {
					retType.getMembers().addAll(EcoreUtil.copyAll(bType.getMembers()));
					continue Z;
				}
			}
			ret.getTypes().add(EcoreUtil.copy(bType));
		}
		
		return ret;
	}
	
}

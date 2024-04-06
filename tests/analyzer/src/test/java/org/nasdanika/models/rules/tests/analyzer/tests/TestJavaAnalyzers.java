package org.nasdanika.models.rules.tests.analyzer.tests;

import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Test;
import org.nasdanika.common.Context;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.coverage.ModuleCoverage;
import org.nasdanika.models.java.util.JavaParserResourceFactory;
import org.nasdanika.models.java.util.ModuleCoverageProvider;
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.NotifierInspector;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.Severity;
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
		
	}
	
	@Test
	public void testAttachCoverage() throws IOException {
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
		NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
		notifierInspector
			.asContentsInspector(false, predicate)
			.inspect(
					dirResource, 
					this::consumeInspectionResult, 
					Context.EMPTY_CONTEXT, 
					progressMonitor);				
	}
				
}

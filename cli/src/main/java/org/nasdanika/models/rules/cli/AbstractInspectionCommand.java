package org.nasdanika.models.rules.cli;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
//import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.nasdanika.cli.ContextMixIn;
import org.nasdanika.cli.ResourceSetMixIn;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.models.rules.Failure;
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.NotifierInspector;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.Severity;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.ncore.Tree;
import org.nasdanika.ncore.TreeItem;
import org.springframework.util.AntPathMatcher;

import picocli.CommandLine.Mixin;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

/**
 * Base abstract class for commands performing inspections using rules and inspectors
 */
public abstract class AbstractInspectionCommand extends AbstractInspectorCommand {
	
	@Mixin 
	private ResourceSetMixIn resourceSetMixIn;
	
	/**
	 * @return A list of root URI's to start scan from.
	 */
	protected abstract List<URI> getInputs(); 

// 	One option to implement roots for local files and directories
//	call .appendSegment("/") for directories
//	@Parameters(description = {
//			"Files and directories",
//			"to inspect"
//	})
//	File[] inputs;
	
	@Option(
			names = {"-e", "--exclude-resource"},
			arity = "*",
			description = {
					"Resources to exclude from inspection",
					"Ant pattern"
				})
	private String[] resourceExcludes;
	
	protected String[] getResourceExcludes() {
		return resourceExcludes;
	}
	
	@Option(
			names = {"-i", "--include-resource"},
			arity = "*",
			description = {
					"Resources to include in inspection",
					"Ant pattern"
				})
	private String[] resourceIncludes;
	
	protected String[] getResourceIncludes() {
		return resourceIncludes;
	}
	
	@Option(
			names = "--exclude-type",
			arity = "*",
			description = "Target types to exclude"
			)
	protected String[] typeExcludes;
	
	@Option(
			names = "--include-type",
			arity = "*",
			description = "Target types to include"
			)
	protected String[] typeIncludes;
		
	@Option(
			names = {"-f", "--fail-on"},
			description = "Names of severities to fail on"
			)
	private String[] failOnSeverities;
	
	@Option(
			names = "--parallel",
			description = "Parallel inspection"
			)
	private boolean parallel;
	
	@Option(
			names = "--stop-on-first-fail",
			description = "Stop on first failure"
			)
	private boolean stopOnFirstFailure;
	
	@Option(
			names = "--limit",
			description = "Max number of results to report"
			)
	private int limit;
		
	/**
	 * Obtains {@link ResourceSet} from resourceSetMixIn.
	 * Override for additional configuration
	 * @param progressMonitor
	 * @return
	 */
	protected ResourceSet createResourceSet(ProgressMonitor progressMonitor) {		
		return resourceSetMixIn.createResourceSet(progressMonitor);
	}
	
	protected boolean isFailOnSeverity(Severity severity) {
		if (severity != null && failOnSeverities != null) {
			for (String sName: failOnSeverities) {
				if (severity.getName().equals(sName.trim())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	protected Resource getResource(Notifier notifier) {
		if (notifier instanceof Resource) {
			return (Resource) notifier;
		}
		if (notifier instanceof EObject) {
			return ((EObject) notifier).eResource();
		}
		return null;
	}
		
	protected Predicate<Notifier> createPredicate(URI baseURI) {
		return obj -> match(obj, baseURI);
	}
	
	protected boolean isIncluded(String path) {
		String[] includes = getResourceIncludes();
		
		if (includes == null || includes.length == 0) {
			return false;
		}
		
		AntPathMatcher matcher = new AntPathMatcher();
		for (String include: includes) {
			if (matcher.match(include, path)) {
				return true;
			}
		}
		
		return false;
	}
	
	protected boolean isExcluded(String path) {
		String[] excludes = getResourceExcludes();
		
		if (excludes == null || excludes.length == 0) {
			return false;
		}
		AntPathMatcher matcher = new AntPathMatcher();
		for (String exclude: excludes) {
			if (matcher.match(exclude, path)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	protected boolean match(Notifier obj, URI baseURI) {
		URI resourceURI = getResource(obj).getURI();
		if (Objects.equals(baseURI, resourceURI)) {
			return true; // Explicitly listed in inputs
		}
		
		if (obj instanceof Tree) {
			return true;
		}
		
		// Matching type
		if ((typeIncludes != null || typeExcludes != null) && obj instanceof EObject) {
			EClass type = ((EObject) obj).eClass();
			if (typeIncludes != null) {
				if (!matchType(type, typeIncludes)) {
					return false;
				}
			}
			if (typeExcludes != null) {
				if (matchType(type, typeExcludes)) {
					return false;
				}
			}
		}
				
		if (obj instanceof TreeItem) {
			String name = ((TreeItem) obj).getName();
			URI uri = URI.createURI(name).resolve(resourceURI);
			String path = uri.deresolve(baseURI).toString();

			if (!isIncluded(path)) {
				return false;
			}
			
			if (isExcluded(path)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Mixin
	private ContextMixIn contextMixIn;
	
	@Spec CommandSpec spec;
	
	@Override
	public Integer call() throws Exception {
		List<URI> inputs = getInputs();
		if (inputs == null || inputs.isEmpty()) {
			// Should be handled by inputs arity
			throw new ParameterException(spec.commandLine(), "At least one input is required");
		}
		
		Map<Notifier, List<InspectionResult>> inspectionResults = Collections.synchronizedMap(new LinkedHashMap<>());
		AtomicInteger counter = new AtomicInteger();
		AtomicBoolean failed = new AtomicBoolean();
		BiPredicate<? super Notifier, ? super InspectionResult> inspectionResultConsumer = (target, inspectionResult) -> {
			inspectionResults.computeIfAbsent(target, key -> Collections.synchronizedList(new ArrayList<>())).add(inspectionResult);
			if (isFail(inspectionResult)) {
				failed.set(true);				
			}
			if (stopOnFirstFailure && failed.get()) {
				return false;
			}
			return limit == 0 || counter.incrementAndGet() < limit;
		};
		
		try (ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(4 + inputs.size())) {
			ResourceSet resourceSet = createResourceSet(progressMonitor.split("Creating Resource Set", 1));
			Inspector<Object> inspector = loadInspector(progressMonitor.split("Loading Inspector", 1));
			NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
			Context context = contextMixIn.createContext(progressMonitor.split("Creating context", 1));
			for (URI input: inputs) {
				try (ProgressMonitor inputProgressMonitor = progressMonitor.split("Inspecting " + input, 1)) {
					Resource inputResource = resourceSet.getResource(input, true);
					notifierInspector
						.asContentsInspector(parallel, createPredicate(input))
						.inspect(
							inputResource, 
							inspectionResultConsumer, 
							context, 
							inputProgressMonitor);					
				}
			}
			
			Map<Resource, List<Map.Entry<Notifier, List<InspectionResult>>>> groupedByResource = Util.groupBy(inspectionResults.entrySet(), e -> getResource(e.getKey()));
			generateReport(groupedByResource, progressMonitor.split("Generating report", 1));
			
			return failed.get() ? 1 : 0;
		}
	}
	
	protected boolean isFail(InspectionResult inspectionResult) {
		if (inspectionResult instanceof Failure) {
			return true;
		}
		if (inspectionResult instanceof Violation) {
			Rule rule = inspectionResult.getRule();
			if (rule != null && isFailOnSeverity(rule.getSeverity())) {
				return true;
			}
		}
		return false;
	}
	
	protected abstract void generateReport(Map<Resource, List<Map.Entry<Notifier, List<InspectionResult>>>> results, ProgressMonitor progressMonitor);
	
	/**
	 * Subclasses may leverage this method to output findings as text
	 * @param results
	 * @param out
	 * @param progressMonitor
	 */
	protected void generateTextReport(
			Map<Resource, List<Map.Entry<Notifier, List<InspectionResult>>>> results, 
			PrintStream out,
			ProgressMonitor progressMonitor) {
		
		for (Entry<Resource, List<Entry<Notifier, List<InspectionResult>>>> resultEntry: results.entrySet().stream().sorted((a, b) -> a.getKey().getURI().toString().compareTo(b.getKey().getURI().toString())).toList()) {
			out.println(resultEntry.getKey().getURI());
			for (Entry<Notifier, List<InspectionResult>> notifierEntry: resultEntry.getValue()) {
				for (InspectionResult inspectionResult: notifierEntry.getValue()) {
					printInspectionResult(inspectionResult, out);
				}
			}
		}		
	}
	
	protected void printInspectionResult(InspectionResult inspectionResult, PrintStream out) {
		out.println("\t[" + inspectionResult.eClass().getName() + "] " + inspectionResult.getName());
		Rule rule = inspectionResult.getRule();
		if (rule != null) {
			out.println("\t\tRule: " + rule.getName());
			EObject ruleContainer = rule.eContainer();
			if (ruleContainer instanceof RuleSet) {
				out.println("\t\tRule set: " + ((RuleSet) ruleContainer).getName());
			}
		}		
	}
		
	public boolean matchType(EClassifier eClassifier, String[] types) {
		if (types != null && eClassifier != null) {
			for (String type: types) {
				URI typeURI = URI.createURI(type);
				if (typeURI.hasFragment()) {
					URI ePackageNsURI = typeURI.trimFragment();
					EPackage ePackage = eClassifier.getEPackage();
					if (ePackageNsURI.equals(URI.createURI(ePackage.getNsURI()))) {
						String fragment = typeURI.fragment();
						if (fragment.startsWith("//")) {
							String eClassifierName = fragment.substring(2);
							if (eClassifierName.equals(eClassifier.getName())) {
								return true;
							}
						} 
					}
					continue;
				}
				
				int dotIdx = type.indexOf('.');
				if (dotIdx == -1) {
					String name = eClassifier.getName();
					for (EPackage ePkg = eClassifier.getEPackage(); ePkg != null; ePkg = ePkg.getESuperPackage()) {
						name = ePkg.getName() + "." + name;
					}
					if (type.equals(name)) {
						return true;
					}
					continue;
				}
				
				if (type.equals(eClassifier.getName())) {
					return true;
				}
			}
			
			if (eClassifier instanceof EClass) {
				for (EClass superType: ((EClass) eClassifier).getESuperTypes()) {
					if (matchType(superType, types)) {
						return true;
					}
				}
			}			
		}
		
		return false;
	}	

}

package org.nasdanika.models.rules.cli;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
//import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.nasdanika.cli.ContextCommand;
import org.nasdanika.cli.ProgressMonitorMixIn;
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
 * Base abstract class for rules/inspector commands
 */
public abstract class AbstractRulesCommand extends ContextCommand {
	
	@Mixin
	private ProgressMonitorMixIn progressMonitorMixIn;
	
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
			names = {"-e", "--exclude"},
			arity = "*",
			description = {
					"Resources to exclude from inspection",
					"Ant pattern"
				})
	private String[] excludes;
	
	protected String[] getExcludes() {
		return excludes;
	}
	
	@Option(
			names = {"-i", "--include"},
			arity = "*",
			description = {
					"Resources to include in inspection",
					"Ant pattern"
				})
	private String[] includes;
	
	protected String[] getIncludes() {
		return includes;
	}
		
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
	
	/**
	 * Obtains {@link ResourceSet} from resourceSetMixIn.
	 * Override for additional configuration
	 * @param progressMonitor
	 * @return
	 */
	protected ResourceSet createResourceSet(ProgressMonitor progressMonitor) {		
		return resourceSetMixIn.createResourceSet(progressMonitor);
	}
	
	protected Object getInspectorRequirement() {
		return null;
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
	
	/**
	 * Uses Inspector.load
	 * @param progressMonitor
	 * @return
	 */
	protected Inspector<Object> loadInspector(ProgressMonitor progressMonitor) {
		return Inspector.load(getInspectorRequirement(), progressMonitor);
	}
	
	protected Predicate<Notifier> createPredicate(URI baseURI) {
		return obj -> match(obj, baseURI);
	}
	
	protected boolean isIncluded(String path) {
		String[] includes = getIncludes();
		
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
		String[] excludes = getExcludes();
		
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
	
	@Spec CommandSpec spec;
	
	@Override
	public Integer call() throws Exception {
		List<URI> inputs = getInputs();
		if (inputs == null || inputs.isEmpty()) {
			// Should be handled by inputs arity
			throw new ParameterException(spec.commandLine(), "At least one input is required");
		}
		
		Map<Notifier, List<InspectionResult>> inspectionResults = Collections.synchronizedMap(new LinkedHashMap<>());
		
		try (ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(4 + inputs.size())) {
			ResourceSet resourceSet = createResourceSet(progressMonitor.split("Creating Resource Set", 1));
			Inspector<Object> inspector = loadInspector(progressMonitor.split("Loading Inspector", 1));
			NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
			Context context = createContext(progressMonitor.split("Creating context", 1));
			for (URI input: inputs) {
				try (ProgressMonitor inputProgressMonitor = progressMonitor.split("Inspecting " + input, 1)) {
					Resource inputResource = resourceSet.getResource(input, true);
					notifierInspector
						.asContentsInspector(parallel, createPredicate(input))
						.inspect(
							inputResource, 
							(target, inspectionResult) -> inspectionResults.computeIfAbsent(target, key -> Collections.synchronizedList(new ArrayList<>())).add(inspectionResult), 
							context, 
							inputProgressMonitor);					
				}
			}
			
			Map<Resource, List<Map.Entry<Notifier, List<InspectionResult>>>> groupedByResource = Util.groupBy(inspectionResults.entrySet(), e -> getResource(e.getKey()));
			generateReport(groupedByResource, progressMonitor.split("Generating report", 1));
			
			Optional<InspectionResult> failure = inspectionResults
				.values()
				.stream()
				.flatMap(Collection::stream)
				.filter(this::isFail)
				.findAny();
			
			return failure.isPresent() ? 1 : 0;
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

}

package org.nasdanika.models.rules.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.cli.ContextCommand;
import org.nasdanika.cli.ProgressMonitorMixIn;
import org.nasdanika.common.Context;
import org.nasdanika.common.Diagnostic;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.emf.persistence.EObjectCapabilityFactory;
import org.nasdanika.html.model.app.graph.emf.ActionGenerator;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.ncore.util.NcoreUtil;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;


@Command(
		description = "Generates rule set documentation action model",
		versionProvider = ModuleVersionProvider.class,		
		mixinStandardHelpOptions = true,
		name = "action-model")
public class ActionModelCommand extends ContextCommand {
		
	@Parameters(
		index =  "0",	
		arity = "1",
		description = {  
			"Model URI or file path, resolved relative",
			"to the current directory",
			"or looked up in registered rule sets",
			"if -R option is provided"
		})
	private String model;
		
	@Option(
		names = {"-R", "--registered"},
		description = {
			"Use registered rule set",
			"with provided URI"
		})
	private boolean registered;
	
	@Option(
		names = {"-f", "--file"},
		description = "Mdel parameter is a file path")
	private boolean isFile;
	
	@Mixin
	private ProgressMonitorMixIn progressMonitorMixIn;	 	

	@Parameters(index =  "1", description = "Output file")
	private File output;
		
	@Override
	public Integer call() throws Exception {
		try (ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(3)) {
			RuleSet ruleSet = getRuleSet(progressMonitor.split("Loading rule set", 1));
			
			Consumer<Diagnostic> diagnosticConsumer = d -> d.dump(System.out, 0);		
			Context context = createContext(progressMonitor.split("Creating context", 1));
			try (ProgressMonitor actionGeneratorProgressMonitor = progressMonitor.split("Generating action model", 1)) {
				ActionGenerator actionGenerator = ActionGenerator.load(ruleSet, context, null, null, null, actionGeneratorProgressMonitor); 
				actionGenerator.generateActionModel(
						diagnosticConsumer, 
						output,
						progressMonitor);
			}			
		}
		return 0;
	}
	
	@Spec CommandSpec spec;
	
	protected RuleSet getRuleSet(ProgressMonitor progressMonitor) throws FileNotFoundException {
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		File currentDir = new File(".");
		URI baseURI = URI.createFileURI(currentDir.getAbsolutePath()).appendSegment("");
		URI modelURI = URI.createURI(model).resolve(baseURI);
		if (registered) {
			Iterable<CapabilityProvider<Object>> ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);
			Collection<RuleSet> ruleSets = Collections.synchronizedCollection(new ArrayList<>());
			for (CapabilityProvider<Object> provider: ruleSetProviders) {
				provider.getPublisher().subscribe(rs -> ruleSets.add((RuleSet) rs), error -> error.printStackTrace());
			}
			for (RuleSet ruleSet: ruleSets) {
				for (URI uri: NcoreUtil.getIdentifiers(ruleSet)) {
					if (uri.equals(modelURI)) {
						return ruleSet;
					}
				}
			}
		} else {
			if (isFile) {
				File modelFile = new File(model);
				modelURI = URI.createFileURI(modelFile.getAbsolutePath());				
			}
			Iterable<CapabilityProvider<Object>> ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(EObject.class, null, EObjectCapabilityFactory.createRequirement(modelURI)), progressMonitor);
			Collection<RuleSet> ruleSets = Collections.synchronizedCollection(new ArrayList<>());
			for (CapabilityProvider<Object> provider: ruleSetProviders) {
				provider.getPublisher().subscribe(rs -> ruleSets.add((RuleSet) rs), error -> error.printStackTrace());
			}
			for (RuleSet ruleSet: ruleSets) {
				return ruleSet;
			}
		}
		throw new ParameterException(spec.commandLine(), "Rule set not found for URI: " + modelURI);
	}

}

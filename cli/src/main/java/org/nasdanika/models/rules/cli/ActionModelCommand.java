package org.nasdanika.models.rules.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.cli.CommandBase;
import org.nasdanika.cli.ProgressMonitorMixIn;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.emf.persistence.EObjectCapabilityFactory;
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
public class ActionModelCommand extends CommandBase {
		
	@Parameters(
		index =  "0",	
		arity = "1",
		description = {  
			"Model URI, resolved relative",
			"to the current directory",
			"or looked up in registered rule sets",
			"if -R option is provided"
		})
	private String model;
		
	@Option(
			names = {"-R", "--registered"},
			description = {
					"Use registered rule set ",
					"with provided URI"
				})
	private boolean registered;
	
	@Mixin
	private ProgressMonitorMixIn progressMonitorMixIn;	 	

	@Parameters(index =  "1", description = "Output file")
	private File output;
		
	@Override
	public Integer call() throws Exception {
		RuleSet ruleSet = getRuleSet();
		System.out.println(ruleSet);
		return 0;
	}
	
	@Spec CommandSpec spec;
	
	protected RuleSet getRuleSet() throws FileNotFoundException {
		ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(1);
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		URI modelURI = URI.createURI(model);
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
			Iterable<CapabilityProvider<Object>> ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(EObject.class, null, EObjectCapabilityFactory.createRequirement(modelURI)), progressMonitor);
			Collection<RuleSet> ruleSets = Collections.synchronizedCollection(new ArrayList<>());
			for (CapabilityProvider<Object> provider: ruleSetProviders) {
				provider.getPublisher().subscribe(rs -> ruleSets.add((RuleSet) rs), error -> error.printStackTrace());
			}
			for (RuleSet ruleSet: ruleSets) {
				return ruleSet;
			}
		}
		throw new ParameterException(spec.commandLine(), "Registered rule set not found for URI: " + modelURI);
	}

}

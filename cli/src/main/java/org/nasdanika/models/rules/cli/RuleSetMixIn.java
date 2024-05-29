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
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.emf.persistence.EObjectCapabilityFactory;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.ncore.util.NcoreUtil;

import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

/**
 * Mix-in for loading a rule set - loaded from capability or external URI
 */
public class RuleSetMixIn {
		
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
	
	@Spec CommandSpec spec;
			
	public RuleSet getRuleSet(String model, ProgressMonitor progressMonitor) throws FileNotFoundException {
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

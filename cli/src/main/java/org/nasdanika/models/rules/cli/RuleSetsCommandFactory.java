package org.nasdanika.models.rules.cli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletionStage;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.cli.SubCommandCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.RuleSet;

import picocli.CommandLine;

/**
 * Base class for factories of commands operating on rule sets.
 * @param <T>
 */
public abstract class RuleSetsCommandFactory<T> extends SubCommandCapabilityFactory<T> {

	@Override
	protected CompletionStage<T> doCreateCommand(
			List<CommandLine> parentPath, 
			Loader loader,
			ProgressMonitor progressMonitor) {
		
		CompletionStage<Iterable<CapabilityProvider<Object>>> ruleSetCS = loader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);	
		return ruleSetCS.thenApply(this::createCommand);			
	}
	
	protected T createCommand(Iterable<CapabilityProvider<Object>> ruleSetProviders) {		
		Collection<RuleSet> ruleSets = Collections.synchronizedCollection(new ArrayList<>());
		for (CapabilityProvider<Object> provider: ruleSetProviders) {
			provider.getPublisher().subscribe(rs -> ruleSets.add((RuleSet) rs), error -> error.printStackTrace());
		}
				
		return createCommand(ruleSets);		
	}
	
	protected abstract T createCommand(Collection<RuleSet> ruleSets);
	
}

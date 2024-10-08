package org.nasdanika.models.rules.tests.rules;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesFactory;

import reactor.core.publisher.Flux;

public class NopRuleSetFactory extends ServiceCapabilityFactory<Object, RuleSet> {

	@Override
	public boolean isFor(Class<?> type, Object requirement) {
		return type == RuleSet.class;
	}

	@Override
	protected CompletionStage<Iterable<CapabilityProvider<RuleSet>>> createService(
			Class<RuleSet> serviceType, 
			Object serviceRequirement,
			Loader loader,
			ProgressMonitor progressMonitor) {
		
		CapabilityProvider<RuleSet> capabilityProvider = new CapabilityProvider<RuleSet>() {

			@Override
			public Flux<RuleSet> getPublisher() {
				return Flux.just(RulesFactory.eINSTANCE.createRuleSet());
			}
			
		};
		
		return CompletableFuture.completedStage(Collections.singleton(capabilityProvider));
	}

}

package org.nasdanika.models.rules.tests.inspectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletionStage;
import java.util.function.Predicate;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.InspectorCapabilityFactory;
import org.nasdanika.models.rules.reflection.InspectorSet;
import org.nasdanika.models.rules.reflection.RuleManager;

import reactor.core.publisher.Flux;

public class ReflectiveInspectorFactory extends InspectorCapabilityFactory<Object> {
	
	@Override
	protected CompletionStage<Iterable<CapabilityProvider<Inspector<Object>>>> createService(
			Class<Inspector<Object>> serviceType, 
			Predicate<Inspector<Object>> serviceRequirement, 
			Loader loader,
			ProgressMonitor progressMonitor) {

			JUnitTestRequirement jUnitTestRequirement = new JUnitTestRequirement(
					"5", 
					true, 
					true, 
					true, 
					false,
					false, 
					false);
			
			CompletionStage<Iterable<CapabilityProvider<Object>>> testGeneratorCS = loader.load(ServiceCapabilityFactory.createRequirement(TestGenerator.class, null, jUnitTestRequirement), progressMonitor);
			return testGeneratorCS.thenApply(testGenerators -> applyTestGenerators(testGenerators, serviceRequirement, progressMonitor));
	}
	
	protected Iterable<CapabilityProvider<Inspector<Object>>> applyTestGenerators(
			Iterable<CapabilityProvider<Object>> testGeneratorsCapabilityProviders,
			Predicate<Inspector<Object>> serviceRequirement,
			ProgressMonitor progressMonitor) {
		
		Collection<TestGenerator> testGenerators = new ArrayList<>();
		
		for (CapabilityProvider<Object> tgp: testGeneratorsCapabilityProviders) {
			tgp.getPublisher().subscribe(tg -> testGenerators.add((TestGenerator) tg));
		}

		Inspector<Object> inspector = new InspectorSet(
			RuleManager.LOADING_RULE_MANAGER, 
			serviceRequirement,
			false, 
			progressMonitor, 
			new ReflectiveInspectors(),
			new JavaCoverageReflectiveInspectors(testGenerators));
	
		if (serviceRequirement == null || serviceRequirement.test(inspector)) {		
			CapabilityProvider<Inspector<Object>> capabilityProvider = new CapabilityProvider<Inspector<Object>>() {
			
				@Override
				public Flux<Inspector<Object>> getPublisher() {			
					return Flux.just(inspector);
				}
				
			};
			
			return Collections.singleton(capabilityProvider);
		}
		
		return Collections.emptySet();
	}

}

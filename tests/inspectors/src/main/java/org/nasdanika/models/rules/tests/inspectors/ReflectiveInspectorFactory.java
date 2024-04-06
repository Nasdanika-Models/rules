package org.nasdanika.models.rules.tests.inspectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.reflection.InspectorSet;
import org.nasdanika.models.rules.reflection.RuleManager;

import reactor.core.publisher.Flux;

public class ReflectiveInspectorFactory extends ServiceCapabilityFactory<Object, Inspector<Object>> {

	@Override
	public boolean isForServiceType(Class<?> type) {
		return type == Inspector.class;
	}

	@Override
	protected CompletionStage<Iterable<CapabilityProvider<Inspector<Object>>>> createService(
			Class<Inspector<Object>> serviceType, 
			Object serviceRequirement,
			BiFunction<Object, ProgressMonitor, CompletionStage<Iterable<CapabilityProvider<Object>>>> resolver,
			ProgressMonitor progressMonitor) {

			CompletionStage<Iterable<CapabilityProvider<Object>>> testGeneratorCS = resolver.apply(ServiceCapabilityFactory.createRequirement(TestGenerator.class, null, new JUnitTestRequirement("5")), progressMonitor);
			return testGeneratorCS.thenApply(testGenerators -> applyTestGenerators(testGenerators, progressMonitor));
	}
	
	protected Iterable<CapabilityProvider<Inspector<Object>>> applyTestGenerators(
			Iterable<CapabilityProvider<Object>> testGeneratorsCapabilityProviders,
			ProgressMonitor progressMonitor) {
		
		Collection<TestGenerator> testGenerators = new ArrayList<>();
		
		for (CapabilityProvider<Object> tgp: testGeneratorsCapabilityProviders) {
			tgp.getPublisher().subscribe(tg -> testGenerators.add((TestGenerator) tg));
		}

		Inspector<Object> inspector = new InspectorSet(
			RuleManager.LOADING_RULE_MANAGER, 
			false, 
			progressMonitor, 
			new ReflectiveInspectors(),
			new JavaCoverageReflectiveInspectors(testGenerators));;
	
		CapabilityProvider<Inspector<Object>> capabilityProvider = new CapabilityProvider<Inspector<Object>>() {
		
			@Override
			public Flux<Inspector<Object>> getPublisher() {
				return Flux.just(inspector);
			}
			
		};
		
		return Collections.singleton(capabilityProvider);
	}

}

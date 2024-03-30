package org.nasdanika.models.rules.tests.inspectors;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
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
		
		Inspector<Object> inspector = new InspectorSet(
				RuleManager.LOADING_RULE_MANAGER, 
				false, 
				progressMonitor, 
				new ReflectiveInspectors(),
				new JavaCoverageReflectiveInspectors());;
		
		CapabilityProvider<Inspector<Object>> capabilityProvider = new CapabilityProvider<Inspector<Object>>() {

			@Override
			public Flux<Inspector<Object>> getPublisher() {
				return Flux.just(inspector);
			}
			
		};
		
		return CompletableFuture.completedStage(Collections.singleton(capabilityProvider));
	}

}

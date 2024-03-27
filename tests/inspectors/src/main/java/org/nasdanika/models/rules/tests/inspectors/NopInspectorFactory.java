package org.nasdanika.models.rules.tests.inspectors;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;

import reactor.core.publisher.Flux;

public class NopInspectorFactory extends ServiceCapabilityFactory<Object, Inspector<Object>> {

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
		
		CapabilityProvider<Inspector<Object>> capabilityProvider = new CapabilityProvider<Inspector<Object>>() {

			@Override
			public Flux<Inspector<Object>> getPublisher() {
				return Flux.just(Inspector.nop());
			}
			
		};
		
		return CompletableFuture.completedStage(Collections.singleton(capabilityProvider));
	}

}

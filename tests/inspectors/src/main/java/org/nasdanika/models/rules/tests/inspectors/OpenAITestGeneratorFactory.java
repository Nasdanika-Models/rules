package org.nasdanika.models.rules.tests.inspectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;

import com.azure.ai.openai.OpenAIClient;

import reactor.core.publisher.Flux;

/**
 * Provides an {@link OpenAIClient} instance.  
 */
public class OpenAITestGeneratorFactory extends ServiceCapabilityFactory<JUnitTestRequirement, TestGenerator> {

	@Override
	public boolean isForServiceType(Class<?> type) {
		return TestGenerator.class.equals(type);
	}

	@Override
	protected CompletionStage<Iterable<CapabilityProvider<TestGenerator>>> createService(
			Class<TestGenerator> serviceType, 
			JUnitTestRequirement serviceRequirement,
			BiFunction<Object, ProgressMonitor, CompletionStage<Iterable<CapabilityProvider<Object>>>> resolver,
			ProgressMonitor progressMonitor) {

			CompletionStage<Iterable<CapabilityProvider<Object>>> openAIClientCS = resolver.apply(ServiceCapabilityFactory.createRequirement(OpenAIClient.class, null, null), progressMonitor);
			return openAIClientCS.thenApply(clients -> applyClients(clients, serviceRequirement, progressMonitor));
	}
	
	protected Iterable<CapabilityProvider<TestGenerator>> applyClients(
			Iterable<CapabilityProvider<Object>> openAIClientCapabilityProviders,
			JUnitTestRequirement serviceRequirement,
			ProgressMonitor progressMonitor) {
		
		Collection<OpenAIClient> clients = new ArrayList<>();
		
		for (CapabilityProvider<Object> ccp: openAIClientCapabilityProviders) {
			ccp.getPublisher().subscribe(tg -> clients.add((OpenAIClient) tg));
		}
	
		CapabilityProvider<TestGenerator> capabilityProvider = new CapabilityProvider<TestGenerator>() {
		
			@Override
			public Flux<TestGenerator> getPublisher() {
				return Flux.fromStream(clients.stream().map(client -> new OpenAITestGenerator(client, serviceRequirement)));
			}
			
		};
		
		return Collections.singleton(capabilityProvider);
	}
	
}

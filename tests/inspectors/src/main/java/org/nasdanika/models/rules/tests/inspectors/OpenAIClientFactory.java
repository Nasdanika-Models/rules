package org.nasdanika.models.rules.tests.inspectors;

import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.KeyCredential;

/**
 * Provides an {@link OpenAIClient} instance.  
 */
public class OpenAIClientFactory extends ServiceCapabilityFactory<Object, OpenAIClient> {

	@Override
	public boolean isFor(Class<?> type, Object requirement) {
		return OpenAIClient.class.equals(type);
	}

	@Override
	protected CompletionStage<Iterable<CapabilityProvider<OpenAIClient>>> createService(
			Class<OpenAIClient> serviceType,
			Object serviceRequirement,
			BiFunction<Object, ProgressMonitor, CompletionStage<Iterable<CapabilityProvider<Object>>>> resolver,
			ProgressMonitor progressMonitor) {
		
    	String key = System.getenv("OPENAI_API_KEY");
    	if (Util.isBlank(key)) {
    		return empty();
    	}
    	
    	OpenAIClient client = new OpenAIClientBuilder()
    		    .credential(new KeyCredential(key))
    		    .endpoint("https://api.openai.com/v1/chat/completions")
    		    .buildClient();
    	
    	return wrap(client);
	}

}

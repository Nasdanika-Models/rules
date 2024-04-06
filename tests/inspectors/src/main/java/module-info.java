import org.nasdanika.capability.CapabilityFactory;
import org.nasdanika.models.rules.tests.inspectors.NopInspectorFactory;
import org.nasdanika.models.rules.tests.inspectors.OpenAIClientFactory;
import org.nasdanika.models.rules.tests.inspectors.OpenAITestGeneratorFactory;
import org.nasdanika.models.rules.tests.inspectors.ReflectiveInspectorFactory;

module org.nasdanika.models.rules.tests.inspectors {
		
	requires transitive com.azure.ai.openai;
	requires transitive com.azure.core;
	requires transitive org.nasdanika.models.rules.tests.rules;
	requires transitive org.nasdanika.models.java;
	requires org.nasdanika.models.rules; // For testing Java inspectors
	
	opens org.nasdanika.models.rules.tests.inspectors; // For reflection
	
	provides CapabilityFactory with 
		OpenAIClientFactory,
		OpenAITestGeneratorFactory,
		ReflectiveInspectorFactory,
		NopInspectorFactory;
	
}

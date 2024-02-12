import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.tests.inspectors.NopInspectorFactory;
import org.nasdanika.models.rules.tests.inspectors.ReflectiveInspectorFactory;

module org.nasdanika.models.rules.tests.inspectors {
		
	requires transitive com.azure.ai.openai;
	requires transitive com.azure.core;
	requires transitive org.nasdanika.models.rules.tests.rules;
	requires transitive org.nasdanika.models.java;
	requires org.nasdanika.models.rules; // For testing Java inspectors
	
	opens org.nasdanika.models.rules.tests.inspectors; // For reflection
	
	uses RuleSet.Factory;
	
	provides Inspector.Factory with ReflectiveInspectorFactory, NopInspectorFactory;
	
}

import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.tests.inspectors.NopInspectorFactory;

module org.nasdanika.models.rules.tests.inspectors {
		
	requires transitive org.nasdanika.models.rules.tests.rules;
	
	uses RuleSet.Factory;
	
	provides Inspector.Factory with NopInspectorFactory;
	
}

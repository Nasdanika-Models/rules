import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.tests.rules.NopRuleSetFactory;

module org.nasdanika.models.rules.tests.rules {

	requires transitive org.nasdanika.models.rules;

	provides RuleSet.Factory with NopRuleSetFactory;

}

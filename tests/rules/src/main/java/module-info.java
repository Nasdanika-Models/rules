import org.nasdanika.capability.CapabilityFactory;
import org.nasdanika.models.rules.tests.rules.NopRuleSetFactory;

module org.nasdanika.models.rules.tests.rules {

	requires transitive org.nasdanika.models.rules;

	provides CapabilityFactory with NopRuleSetFactory;

}

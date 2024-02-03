package org.nasdanika.models.rules.tests.rules;

import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesFactory;

public class NopRuleSetFactory implements RuleSet.Factory {

	@Override
	public RuleSet getRuleSet() {
		return RulesFactory.eINSTANCE.createRuleSet();
	}

}

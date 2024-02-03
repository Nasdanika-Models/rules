package org.nasdanika.models.rules.tests.inspectors.tests;

import java.util.ServiceLoader;

import org.junit.jupiter.api.Test;
import org.nasdanika.models.rules.RuleSet;

public class TestInspectors {
	
	@Test
	public void testRuleSetFactory() {
		Iterable<RuleSet.Factory> ruleSetFactories = ServiceLoader.load(RuleSet.Factory.class);
		for (RuleSet.Factory rsf: ruleSetFactories) {
			System.out.println(rsf);
		}
	}
				
}

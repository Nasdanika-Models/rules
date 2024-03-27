package org.nasdanika.models.rules.tests.inspectors.tests;

import org.junit.jupiter.api.Test;
import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.models.rules.RuleSet;

public class TestInspectors {
	
	@Test
	public void testRuleSetFactory() {
		CapabilityLoader capabilitLoader = new CapabilityLoader();
		Iterable<CapabilityProvider<Object>> providers = capabilitLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class),  new PrintStreamProgressMonitor());
		for (CapabilityProvider<Object> provider: providers) {
			provider.getPublisher().subscribe(System.out::println);
		}
	}
				
}

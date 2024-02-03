package org.nasdanika.models.rules.tests.analyzer.tests;

import java.util.ServiceLoader;

import org.junit.jupiter.api.Test;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.RuleSet;

public class TestAnalyzers {
	
	@Test
	public void tesInspectorFactory() {
		Iterable<Inspector.Factory> inspectorFactories = ServiceLoader.load(Inspector.Factory.class);
		for (Inspector.Factory rsf: inspectorFactories) {
			System.out.println(rsf);
		}
	}
				
}

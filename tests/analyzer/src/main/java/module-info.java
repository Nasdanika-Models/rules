module org.nasdanika.models.rules.tests.analyzer{
		
	requires transitive org.nasdanika.models.rules.tests.inspectors;
	requires transitive org.nasdanika.models.java;
	requires org.eclipse.emf.ecore.xmi;
	requires org.nasdanika.models.gitlab;
	requires org.apache.commons.lang3;
	
	exports org.nasdanika.models.rules.tests.analyzer;
		
}

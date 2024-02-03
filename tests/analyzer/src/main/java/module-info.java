import org.nasdanika.models.rules.Inspector;

module org.nasdanika.models.rules.tests.analyzer{
		
	requires transitive org.nasdanika.models.rules.tests.inspectors;
	
	exports org.nasdanika.models.rules.tests.analyzer;
	
	uses Inspector.Factory;
	
}

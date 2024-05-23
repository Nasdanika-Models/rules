module org.nasdanika.models.rules.processors {
		
	requires transitive org.nasdanika.models.rules;
	requires transitive org.nasdanika.models.architecture.processors;	
	
	exports org.nasdanika.models.rules.processors.ecore;
	opens org.nasdanika.models.rules.processors.ecore; // For loading resources
	
	exports org.nasdanika.models.rules.processors.doc;
	opens org.nasdanika.models.rules.processors.doc; // For loading resources
	
}

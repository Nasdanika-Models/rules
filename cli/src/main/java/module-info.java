module org.nasdanika.models.rules.cli {
	
	exports org.nasdanika.models.rules.cli;

	requires transitive org.nasdanika.cli;
	requires transitive org.nasdanika.models.rules.processors;
	requires spring.core;
	
	opens org.nasdanika.models.rules.cli to info.picocli;

}

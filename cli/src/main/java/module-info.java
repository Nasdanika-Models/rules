import org.nasdanika.capability.CapabilityFactory;
import org.nasdanika.models.rules.cli.RulesCommandFactory;

module org.nasdanika.models.rules.cli {

	requires transitive org.nasdanika.cli;
	requires transitive org.nasdanika.models.rules;
	requires spring.core;
	
	opens org.nasdanika.models.rules.cli to info.picocli;
	
	provides CapabilityFactory with 
		RulesCommandFactory;

}

import org.nasdanika.capability.CapabilityFactory;
import org.nasdanika.models.rules.cli.RulesCommandFactory;

module org.nasdanika.models.rules.cli {
	
	exports org.nasdanika.models.rules.cli;

	requires transitive org.nasdanika.models.app.cli;
	requires transitive org.nasdanika.models.rules.processors;
	requires spring.core;
	requires org.eclipse.emf.ecore.xmi;
	
	opens org.nasdanika.models.rules.cli to info.picocli;
	
	provides CapabilityFactory with
		RulesCommandFactory;

}

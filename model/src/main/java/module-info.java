import org.nasdanika.capability.CapabilityFactory;
import org.nasdanika.models.rules.java.util.RulesJavaEPackageResourceSetCapabilityFactory;
import org.nasdanika.models.rules.util.RulesEPackageResourceSetCapabilityFactory;

module org.nasdanika.models.rules {
	exports org.nasdanika.models.rules;
	exports org.nasdanika.models.rules.impl;
	exports org.nasdanika.models.rules.util;
	exports org.nasdanika.models.rules.java;
	exports org.nasdanika.models.rules.java.impl;
	exports org.nasdanika.models.rules.java.util;
	exports org.nasdanika.models.rules.reflection;
	
	requires transitive org.eclipse.emf.ecore;
	requires transitive org.eclipse.emf.common;
	requires transitive org.nasdanika.models.architecture;
	requires transitive org.nasdanika.models.java;
	
	provides CapabilityFactory with
		RulesEPackageResourceSetCapabilityFactory,
		RulesJavaEPackageResourceSetCapabilityFactory;
		
}
module org.nasdanika.models.rules {
	exports org.nasdanika.models.rules;
	exports org.nasdanika.models.rules.impl;
	exports org.nasdanika.models.rules.util;
	
	requires transitive org.eclipse.emf.ecore;
	requires transitive org.eclipse.emf.common;
	requires transitive org.nasdanika.models.architecture;
}
package org.nasdanika.models.rules.reflection;

import org.nasdanika.models.rules.Rule;

/**
 * Resolves rules by id. This interface can be implement by reflective target classes (factories).
 */
public interface RuleResolver {
	
	Rule resolve(String id);

}

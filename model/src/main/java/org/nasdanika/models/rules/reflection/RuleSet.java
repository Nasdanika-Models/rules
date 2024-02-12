package org.nasdanika.models.rules.reflection;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.nasdanika.emf.persistence.EObjectLoader;

/**
 * Annotation for a class with inspector methods.
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface RuleSet {
	
	/**
	 * {@link org.nasdanika.models.rules.RuleSet} id to be resolve to a rule set 
	 * It can be used to define a rule set as part of a class declaring inspector methods. 
	 * @return
	 */
	String value();	
	
	/**
	 * {@link org.nasdanika.models.rules.RuleSet} YAML specification loaded by {@link EObjectLoader}. 
	 * It can be used to define a rule set as part of a class declaring inspector methods. 
	 * @return
	 */
	String ruleSet();	

}

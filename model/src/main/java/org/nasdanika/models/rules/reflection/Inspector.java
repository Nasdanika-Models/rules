package org.nasdanika.models.rules.reflection;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.emf.persistence.EObjectLoader;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.Violation;

/**
 * Annotation for an inspector method.
 * The method shall take target as its first argument and may take {@link BiConsumer} and {@link ProgressMonitor}.
 * It may return a {@link Violation} or a String, an array of violations/strings, a {@link Stream} of violations/strings, {@link Iterator} or an {@link Iterable} of violations/strings.
 * The returned strings are wrapped into violations and used as violation names.
 * The returned violations are associated with the target argument.
 * If <code>value</code> or <code>rule</code> are defined then the violation is injected the resolved/created rule. 
 * Otherwise, it is injected with a rule if it doesn't already have a rule associated. The injected rule has the method FQN as it's name.
 * If reflection targets have {@link RuleSet} annotation, then the rule is added to the rule set.
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Inspector {
	
	/**
	 * Rule id to be resolved to a rule.
	 * @return
	 */
	String value() default "";
	
	/**
	 * {@link Rule} YAML specification loaded by {@link EObjectLoader}. 
	 * It can be used to define a rule as part of inspector method. 
	 * @return
	 */
	String rule() default "";
	

}

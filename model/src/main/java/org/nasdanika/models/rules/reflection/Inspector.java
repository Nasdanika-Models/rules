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
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.Violation;

/**
 * Annotation for an inspector method.
 * The method shall take target as its first argument and may take {@link BiConsumer} and {@link ProgressMonitor}.
 * It may return an {@link InspectionResult} or a String, an array of inspection results/strings, 
 * a {@link Stream} of inspection results/strings, {@link Iterator} or an {@link Iterable} of inspection results/strings.
 * The returned strings are wrapped into {@link Violation}s and used as violation names.
 * The returned inspection results are associated with the target argument.
 * If <code>value</code> or <code>rule</code> are defined then inspection results are injected the resolved/created rule. 
 * Otherwise, it is injected with a rule if it doesn't already have a rule associated. The injected rule has the method FQN as it's name.
 * If reflection targets have {@link RuleSet} annotation, then the rule is added to the rule set.
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Inspector {
	
	/**
	 * {@link Rule} YAML specification loaded by {@link EObjectLoader}. 
	 * It can be used to define a rule as part of inspector method. 
	 * @return
	 */
	String value() default "";
	
	/**
	 * Rule id to be resolved to a rule.
	 * @return
	 */
	String rule() default "";
	
	/**
	 * SpEL boolean expression evaluated in the context of the target object with <code>context</code> variable.	
	 * @return
	 */
	String condition() default "";
}

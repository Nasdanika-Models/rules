package org.nasdanika.models.rules.reflection;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.emf.persistence.EObjectLoader;
import org.nasdanika.models.rules.Violation;

/**
 * Annotation for an inspector method.
 * The method shall take target as its first argument and may take {@link BiConsumer} and {@link ProgressMonitor}.
 * It may return a {@link Violation}, an array of violations, a {@link Stream} of violations, {@link Iterator} or an {@link Iterable} of violations.
 * The returned violations will be associated with the target argument.
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface RuleSet {
	
	/**
	 * {@link org.nasdanika.models.rules.RuleSet} YAML specification loaded by {@link EObjectLoader}. 
	 * It can be used to define a rule set as part of a class declaring inspector methods. 
	 * @return
	 */
	String value();	

}

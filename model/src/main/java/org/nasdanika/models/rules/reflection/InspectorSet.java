package org.nasdanika.models.rules.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Reflector;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.Violation;

/**
 * Collects 
 */
public class InspectorSet extends Reflector implements org.nasdanika.models.rules.Inspector<Object> {
	
	protected List<org.nasdanika.models.rules.Inspector<Object>> inspectors = new ArrayList<>();
	private Function<String, Rule> ruleResovler;
	private boolean parallel;
	
	public InspectorSet(Function<String, Rule> ruleResolver, boolean parallel, Object... factories) {
		this.ruleResovler = ruleResolver;
		this.parallel = parallel;
		for (Object factory: factories) {
			getAnnotatedElementRecords(factory, Collections.singletonList(factory))
				.filter(aer -> aer.getAnnotation(Inspector.class) != null)
				.forEach(this::createInspector);
		}
	}
	
	private org.nasdanika.models.rules.Inspector<Object> createInspector(AnnotatedElementRecord aer) {
		Method method = (Method) aer.getAnnotatedElement();
		Parameter[] parameters = method.getParameters();
		
		return new org.nasdanika.models.rules.Inspector<Object>() {

			@Override
			public void inspect(Object target, BiConsumer<? super Object, Violation> violationConsumer,	ProgressMonitor progressMonitor) {
				Object result;
				if (parameters.length == 1) {
					result = aer.invoke(target);
				} else if (parameters.length ==2) {
					if (parameters[1].getType().isAssignableFrom(BiConsumer.class)) {
						result = aer.invoke(target, violationConsumer);						
					} else {
						result = aer.invoke(target, progressMonitor);						
					}					
				} else if (parameters.length ==3) {
					result = aer.invoke(target, violationConsumer, progressMonitor);
				} else {
					throw new IllegalArgumentException("Cannot invoke " + method + " - unsupported number of parameters");
				}				
				// TODO - handle result, inject rule, wire to rule set
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				return parameters[0].getType().isAssignableFrom(targetType);
			}
			
		};
	}

	@Override
	public void inspect(Object target, BiConsumer<Object, Violation> violationConsumer, ProgressMonitor progressMonitor) {
		if (target != null) {
			Stream<org.nasdanika.models.rules.Inspector<Object>> iStream = inspectors.stream();
			if (parallel) {
				iStream = iStream.parallel();
			}
			iStream.forEach(inspector -> inspector.inspect(target, violationConsumer, progressMonitor));
		}				
	}

	@Override
	public boolean isForType(Class<?> targetType) {
		Stream<org.nasdanika.models.rules.Inspector<Object>> iStream = inspectors.stream();
		if (parallel) {
			iStream = iStream.parallel();
		}
		return iStream.filter(i -> i.isForType(targetType)).findAny().isPresent();
	}

}

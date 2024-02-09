package org.nasdanika.models.rules.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.nasdanika.common.Context;
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
	private List<RuleSet> ruleSets = new ArrayList<RuleSet>(); 
	private boolean parallel;
	
	public InspectorSet(Function<String, Rule> ruleResolver, boolean parallel, Object... factories) {
		this.ruleResovler = ruleResolver;
		this.parallel = parallel;
		for (Object factory: factories) {
			getAnnotatedElementRecords(factory, Collections.singletonList(factory))
				.filter(aer -> aer.getAnnotation(Inspector.class) != null)
				.map(this::createInspector)
				.forEach(inspectors::add);
		}
	}
	
	@Override
	protected Stream<AnnotatedElementRecord> getAnnotatedElementRecords(Object target, List<Object> factoryPath) {
		return super.getAnnotatedElementRecords(target, factoryPath);
	}
	
	/**
	 * @return {@link org.nasdanika.models.rules.RuleSet} supported by this inspector set.
	 */
	public List<RuleSet> getRuleSets() {
		return ruleSets;
	}
	
	protected org.nasdanika.models.rules.Inspector<Object> createInspector(AnnotatedElementRecord aer) {
		Method method = (Method) aer.getAnnotatedElement();
		Parameter[] parameters = method.getParameters();
		
		return new org.nasdanika.models.rules.Inspector<Object>() {

			@Override
			public void inspect(Object target, BiConsumer<? super Object, Violation> violationConsumer, Context context,	ProgressMonitor progressMonitor) {
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
	public void inspect(Object target, BiConsumer<Object, Violation> violationConsumer, Context context, ProgressMonitor progressMonitor) {
		if (target != null) {
			Stream<org.nasdanika.models.rules.Inspector<Object>> iStream = inspectors.stream();
			if (parallel) {
				iStream = iStream.parallel();
			}
			iStream
			.filter(inspector -> target != null && inspector.isForType(target.getClass()))
			.forEach(inspector -> inspector.inspect(target, violationConsumer, context, progressMonitor));
		}				
	}

	@Override
	public boolean isForType(Class<?> targetType) {
		for (org.nasdanika.models.rules.Inspector<Object> inspector: inspectors) {
			if (inspector.isForType(targetType)) {
				return true;
			}
		}
		return false;
	}

}

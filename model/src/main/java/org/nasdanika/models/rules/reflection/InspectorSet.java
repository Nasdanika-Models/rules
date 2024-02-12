package org.nasdanika.models.rules.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Reflector;
import org.nasdanika.common.Util;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.Violation;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Collects 
 */
public class InspectorSet extends Reflector implements org.nasdanika.models.rules.Inspector<Object> {
			
	protected List<org.nasdanika.models.rules.Inspector<Object>> inspectors = new ArrayList<>();
	private RuleManager ruleManager;
	private Map<Class<?>, org.nasdanika.models.rules.RuleSet> ruleSets = new HashMap<>(); 
	private boolean parallel;
	
	/**
	 * 
	 * @param ruleLoader Loads rule from "value" specification
	 * @param ruleResolver Resolves rule from "rule" name/id
	 * @param parallel
	 * @param factories
	 */
	public InspectorSet(
			RuleManager ruleManager, 
			boolean parallel, 
			ProgressMonitor progressMonitor,
			Object... factories) {
		this.ruleManager = ruleManager;
		this.parallel = parallel;
		for (Object factory: factories) {
			getAnnotatedElementRecords(factory, Collections.singletonList(factory))
				.filter(aer -> aer.getAnnotation(Inspector.class) != null)
				.map(aer -> createInspector(aer, progressMonitor))
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
	public Collection<org.nasdanika.models.rules.RuleSet> getRuleSets() {		
		return ruleSets.values();
	}
	
	protected Rule createRule() {
		return RulesFactory.eINSTANCE.createRule();
	}
	
	protected org.nasdanika.models.rules.RuleSet createRuleSet() {
		return RulesFactory.eINSTANCE.createRuleSet();
	}
	
	protected RuleManager getRuleManager(AnnotatedElementRecord aer) {
		Object aerTarget = aer.getTarget();
		if (aerTarget instanceof RuleManager) {
			return (RuleManager) aerTarget;
		}
		List<Object> factoryPath = aer.getFactoryPath();
		if (factoryPath != null) {
			LinkedList<Object> rfp = new LinkedList<>(factoryPath);
			Collections.reverse(factoryPath);
			for (Object factory: rfp) {
				if (factory instanceof RuleManager) {
					return (RuleManager) factory;
				}
			}
		}
		return ruleManager;
	}
	
	protected EvaluationContext createEvaluationContext(Context context) {
		return new StandardEvaluationContext();
	}

	protected SpelExpressionParser createExpressionParser(Context context) {
		return new SpelExpressionParser();
	}
	
	protected org.nasdanika.models.rules.Inspector<Object> createInspector(AnnotatedElementRecord aer, ProgressMonitor progressMonitor) {
		Method method = (Method) aer.getAnnotatedElement();
		Parameter[] parameters = method.getParameters();
		Inspector inspectorAnnotation = aer.getAnnotation(Inspector.class);
		Rule[] rule = { null };		
		String ruleSpec = inspectorAnnotation.value();
		String ruleId = inspectorAnnotation.rule();
		if (Util.isBlank(ruleSpec) && Util.isBlank(ruleId)) {
			rule[0] = createRule();
			rule[0].setName(method.toString());
		} else if (!Util.isBlank(ruleSpec)) {
			rule[0] = getRuleManager(aer).loadRule(method, ruleSpec, progressMonitor);
		} else if (!Util.isBlank(ruleId)) {
			rule[0] = getRuleManager(aer).resolveRule(method, ruleId);
		} else {
			throw new IllegalArgumentException("Inspector 'value' and 'rule' are mutually exclusive: " + method);
		}	
		
		if (rule[0].eContainer() == null) {
			org.nasdanika.models.rules.RuleSet ruleSet = getRuleSet(aer, progressMonitor);
			if (ruleSet != null) {
				ruleSet.getRules().add(rule[0]);
			}
		}
		
		return new org.nasdanika.models.rules.Inspector<Object>() {

			@Override
			public void inspect(
					Object target, 
					BiConsumer<? super Object, Violation> violationConsumer, 
					Context context, 
					ProgressMonitor progressMonitor) {
				
				String condition = inspectorAnnotation.condition();
				if (!Util.isBlank(condition)) {
					ExpressionParser parser = createExpressionParser(context);
					Expression exp = parser.parseExpression(condition);
					EvaluationContext evaluationContext = createEvaluationContext(context);
					evaluationContext.setVariable("context", context);
					Boolean result = exp.getValue(evaluationContext, target, Boolean.class);
					if (!Boolean.TRUE.equals(result)) {
						return;
					}						
				}
				
				Object[] args = new Object[parameters.length];
				args[0] = target;
				
				boolean violationConsumerBound = false; 
				boolean contextBound = false; 
				boolean progressMonitorBound = false; 

				// Binding parameters
				for (int i = 1; i < parameters.length; ++i) {
					if (!violationConsumerBound && parameters[i].getType().isAssignableFrom(BiConsumer.class)) {
						args[i] = violationConsumer;
						violationConsumerBound = true;
					} else if (!contextBound && parameters[i].getType().isAssignableFrom(Context.class)) {
						args[i] = context;
						contextBound = true;
					} else if (!progressMonitorBound && parameters[i].getType().isAssignableFrom(ProgressMonitor.class)) {
						args[i] = progressMonitor;
						progressMonitorBound = true;
					} else {
						throw new IllegalArgumentException("Cannot bind parameter " + i + " of type " + parameters[i].getType() + " in method " + method);
					}
				}					
				
				Object result = aer.invoke(args);
				handleInspectorResult(target, result, rule[0], violationConsumer, context, progressMonitor);
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				return parameters[0].getType().isAssignableFrom(targetType);
			}
			
		};
	}
	
	protected org.nasdanika.models.rules.RuleSet getRuleSet(AnnotatedElementRecord aer, ProgressMonitor progressMonitor) {
		List<Object> candidates = new ArrayList<>();
		candidates.add(aer.getTarget());
		List<Object> factoryPath = aer.getFactoryPath();
		if (factoryPath != null) {
			LinkedList<Object> rfp = new LinkedList<>(factoryPath);
			Collections.reverse(factoryPath);
			for (Object factory: rfp) {
				candidates.add(factory);
			}
		}
		
		for (Object obj: candidates) {
			Class<? extends Object> tClass = obj.getClass();
			org.nasdanika.models.rules.RuleSet trs = ruleSets.get(tClass);
			if (trs != null) {
				return trs;
			}
			RuleSet ruleSetAnnotation = tClass.getAnnotation(RuleSet.class);
			if (ruleSetAnnotation != null) {
				String spec = ruleSetAnnotation.value();
				String id = ruleSetAnnotation.ruleSet();
				if (!Util.isBlank(spec)) {
					trs = getRuleManager(aer).loadRuleSet(obj, spec, progressMonitor);
					ruleSets.put(tClass, trs);
					return trs;
				}
				
				if (!Util.isBlank(id)) {
					trs = getRuleManager(aer).resolveRuleSet(obj, id, progressMonitor);
					ruleSets.put(tClass, trs);
					return trs;
				} 
				
				if (!Util.isBlank(spec) && !Util.isBlank(id)) {
					throw new IllegalArgumentException("RuleSet 'value' and 'ruleSet' are mutually exclusive: " + tClass);
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param target
	 * @param result String, violation, iterator/iterable/stream/array of violations or strings, 
	 * @param violationConsumer
	 * @param context
	 * @param progressMonitor
	 */
	protected void handleInspectorResult(
			Object target, 
			Object result, 
			Rule rule,
			BiConsumer<? super Object, Violation> violationConsumer, 
			Context context, 
			ProgressMonitor progressMonitor) {
		
		if (result != null) {
			if (result instanceof Iterator) {
				Iterator<?> iterator = (Iterator<?>) result;
				while (iterator.hasNext()) {
					handleInspectorResult(target, iterator.next(), rule, violationConsumer, context, progressMonitor);
				}
			} else if (result instanceof Iterable) {
				handleInspectorResult(target, ((Iterable<?>) result).iterator(), rule, violationConsumer, context, progressMonitor);
			} else if (result instanceof Stream) {				
				((Stream<?>) result).forEach(re -> handleInspectorResult(target, re, rule, violationConsumer, context, progressMonitor));
			} else if (result.getClass().isArray()) {
				for (int i = 0; i < Array.getLength(result); ++i) {
					handleInspectorResult(target, Array.get(result, i), rule, violationConsumer, context, progressMonitor);
				}
			} else {
				Violation violation;
				if (result instanceof String) {
					violation = createViolation();
					violation.setName((String) result);
				} else if (result instanceof Violation) {
					violation = (Violation) result;
				} else {
					throw new IllegalArgumentException("Unexpected result type: " + result);
				}
				
				if (violation.getRule() == null) {
					violation.setRule(rule);
				}
				violationConsumer.accept(target, violation);
			}
		}				
	}
	
	protected Violation createViolation() {
		return RulesFactory.eINSTANCE.createViolation();
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

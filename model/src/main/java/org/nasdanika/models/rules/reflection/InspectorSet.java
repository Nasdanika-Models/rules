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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Reflector;
import org.nasdanika.common.Util;
import org.nasdanika.models.rules.Failure;
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.Severity;
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
			Predicate<org.nasdanika.models.rules.Inspector<Object>> inspectorPredicate,
			boolean parallel, 
			ProgressMonitor progressMonitor,
			Object... factories) {
		this.ruleManager = ruleManager;
		this.parallel = parallel;
		for (Object factory: factories) {
			getAnnotatedElementRecords(factory, Collections.singletonList(factory))
				.filter(aer -> aer.getAnnotation(Inspector.class) != null)
				.map(aer -> createInspector(aer, progressMonitor))
				.filter(i -> inspectorPredicate == null || inspectorPredicate.test(i))
				.forEach(inspectors::add);
		}
	}
	
	public boolean isEmpty() {
		return inspectors.isEmpty();
	}
	
	@Override
	public Collection<Rule> getRules() {
		return inspectors.stream().flatMap(i -> i.getRules().stream()).toList();
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
			rule[0] = getRuleManager(aer).resolveRule(method, ruleId, progressMonitor);
		} else {
			throw new IllegalArgumentException("Inspector 'value' and 'rule' are mutually exclusive: " + method);
		}	
		
		if (rule[0].eContainer() == null) {
			org.nasdanika.models.rules.RuleSet ruleSet = getRuleSet(aer, progressMonitor);
			if (ruleSet != null) {
				ruleSet.getRules().add(rule[0]);
			}
		}
		
		String severityId = inspectorAnnotation.severity();
		if (!Util.isBlank(severityId) && rule[0].eContainer() instanceof org.nasdanika.models.rules.RuleSet) {
			org.nasdanika.models.rules.RuleSet ruleSet = (org.nasdanika.models.rules.RuleSet) rule[0].eContainer();
			for (Severity severity: ruleSet.getSeverities()) {
				if (severityId.equals(severity.getId())) {
					rule[0].setSeverity(severity);
					break;
				}
			}
			if (rule[0].getSeverity() == null) {
				Severity severity = RulesFactory.eINSTANCE.createSeverity();
				severity.setId(severityId);
				severity.setName(severityId);
				ruleSet.getSeverities().add(severity);
				rule[0].setSeverity(severity);
			}
		}
		
		return new org.nasdanika.models.rules.Inspector<Object>() {
			
			@Override
			public Collection<Rule> getRules() {
				return Collections.singleton(rule[0]);
			}

			@Override
			public void inspect(
					Object target, 
					BiPredicate<? super Object, ? super InspectionResult> inspectionResultConsumer, 
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
				
				BiPredicate<? super Object, InspectionResult> injectingInspectionResultConsumer = (trg, inspectionResult) -> {
					if (inspectionResult != null && inspectionResult.getRule() == null) {
						inspectionResult.setRule(rule[0]);
					}
					return inspectionResultConsumer.test(trg, inspectionResult);
				};
				
				// Binding parameters
				for (int i = 1; i < parameters.length; ++i) {
					if (!violationConsumerBound && parameters[i].getType().isAssignableFrom(BiPredicate.class)) {
						args[i] = injectingInspectionResultConsumer;
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
				
				Object[] result = null;
				try {
					result = new Object[] { aer.invoke(args) };
				} catch (Exception e) {
					Failure failure = createFailure();
					failure.setName(e.toString());
					failure.setCause(org.nasdanika.ncore.Throwable.wrap(e));
					failure.setRule(rule[0]);
					injectingInspectionResultConsumer.test(target, failure);
				}
				if (result != null) {
					handleInspectorResult(target, result[0], rule[0], injectingInspectionResultConsumer, context, progressMonitor);
				}
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
			BiPredicate<? super Object, InspectionResult> inspectionResultConsumer, 
			Context context, 
			ProgressMonitor progressMonitor) {
		
		if (result != null) {
			if (result instanceof Iterator) {
				Iterator<?> iterator = (Iterator<?>) result;
				while (iterator.hasNext()) {
					handleInspectorResult(target, iterator.next(), rule, inspectionResultConsumer, context, progressMonitor);
				}
			} else if (result instanceof Iterable) {
				handleInspectorResult(target, ((Iterable<?>) result).iterator(), rule, inspectionResultConsumer, context, progressMonitor);
			} else if (result instanceof Stream) {				
				((Stream<?>) result).forEach(re -> handleInspectorResult(target, re, rule, inspectionResultConsumer, context, progressMonitor));
			} else if (result.getClass().isArray()) {
				for (int i = 0; i < Array.getLength(result); ++i) {
					handleInspectorResult(target, Array.get(result, i), rule, inspectionResultConsumer, context, progressMonitor);
				}
			} else {
				InspectionResult inspectionResult;
				if (result instanceof String) {
					inspectionResult = createViolation();
					inspectionResult.setName((String) result);
				} else if (result instanceof InspectionResult) {
					inspectionResult = (InspectionResult) result;
				} else {
					inspectionResult = createFailure();
					inspectionResult.setName("Unexpected result type: " + result);
				}
				
				inspectionResultConsumer.test(target, inspectionResult);
			}
		}				
	}
	
	protected Violation createViolation() {
		return RulesFactory.eINSTANCE.createViolation();
	}
	
	protected Failure createFailure() {
		return RulesFactory.eINSTANCE.createFailure();
	}

	@Override
	public void inspect(Object target, BiPredicate<Object, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
		if (target != null) {
			Stream<org.nasdanika.models.rules.Inspector<Object>> iStream = inspectors.stream();
			if (parallel) {
				iStream = iStream.parallel();
			}
			AtomicBoolean isCancelled = new AtomicBoolean();
			BiPredicate<Object, ? super InspectionResult> filterInspectionResultConsumer = org.nasdanika.models.rules.Inspector.filterInspectionResultConsumer(inspectionResultConsumer, () -> isCancelled.set(true));					
			iStream
				.filter(inspector -> target != null && inspector.isForType(target.getClass()))
				.forEach(inspector -> {
					if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled())) {
						inspector.inspect(target, filterInspectionResultConsumer, context, progressMonitor);
					}
				});
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

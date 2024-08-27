package org.nasdanika.models.rules.processors.doc;

import java.util.function.BiConsumer;

import org.eclipse.emf.common.util.URI;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.Element;
import org.nasdanika.graph.emf.EObjectNode;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.graph.processor.ProcessorInfo;
import org.nasdanika.graph.processor.emf.EObjectNodeProcessor;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.AppFactory;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.Severity;
import org.nasdanika.ncore.util.NcoreUtil;

/**
 * Node processor factory to use with {@link EObjectReflectiveProcessorFactory} to generate family documentation.
 * @author Pavel
 *
 */
public class RulesNodeProcessorFactory {
			
	private Context context;
	private java.util.function.BiFunction<URI, ProgressMonitor, Label> prototypeProvider;

	protected java.util.function.Function<ProgressMonitor, Action> getPrototypeProvider(NodeProcessorConfig<WidgetFactory, WidgetFactory> config) {
		return progressMonitor -> {
			if (prototypeProvider != null) {
				for (URI identifier: NcoreUtil.getIdentifiers(((EObjectNode) config.getElement()).get())) {
					Label prototype = prototypeProvider.apply(identifier, progressMonitor);
					if (prototype instanceof Action) {
						return (Action) prototype;
					}				
				}			
			}
			return AppFactory.eINSTANCE.createAction();
		};		
	}
	
	/**
	 * 
	 * @param context
	 * @param reflectiveFactories Objects with annotated methods for creating processors. 
	 */
	public RulesNodeProcessorFactory(
			Context context, 
			java.util.function.BiFunction<URI, ProgressMonitor, Label> prototypeProvider)  {
		this.context = context;
		this.prototypeProvider = prototypeProvider;
	}
	
//	TODO Action.java
//	TODO BinaryResourceAction.java
//	TODO CreateBinaryResourceAction.java
//	TODO CreateResourceAction.java
//	TODO CreateTextResourceAction.java
//	TODO DeleteResourceAction.java
	
//	TODO Failure.java
//	TODO Inspectable.java
//	TODO InspectionResult.java
//	TODO MoveResourceAction.java
//	TODO ResourceAction.java
	
//	Rule.java
	@EObjectNodeProcessor(type = org.nasdanika.models.rules.Rule.class)
	public Object createRuleNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new RuleNodeProcessor<Rule>(config, context, getPrototypeProvider(config));
	}
	
//	RuleSet.java
	@EObjectNodeProcessor(type = org.nasdanika.models.rules.RuleSet.class)
	public Object createRuleSetNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new RuleSetNodeProcessor<RuleSet>(config, context, getPrototypeProvider(config));
	}
	
//	Severity.java
	@EObjectNodeProcessor(type = org.nasdanika.models.rules.Severity.class)
	public Object createSeverityNodeProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			boolean parallel, 
			BiConsumer<Element,BiConsumer<ProcessorInfo<Object>,ProgressMonitor>> infoProvider,
			ProgressMonitor progressMonitor) {
		
		return new SeverityNodeProcessor<Severity>(config, context, getPrototypeProvider(config));
	}
	
//	TODO TextResourceAction.java
//	TODO UpdateBinaryResourceAction.java
//	TODO UpdateResourceAction.java
//	TODO UpdateTextResourceAction.java
//	TODO Violation.java
//	TODO Waiver.java
	
}

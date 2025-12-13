/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.ACTION)
public class ActionProcessorFactory /* extends NodeProcessorFactory */ {
	
	protected Context context;

	public ActionProcessorFactory(Context context) {
		this.context = context;
	}
	
	
//	@EClassifierNodeProcessorFactory(
//			description = "Description TODO",
//			documentation = 
//                    """
//					Documentation TODO 
//                    """
//	)
//	public EClassNodeProcessor createEClassNodeProcessor(
//			NodeProcessorConfig<WidgetFactory, WidgetFactory, Object> config, 
//			java.util.function.BiFunction<EObject, ProgressMonitor, Action> prototypeProvider,
//			BiConsumer<Label, ProgressMonitor> labelConfigurator,
//			ProgressMonitor progressMonitor) {		
//		return new EClassNodeProcessor(config, context, prototypeProvider) {
//			
//			@Override
//			public void configureLabel(Object source, Label label, ProgressMonitor progressMonitor) {
//				super.configureLabel(source, label, progressMonitor);
//				if (labelConfigurator != null) {
//					labelConfigurator.accept(label, progressMonitor);
//				}
//			}	
//			
//		};
//	}
	
	
} 

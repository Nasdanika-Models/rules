/**
 */
package org.nasdanika.models.rules.processors.doc;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;
import org.nasdanika.models.architecture.processors.doc.ArchitectureDescriptionElementNodeProcessor;
import org.nasdanika.models.rules.Severity;

public class SeverityNodeProcessor<T extends Severity> extends ArchitectureDescriptionElementNodeProcessor<T> {

	public SeverityNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		
		super(config, context, prototypeProvider);
	}

//	EList<Rule> getRules();

} 

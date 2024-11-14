/**
 */
package org.nasdanika.models.rules.processors.doc;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.graph.processor.OutgoingEndpoint;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.graph.WidgetFactory;
import org.nasdanika.models.architecture.processors.doc.NodeNodeProcessor;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RulesPackage;

public class RuleNodeProcessor<T extends Rule> extends NodeNodeProcessor<T> {
	
	public RuleNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		
		super(config, context, prototypeProvider);
	}

	// Severity	
	private WidgetFactory severityWidgetFactory;
	
	@OutgoingEndpoint("reference.name == 'severity'")
	public final void setSeverityEndpoint(WidgetFactory severityWidgetFactory) {
		this.severityWidgetFactory = severityWidgetFactory;
	}
	
	public WidgetFactory getSeverityWidgetFactory() {
		return severityWidgetFactory;
	}
	
	@Override
	public Object select(Object selector, URI base, ProgressMonitor progressMonitor) {
		if (selector == RulesPackage.Literals.RULE__SEVERITY && severityWidgetFactory != null) {
			return severityWidgetFactory.createLink(base, progressMonitor);
		}
		return super.select(selector, base, progressMonitor);
	}	
	
	// TODO - properties table - suppress, severity
	// TODO - actions table

//	boolean isSuppress();
//	EList<Action> getActions();
	
} // Rule

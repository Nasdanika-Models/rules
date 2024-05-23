/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.SEVERITY)
public class SeverityProcessorFactory /* extends ArchitectureDescriptionElementProcessorFactory */ {
	
	protected Context context;

	public SeverityProcessorFactory(Context context) {
		this.context = context;
	}

//	EList<Rule> getRules();

} 

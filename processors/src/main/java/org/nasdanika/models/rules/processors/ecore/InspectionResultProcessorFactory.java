/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.INSPECTION_RESULT)
public class InspectionResultProcessorFactory /* extends ArchitectureDescriptionElementProcessorFactory */ {
	
	protected Context context;

	public InspectionResultProcessorFactory(Context context) {
		this.context = context;
	}
	
//	Rule getRule();
//	void setRule(Rule value);

} 

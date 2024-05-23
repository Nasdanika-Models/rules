/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.INSPECTABLE)
public class InspectableProcessorFactory {
	
	protected Context context;

	public InspectableProcessorFactory(Context context) {
		this.context = context;
	}	
	
//	EList<InspectionResult> getInspectionResults();
//	EList<Waiver> getWaivers();

} 

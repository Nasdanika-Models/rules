/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.VIOLATION)
public class ViolationProcessorFactory extends InspectionResultProcessorFactory {
	
	public ViolationProcessorFactory(Context context) {
		super(context);
	}
	
//	EList<Waiver> getWaivers();
//	EList<Action> getActions();

} // Violation

/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.FAILURE)
public class FailureProcessorFactory extends InspectionResultProcessorFactory {
	
	public FailureProcessorFactory(Context context) {
		super(context);
	}
	

//	org.nasdanika.ncore.Throwable getCause();
//	void setCause(org.nasdanika.ncore.Throwable value);

} // Failure

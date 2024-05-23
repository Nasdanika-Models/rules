/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.UPDATE_RESOURCE_ACTION)
public class UpdateResourceActionProcessorFactory extends ResourceActionProcessorFactory {
	
	public UpdateResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
} 

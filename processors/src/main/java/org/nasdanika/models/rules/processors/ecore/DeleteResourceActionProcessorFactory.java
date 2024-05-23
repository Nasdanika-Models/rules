/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.DELETE_RESOURCE_ACTION)
public class DeleteResourceActionProcessorFactory extends ResourceActionProcessorFactory {
	
	public DeleteResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
} 

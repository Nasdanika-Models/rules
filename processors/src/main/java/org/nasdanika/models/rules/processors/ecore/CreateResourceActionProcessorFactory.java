/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.CREATE_RESOURCE_ACTION)
public class CreateResourceActionProcessorFactory extends ResourceActionProcessorFactory {
	
	public CreateResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
} 

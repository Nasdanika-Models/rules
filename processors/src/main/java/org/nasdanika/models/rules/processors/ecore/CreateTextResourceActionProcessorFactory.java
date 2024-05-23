/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.CREATE_TEXT_RESOURCE_ACTION)
public class CreateTextResourceActionProcessorFactory extends CreateResourceActionProcessorFactory /*, TextResourceAction */ {
	
	public CreateTextResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
} 

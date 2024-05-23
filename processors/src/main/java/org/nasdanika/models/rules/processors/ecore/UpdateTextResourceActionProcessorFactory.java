/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.UPDATE_TEXT_RESOURCE_ACTION)
public class UpdateTextResourceActionProcessorFactory extends UpdateResourceActionProcessorFactory /* , TextResourceAction */ {
	
	public UpdateTextResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
} 

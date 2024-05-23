/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.UPDATE_BINARY_RESOURCE_ACTION)
public class UpdateBinaryResourceActionProcessorFactory extends UpdateResourceActionProcessorFactory /*, BinaryResourceAction */ {
	
	public UpdateBinaryResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
} // UpdateBinaryResourceAction

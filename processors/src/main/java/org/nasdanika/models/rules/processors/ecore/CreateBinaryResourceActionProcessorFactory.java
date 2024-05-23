/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.CREATE_BINARY_RESOURCE_ACTION)
public class CreateBinaryResourceActionProcessorFactory extends CreateResourceActionProcessorFactory /*, BinaryResourceAction */ {
	
	public CreateBinaryResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
} 

/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.BINARY_RESOURCE_ACTION)
public class BinaryResourceActionProcessorFactory extends ResourceActionProcessorFactory {
	
	public BinaryResourceActionProcessorFactory(Context context) {
		super(context);
	}
		
//	byte[] getContent();
//	void setContent(byte[] value);

} 

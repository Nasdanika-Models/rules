/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.MOVE_RESOURCE_ACTION)
public class MoveResourceActionProcessorFactory extends ResourceActionProcessorFactory {
	
	public MoveResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
//	String getNewIdentifier();
//	void setNewIdentifier(String value);

} 

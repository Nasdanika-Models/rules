/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.RESOURCE_ACTION)
public class ResourceActionProcessorFactory extends ActionProcessorFactory {
	
	public ResourceActionProcessorFactory(Context context) {
		super(context);
	}
	
//	String getResourceIdentifier();
//	void setResourceIdentifier(String value);

} // ResourceAction

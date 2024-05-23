/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.TEXT_RESOURCE_ACTION)
public class TextResourceActionProcessorFactory extends ResourceActionProcessorFactory {
	
	public TextResourceActionProcessorFactory(Context context) {
		super(context);
	}
	

//	String getContent();
//	void setContent(String value);

} // TextResourceAction

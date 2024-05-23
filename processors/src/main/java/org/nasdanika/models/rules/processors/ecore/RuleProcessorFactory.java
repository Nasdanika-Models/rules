/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.RULE)
public class RuleProcessorFactory /* extends NodeProcessorFactory */ {
	
	protected Context context;

	public RuleProcessorFactory(Context context) {
		this.context = context;
	}

//	boolean isSuppress();
//	void setSuppress(boolean value);
//	Severity getSeverity();
//	void setSeverity(Severity value);
//	EList<Action> getActions();
	
} // Rule

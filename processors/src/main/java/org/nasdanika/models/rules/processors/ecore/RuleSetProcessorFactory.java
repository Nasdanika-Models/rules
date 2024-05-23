/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.RULE_SET)
public class RuleSetProcessorFactory /* extends DomainProcessorFactory */ {
	
	protected Context context;

	public RuleSetProcessorFactory(Context context) {
		this.context = context;
	}
	
//	EList<RuleSet> getExtends();
//	EList<RuleSet> getExtensions();
//	EList<Rule> getRules();
//	EList<Severity> getSeverities();

} // RuleSet

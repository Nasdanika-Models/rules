/**
 */
package org.nasdanika.models.rules.processors.ecore;

import org.nasdanika.common.Context;
import org.nasdanika.models.ecore.graph.processors.EClassifierNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EClassifierNodeProcessorFactory(classifierID = RulesPackage.WAIVER)
public class WaiverProcessorFactory /* extends ArchitectureDescriptionElementProcessorFactory */ {
	
	protected Context context;

	public WaiverProcessorFactory(Context context) {
		this.context = context;
	}

//	EList<Violation> getViolations();

} // Waiver

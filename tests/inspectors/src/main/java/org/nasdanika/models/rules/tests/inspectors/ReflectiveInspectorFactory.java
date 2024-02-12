package org.nasdanika.models.rules.tests.inspectors;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.reflection.InspectorSet;
import org.nasdanika.models.rules.reflection.RuleManager;

public class ReflectiveInspectorFactory implements Inspector.Factory {

	@Override
	public Inspector<Object> getInspector(ProgressMonitor progressMonitor) {
		return new InspectorSet(RuleManager.LOADING_RULE_MANAGER, false, progressMonitor, new ReflectiveInspectors());
	}

}

package org.nasdanika.models.rules.tests.inspectors;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;

public class NopInspectorFactory implements Inspector.Factory {

	@Override
	public Inspector<Object> getInspector(ProgressMonitor progressMonitor) {
		return Inspector.nop();
	}

}

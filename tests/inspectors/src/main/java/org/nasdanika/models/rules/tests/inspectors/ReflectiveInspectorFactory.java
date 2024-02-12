package org.nasdanika.models.rules.tests.inspectors;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.reflection.InspectorSet;

public class ReflectiveInspectorFactory implements Inspector.Factory {

	@Override
	public Inspector<Object> getInspector(ProgressMonitor progressMonitor) {
		return new InspectorSet(null, false, progressMonitor, new ReflectiveInspectors());
	}

}

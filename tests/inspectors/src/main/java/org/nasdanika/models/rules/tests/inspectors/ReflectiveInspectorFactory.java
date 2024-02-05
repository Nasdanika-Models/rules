package org.nasdanika.models.rules.tests.inspectors;

import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.reflection.InspectorSet;

public class ReflectiveInspectorFactory implements Inspector.Factory {

	@Override
	public Inspector<Object> getInspector() {
		return new InspectorSet(null, false, new ReflectiveInspectorFactory());
	}

}

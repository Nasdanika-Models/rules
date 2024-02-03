package org.nasdanika.models.rules.tests.inspectors;

import org.nasdanika.models.rules.Inspector;

public class NopInspectorFactory implements Inspector.Factory {

	@Override
	public Inspector<Object> getInspector() {
		return Inspector.nop();
	}

}

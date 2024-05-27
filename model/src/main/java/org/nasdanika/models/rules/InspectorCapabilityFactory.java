package org.nasdanika.models.rules;

import java.util.function.Predicate;

import org.nasdanika.capability.ServiceCapabilityFactory;

public abstract class InspectorCapabilityFactory<T> extends ServiceCapabilityFactory<Predicate<Inspector<T>>, Inspector<T>> {

	@Override
	public boolean isFor(Class<?> type, Object requirement) {
		return type == Inspector.class;
	}

}

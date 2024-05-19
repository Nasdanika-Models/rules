package org.nasdanika.models.rules;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.Composable;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;

/**
 * Inspects provided object and passes inspection results to a consumer
 */
public interface Inspector<T> extends Composable<Inspector<T>> {
		
	void inspect(T target, BiConsumer<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor);
	
	/**
	 * @param type
	 * @return true if the inspector "is interested" in targets of specific type and they shall be passed to it.
	 */
	boolean isForType(Class<?> targetType);
	
	@Override
	default Inspector<T> compose(Inspector<T> other) {
		if (other == null) {
			return this;
		}
		
		return new Inspector<T>() {

			@Override
			public void inspect(T target, BiConsumer<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				if (target != null) {
					if (Inspector.this.isForType(target.getClass())) {
						Inspector.this.inspect(target, inspectionResultConsumer, context, progressMonitor);
					}
					if (other.isForType(target.getClass())) {
						other.inspect(target, inspectionResultConsumer, context, progressMonitor);
					}
				}
				
			}

			@Override
			public boolean isForType(Class<?> targetType) {				
				return Inspector.this.isForType(targetType) || other.isForType(targetType);
			}
		};
		
	}
	
	@SafeVarargs
	static <T> Inspector<T> compose(Inspector<T>... inspectors) {
		return new Inspector<T>() {

			@Override
			public void inspect(T target, BiConsumer<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				if (target != null) {
					for (Inspector<T> inspector: inspectors) {
						if (inspector.isForType(target.getClass())) {
							inspector.inspect(target, inspectionResultConsumer, context, progressMonitor);
						}
					}
				}				
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				for (Inspector<T> inspector: inspectors) {
					if (inspector.isForType(targetType)) {
						return true;
					}
				}
				return false;
			}
		};
		
	}
	
	static <T> Inspector<T> compose(Collection<Inspector<T>> inspectors, boolean parallel) {
		return new Inspector<T>() {

			@Override
			public void inspect(T target, BiConsumer<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				if (target != null) {
					Stream<Inspector<T>> iStream = inspectors.stream();
					if (parallel) {
						iStream = iStream.parallel();
					}
					iStream.forEach(inspector -> inspector.inspect(target, inspectionResultConsumer, context, progressMonitor));
				}				
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				Stream<Inspector<T>> iStream = inspectors.stream();
				if (parallel) {
					iStream = iStream.parallel();
				}
				return iStream.filter(i -> i.isForType(targetType)).findAny().isPresent();
			}
		};		
	}
	
	static <T> Inspector<T> nop() {
		return new Inspector<T>() {

			@Override
			public void inspect(T target, BiConsumer<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				// NOP				
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				return false;
			}
			
		};
	}

	/**
	 * Loads inspectors from Inspector.Factory services and composes them.
	 * @return
	 */
	static Inspector<Object> load(Object requirement, ProgressMonitor progressMonitor) {
		Inspector<Object> ret = null;
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		Iterable<CapabilityProvider<Object>> providers = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(Inspector.class, null, requirement), progressMonitor);
		for (CapabilityProvider<Object> provider: providers) {
			for (Object obj: provider.getPublisher().toIterable()) {
				@SuppressWarnings("unchecked")
				Inspector<Object> inspector = (Inspector<Object>) obj;
				ret = ret == null ? inspector : compose(ret, inspector);
			}
		}
		return ret == null ? nop() : ret;
	}

}

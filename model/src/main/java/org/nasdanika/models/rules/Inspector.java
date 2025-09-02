package org.nasdanika.models.rules;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.Composable;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;

import reactor.core.publisher.Flux;

/**
 * Inspects provided object and passes inspection results to a consumer
 */
public interface Inspector<T> extends Composable<Inspector<T>> {
	
	/**
	 * @return
	 */
	default Collection<Rule> getRules() {
		return Collections.emptySet();
	}
		
	/**
	 * Inspects the target and reports results to the consumer.
	 * The consumer may return <code>false</code> to indicate that it has received enough results and inspection shall stop.
	 * @param target
	 * @param inspectionResultConsumer
	 * @param context
	 * @param progressMonitor
	 */
	void inspect(T target, BiPredicate<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor);
	
	/**
	 * Inspects the target and reports results to the consumer.
	 * The consumer may return <code>false</code> to indicate that it has received enough results and inspection shall stop.
	 * @param target
	 * @param inspectionResultConsumer
	 * @param context
	 * @param progressMonitor
	 */
	Flux<InspectionResult> inspectAsync(T target, Context context);	
	
	/**
	 * Calls onCancel {@link Runnable} if the argument predicate return false. 
	 * @param <T>
	 * @param inspectionResultConsumer
	 * @param onCancel
	 * @return
	 */
	static <T> BiPredicate<? super T, ? super InspectionResult> filterInspectionResultConsumer(BiPredicate<? super T, ? super InspectionResult> inspectionResultConsumer, Runnable onCancel) {
		return (target, result) -> {
			if (inspectionResultConsumer.test(target, result)) {
				return true;
			}
			onCancel.run();
			return false;
		};		
	}
	
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
			public Collection<Rule> getRules() {
				return Stream.of(this, other).flatMap(i -> i.getRules().stream()).toList();
			}			

			@Override
			public void inspect(T target, BiPredicate<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				if (target != null) {
					AtomicBoolean isCancelled = new AtomicBoolean();
					BiPredicate<? super T, ? super InspectionResult> filterInspectionResultConsumer = filterInspectionResultConsumer(inspectionResultConsumer, () -> isCancelled.set(true));
					if (Inspector.this.isForType(target.getClass())) {
						Inspector.this.inspect(target, filterInspectionResultConsumer, context, progressMonitor);
					}
					if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled()) && other.isForType(target.getClass())) {
						other.inspect(target, filterInspectionResultConsumer, context, progressMonitor);
					}
				}
				
			}

			@Override
			public boolean isForType(Class<?> targetType) {				
				return Inspector.this.isForType(targetType) || other.isForType(targetType);
			}

			@Override
			public Flux<InspectionResult> inspectAsync(T target, Context context) {
				return Flux.concat(Inspector.this.inspectAsync(target, context), other.inspectAsync(target, context));
			}
		};
		
	}
	
	@SafeVarargs
	static <T> Inspector<T> compose(Inspector<T>... inspectors) {
		return new Inspector<T>() {
			
			@Override
			public Collection<Rule> getRules() {
				return Arrays.stream(inspectors).flatMap(i -> i.getRules().stream()).toList();
			}

			@Override
			public void inspect(T target, BiPredicate<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				if (target != null) {
					AtomicBoolean isCancelled = new AtomicBoolean();
					BiPredicate<? super T, ? super InspectionResult> filterInspectionResultConsumer = filterInspectionResultConsumer(inspectionResultConsumer, () -> isCancelled.set(true));
					for (Inspector<T> inspector: inspectors) {
						if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled()) && inspector.isForType(target.getClass())) {
							inspector.inspect(target, filterInspectionResultConsumer, context, progressMonitor);
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

			@Override
			public Flux<InspectionResult> inspectAsync(T target, Context context) {				
				return Flux.concat(Stream.of(inspectors).map(i -> i.inspectAsync(target, context)).toList());
			}
			
		};
		
	}
	
	static <T> Inspector<T> compose(Collection<Inspector<T>> inspectors, boolean parallel) {
		return new Inspector<T>() {
			
			@Override
			public Collection<Rule> getRules() {
				return inspectors.stream().flatMap(i -> i.getRules().stream()).toList();
			}

			@Override
			public void inspect(T target, BiPredicate<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				if (target != null) {
					Stream<Inspector<T>> iStream = inspectors.stream();
					if (parallel) {
						iStream = iStream.parallel();
					}
					AtomicBoolean isCancelled = new AtomicBoolean();
					BiPredicate<? super T, ? super InspectionResult> filterInspectionResultConsumer = filterInspectionResultConsumer(inspectionResultConsumer, () -> isCancelled.set(true));					
					iStream.forEach(inspector -> {
						if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled())) {
							inspector.inspect(target, filterInspectionResultConsumer, context, progressMonitor);
						}
					});
				}				
			}

			@Override
			public Flux<InspectionResult> inspectAsync(T target, Context context) {				
				return Flux.concat(inspectors.stream().map(i -> i.inspectAsync(target, context)).toList());
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
			public void inspect(T target, BiPredicate<? super T, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				// NOP				
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				return false;
			}
			
			@Override
			public Flux<InspectionResult> inspectAsync(T target, Context context) {
				return Flux.empty();
			}
			
		};
	}

	/**
	 * Loads inspectors from Inspector.Factory services and composes them.
	 * @return
	 */
	static Inspector<Object> load(Predicate<Inspector<Object>> requirement, ProgressMonitor progressMonitor) {
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

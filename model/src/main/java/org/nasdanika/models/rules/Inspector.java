package org.nasdanika.models.rules;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.nasdanika.common.Composeable;
import org.nasdanika.common.ProgressMonitor;

/**
 * Inspects provided object and passes findings (violation to a violation sink
 */
public interface Inspector<T> extends Composeable<Inspector<T>> {
	
	interface Factory extends Composeable<Factory> {
		
		Inspector<Object> getInspector();
		
		@Override
		default Factory compose(Factory other) {
			if (other == null) {
				return this;
			}
			return () -> {
				Inspector<Object> inspector = getInspector();
				Inspector<Object> otherInspector = other.getInspector();
				return inspector.compose(otherInspector);
			};
		}

	}	
	
	void inspect(T target, BiConsumer<? super T, Violation> violationConsumer, ProgressMonitor progressMonitor);
	
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
			public void inspect(T target, BiConsumer<? super T, Violation> violationConsumer, ProgressMonitor progressMonitor) {
				if (target != null) {
					if (Inspector.this.isForType(target.getClass())) {
						Inspector.this.inspect(target, violationConsumer, progressMonitor);
					}
					if (other.isForType(target.getClass())) {
						other.inspect(target, violationConsumer, progressMonitor);
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
			public void inspect(T target, BiConsumer<? super T, Violation> violationConsumer, ProgressMonitor progressMonitor) {
				if (target != null) {
					for (Inspector<T> inspector: inspectors) {
						if (inspector.isForType(target.getClass())) {
							inspector.inspect(target, violationConsumer, progressMonitor);
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
			public void inspect(T target, BiConsumer<? super T, Violation> violationConsumer, ProgressMonitor progressMonitor) {
				if (target != null) {
					Stream<Inspector<T>> iStream = inspectors.stream();
					if (parallel) {
						iStream = iStream.parallel();
					}
					iStream.forEach(inspector -> inspector.inspect(target, violationConsumer, progressMonitor));
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
			public void inspect(T target, BiConsumer<? super T, Violation> violationConsumer, ProgressMonitor progressMonitor) {
				// NOP				
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				return false;
			}
			
		};
	}
	
	/**
	 * Inspector which is aware of {@link ResourceSet}, {@link Resource}, and {@link EObject} contents and passes to
	 * the delegate the target object and its contents as well.
	 * @param delegate
	 * @return
	 */
	static Inspector<Notifier> contentsInspector(Inspector<Notifier> delegate, boolean parallel) {
		return new Inspector<Notifier>() {

			@Override
			public void inspect(Notifier target, BiConsumer<? super Notifier, Violation> violationConsumer,	ProgressMonitor progressMonitor) {
				if (delegate != null) {
					if (delegate.isForType(target.getClass())) {
						delegate.inspect(target, violationConsumer, progressMonitor);
					}
					if (target instanceof ResourceSet) {
						Stream<Resource> rStream = ((ResourceSet) target).getResources().stream();
						if (parallel) {
							rStream = rStream.parallel();
						} 
						rStream.forEach(resource -> inspect(resource, violationConsumer, progressMonitor));
					} else if (target instanceof ResourceSet) {
						Stream<EObject> contentsStream = ((Resource) target).getContents().stream();
						if (parallel) {
							contentsStream = contentsStream.parallel();
						}
						contentsStream.forEach(root -> inspect(root, violationConsumer, progressMonitor));
					} else if (target instanceof EObject) {
						Stream<EObject> contentsStream = ((EObject) target).eContents().stream();
						if (parallel) {
							contentsStream = contentsStream.parallel();
						}
						contentsStream.forEach(contents -> inspect(contents, violationConsumer, progressMonitor));
					}
				}				
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				return Notifier.class.isAssignableFrom(targetType);
			}
			
		};
	}

}

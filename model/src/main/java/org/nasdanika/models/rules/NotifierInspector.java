package org.nasdanika.models.rules;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.ncore.Tree;
import org.nasdanika.ncore.TreeItem;

/**
 * Binding to {@link Notifier}
 */
public interface NotifierInspector extends Inspector<Notifier> {
	
	@Override
	default boolean isForType(Class<?> targetType) {
		return Notifier.class.isAssignableFrom(targetType);
	}
		
	/**
	 * Inspector which is aware of {@link ResourceSet}, {@link Resource}, and {@link EObject} contents as well as of {@link TreeItem} semantics - referencing another resource.
	 * @param parallel If true contents is inspected using parallel stream
	 * @param predicate contents predicate, can be null.
	 * @return
	 */
	default NotifierInspector asContentsInspector(boolean parallel, Predicate<Notifier> predicate) {
		return new NotifierInspector() {
			
			private URI resolve(EObject eObj) {
				EObject eContainer = eObj.eContainer();
				if (eContainer == null) {
					Resource eResource = eObj.eResource();
					return eResource == null ? null : eResource.getURI();
				}
				URI containerURI = resolve(eContainer);
				if (containerURI == null) {
					return null;
				}
				
				if (eObj instanceof TreeItem) {
					if (Util.isBlank(containerURI.lastSegment())) {
						containerURI = containerURI.trimSegments(1);
					}
					return containerURI.appendSegment(((TreeItem) eObj).getName());
				}
				return containerURI;
			}
			
			@Override
			public Collection<Rule> getRules() {
				return NotifierInspector.this.getRules();
			}

			@Override
			public void inspect(Notifier target, BiPredicate<? super Notifier, ? super InspectionResult> inspectionResultConsumer, Context context, ProgressMonitor progressMonitor) {
				if (predicate == null || predicate.test(target)) {
					AtomicBoolean isCancelled = new AtomicBoolean();
					BiPredicate<? super Notifier, ? super InspectionResult> filterInspectionResultConsumer = Inspector.filterInspectionResultConsumer(inspectionResultConsumer, () -> isCancelled.set(true));					
					if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled())) {					
						if (NotifierInspector.this.isForType(target.getClass())) {
							NotifierInspector.this.inspect(target, filterInspectionResultConsumer, context, progressMonitor);
						}
						if (target instanceof ResourceSet) {
							Stream<Resource> rStream = ((ResourceSet) target).getResources().stream();
							if (parallel) {
								rStream = rStream.parallel();
							} 
							rStream.forEach(resource -> {
								if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled())) {
									inspect(resource, filterInspectionResultConsumer, context, progressMonitor);
								}
							});
						} else if (target instanceof Resource) {
							Stream<EObject> contentsStream = ((Resource) target).getContents().stream();
							if (parallel) {
								contentsStream = contentsStream.parallel();
							}
							contentsStream.forEach(root -> {
								if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled())) {
									inspect(root, filterInspectionResultConsumer, context, progressMonitor);
								}
							});
						} else if (target instanceof EObject) {
							if (target instanceof TreeItem && ((TreeItem) target).eContainer() != null) {
								URI targetURI = resolve((TreeItem) target);
								if (targetURI != null) {
									if (target instanceof Tree && !Util.isBlank(targetURI.lastSegment())) {
										targetURI = targetURI.appendSegment("");
									}
									Resource eResource = ((TreeItem) target).eResource();
									if (eResource != null) {
										ResourceSet resourceSet = eResource.getResourceSet();
										if (resourceSet != null) {
											Resource targetResource = resourceSet.getResource(targetURI, true);
											inspect(targetResource, filterInspectionResultConsumer, context, progressMonitor);
										}
									}
								}
							}
							
							Stream<EObject> contentsStream = ((EObject) target).eContents().stream();
							if (parallel) {
								contentsStream = contentsStream.parallel();
							}
							contentsStream.forEach(contents -> {
								if (!isCancelled.get() && (progressMonitor == null || !progressMonitor.isCancelled())) {
									inspect(contents, filterInspectionResultConsumer, context, progressMonitor);
								}
							});
						}
					}
				}
			}

			@Override
			public boolean isForType(Class<?> targetType) {
				return Notifier.class.isAssignableFrom(targetType);
			}
			
		};
	}
	
	static NotifierInspector adapt(Inspector<? super Notifier> inspector) {
		return new NotifierInspector() {
			
			@Override
			public Collection<Rule> getRules() {
				return inspector.getRules();
			}
			
			@Override
			public void inspect(
					Notifier target, 
					BiPredicate<? super Notifier, ? super InspectionResult> inspectionResultConsumer, 
					Context context,
					ProgressMonitor progressMonitor) {
				
				inspector.inspect(target, (t,v) -> inspectionResultConsumer.test((Notifier) t, v), context, progressMonitor);
			}
			
			@Override
			public boolean isForType(Class<?> targetType) {
				return inspector.isForType(targetType);
			}
			
		};
	}

}

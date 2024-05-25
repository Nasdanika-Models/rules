package org.nasdanika.models.rules.util;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.nasdanika.capability.emf.ResourceSetRequirement;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.emf.persistence.ObjectLoaderCapabilityFactory;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.ncore.util.NcoreResourceSet;

/**
 * Loads {@link RuleSet}. Requirement is RuleSet ID 
 */
public abstract class RuleSetCapabilityFactory extends ObjectLoaderCapabilityFactory<Predicate<RuleSet>, RuleSet> {

	@Override
	public boolean isForServiceType(Class<?> type) {
		return RuleSet.class == type;
	}

	@Override
	protected RuleSet load(Predicate<RuleSet> requirement, ResourceSet resourceSet, ProgressMonitor progressMonitor) {
		RuleSet ruleSet = (RuleSet) resourceSet.getEObject(getResourceSetURI(), true);
		return requirement == null || requirement.test(ruleSet) ? ruleSet : null;
	}
	
	protected abstract URI getResourceSetURI();
	
	@Override
	protected ResourceSetRequirement getResourceSetRequirement(Predicate<RuleSet> serviceRequirement) {
		return new ResourceSetRequirement(new NcoreResourceSet(), null);
	}

}

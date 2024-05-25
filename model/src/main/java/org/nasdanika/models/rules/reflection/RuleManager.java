package org.nasdanika.models.rules.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.NasdanikaException;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.emf.persistence.EObjectLoader;
import org.nasdanika.exec.ExecPackage;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.ncore.NcorePackage;
import org.nasdanika.ncore.util.NcoreUtil;
import org.nasdanika.persistence.ConfigurationException;
import org.nasdanika.persistence.ObjectLoader;

/**
 * Resolves rules and rule sets by id or loads from a spec.
 * This interface can be implement by reflective target classes (factories).
 */
public interface RuleManager {

	/**
	 * Rule manager which can load rules from YAML spec, but cannot resolve them.
	 */
	static RuleManager LOADING_RULE_MANAGER = new RuleManager() {
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		
		private Collection<RuleSet> ruleSets;
		
		private synchronized Collection<RuleSet> getRuleSets(ProgressMonitor progressMonitor) {
			if (ruleSets == null) {
				ruleSets = Collections.synchronizedCollection(new ArrayList<>());
				Iterable<CapabilityProvider<Object>> ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);
				List<Throwable> failures = new ArrayList<>();
				for (CapabilityProvider<Object> provider: ruleSetProviders) {
					provider.getPublisher().subscribe(rs -> ruleSets.add(((RuleSet) rs).resolve()), failures::add);
				}
				
				if (failures.size() == 1) {
					throw new NasdanikaException("Error during rule set loading: " + failures.get(0), failures.get(0));
				} else if (!failures.isEmpty()) {
					NasdanikaException nasdanikaException = new NasdanikaException("Errors during rule set loading: " + failures);
					failures.forEach(nasdanikaException::addSuppressed);
					throw nasdanikaException;
				}
			}
			return ruleSets;
		}

		/**
		 * Resolves by URI
		 */
		@Override
		public RuleSet resolveRuleSet(Object target, String ruleSet, ProgressMonitor progressMonitor) {
			URI ruleSetURI = URI.createURI(ruleSet);
			for (RuleSet rs: getRuleSets(progressMonitor)) {
				for (URI uri: NcoreUtil.getIdentifiers(rs)) {
					if (ruleSetURI.equals(uri)) {
						return rs;
					}
				}
			}
			throw new IllegalArgumentException("Rule set not found: " + ruleSet);
		}
		
		@Override
		public Rule resolveRule(Method inspectorMethod, String rule, ProgressMonitor progressMonitor) {
			URI ruleURI = URI.createURI(rule);
			for (RuleSet rs: getRuleSets(progressMonitor)) {
				for (Rule r: rs.getRules()) {
					for (URI uri: NcoreUtil.getIdentifiers(r)) {
						if (ruleURI.equals(uri)) {
							return r;
						}
					}
				}
			}
			throw new IllegalArgumentException("Rule not found: " + rule);
		}
	};
	
	/**
	 * Resolves rule
	 * @param inspectorMethod Inspector method
	 * @param rule value of 'rule' attribute
	 * @return
	 */
	Rule resolveRule(Method inspectorMethod, String rule, ProgressMonitor progressMonitor);
	
	/**
	 * @param inspectorMethod Inspector method
	 * @param spec Rule (YAML) spec
	 * @return
	 */
	default Rule loadRule(Method inspectorMethod, String spec, ProgressMonitor progressMonitor) {
		EObjectLoader eObjectLoader = new EObjectLoader((ObjectLoader) null) {
			
			@Override
			public ResolutionResult resolveEClass(String type) {
				EClass eClass = (EClass) getType(type, inspectorMethod);
				return new ResolutionResult(eClass, null);
			}
			
		};
		
		Rule rule = createRule();
		
		URI baseURI = Util.createClassURI(inspectorMethod.getDeclaringClass());		
		eObjectLoader.loadYaml(
			spec, 
			rule, 
			baseURI, 
			null, 
			Collections.emptyList(), 
			progressMonitor);
		
		String methodName = inspectorMethod.getName();		
		if (Util.isBlank(rule.getName())) {
			rule.setName(Util.nameToLabel(methodName));
		}
		if (Util.isBlank(rule.getId())) {
			rule.setId(inspectorMethod.getDeclaringClass().getName() + "." + methodName);
		}

		return rule;
	}
	
	default Rule createRule() {
		return RulesFactory.eINSTANCE.createRule();
	}
	
	default Map<String, EPackage> getEPackages() {
		return Map.ofEntries(
				Map.entry("rules", RulesPackage.eINSTANCE),
				Map.entry("exec", ExecPackage.eINSTANCE),
				Map.entry("ncore", NcorePackage.eINSTANCE),
				Map.entry("ecore", EcorePackage.eINSTANCE));
	}
	
	default EClassifier getType(String type, Object source) {
		if (Util.isBlank(type)) {
			return null;
		}
		URI typeURI = URI.createURI(type);
		if (typeURI.hasFragment()) {
			URI ePackageNsURI = typeURI.trimFragment();
			for (EPackage ePackage: getEPackages().values()) {
				if (ePackageNsURI.equals(URI.createURI(ePackage.getNsURI()))) {
					String eClassifierName = typeURI.fragment().substring(2);
					EClassifier eClassifier = ePackage.getEClassifier(eClassifierName);
					if (eClassifier == null) {
						throw new IllegalArgumentException("EClassifier " + eClassifierName + " not found in EPackage: " + ePackageNsURI + " (" + source + ")"); 				
					}
					return eClassifier;
				}
			}
			throw new IllegalArgumentException("EPackage not found: " + ePackageNsURI + " (" + source + ")"); 
		}
		
		int dotIdx = type.indexOf('.');
		if (dotIdx == -1) {
			Optional<EClassifier> typeOpt = getEPackages()
				.values()	
				.stream()
				.flatMap(this::withSubPackages)
				.map(ep -> ep.getEClassifier(type))
				.filter(Objects::nonNull)
				.findFirst();
			
			if (typeOpt.isPresent()) {
				return typeOpt.get();
			}
			throw new IllegalArgumentException("Unknown type: " + type + " (" + source + ")"); 				
		}
		
		Optional<EClassifier> typeOpt = getEPackages()
				.entrySet()
				.stream()
				.filter(pe -> pe.getKey().equals(type.substring(0, dotIdx)))
				.map(Map.Entry::getValue)
				.map(ep -> findEClassifier(ep, type.substring(dotIdx + 1)))
				.filter(Objects::nonNull)
				.findFirst();
			
		if (typeOpt.isPresent()) {
			return typeOpt.get();
		}
		throw new ConfigurationException("Unknown type: " + type + " (" + source + ")"); 				
	}	
	
	private Stream<EPackage> withSubPackages(EPackage ePackage) {
		Stream<EPackage> subPackagesStream = ePackage
			.getESubpackages()
			.stream()
			.flatMap(this::withSubPackages);
		
		return Stream.concat(Stream.of(ePackage), subPackagesStream);
	}

	private EClassifier findEClassifier(EPackage ePackage, String name) {
		int dotIdx = name.indexOf('.');
		if (dotIdx == -1) {
			return ePackage.getEClassifier(name);
		}
		String spName = name.substring(0, dotIdx);
		Optional<EPackage> subPackageOpt = ePackage
				.getESubpackages()
				.stream()
				.filter(sp -> spName.equals(sp.getName()))
				.findFirst();
		
		return subPackageOpt.isPresent() ? findEClassifier(subPackageOpt.get(), name.substring(dotIdx + 1)) : null;		
	}
	
	/**
	 * Resolves rule set
	 * @param target 
	 * @param rule value of 'rule' attribute
	 * @return
	 */
	org.nasdanika.models.rules.RuleSet resolveRuleSet(Object target, String ruleSet, ProgressMonitor progressMonitor);
	
	default org.nasdanika.models.rules.RuleSet createRuleSet() {
		return RulesFactory.eINSTANCE.createRuleSet();
	}
	
	/**
	 * @param inspectorMethod Inspector method
	 * @param spec Rule (YAML) spec
	 * @return
	 */
	default org.nasdanika.models.rules.RuleSet loadRuleSet(Object target, String spec, ProgressMonitor progressMonitor) {
		EObjectLoader eObjectLoader = new EObjectLoader((ObjectLoader) null) {
			
			@Override
			public ResolutionResult resolveEClass(String type) {
				EClass eClass = (EClass) getType(type, target);
				return new ResolutionResult(eClass, null);
			}
			
		};
		
		org.nasdanika.models.rules.RuleSet ruleSet = createRuleSet();
		
		Class<? extends Object> clazz = target.getClass();
		URI baseURI = Util.createClassURI(clazz);		
		eObjectLoader.loadYaml(
			spec, 
			ruleSet, 
			baseURI, 
			null, 
			Collections.emptyList(), 
			progressMonitor);
			
		String className = clazz.getName();
		if (Util.isBlank(ruleSet.getName())) {
			int lastDot = className.lastIndexOf('.');
			ruleSet.setName(Util.nameToLabel(lastDot == -1 ? className : className.substring(lastDot + 1)));
		}
		
		if (Util.isBlank(ruleSet.getId())) {
			ruleSet.setId(className);
		}

		return ruleSet;		
	}

}

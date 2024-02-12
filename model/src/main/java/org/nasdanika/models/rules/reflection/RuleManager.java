package org.nasdanika.models.rules.reflection;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.emf.persistence.EObjectLoader;
import org.nasdanika.exec.ExecPackage;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.ncore.NcorePackage;
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
		
		@Override
		public RuleSet resolveRuleSet(Object target, String ruleSet, ProgressMonitor progressMonitor) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Rule resolveRule(Method inspectorMethod, String rule) {
			throw new UnsupportedOperationException();
		}
	};
	
	/**
	 * Resolves rule
	 * @param inspectorMethod Inspector method
	 * @param rule value of 'rule' attribute
	 * @return
	 */
	Rule resolveRule(Method inspectorMethod, String rule);
	
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
		
		URI baseURI = Util.createClassURI(target.getClass());		
			eObjectLoader.loadYaml(
					spec, 
					ruleSet, 
					baseURI, 
					null, 
					Collections.emptyList(), 
					progressMonitor);

		return ruleSet;		
	}

}

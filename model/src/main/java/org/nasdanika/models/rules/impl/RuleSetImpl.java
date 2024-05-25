/**
 */
package org.nasdanika.models.rules.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.models.architecture.impl.DomainImpl;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.models.rules.Severity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.RuleSetImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.impl.RuleSetImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.impl.RuleSetImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.impl.RuleSetImpl#getSeverities <em>Severities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleSetImpl extends DomainImpl implements RuleSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.RULE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<RuleSet> getExtends() {
		return (EList<RuleSet>)eDynamicGet(RulesPackage.RULE_SET__EXTENDS, RulesPackage.Literals.RULE_SET__EXTENDS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<RuleSet> getExtensions() {
		return (EList<RuleSet>)eDynamicGet(RulesPackage.RULE_SET__EXTENSIONS, RulesPackage.Literals.RULE_SET__EXTENSIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Rule> getRules() {
		return (EList<Rule>)eDynamicGet(RulesPackage.RULE_SET__RULES, RulesPackage.Literals.RULE_SET__RULES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Severity> getSeverities() {
		return (EList<Severity>)eDynamicGet(RulesPackage.RULE_SET__SEVERITIES, RulesPackage.Literals.RULE_SET__SEVERITIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public RuleSet resolve() {
		if (getExtends().isEmpty()) {
			return this;
		}
		RuleSet copy = EcoreUtil.copy(this);

		Map<Severity, Severity> severityMap = new IdentityHashMap<>();
		// Severities
		for (RuleSet base: getExtends()) {
			RuleSet resolvedBase = base.resolve();
			Z: for (Severity baseSeverity: resolvedBase.getSeverities()) {
				for (Severity severity: copy.getSeverities()) {
					if (Objects.equals(baseSeverity.getId(), severity.getId())) {
						severityMap.put(baseSeverity, severity);
						continue Z; // The base rule is present in the copy
					}
				}
				Severity severityCopy = EcoreUtil.copy(baseSeverity);
				copy.getSeverities().add(severityCopy); // Adding the base rule to the copy
				severityMap.put(baseSeverity, severityCopy);
			}
		}		
		
		for (RuleSet base: getExtends()) {
			RuleSet resolvedBase = base.resolve();
			Z: for (Rule baseRule: resolvedBase.getRules()) {
				for (Rule rule: copy.getRules()) {
					if (Objects.equals(baseRule.getId(), rule.getId())) {
						continue Z; // The base rule is present in the copy
					}
				}
				Rule ruleCopy = EcoreUtil.copy(baseRule);
				Severity severity = ruleCopy.getSeverity();
				if (severity != null) {
					Severity mappedSeverity = severityMap.get(severity);
					if (mappedSeverity != null) {
						ruleCopy.setSeverity(mappedSeverity);
					}
				}
							
				copy.getRules().add(ruleCopy); // Adding the base rule to the copy
			}
		}		
		
		Iterator<Rule> rit = copy.getRules().iterator();
		while (rit.hasNext()) {
			Rule rule = rit.next();
			if (rule.isSuppress()) {
				rit.remove();
			}
		}
		
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RulesPackage.RULE_SET__EXTENDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtends()).basicAdd(otherEnd, msgs);
			case RulesPackage.RULE_SET__EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtensions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RulesPackage.RULE_SET__EXTENDS:
				return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
			case RulesPackage.RULE_SET__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case RulesPackage.RULE_SET__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case RulesPackage.RULE_SET__SEVERITIES:
				return ((InternalEList<?>)getSeverities()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RulesPackage.RULE_SET__EXTENDS:
				return getExtends();
			case RulesPackage.RULE_SET__EXTENSIONS:
				return getExtensions();
			case RulesPackage.RULE_SET__RULES:
				return getRules();
			case RulesPackage.RULE_SET__SEVERITIES:
				return getSeverities();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RulesPackage.RULE_SET__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends RuleSet>)newValue);
				return;
			case RulesPackage.RULE_SET__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends RuleSet>)newValue);
				return;
			case RulesPackage.RULE_SET__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case RulesPackage.RULE_SET__SEVERITIES:
				getSeverities().clear();
				getSeverities().addAll((Collection<? extends Severity>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RulesPackage.RULE_SET__EXTENDS:
				getExtends().clear();
				return;
			case RulesPackage.RULE_SET__EXTENSIONS:
				getExtensions().clear();
				return;
			case RulesPackage.RULE_SET__RULES:
				getRules().clear();
				return;
			case RulesPackage.RULE_SET__SEVERITIES:
				getSeverities().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RulesPackage.RULE_SET__EXTENDS:
				return !getExtends().isEmpty();
			case RulesPackage.RULE_SET__EXTENSIONS:
				return !getExtensions().isEmpty();
			case RulesPackage.RULE_SET__RULES:
				return !getRules().isEmpty();
			case RulesPackage.RULE_SET__SEVERITIES:
				return !getSeverities().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RulesPackage.RULE_SET___RESOLVE:
				return resolve();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RuleSetImpl

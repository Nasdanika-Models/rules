/**
 */
package org.nasdanika.models.rules.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.InternalEList;

import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesPackage;

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
 * </ul>
 *
 * @generated
 */
public class RuleSetImpl extends MinimalEObjectImpl.Container implements RuleSet {
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
	@Override
	protected int eStaticFeatureCount() {
		return 0;
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
		}
		return super.eIsSet(featureID);
	}

} //RuleSetImpl

/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.models.architecture.impl.ArchitectureDescriptionElementImpl;

import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RulesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inspection Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.InspectionResultImpl#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InspectionResultImpl extends ArchitectureDescriptionElementImpl implements InspectionResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InspectionResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.INSPECTION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getRule() {
		return (Rule)eDynamicGet(RulesPackage.INSPECTION_RESULT__RULE, RulesPackage.Literals.INSPECTION_RESULT__RULE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetRule() {
		return (Rule)eDynamicGet(RulesPackage.INSPECTION_RESULT__RULE, RulesPackage.Literals.INSPECTION_RESULT__RULE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRule(Rule newRule) {
		eDynamicSet(RulesPackage.INSPECTION_RESULT__RULE, RulesPackage.Literals.INSPECTION_RESULT__RULE, newRule);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RulesPackage.INSPECTION_RESULT__RULE:
				if (resolve) return getRule();
				return basicGetRule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RulesPackage.INSPECTION_RESULT__RULE:
				setRule((Rule)newValue);
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
			case RulesPackage.INSPECTION_RESULT__RULE:
				setRule((Rule)null);
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
			case RulesPackage.INSPECTION_RESULT__RULE:
				return basicGetRule() != null;
		}
		return super.eIsSet(featureID);
	}

} //InspectionResultImpl

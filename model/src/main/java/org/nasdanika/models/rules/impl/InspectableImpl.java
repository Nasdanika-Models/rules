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

import org.nasdanika.models.rules.Inspectable;
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.models.rules.Waiver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inspectable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.InspectableImpl#getInspectionResults <em>Inspection Results</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.impl.InspectableImpl#getWaivers <em>Waivers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InspectableImpl extends MinimalEObjectImpl.Container implements Inspectable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InspectableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.INSPECTABLE;
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
	public EList<InspectionResult> getInspectionResults() {
		return (EList<InspectionResult>)eDynamicGet(RulesPackage.INSPECTABLE__INSPECTION_RESULTS, RulesPackage.Literals.INSPECTABLE__INSPECTION_RESULTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Waiver> getWaivers() {
		return (EList<Waiver>)eDynamicGet(RulesPackage.INSPECTABLE__WAIVERS, RulesPackage.Literals.INSPECTABLE__WAIVERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RulesPackage.INSPECTABLE__INSPECTION_RESULTS:
				return ((InternalEList<?>)getInspectionResults()).basicRemove(otherEnd, msgs);
			case RulesPackage.INSPECTABLE__WAIVERS:
				return ((InternalEList<?>)getWaivers()).basicRemove(otherEnd, msgs);
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
			case RulesPackage.INSPECTABLE__INSPECTION_RESULTS:
				return getInspectionResults();
			case RulesPackage.INSPECTABLE__WAIVERS:
				return getWaivers();
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
			case RulesPackage.INSPECTABLE__INSPECTION_RESULTS:
				getInspectionResults().clear();
				getInspectionResults().addAll((Collection<? extends InspectionResult>)newValue);
				return;
			case RulesPackage.INSPECTABLE__WAIVERS:
				getWaivers().clear();
				getWaivers().addAll((Collection<? extends Waiver>)newValue);
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
			case RulesPackage.INSPECTABLE__INSPECTION_RESULTS:
				getInspectionResults().clear();
				return;
			case RulesPackage.INSPECTABLE__WAIVERS:
				getWaivers().clear();
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
			case RulesPackage.INSPECTABLE__INSPECTION_RESULTS:
				return !getInspectionResults().isEmpty();
			case RulesPackage.INSPECTABLE__WAIVERS:
				return !getWaivers().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InspectableImpl

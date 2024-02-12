/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.models.rules.MoveResourceAction;
import org.nasdanika.models.rules.RulesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Move Resource Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.MoveResourceActionImpl#getNewIdentifier <em>New Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MoveResourceActionImpl extends ResourceActionImpl implements MoveResourceAction {
	/**
	 * The default value of the '{@link #getNewIdentifier() <em>New Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_IDENTIFIER_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoveResourceActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.MOVE_RESOURCE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNewIdentifier() {
		return (String)eDynamicGet(RulesPackage.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER, RulesPackage.Literals.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNewIdentifier(String newNewIdentifier) {
		eDynamicSet(RulesPackage.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER, RulesPackage.Literals.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER, newNewIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RulesPackage.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER:
				return getNewIdentifier();
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
			case RulesPackage.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER:
				setNewIdentifier((String)newValue);
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
			case RulesPackage.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER:
				setNewIdentifier(NEW_IDENTIFIER_EDEFAULT);
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
			case RulesPackage.MOVE_RESOURCE_ACTION__NEW_IDENTIFIER:
				return NEW_IDENTIFIER_EDEFAULT == null ? getNewIdentifier() != null : !NEW_IDENTIFIER_EDEFAULT.equals(getNewIdentifier());
		}
		return super.eIsSet(featureID);
	}

} //MoveResourceActionImpl

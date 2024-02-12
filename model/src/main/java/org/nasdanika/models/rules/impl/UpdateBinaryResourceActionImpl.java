/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.models.rules.BinaryResourceAction;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.models.rules.UpdateBinaryResourceAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Binary Resource Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.UpdateBinaryResourceActionImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdateBinaryResourceActionImpl extends UpdateResourceActionImpl implements UpdateBinaryResourceAction {
	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] CONTENT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateBinaryResourceActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.UPDATE_BINARY_RESOURCE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getContent() {
		return (byte[])eDynamicGet(RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT, RulesPackage.Literals.BINARY_RESOURCE_ACTION__CONTENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContent(byte[] newContent) {
		eDynamicSet(RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT, RulesPackage.Literals.BINARY_RESOURCE_ACTION__CONTENT, newContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT:
				return getContent();
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
			case RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT:
				setContent((byte[])newValue);
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
			case RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT:
				setContent(CONTENT_EDEFAULT);
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
			case RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT:
				return CONTENT_EDEFAULT == null ? getContent() != null : !CONTENT_EDEFAULT.equals(getContent());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BinaryResourceAction.class) {
			switch (derivedFeatureID) {
				case RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT: return RulesPackage.BINARY_RESOURCE_ACTION__CONTENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BinaryResourceAction.class) {
			switch (baseFeatureID) {
				case RulesPackage.BINARY_RESOURCE_ACTION__CONTENT: return RulesPackage.UPDATE_BINARY_RESOURCE_ACTION__CONTENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //UpdateBinaryResourceActionImpl

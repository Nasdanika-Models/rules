/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.models.rules.BinaryResourceAction;
import org.nasdanika.models.rules.RulesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Resource Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.BinaryResourceActionImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryResourceActionImpl extends ResourceActionImpl implements BinaryResourceAction {
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
	protected BinaryResourceActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.BINARY_RESOURCE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getContent() {
		return (byte[])eDynamicGet(RulesPackage.BINARY_RESOURCE_ACTION__CONTENT, RulesPackage.Literals.BINARY_RESOURCE_ACTION__CONTENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContent(byte[] newContent) {
		eDynamicSet(RulesPackage.BINARY_RESOURCE_ACTION__CONTENT, RulesPackage.Literals.BINARY_RESOURCE_ACTION__CONTENT, newContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RulesPackage.BINARY_RESOURCE_ACTION__CONTENT:
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
			case RulesPackage.BINARY_RESOURCE_ACTION__CONTENT:
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
			case RulesPackage.BINARY_RESOURCE_ACTION__CONTENT:
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
			case RulesPackage.BINARY_RESOURCE_ACTION__CONTENT:
				return CONTENT_EDEFAULT == null ? getContent() != null : !CONTENT_EDEFAULT.equals(getContent());
		}
		return super.eIsSet(featureID);
	}

} //BinaryResourceActionImpl

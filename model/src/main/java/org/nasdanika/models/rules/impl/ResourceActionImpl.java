/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.models.rules.ResourceAction;
import org.nasdanika.models.rules.RulesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.ResourceActionImpl#getResourceIdentifier <em>Resource Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceActionImpl extends ActionImpl implements ResourceAction {
	/**
	 * The default value of the '{@link #getResourceIdentifier() <em>Resource Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_IDENTIFIER_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.RESOURCE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceIdentifier() {
		return (String)eDynamicGet(RulesPackage.RESOURCE_ACTION__RESOURCE_IDENTIFIER, RulesPackage.Literals.RESOURCE_ACTION__RESOURCE_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceIdentifier(String newResourceIdentifier) {
		eDynamicSet(RulesPackage.RESOURCE_ACTION__RESOURCE_IDENTIFIER, RulesPackage.Literals.RESOURCE_ACTION__RESOURCE_IDENTIFIER, newResourceIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RulesPackage.RESOURCE_ACTION__RESOURCE_IDENTIFIER:
				return getResourceIdentifier();
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
			case RulesPackage.RESOURCE_ACTION__RESOURCE_IDENTIFIER:
				setResourceIdentifier((String)newValue);
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
			case RulesPackage.RESOURCE_ACTION__RESOURCE_IDENTIFIER:
				setResourceIdentifier(RESOURCE_IDENTIFIER_EDEFAULT);
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
			case RulesPackage.RESOURCE_ACTION__RESOURCE_IDENTIFIER:
				return RESOURCE_IDENTIFIER_EDEFAULT == null ? getResourceIdentifier() != null : !RESOURCE_IDENTIFIER_EDEFAULT.equals(getResourceIdentifier());
		}
		return super.eIsSet(featureID);
	}

} //ResourceActionImpl

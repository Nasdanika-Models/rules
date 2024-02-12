/**
 */
package org.nasdanika.models.rules;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Move Resource Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Moves (renames) the resources - changes its identifier
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.MoveResourceAction#getNewIdentifier <em>New Identifier</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getMoveResourceAction()
 * @model
 * @generated
 */
public interface MoveResourceAction extends ResourceAction {
	/**
	 * Returns the value of the '<em><b>New Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * New identifier
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>New Identifier</em>' attribute.
	 * @see #setNewIdentifier(String)
	 * @see org.nasdanika.models.rules.RulesPackage#getMoveResourceAction_NewIdentifier()
	 * @model
	 * @generated
	 */
	String getNewIdentifier();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.MoveResourceAction#getNewIdentifier <em>New Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Identifier</em>' attribute.
	 * @see #getNewIdentifier()
	 * @generated
	 */
	void setNewIdentifier(String value);

} // MoveResourceAction

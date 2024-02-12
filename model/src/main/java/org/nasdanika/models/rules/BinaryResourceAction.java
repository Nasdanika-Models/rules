/**
 */
package org.nasdanika.models.rules;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Resource Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.BinaryResourceAction#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getBinaryResourceAction()
 * @model
 * @generated
 */
public interface BinaryResourceAction extends ResourceAction {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(byte[])
	 * @see org.nasdanika.models.rules.RulesPackage#getBinaryResourceAction_Content()
	 * @model
	 * @generated
	 */
	byte[] getContent();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.BinaryResourceAction#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(byte[] value);

} // BinaryResourceAction

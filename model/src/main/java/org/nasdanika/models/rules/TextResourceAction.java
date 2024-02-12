/**
 */
package org.nasdanika.models.rules;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Resource Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.TextResourceAction#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getTextResourceAction()
 * @model
 * @generated
 */
public interface TextResourceAction extends ResourceAction {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.nasdanika.models.rules.RulesPackage#getTextResourceAction_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.TextResourceAction#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // TextResourceAction

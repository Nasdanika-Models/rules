/**
 */
package org.nasdanika.models.rules;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An action on a resource identified by a string identifier, e.g. a path or URI
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.ResourceAction#getResourceIdentifier <em>Resource Identifier</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getResourceAction()
 * @model
 * @generated
 */
public interface ResourceAction extends Action {
	/**
	 * Returns the value of the '<em><b>Resource Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resource identifier - path, URI, ...
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Identifier</em>' attribute.
	 * @see #setResourceIdentifier(String)
	 * @see org.nasdanika.models.rules.RulesPackage#getResourceAction_ResourceIdentifier()
	 * @model
	 * @generated
	 */
	String getResourceIdentifier();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.ResourceAction#getResourceIdentifier <em>Resource Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Identifier</em>' attribute.
	 * @see #getResourceIdentifier()
	 * @generated
	 */
	void setResourceIdentifier(String value);

} // ResourceAction

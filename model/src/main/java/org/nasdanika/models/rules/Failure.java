/**
 */
package org.nasdanika.models.rules;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.Failure#getCause <em>Cause</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getFailure()
 * @model
 * @generated
 */
public interface Failure extends InspectionResult {
	/**
	 * Returns the value of the '<em><b>Cause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cause</em>' containment reference.
	 * @see #setCause(org.nasdanika.ncore.Throwable)
	 * @see org.nasdanika.models.rules.RulesPackage#getFailure_Cause()
	 * @model containment="true"
	 * @generated
	 */
	org.nasdanika.ncore.Throwable getCause();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.Failure#getCause <em>Cause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cause</em>' containment reference.
	 * @see #getCause()
	 * @generated
	 */
	void setCause(org.nasdanika.ncore.Throwable value);

} // Failure

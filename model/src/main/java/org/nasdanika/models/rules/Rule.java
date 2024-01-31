/**
 */
package org.nasdanika.models.rules;

import org.nasdanika.models.architecture.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.Rule#isSuppress <em>Suppress</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.Rule#getSeverity <em>Severity</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Node {

	/**
	 * Returns the value of the '<em><b>Suppress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppress</em>' attribute.
	 * @see #setSuppress(boolean)
	 * @see org.nasdanika.models.rules.RulesPackage#getRule_Suppress()
	 * @model
	 * @generated
	 */
	boolean isSuppress();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.Rule#isSuppress <em>Suppress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppress</em>' attribute.
	 * @see #isSuppress()
	 * @generated
	 */
	void setSuppress(boolean value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.models.rules.Severity#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' reference.
	 * @see #setSeverity(Severity)
	 * @see org.nasdanika.models.rules.RulesPackage#getRule_Severity()
	 * @see org.nasdanika.models.rules.Severity#getRules
	 * @model opposite="rules" required="true"
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.Rule#getSeverity <em>Severity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' reference.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);
} // Rule

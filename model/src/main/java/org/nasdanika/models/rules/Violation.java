/**
 */
package org.nasdanika.models.rules;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Violation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.Violation#getWaivers <em>Waivers</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.Violation#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getViolation()
 * @model
 * @generated
 */
public interface Violation extends InspectionResult {
	/**
	 * Returns the value of the '<em><b>Waivers</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Waiver}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.models.rules.Waiver#getViolations <em>Violations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waivers</em>' reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getViolation_Waivers()
	 * @see org.nasdanika.models.rules.Waiver#getViolations
	 * @model opposite="violations"
	 * @generated
	 */
	EList<Waiver> getWaivers();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Actions to be taken to address the violation
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getViolation_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

} // Violation

/**
 */
package org.nasdanika.models.rules;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Waiver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.Waiver#getViolations <em>Violations</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getWaiver()
 * @model
 * @generated
 */
public interface Waiver extends EObject {
	/**
	 * Returns the value of the '<em><b>Violations</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Violation}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.models.rules.Violation#getWaivers <em>Waivers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Violations</em>' reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getWaiver_Violations()
	 * @see org.nasdanika.models.rules.Violation#getWaivers
	 * @model opposite="waivers"
	 * @generated
	 */
	EList<Violation> getViolations();

} // Waiver

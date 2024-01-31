/**
 */
package org.nasdanika.models.rules;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inspectable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.Inspectable#getViolations <em>Violations</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.Inspectable#getWaivers <em>Waivers</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getInspectable()
 * @model
 * @generated
 */
public interface Inspectable extends EObject {
	/**
	 * Returns the value of the '<em><b>Violations</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Violation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Violations</em>' containment reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getInspectable_Violations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Violation> getViolations();

	/**
	 * Returns the value of the '<em><b>Waivers</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Waiver}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waivers</em>' containment reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getInspectable_Waivers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Waiver> getWaivers();

} // Inspectable

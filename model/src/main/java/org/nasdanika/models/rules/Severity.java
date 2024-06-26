/**
 */
package org.nasdanika.models.rules;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.models.architecture.ArchitectureDescriptionElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Severity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.Severity#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getSeverity()
 * @model
 * @generated
 */
public interface Severity extends ArchitectureDescriptionElement {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Rule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getSeverity_Rules()
	 * @model transient="true" changeable="false" derived="true"
	 *        annotation="urn:org.nasdanika opposite='severity'"
	 * @generated
	 */
	EList<Rule> getRules();

} // Severity

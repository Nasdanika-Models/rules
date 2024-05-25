/**
 */
package org.nasdanika.models.rules;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.models.architecture.Domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.RuleSet#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.RuleSet#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.RuleSet#getRules <em>Rules</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.RuleSet#getSeverities <em>Severities</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.RulesPackage#getRuleSet()
 * @model
 * @generated
 */
public interface RuleSet extends Domain {
	
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.RuleSet}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.models.rules.RuleSet#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getRuleSet_Extends()
	 * @see org.nasdanika.models.rules.RuleSet#getExtensions
	 * @model opposite="extensions"
	 * @generated
	 */
	EList<RuleSet> getExtends();

	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.RuleSet}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.models.rules.RuleSet#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getRuleSet_Extensions()
	 * @see org.nasdanika.models.rules.RuleSet#getExtends
	 * @model opposite="extends"
	 * @generated
	 */
	EList<RuleSet> getExtensions();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Rule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getRuleSet_Rules()
	 * @model containment="true" keys="id"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Severities</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.models.rules.Severity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severities</em>' containment reference list.
	 * @see org.nasdanika.models.rules.RulesPackage#getRuleSet_Severities()
	 * @model containment="true" keys="id"
	 *        annotation="urn:org.nasdanika homogeneous='true'"
	 * @generated
	 */
	EList<Severity> getSeverities();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	RuleSet resolve();

} // RuleSet

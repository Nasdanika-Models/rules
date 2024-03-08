/**
 */
package org.nasdanika.models.rules;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.models.rules.RulesPackage
 * @generated
 */
public interface RulesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RulesFactory eINSTANCE = org.nasdanika.models.rules.impl.RulesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
	Rule createRule();

	/**
	 * Returns a new object of class '<em>Rule Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Set</em>'.
	 * @generated
	 */
	RuleSet createRuleSet();

	/**
	 * Returns a new object of class '<em>Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Violation</em>'.
	 * @generated
	 */
	Violation createViolation();

	/**
	 * Returns a new object of class '<em>Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failure</em>'.
	 * @generated
	 */
	Failure createFailure();

	/**
	 * Returns a new object of class '<em>Waiver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Waiver</em>'.
	 * @generated
	 */
	Waiver createWaiver();

	/**
	 * Returns a new object of class '<em>Inspectable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inspectable</em>'.
	 * @generated
	 */
	Inspectable createInspectable();

	/**
	 * Returns a new object of class '<em>Inspection Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inspection Result</em>'.
	 * @generated
	 */
	InspectionResult createInspectionResult();

	/**
	 * Returns a new object of class '<em>Severity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Severity</em>'.
	 * @generated
	 */
	Severity createSeverity();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Action</em>'.
	 * @generated
	 */
	ResourceAction createResourceAction();

	/**
	 * Returns a new object of class '<em>Text Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Resource Action</em>'.
	 * @generated
	 */
	TextResourceAction createTextResourceAction();

	/**
	 * Returns a new object of class '<em>Binary Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Resource Action</em>'.
	 * @generated
	 */
	BinaryResourceAction createBinaryResourceAction();

	/**
	 * Returns a new object of class '<em>Create Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Resource Action</em>'.
	 * @generated
	 */
	CreateResourceAction createCreateResourceAction();

	/**
	 * Returns a new object of class '<em>Create Text Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Text Resource Action</em>'.
	 * @generated
	 */
	CreateTextResourceAction createCreateTextResourceAction();

	/**
	 * Returns a new object of class '<em>Create Binary Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Binary Resource Action</em>'.
	 * @generated
	 */
	CreateBinaryResourceAction createCreateBinaryResourceAction();

	/**
	 * Returns a new object of class '<em>Delete Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Resource Action</em>'.
	 * @generated
	 */
	DeleteResourceAction createDeleteResourceAction();

	/**
	 * Returns a new object of class '<em>Move Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move Resource Action</em>'.
	 * @generated
	 */
	MoveResourceAction createMoveResourceAction();

	/**
	 * Returns a new object of class '<em>Update Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Resource Action</em>'.
	 * @generated
	 */
	UpdateResourceAction createUpdateResourceAction();

	/**
	 * Returns a new object of class '<em>Update Text Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Text Resource Action</em>'.
	 * @generated
	 */
	UpdateTextResourceAction createUpdateTextResourceAction();

	/**
	 * Returns a new object of class '<em>Update Binary Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Binary Resource Action</em>'.
	 * @generated
	 */
	UpdateBinaryResourceAction createUpdateBinaryResourceAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RulesPackage getRulesPackage();

} //RulesFactory

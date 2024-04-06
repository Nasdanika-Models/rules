/**
 */
package org.nasdanika.models.rules.java;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.models.rules.java.JavaPackage
 * @generated
 */
public interface JavaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavaFactory eINSTANCE = org.nasdanika.models.rules.java.impl.JavaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compilation Unit Action</em>'.
	 * @generated
	 */
	CompilationUnitAction createCompilationUnitAction();

	/**
	 * Returns a new object of class '<em>Create Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Compilation Unit Action</em>'.
	 * @generated
	 */
	CreateCompilationUnitAction createCreateCompilationUnitAction();

	/**
	 * Returns a new object of class '<em>Delete Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Compilation Unit Action</em>'.
	 * @generated
	 */
	DeleteCompilationUnitAction createDeleteCompilationUnitAction();

	/**
	 * Returns a new object of class '<em>Update Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Compilation Unit Action</em>'.
	 * @generated
	 */
	UpdateCompilationUnitAction createUpdateCompilationUnitAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavaPackage getJavaPackage();

} //JavaFactory

/**
 */
package org.nasdanika.models.rules.processors.ecore.java;

import org.nasdanika.models.java.CompilationUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Compilation Unit Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.java.DeleteCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.java.JavaPackage#getDeleteCompilationUnitAction()
 * @model
 * @generated
 */
public interface DeleteCompilationUnitAction extends CompilationUnitAction {
	/**
	 * Returns the value of the '<em><b>Compilation Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compilation Unit</em>' reference.
	 * @see #setCompilationUnit(CompilationUnit)
	 * @see org.nasdanika.models.rules.java.JavaPackage#getDeleteCompilationUnitAction_CompilationUnit()
	 * @model
	 * @generated
	 */
	CompilationUnit getCompilationUnit();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.java.DeleteCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compilation Unit</em>' reference.
	 * @see #getCompilationUnit()
	 * @generated
	 */
	void setCompilationUnit(CompilationUnit value);

} // DeleteCompilationUnitAction

/**
 */
package org.nasdanika.models.rules.java;

import org.nasdanika.models.java.CompilationUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Compilation Unit Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.java.CreateCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.java.JavaPackage#getCreateCompilationUnitAction()
 * @model
 * @generated
 */
public interface CreateCompilationUnitAction extends CompilationUnitAction {
	/**
	 * Returns the value of the '<em><b>Compilation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compilation Unit</em>' containment reference.
	 * @see #setCompilationUnit(CompilationUnit)
	 * @see org.nasdanika.models.rules.java.JavaPackage#getCreateCompilationUnitAction_CompilationUnit()
	 * @model containment="true"
	 * @generated
	 */
	CompilationUnit getCompilationUnit();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.java.CreateCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compilation Unit</em>' containment reference.
	 * @see #getCompilationUnit()
	 * @generated
	 */
	void setCompilationUnit(CompilationUnit value);

} // CreateCompilationUnitAction

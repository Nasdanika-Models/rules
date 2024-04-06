/**
 */
package org.nasdanika.models.rules.java;

import org.nasdanika.models.java.CompilationUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Compilation Unit Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.java.UpdateCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.models.rules.java.JavaPackage#getUpdateCompilationUnitAction()
 * @model
 * @generated
 */
public interface UpdateCompilationUnitAction extends CompilationUnitAction {
	/**
	 * Returns the value of the '<em><b>Compilation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compilation Unit</em>' containment reference.
	 * @see #setCompilationUnit(CompilationUnit)
	 * @see org.nasdanika.models.rules.java.JavaPackage#getUpdateCompilationUnitAction_CompilationUnit()
	 * @model containment="true"
	 * @generated
	 */
	CompilationUnit getCompilationUnit();

	/**
	 * Sets the value of the '{@link org.nasdanika.models.rules.java.UpdateCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compilation Unit</em>' containment reference.
	 * @see #getCompilationUnit()
	 * @generated
	 */
	void setCompilationUnit(CompilationUnit value);

} // UpdateCompilationUnitAction

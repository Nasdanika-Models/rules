/**
 */
package org.nasdanika.models.rules.java.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.models.java.CompilationUnit;

import org.nasdanika.models.rules.java.DeleteCompilationUnitAction;
import org.nasdanika.models.rules.java.JavaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Compilation Unit Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.java.impl.DeleteCompilationUnitActionImpl#getCompilationUnit <em>Compilation Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeleteCompilationUnitActionImpl extends CompilationUnitActionImpl implements DeleteCompilationUnitAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteCompilationUnitActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.DELETE_COMPILATION_UNIT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompilationUnit getCompilationUnit() {
		return (CompilationUnit)eDynamicGet(JavaPackage.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, JavaPackage.Literals.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationUnit basicGetCompilationUnit() {
		return (CompilationUnit)eDynamicGet(JavaPackage.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, JavaPackage.Literals.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompilationUnit(CompilationUnit newCompilationUnit) {
		eDynamicSet(JavaPackage.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, JavaPackage.Literals.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, newCompilationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
				if (resolve) return getCompilationUnit();
				return basicGetCompilationUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaPackage.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
				setCompilationUnit((CompilationUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JavaPackage.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
				setCompilationUnit((CompilationUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JavaPackage.DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
				return basicGetCompilationUnit() != null;
		}
		return super.eIsSet(featureID);
	}

} //DeleteCompilationUnitActionImpl

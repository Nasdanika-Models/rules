/**
 */
package org.nasdanika.models.rules.java.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.nasdanika.models.java.CompilationUnit;

import org.nasdanika.models.rules.java.JavaPackage;
import org.nasdanika.models.rules.java.UpdateCompilationUnitAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Compilation Unit Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.java.impl.UpdateCompilationUnitActionImpl#getCompilationUnit <em>Compilation Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdateCompilationUnitActionImpl extends CompilationUnitActionImpl implements UpdateCompilationUnitAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateCompilationUnitActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.UPDATE_COMPILATION_UNIT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompilationUnit getCompilationUnit() {
		return (CompilationUnit)eDynamicGet(JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, JavaPackage.Literals.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompilationUnit(CompilationUnit newCompilationUnit, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newCompilationUnit, JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompilationUnit(CompilationUnit newCompilationUnit) {
		eDynamicSet(JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, JavaPackage.Literals.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT, newCompilationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
				return basicSetCompilationUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
				return getCompilationUnit();
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
			case JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
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
			case JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
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
			case JavaPackage.UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT:
				return getCompilationUnit() != null;
		}
		return super.eIsSet(featureID);
	}

} //UpdateCompilationUnitActionImpl

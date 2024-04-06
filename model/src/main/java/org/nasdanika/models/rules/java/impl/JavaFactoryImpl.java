/**
 */
package org.nasdanika.models.rules.java.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.models.rules.java.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaFactoryImpl extends EFactoryImpl implements JavaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavaFactory init() {
		try {
			JavaFactory theJavaFactory = (JavaFactory)EPackage.Registry.INSTANCE.getEFactory(JavaPackage.eNS_URI);
			if (theJavaFactory != null) {
				return theJavaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JavaPackage.COMPILATION_UNIT_ACTION: return createCompilationUnitAction();
			case JavaPackage.CREATE_COMPILATION_UNIT_ACTION: return createCreateCompilationUnitAction();
			case JavaPackage.DELETE_COMPILATION_UNIT_ACTION: return createDeleteCompilationUnitAction();
			case JavaPackage.UPDATE_COMPILATION_UNIT_ACTION: return createUpdateCompilationUnitAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompilationUnitAction createCompilationUnitAction() {
		CompilationUnitActionImpl compilationUnitAction = new CompilationUnitActionImpl();
		return compilationUnitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreateCompilationUnitAction createCreateCompilationUnitAction() {
		CreateCompilationUnitActionImpl createCompilationUnitAction = new CreateCompilationUnitActionImpl();
		return createCompilationUnitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeleteCompilationUnitAction createDeleteCompilationUnitAction() {
		DeleteCompilationUnitActionImpl deleteCompilationUnitAction = new DeleteCompilationUnitActionImpl();
		return deleteCompilationUnitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UpdateCompilationUnitAction createUpdateCompilationUnitAction() {
		UpdateCompilationUnitActionImpl updateCompilationUnitAction = new UpdateCompilationUnitActionImpl();
		return updateCompilationUnitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaPackage getJavaPackage() {
		return (JavaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavaPackage getPackage() {
		return JavaPackage.eINSTANCE;
	}

} //JavaFactoryImpl

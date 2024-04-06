/**
 */
package org.nasdanika.models.rules.java.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.nasdanika.drawio.model.ModelPackage;

import org.nasdanika.models.architecture.ArchitecturePackage;

import org.nasdanika.models.coverage.CoveragePackage;

import org.nasdanika.models.party.PartyPackage;

import org.nasdanika.models.rules.RulesPackage;

import org.nasdanika.models.rules.impl.RulesPackageImpl;

import org.nasdanika.models.rules.java.CompilationUnitAction;
import org.nasdanika.models.rules.java.CreateCompilationUnitAction;
import org.nasdanika.models.rules.java.DeleteCompilationUnitAction;
import org.nasdanika.models.rules.java.JavaFactory;
import org.nasdanika.models.rules.java.JavaPackage;
import org.nasdanika.models.rules.java.UpdateCompilationUnitAction;

import org.nasdanika.ncore.NcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaPackageImpl extends EPackageImpl implements JavaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilationUnitActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createCompilationUnitActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteCompilationUnitActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateCompilationUnitActionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.nasdanika.models.rules.java.JavaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavaPackageImpl() {
		super(eNS_URI, JavaFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link JavaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavaPackage init() {
		if (isInited) return (JavaPackage)EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredJavaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		JavaPackageImpl theJavaPackage = registeredJavaPackage instanceof JavaPackageImpl ? (JavaPackageImpl)registeredJavaPackage : new JavaPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ArchitecturePackage.eINSTANCE.eClass();
		CoveragePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		org.nasdanika.graph.model.ModelPackage.eINSTANCE.eClass();
		org.nasdanika.models.java.JavaPackage.eINSTANCE.eClass();
		NcorePackage.eINSTANCE.eClass();
		PartyPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);
		RulesPackageImpl theRulesPackage = (RulesPackageImpl)(registeredPackage instanceof RulesPackageImpl ? registeredPackage : RulesPackage.eINSTANCE);

		// Create package meta-data objects
		theJavaPackage.createPackageContents();
		theRulesPackage.createPackageContents();

		// Initialize created meta-data
		theJavaPackage.initializePackageContents();
		theRulesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavaPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI, theJavaPackage);
		return theJavaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompilationUnitAction() {
		return compilationUnitActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreateCompilationUnitAction() {
		return createCompilationUnitActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCreateCompilationUnitAction_CompilationUnit() {
		return (EReference)createCompilationUnitActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeleteCompilationUnitAction() {
		return deleteCompilationUnitActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeleteCompilationUnitAction_CompilationUnit() {
		return (EReference)deleteCompilationUnitActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUpdateCompilationUnitAction() {
		return updateCompilationUnitActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUpdateCompilationUnitAction_CompilationUnit() {
		return (EReference)updateCompilationUnitActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaFactory getJavaFactory() {
		return (JavaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		compilationUnitActionEClass = createEClass(COMPILATION_UNIT_ACTION);

		createCompilationUnitActionEClass = createEClass(CREATE_COMPILATION_UNIT_ACTION);
		createEReference(createCompilationUnitActionEClass, CREATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT);

		deleteCompilationUnitActionEClass = createEClass(DELETE_COMPILATION_UNIT_ACTION);
		createEReference(deleteCompilationUnitActionEClass, DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT);

		updateCompilationUnitActionEClass = createEClass(UPDATE_COMPILATION_UNIT_ACTION);
		createEReference(updateCompilationUnitActionEClass, UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RulesPackage theRulesPackage = (RulesPackage)EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);
		org.nasdanika.models.java.JavaPackage theJavaPackage_1 = (org.nasdanika.models.java.JavaPackage)EPackage.Registry.INSTANCE.getEPackage(org.nasdanika.models.java.JavaPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compilationUnitActionEClass.getESuperTypes().add(theRulesPackage.getAction());
		createCompilationUnitActionEClass.getESuperTypes().add(this.getCompilationUnitAction());
		deleteCompilationUnitActionEClass.getESuperTypes().add(this.getCompilationUnitAction());
		updateCompilationUnitActionEClass.getESuperTypes().add(this.getCompilationUnitAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(compilationUnitActionEClass, CompilationUnitAction.class, "CompilationUnitAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createCompilationUnitActionEClass, CreateCompilationUnitAction.class, "CreateCompilationUnitAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateCompilationUnitAction_CompilationUnit(), theJavaPackage_1.getCompilationUnit(), null, "compilationUnit", null, 0, 1, CreateCompilationUnitAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteCompilationUnitActionEClass, DeleteCompilationUnitAction.class, "DeleteCompilationUnitAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteCompilationUnitAction_CompilationUnit(), theJavaPackage_1.getCompilationUnit(), null, "compilationUnit", null, 0, 1, DeleteCompilationUnitAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateCompilationUnitActionEClass, UpdateCompilationUnitAction.class, "UpdateCompilationUnitAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateCompilationUnitAction_CompilationUnit(), theJavaPackage_1.getCompilationUnit(), null, "compilationUnit", null, 0, 1, UpdateCompilationUnitAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";
		addAnnotation
		  (compilationUnitActionEClass,
		   source,
		   new String[] {
			   "documentation", "An action on a compilation unit"
		   });
	}

} //JavaPackageImpl

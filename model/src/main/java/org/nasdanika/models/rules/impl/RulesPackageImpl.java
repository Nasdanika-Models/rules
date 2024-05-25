/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.nasdanika.drawio.model.ModelPackage;
import org.nasdanika.models.architecture.ArchitecturePackage;
import org.nasdanika.models.coverage.CoveragePackage;
import org.nasdanika.models.java.JavaPackage;
import org.nasdanika.models.party.PartyPackage;
import org.nasdanika.models.rules.Action;
import org.nasdanika.models.rules.BinaryResourceAction;
import org.nasdanika.models.rules.CreateBinaryResourceAction;
import org.nasdanika.models.rules.CreateResourceAction;
import org.nasdanika.models.rules.CreateTextResourceAction;
import org.nasdanika.models.rules.DeleteResourceAction;
import org.nasdanika.models.rules.Failure;
import org.nasdanika.models.rules.Inspectable;
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.MoveResourceAction;
import org.nasdanika.models.rules.ResourceAction;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.models.rules.Severity;
import org.nasdanika.models.rules.TextResourceAction;
import org.nasdanika.models.rules.UpdateBinaryResourceAction;
import org.nasdanika.models.rules.UpdateResourceAction;
import org.nasdanika.models.rules.UpdateTextResourceAction;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.models.rules.Waiver;
import org.nasdanika.models.rules.java.impl.JavaPackageImpl;
import org.nasdanika.models.source.SourcePackage;
import org.nasdanika.ncore.NcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RulesPackageImpl extends EPackageImpl implements RulesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSetEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass violationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waiverEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inspectableEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inspectionResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass severityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createTextResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createBinaryResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moveResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateTextResourceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateBinaryResourceActionEClass = null;

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
	 * @see org.nasdanika.models.rules.RulesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RulesPackageImpl() {
		super(eNS_URI, RulesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RulesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RulesPackage init() {
		if (isInited) return (RulesPackage)EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRulesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RulesPackageImpl theRulesPackage = registeredRulesPackage instanceof RulesPackageImpl ? (RulesPackageImpl)registeredRulesPackage : new RulesPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ArchitecturePackage.eINSTANCE.eClass();
		CoveragePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		org.nasdanika.graph.model.ModelPackage.eINSTANCE.eClass();
		JavaPackage.eINSTANCE.eClass();
		NcorePackage.eINSTANCE.eClass();
		PartyPackage.eINSTANCE.eClass();
		SourcePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(org.nasdanika.models.rules.java.JavaPackage.eNS_URI);
		JavaPackageImpl theJavaPackage_1 = (JavaPackageImpl)(registeredPackage instanceof JavaPackageImpl ? registeredPackage : org.nasdanika.models.rules.java.JavaPackage.eINSTANCE);

		// Create package meta-data objects
		theRulesPackage.createPackageContents();
		theJavaPackage_1.createPackageContents();

		// Initialize created meta-data
		theRulesPackage.initializePackageContents();
		theJavaPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRulesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RulesPackage.eNS_URI, theRulesPackage);
		return theRulesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRule_Suppress() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Severity() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Actions() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRuleSet() {
		return ruleSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRuleSet_Extends() {
		return (EReference)ruleSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRuleSet_Extensions() {
		return (EReference)ruleSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRuleSet_Rules() {
		return (EReference)ruleSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRuleSet_Severities() {
		return (EReference)ruleSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRuleSet__Resolve() {
		return ruleSetEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getViolation() {
		return violationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getViolation_Waivers() {
		return (EReference)violationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getViolation_Actions() {
		return (EReference)violationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFailure() {
		return failureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFailure_Cause() {
		return (EReference)failureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWaiver() {
		return waiverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWaiver_Violations() {
		return (EReference)waiverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInspectable() {
		return inspectableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInspectable_InspectionResults() {
		return (EReference)inspectableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInspectable_Waivers() {
		return (EReference)inspectableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInspectionResult() {
		return inspectionResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInspectionResult_Rule() {
		return (EReference)inspectionResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSeverity() {
		return severityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSeverity_Rules() {
		return (EReference)severityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourceAction() {
		return resourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceAction_ResourceIdentifier() {
		return (EAttribute)resourceActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTextResourceAction() {
		return textResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTextResourceAction_Content() {
		return (EAttribute)textResourceActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBinaryResourceAction() {
		return binaryResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBinaryResourceAction_Content() {
		return (EAttribute)binaryResourceActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreateResourceAction() {
		return createResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreateTextResourceAction() {
		return createTextResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreateBinaryResourceAction() {
		return createBinaryResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeleteResourceAction() {
		return deleteResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMoveResourceAction() {
		return moveResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMoveResourceAction_NewIdentifier() {
		return (EAttribute)moveResourceActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUpdateResourceAction() {
		return updateResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUpdateTextResourceAction() {
		return updateTextResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUpdateBinaryResourceAction() {
		return updateBinaryResourceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RulesFactory getRulesFactory() {
		return (RulesFactory)getEFactoryInstance();
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
		ruleEClass = createEClass(RULE);
		createEAttribute(ruleEClass, RULE__SUPPRESS);
		createEReference(ruleEClass, RULE__SEVERITY);
		createEReference(ruleEClass, RULE__ACTIONS);

		ruleSetEClass = createEClass(RULE_SET);
		createEReference(ruleSetEClass, RULE_SET__EXTENDS);
		createEReference(ruleSetEClass, RULE_SET__EXTENSIONS);
		createEReference(ruleSetEClass, RULE_SET__RULES);
		createEReference(ruleSetEClass, RULE_SET__SEVERITIES);
		createEOperation(ruleSetEClass, RULE_SET___RESOLVE);

		inspectableEClass = createEClass(INSPECTABLE);
		createEReference(inspectableEClass, INSPECTABLE__INSPECTION_RESULTS);
		createEReference(inspectableEClass, INSPECTABLE__WAIVERS);

		inspectionResultEClass = createEClass(INSPECTION_RESULT);
		createEReference(inspectionResultEClass, INSPECTION_RESULT__RULE);

		violationEClass = createEClass(VIOLATION);
		createEReference(violationEClass, VIOLATION__WAIVERS);
		createEReference(violationEClass, VIOLATION__ACTIONS);

		failureEClass = createEClass(FAILURE);
		createEReference(failureEClass, FAILURE__CAUSE);

		waiverEClass = createEClass(WAIVER);
		createEReference(waiverEClass, WAIVER__VIOLATIONS);

		severityEClass = createEClass(SEVERITY);
		createEReference(severityEClass, SEVERITY__RULES);

		actionEClass = createEClass(ACTION);

		resourceActionEClass = createEClass(RESOURCE_ACTION);
		createEAttribute(resourceActionEClass, RESOURCE_ACTION__RESOURCE_IDENTIFIER);

		textResourceActionEClass = createEClass(TEXT_RESOURCE_ACTION);
		createEAttribute(textResourceActionEClass, TEXT_RESOURCE_ACTION__CONTENT);

		binaryResourceActionEClass = createEClass(BINARY_RESOURCE_ACTION);
		createEAttribute(binaryResourceActionEClass, BINARY_RESOURCE_ACTION__CONTENT);

		createResourceActionEClass = createEClass(CREATE_RESOURCE_ACTION);

		createTextResourceActionEClass = createEClass(CREATE_TEXT_RESOURCE_ACTION);

		createBinaryResourceActionEClass = createEClass(CREATE_BINARY_RESOURCE_ACTION);

		deleteResourceActionEClass = createEClass(DELETE_RESOURCE_ACTION);

		moveResourceActionEClass = createEClass(MOVE_RESOURCE_ACTION);
		createEAttribute(moveResourceActionEClass, MOVE_RESOURCE_ACTION__NEW_IDENTIFIER);

		updateResourceActionEClass = createEClass(UPDATE_RESOURCE_ACTION);

		updateTextResourceActionEClass = createEClass(UPDATE_TEXT_RESOURCE_ACTION);

		updateBinaryResourceActionEClass = createEClass(UPDATE_BINARY_RESOURCE_ACTION);
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
		org.nasdanika.models.rules.java.JavaPackage theJavaPackage_1 = (org.nasdanika.models.rules.java.JavaPackage)EPackage.Registry.INSTANCE.getEPackage(org.nasdanika.models.rules.java.JavaPackage.eNS_URI);
		ArchitecturePackage theArchitecturePackage = (ArchitecturePackage)EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);
		NcorePackage theNcorePackage = (NcorePackage)EPackage.Registry.INSTANCE.getEPackage(NcorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theJavaPackage_1);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ruleEClass.getESuperTypes().add(theArchitecturePackage.getNode());
		ruleSetEClass.getESuperTypes().add(theArchitecturePackage.getDomain());
		inspectionResultEClass.getESuperTypes().add(theArchitecturePackage.getArchitectureDescriptionElement());
		violationEClass.getESuperTypes().add(this.getInspectionResult());
		failureEClass.getESuperTypes().add(this.getInspectionResult());
		waiverEClass.getESuperTypes().add(theArchitecturePackage.getArchitectureDescriptionElement());
		severityEClass.getESuperTypes().add(theArchitecturePackage.getArchitectureDescriptionElement());
		actionEClass.getESuperTypes().add(theArchitecturePackage.getNode());
		resourceActionEClass.getESuperTypes().add(this.getAction());
		textResourceActionEClass.getESuperTypes().add(this.getResourceAction());
		binaryResourceActionEClass.getESuperTypes().add(this.getResourceAction());
		createResourceActionEClass.getESuperTypes().add(this.getResourceAction());
		createTextResourceActionEClass.getESuperTypes().add(this.getCreateResourceAction());
		createTextResourceActionEClass.getESuperTypes().add(this.getTextResourceAction());
		createBinaryResourceActionEClass.getESuperTypes().add(this.getCreateResourceAction());
		createBinaryResourceActionEClass.getESuperTypes().add(this.getBinaryResourceAction());
		deleteResourceActionEClass.getESuperTypes().add(this.getResourceAction());
		moveResourceActionEClass.getESuperTypes().add(this.getResourceAction());
		updateResourceActionEClass.getESuperTypes().add(this.getResourceAction());
		updateTextResourceActionEClass.getESuperTypes().add(this.getUpdateResourceAction());
		updateTextResourceActionEClass.getESuperTypes().add(this.getTextResourceAction());
		updateBinaryResourceActionEClass.getESuperTypes().add(this.getUpdateResourceAction());
		updateBinaryResourceActionEClass.getESuperTypes().add(this.getBinaryResourceAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRule_Suppress(), ecorePackage.getEBoolean(), "suppress", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Severity(), this.getSeverity(), this.getSeverity_Rules(), "severity", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Actions(), this.getAction(), null, "actions", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleSetEClass, RuleSet.class, "RuleSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleSet_Extends(), this.getRuleSet(), this.getRuleSet_Extensions(), "extends", null, 0, -1, RuleSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleSet_Extensions(), this.getRuleSet(), this.getRuleSet_Extends(), "extensions", null, 0, -1, RuleSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleSet_Rules(), this.getRule(), null, "rules", null, 0, -1, RuleSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getRuleSet_Rules().getEKeys().add(theNcorePackage.getStringIdentity_Id());
		initEReference(getRuleSet_Severities(), this.getSeverity(), null, "severities", null, 0, -1, RuleSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getRuleSet_Severities().getEKeys().add(theNcorePackage.getStringIdentity_Id());

		initEOperation(getRuleSet__Resolve(), this.getRuleSet(), "resolve", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inspectableEClass, Inspectable.class, "Inspectable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInspectable_InspectionResults(), this.getInspectionResult(), null, "inspectionResults", null, 0, -1, Inspectable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInspectable_Waivers(), this.getWaiver(), null, "waivers", null, 0, -1, Inspectable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inspectionResultEClass, InspectionResult.class, "InspectionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInspectionResult_Rule(), this.getRule(), null, "rule", null, 1, 1, InspectionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(violationEClass, Violation.class, "Violation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViolation_Waivers(), this.getWaiver(), this.getWaiver_Violations(), "waivers", null, 0, -1, Violation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViolation_Actions(), this.getAction(), null, "actions", null, 0, -1, Violation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(failureEClass, Failure.class, "Failure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFailure_Cause(), theNcorePackage.getThrowable(), null, "cause", null, 0, 1, Failure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waiverEClass, Waiver.class, "Waiver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWaiver_Violations(), this.getViolation(), this.getViolation_Waivers(), "violations", null, 0, -1, Waiver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(severityEClass, Severity.class, "Severity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSeverity_Rules(), this.getRule(), this.getRule_Severity(), "rules", null, 0, -1, Severity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceActionEClass, ResourceAction.class, "ResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceAction_ResourceIdentifier(), ecorePackage.getEString(), "resourceIdentifier", null, 0, 1, ResourceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textResourceActionEClass, TextResourceAction.class, "TextResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextResourceAction_Content(), ecorePackage.getEString(), "content", null, 0, 1, TextResourceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryResourceActionEClass, BinaryResourceAction.class, "BinaryResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryResourceAction_Content(), ecorePackage.getEByteArray(), "content", null, 0, 1, BinaryResourceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createResourceActionEClass, CreateResourceAction.class, "CreateResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createTextResourceActionEClass, CreateTextResourceAction.class, "CreateTextResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createBinaryResourceActionEClass, CreateBinaryResourceAction.class, "CreateBinaryResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteResourceActionEClass, DeleteResourceAction.class, "DeleteResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moveResourceActionEClass, MoveResourceAction.class, "MoveResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMoveResourceAction_NewIdentifier(), ecorePackage.getEString(), "newIdentifier", null, 0, 1, MoveResourceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateResourceActionEClass, UpdateResourceAction.class, "UpdateResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateTextResourceActionEClass, UpdateTextResourceAction.class, "UpdateTextResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateBinaryResourceActionEClass, UpdateBinaryResourceAction.class, "UpdateBinaryResourceAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// urn:org.nasdanika
		createUrnorgAnnotations();
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
		  (getRule_Actions(),
		   source,
		   new String[] {
			   "documentation", "Actions to be taken to address rule violations. Rule actions serve as documentation and as templates/prototypes for violation actions."
		   });
		addAnnotation
		  (getViolation_Actions(),
		   source,
		   new String[] {
			   "documentation", "Actions to be taken to address the violation"
		   });
		addAnnotation
		  (actionEClass,
		   source,
		   new String[] {
			   "documentation", "An action to be taken to address a rule violation"
		   });
		addAnnotation
		  (resourceActionEClass,
		   source,
		   new String[] {
			   "documentation", "An action on a resource identified by a string identifier, e.g. a path or URI"
		   });
		addAnnotation
		  (getResourceAction_ResourceIdentifier(),
		   source,
		   new String[] {
			   "documentation", "Resource identifier - path, URI, ..."
		   });
		addAnnotation
		  (moveResourceActionEClass,
		   source,
		   new String[] {
			   "documentation", "Moves (renames) the resources - changes its identifier"
		   });
		addAnnotation
		  (getMoveResourceAction_NewIdentifier(),
		   source,
		   new String[] {
			   "documentation", "New identifier"
		   });
	}

	/**
	 * Initializes the annotations for <b>urn:org.nasdanika</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUrnorgAnnotations() {
		String source = "urn:org.nasdanika";
		addAnnotation
		  (getRuleSet_Severities(),
		   source,
		   new String[] {
			   "homogeneous", "true"
		   });
	}

} //RulesPackageImpl

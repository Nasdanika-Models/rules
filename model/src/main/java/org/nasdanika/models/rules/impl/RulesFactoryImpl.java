/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.models.rules.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RulesFactoryImpl extends EFactoryImpl implements RulesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RulesFactory init() {
		try {
			RulesFactory theRulesFactory = (RulesFactory)EPackage.Registry.INSTANCE.getEFactory(RulesPackage.eNS_URI);
			if (theRulesFactory != null) {
				return theRulesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RulesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulesFactoryImpl() {
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
			case RulesPackage.RULE: return createRule();
			case RulesPackage.RULE_SET: return createRuleSet();
			case RulesPackage.VIOLATION: return createViolation();
			case RulesPackage.WAIVER: return createWaiver();
			case RulesPackage.INSPECTABLE: return createInspectable();
			case RulesPackage.SEVERITY: return createSeverity();
			case RulesPackage.ACTION: return createAction();
			case RulesPackage.RESOURCE_ACTION: return createResourceAction();
			case RulesPackage.TEXT_RESOURCE_ACTION: return createTextResourceAction();
			case RulesPackage.BINARY_RESOURCE_ACTION: return createBinaryResourceAction();
			case RulesPackage.CREATE_RESOURCE_ACTION: return createCreateResourceAction();
			case RulesPackage.CREATE_TEXT_RESOURCE_ACTION: return createCreateTextResourceAction();
			case RulesPackage.CREATE_BINARY_RESOURCE_ACTION: return createCreateBinaryResourceAction();
			case RulesPackage.DELETE_RESOURCE_ACTION: return createDeleteResourceAction();
			case RulesPackage.MOVE_RESOURCE_ACTION: return createMoveResourceAction();
			case RulesPackage.UPDATE_RESOURCE_ACTION: return createUpdateResourceAction();
			case RulesPackage.UPDATE_TEXT_RESOURCE_ACTION: return createUpdateTextResourceAction();
			case RulesPackage.UPDATE_BINARY_RESOURCE_ACTION: return createUpdateBinaryResourceAction();
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
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RuleSet createRuleSet() {
		RuleSetImpl ruleSet = new RuleSetImpl();
		return ruleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Violation createViolation() {
		ViolationImpl violation = new ViolationImpl();
		return violation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Waiver createWaiver() {
		WaiverImpl waiver = new WaiverImpl();
		return waiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Inspectable createInspectable() {
		InspectableImpl inspectable = new InspectableImpl();
		return inspectable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Severity createSeverity() {
		SeverityImpl severity = new SeverityImpl();
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceAction createResourceAction() {
		ResourceActionImpl resourceAction = new ResourceActionImpl();
		return resourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TextResourceAction createTextResourceAction() {
		TextResourceActionImpl textResourceAction = new TextResourceActionImpl();
		return textResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BinaryResourceAction createBinaryResourceAction() {
		BinaryResourceActionImpl binaryResourceAction = new BinaryResourceActionImpl();
		return binaryResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreateResourceAction createCreateResourceAction() {
		CreateResourceActionImpl createResourceAction = new CreateResourceActionImpl();
		return createResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreateTextResourceAction createCreateTextResourceAction() {
		CreateTextResourceActionImpl createTextResourceAction = new CreateTextResourceActionImpl();
		return createTextResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreateBinaryResourceAction createCreateBinaryResourceAction() {
		CreateBinaryResourceActionImpl createBinaryResourceAction = new CreateBinaryResourceActionImpl();
		return createBinaryResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeleteResourceAction createDeleteResourceAction() {
		DeleteResourceActionImpl deleteResourceAction = new DeleteResourceActionImpl();
		return deleteResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MoveResourceAction createMoveResourceAction() {
		MoveResourceActionImpl moveResourceAction = new MoveResourceActionImpl();
		return moveResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UpdateResourceAction createUpdateResourceAction() {
		UpdateResourceActionImpl updateResourceAction = new UpdateResourceActionImpl();
		return updateResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UpdateTextResourceAction createUpdateTextResourceAction() {
		UpdateTextResourceActionImpl updateTextResourceAction = new UpdateTextResourceActionImpl();
		return updateTextResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UpdateBinaryResourceAction createUpdateBinaryResourceAction() {
		UpdateBinaryResourceActionImpl updateBinaryResourceAction = new UpdateBinaryResourceActionImpl();
		return updateBinaryResourceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RulesPackage getRulesPackage() {
		return (RulesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RulesPackage getPackage() {
		return RulesPackage.eINSTANCE;
	}

} //RulesFactoryImpl

/**
 */
package org.nasdanika.models.rules.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.nasdanika.common.Adaptable;
import org.nasdanika.drawio.model.SemanticElement;
import org.nasdanika.graph.model.Connection;
import org.nasdanika.graph.model.ConnectionSource;
import org.nasdanika.graph.model.ConnectionTarget;
import org.nasdanika.graph.model.DocumentedNamedConnectionSource;
import org.nasdanika.graph.model.DocumentedNamedConnectionTarget;
import org.nasdanika.graph.model.DocumentedNamedGraph;
import org.nasdanika.graph.model.DocumentedNamedGraphElement;
import org.nasdanika.graph.model.Graph;
import org.nasdanika.graph.model.GraphElement;
import org.nasdanika.models.architecture.ArchitectureDescription;
import org.nasdanika.models.architecture.ArchitectureDescriptionElement;
import org.nasdanika.models.architecture.ArchitectureElement;
import org.nasdanika.models.architecture.Domain;
import org.nasdanika.models.architecture.Node;
import org.nasdanika.models.architecture.RelationshipSource;
import org.nasdanika.models.architecture.RelationshipTarget;
import org.nasdanika.models.architecture.Undergoer;
import org.nasdanika.models.rules.*;
import org.nasdanika.ncore.Documented;
import org.nasdanika.ncore.DocumentedNamedElement;
import org.nasdanika.ncore.DocumentedNamedStringIdentity;
import org.nasdanika.ncore.ModelElement;
import org.nasdanika.ncore.NamedElement;
import org.nasdanika.ncore.Period;
import org.nasdanika.ncore.StringIdentity;
import org.nasdanika.persistence.Marked;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.nasdanika.models.rules.RulesPackage
 * @generated
 */
public class RulesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RulesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulesSwitch() {
		if (modelPackage == null) {
			modelPackage = RulesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RulesPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseNode(rule);
				if (result == null) result = caseRelationshipSource(rule);
				if (result == null) result = caseRelationshipTarget(rule);
				if (result == null) result = caseDocumentedNamedConnectionSource(rule);
				if (result == null) result = caseArchitectureDescriptionElement(rule);
				if (result == null) result = caseDocumentedNamedConnectionTarget(rule);
				if (result == null) result = caseDocumentedNamedGraphElement(rule);
				if (result == null) result = caseConnectionSource(rule);
				if (result == null) result = caseArchitectureElement(rule);
				if (result == null) result = caseUndergoer(rule);
				if (result == null) result = caseConnectionTarget(rule);
				if (result == null) result = caseGraphElement(rule);
				if (result == null) result = caseDocumentedNamedStringIdentity(rule);
				if (result == null) result = casePeriod(rule);
				if (result == null) result = caseStringIdentity(rule);
				if (result == null) result = caseSemanticElement(rule);
				if (result == null) result = caseDocumentedNamedElement(rule);
				if (result == null) result = caseNamedElement(rule);
				if (result == null) result = caseDocumented(rule);
				if (result == null) result = caseModelElement(rule);
				if (result == null) result = caseMarked(rule);
				if (result == null) result = caseAdaptable(rule);
				if (result == null) result = caseIMarked(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.RULE_SET: {
				RuleSet ruleSet = (RuleSet)theEObject;
				T result = caseRuleSet(ruleSet);
				if (result == null) result = caseDomain(ruleSet);
				if (result == null) result = caseArchitectureDescriptionElement(ruleSet);
				if (result == null) result = caseArchitectureDescription(ruleSet);
				if (result == null) result = caseDocumentedNamedGraphElement(ruleSet);
				if (result == null) result = caseArchitectureElement(ruleSet);
				if (result == null) result = caseUndergoer(ruleSet);
				if (result == null) result = caseDocumentedNamedGraph(ruleSet);
				if (result == null) result = caseGraphElement(ruleSet);
				if (result == null) result = caseDocumentedNamedStringIdentity(ruleSet);
				if (result == null) result = casePeriod(ruleSet);
				if (result == null) result = caseGraph(ruleSet);
				if (result == null) result = caseStringIdentity(ruleSet);
				if (result == null) result = caseSemanticElement(ruleSet);
				if (result == null) result = caseDocumentedNamedElement(ruleSet);
				if (result == null) result = caseNamedElement(ruleSet);
				if (result == null) result = caseDocumented(ruleSet);
				if (result == null) result = caseModelElement(ruleSet);
				if (result == null) result = caseMarked(ruleSet);
				if (result == null) result = caseAdaptable(ruleSet);
				if (result == null) result = caseIMarked(ruleSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.INSPECTABLE: {
				Inspectable inspectable = (Inspectable)theEObject;
				T result = caseInspectable(inspectable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.INSPECTION_RESULT: {
				InspectionResult inspectionResult = (InspectionResult)theEObject;
				T result = caseInspectionResult(inspectionResult);
				if (result == null) result = caseArchitectureDescriptionElement(inspectionResult);
				if (result == null) result = caseDocumentedNamedGraphElement(inspectionResult);
				if (result == null) result = caseArchitectureElement(inspectionResult);
				if (result == null) result = caseUndergoer(inspectionResult);
				if (result == null) result = caseGraphElement(inspectionResult);
				if (result == null) result = caseDocumentedNamedStringIdentity(inspectionResult);
				if (result == null) result = casePeriod(inspectionResult);
				if (result == null) result = caseStringIdentity(inspectionResult);
				if (result == null) result = caseSemanticElement(inspectionResult);
				if (result == null) result = caseDocumentedNamedElement(inspectionResult);
				if (result == null) result = caseNamedElement(inspectionResult);
				if (result == null) result = caseDocumented(inspectionResult);
				if (result == null) result = caseModelElement(inspectionResult);
				if (result == null) result = caseMarked(inspectionResult);
				if (result == null) result = caseAdaptable(inspectionResult);
				if (result == null) result = caseIMarked(inspectionResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.VIOLATION: {
				Violation violation = (Violation)theEObject;
				T result = caseViolation(violation);
				if (result == null) result = caseInspectionResult(violation);
				if (result == null) result = caseArchitectureDescriptionElement(violation);
				if (result == null) result = caseDocumentedNamedGraphElement(violation);
				if (result == null) result = caseArchitectureElement(violation);
				if (result == null) result = caseUndergoer(violation);
				if (result == null) result = caseGraphElement(violation);
				if (result == null) result = caseDocumentedNamedStringIdentity(violation);
				if (result == null) result = casePeriod(violation);
				if (result == null) result = caseStringIdentity(violation);
				if (result == null) result = caseSemanticElement(violation);
				if (result == null) result = caseDocumentedNamedElement(violation);
				if (result == null) result = caseNamedElement(violation);
				if (result == null) result = caseDocumented(violation);
				if (result == null) result = caseModelElement(violation);
				if (result == null) result = caseMarked(violation);
				if (result == null) result = caseAdaptable(violation);
				if (result == null) result = caseIMarked(violation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.FAILURE: {
				Failure failure = (Failure)theEObject;
				T result = caseFailure(failure);
				if (result == null) result = caseInspectionResult(failure);
				if (result == null) result = caseArchitectureDescriptionElement(failure);
				if (result == null) result = caseDocumentedNamedGraphElement(failure);
				if (result == null) result = caseArchitectureElement(failure);
				if (result == null) result = caseUndergoer(failure);
				if (result == null) result = caseGraphElement(failure);
				if (result == null) result = caseDocumentedNamedStringIdentity(failure);
				if (result == null) result = casePeriod(failure);
				if (result == null) result = caseStringIdentity(failure);
				if (result == null) result = caseSemanticElement(failure);
				if (result == null) result = caseDocumentedNamedElement(failure);
				if (result == null) result = caseNamedElement(failure);
				if (result == null) result = caseDocumented(failure);
				if (result == null) result = caseModelElement(failure);
				if (result == null) result = caseMarked(failure);
				if (result == null) result = caseAdaptable(failure);
				if (result == null) result = caseIMarked(failure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.WAIVER: {
				Waiver waiver = (Waiver)theEObject;
				T result = caseWaiver(waiver);
				if (result == null) result = caseArchitectureDescriptionElement(waiver);
				if (result == null) result = caseDocumentedNamedGraphElement(waiver);
				if (result == null) result = caseArchitectureElement(waiver);
				if (result == null) result = caseUndergoer(waiver);
				if (result == null) result = caseGraphElement(waiver);
				if (result == null) result = caseDocumentedNamedStringIdentity(waiver);
				if (result == null) result = casePeriod(waiver);
				if (result == null) result = caseStringIdentity(waiver);
				if (result == null) result = caseSemanticElement(waiver);
				if (result == null) result = caseDocumentedNamedElement(waiver);
				if (result == null) result = caseNamedElement(waiver);
				if (result == null) result = caseDocumented(waiver);
				if (result == null) result = caseModelElement(waiver);
				if (result == null) result = caseMarked(waiver);
				if (result == null) result = caseAdaptable(waiver);
				if (result == null) result = caseIMarked(waiver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.SEVERITY: {
				Severity severity = (Severity)theEObject;
				T result = caseSeverity(severity);
				if (result == null) result = caseArchitectureDescriptionElement(severity);
				if (result == null) result = caseDocumentedNamedGraphElement(severity);
				if (result == null) result = caseArchitectureElement(severity);
				if (result == null) result = caseUndergoer(severity);
				if (result == null) result = caseGraphElement(severity);
				if (result == null) result = caseDocumentedNamedStringIdentity(severity);
				if (result == null) result = casePeriod(severity);
				if (result == null) result = caseStringIdentity(severity);
				if (result == null) result = caseSemanticElement(severity);
				if (result == null) result = caseDocumentedNamedElement(severity);
				if (result == null) result = caseNamedElement(severity);
				if (result == null) result = caseDocumented(severity);
				if (result == null) result = caseModelElement(severity);
				if (result == null) result = caseMarked(severity);
				if (result == null) result = caseAdaptable(severity);
				if (result == null) result = caseIMarked(severity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseNode(action);
				if (result == null) result = caseRelationshipSource(action);
				if (result == null) result = caseRelationshipTarget(action);
				if (result == null) result = caseDocumentedNamedConnectionSource(action);
				if (result == null) result = caseArchitectureDescriptionElement(action);
				if (result == null) result = caseDocumentedNamedConnectionTarget(action);
				if (result == null) result = caseDocumentedNamedGraphElement(action);
				if (result == null) result = caseConnectionSource(action);
				if (result == null) result = caseArchitectureElement(action);
				if (result == null) result = caseUndergoer(action);
				if (result == null) result = caseConnectionTarget(action);
				if (result == null) result = caseGraphElement(action);
				if (result == null) result = caseDocumentedNamedStringIdentity(action);
				if (result == null) result = casePeriod(action);
				if (result == null) result = caseStringIdentity(action);
				if (result == null) result = caseSemanticElement(action);
				if (result == null) result = caseDocumentedNamedElement(action);
				if (result == null) result = caseNamedElement(action);
				if (result == null) result = caseDocumented(action);
				if (result == null) result = caseModelElement(action);
				if (result == null) result = caseMarked(action);
				if (result == null) result = caseAdaptable(action);
				if (result == null) result = caseIMarked(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.RESOURCE_ACTION: {
				ResourceAction resourceAction = (ResourceAction)theEObject;
				T result = caseResourceAction(resourceAction);
				if (result == null) result = caseAction(resourceAction);
				if (result == null) result = caseNode(resourceAction);
				if (result == null) result = caseRelationshipSource(resourceAction);
				if (result == null) result = caseRelationshipTarget(resourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(resourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(resourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(resourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(resourceAction);
				if (result == null) result = caseConnectionSource(resourceAction);
				if (result == null) result = caseArchitectureElement(resourceAction);
				if (result == null) result = caseUndergoer(resourceAction);
				if (result == null) result = caseConnectionTarget(resourceAction);
				if (result == null) result = caseGraphElement(resourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(resourceAction);
				if (result == null) result = casePeriod(resourceAction);
				if (result == null) result = caseStringIdentity(resourceAction);
				if (result == null) result = caseSemanticElement(resourceAction);
				if (result == null) result = caseDocumentedNamedElement(resourceAction);
				if (result == null) result = caseNamedElement(resourceAction);
				if (result == null) result = caseDocumented(resourceAction);
				if (result == null) result = caseModelElement(resourceAction);
				if (result == null) result = caseMarked(resourceAction);
				if (result == null) result = caseAdaptable(resourceAction);
				if (result == null) result = caseIMarked(resourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.TEXT_RESOURCE_ACTION: {
				TextResourceAction textResourceAction = (TextResourceAction)theEObject;
				T result = caseTextResourceAction(textResourceAction);
				if (result == null) result = caseResourceAction(textResourceAction);
				if (result == null) result = caseAction(textResourceAction);
				if (result == null) result = caseNode(textResourceAction);
				if (result == null) result = caseRelationshipSource(textResourceAction);
				if (result == null) result = caseRelationshipTarget(textResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(textResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(textResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(textResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(textResourceAction);
				if (result == null) result = caseConnectionSource(textResourceAction);
				if (result == null) result = caseArchitectureElement(textResourceAction);
				if (result == null) result = caseUndergoer(textResourceAction);
				if (result == null) result = caseConnectionTarget(textResourceAction);
				if (result == null) result = caseGraphElement(textResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(textResourceAction);
				if (result == null) result = casePeriod(textResourceAction);
				if (result == null) result = caseStringIdentity(textResourceAction);
				if (result == null) result = caseSemanticElement(textResourceAction);
				if (result == null) result = caseDocumentedNamedElement(textResourceAction);
				if (result == null) result = caseNamedElement(textResourceAction);
				if (result == null) result = caseDocumented(textResourceAction);
				if (result == null) result = caseModelElement(textResourceAction);
				if (result == null) result = caseMarked(textResourceAction);
				if (result == null) result = caseAdaptable(textResourceAction);
				if (result == null) result = caseIMarked(textResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.BINARY_RESOURCE_ACTION: {
				BinaryResourceAction binaryResourceAction = (BinaryResourceAction)theEObject;
				T result = caseBinaryResourceAction(binaryResourceAction);
				if (result == null) result = caseResourceAction(binaryResourceAction);
				if (result == null) result = caseAction(binaryResourceAction);
				if (result == null) result = caseNode(binaryResourceAction);
				if (result == null) result = caseRelationshipSource(binaryResourceAction);
				if (result == null) result = caseRelationshipTarget(binaryResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(binaryResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(binaryResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(binaryResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(binaryResourceAction);
				if (result == null) result = caseConnectionSource(binaryResourceAction);
				if (result == null) result = caseArchitectureElement(binaryResourceAction);
				if (result == null) result = caseUndergoer(binaryResourceAction);
				if (result == null) result = caseConnectionTarget(binaryResourceAction);
				if (result == null) result = caseGraphElement(binaryResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(binaryResourceAction);
				if (result == null) result = casePeriod(binaryResourceAction);
				if (result == null) result = caseStringIdentity(binaryResourceAction);
				if (result == null) result = caseSemanticElement(binaryResourceAction);
				if (result == null) result = caseDocumentedNamedElement(binaryResourceAction);
				if (result == null) result = caseNamedElement(binaryResourceAction);
				if (result == null) result = caseDocumented(binaryResourceAction);
				if (result == null) result = caseModelElement(binaryResourceAction);
				if (result == null) result = caseMarked(binaryResourceAction);
				if (result == null) result = caseAdaptable(binaryResourceAction);
				if (result == null) result = caseIMarked(binaryResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.CREATE_RESOURCE_ACTION: {
				CreateResourceAction createResourceAction = (CreateResourceAction)theEObject;
				T result = caseCreateResourceAction(createResourceAction);
				if (result == null) result = caseResourceAction(createResourceAction);
				if (result == null) result = caseAction(createResourceAction);
				if (result == null) result = caseNode(createResourceAction);
				if (result == null) result = caseRelationshipSource(createResourceAction);
				if (result == null) result = caseRelationshipTarget(createResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(createResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(createResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(createResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(createResourceAction);
				if (result == null) result = caseConnectionSource(createResourceAction);
				if (result == null) result = caseArchitectureElement(createResourceAction);
				if (result == null) result = caseUndergoer(createResourceAction);
				if (result == null) result = caseConnectionTarget(createResourceAction);
				if (result == null) result = caseGraphElement(createResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(createResourceAction);
				if (result == null) result = casePeriod(createResourceAction);
				if (result == null) result = caseStringIdentity(createResourceAction);
				if (result == null) result = caseSemanticElement(createResourceAction);
				if (result == null) result = caseDocumentedNamedElement(createResourceAction);
				if (result == null) result = caseNamedElement(createResourceAction);
				if (result == null) result = caseDocumented(createResourceAction);
				if (result == null) result = caseModelElement(createResourceAction);
				if (result == null) result = caseMarked(createResourceAction);
				if (result == null) result = caseAdaptable(createResourceAction);
				if (result == null) result = caseIMarked(createResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.CREATE_TEXT_RESOURCE_ACTION: {
				CreateTextResourceAction createTextResourceAction = (CreateTextResourceAction)theEObject;
				T result = caseCreateTextResourceAction(createTextResourceAction);
				if (result == null) result = caseCreateResourceAction(createTextResourceAction);
				if (result == null) result = caseTextResourceAction(createTextResourceAction);
				if (result == null) result = caseResourceAction(createTextResourceAction);
				if (result == null) result = caseAction(createTextResourceAction);
				if (result == null) result = caseNode(createTextResourceAction);
				if (result == null) result = caseRelationshipSource(createTextResourceAction);
				if (result == null) result = caseRelationshipTarget(createTextResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(createTextResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(createTextResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(createTextResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(createTextResourceAction);
				if (result == null) result = caseConnectionSource(createTextResourceAction);
				if (result == null) result = caseArchitectureElement(createTextResourceAction);
				if (result == null) result = caseUndergoer(createTextResourceAction);
				if (result == null) result = caseConnectionTarget(createTextResourceAction);
				if (result == null) result = caseGraphElement(createTextResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(createTextResourceAction);
				if (result == null) result = casePeriod(createTextResourceAction);
				if (result == null) result = caseStringIdentity(createTextResourceAction);
				if (result == null) result = caseSemanticElement(createTextResourceAction);
				if (result == null) result = caseDocumentedNamedElement(createTextResourceAction);
				if (result == null) result = caseNamedElement(createTextResourceAction);
				if (result == null) result = caseDocumented(createTextResourceAction);
				if (result == null) result = caseModelElement(createTextResourceAction);
				if (result == null) result = caseMarked(createTextResourceAction);
				if (result == null) result = caseAdaptable(createTextResourceAction);
				if (result == null) result = caseIMarked(createTextResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.CREATE_BINARY_RESOURCE_ACTION: {
				CreateBinaryResourceAction createBinaryResourceAction = (CreateBinaryResourceAction)theEObject;
				T result = caseCreateBinaryResourceAction(createBinaryResourceAction);
				if (result == null) result = caseCreateResourceAction(createBinaryResourceAction);
				if (result == null) result = caseBinaryResourceAction(createBinaryResourceAction);
				if (result == null) result = caseResourceAction(createBinaryResourceAction);
				if (result == null) result = caseAction(createBinaryResourceAction);
				if (result == null) result = caseNode(createBinaryResourceAction);
				if (result == null) result = caseRelationshipSource(createBinaryResourceAction);
				if (result == null) result = caseRelationshipTarget(createBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(createBinaryResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(createBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(createBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(createBinaryResourceAction);
				if (result == null) result = caseConnectionSource(createBinaryResourceAction);
				if (result == null) result = caseArchitectureElement(createBinaryResourceAction);
				if (result == null) result = caseUndergoer(createBinaryResourceAction);
				if (result == null) result = caseConnectionTarget(createBinaryResourceAction);
				if (result == null) result = caseGraphElement(createBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(createBinaryResourceAction);
				if (result == null) result = casePeriod(createBinaryResourceAction);
				if (result == null) result = caseStringIdentity(createBinaryResourceAction);
				if (result == null) result = caseSemanticElement(createBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedElement(createBinaryResourceAction);
				if (result == null) result = caseNamedElement(createBinaryResourceAction);
				if (result == null) result = caseDocumented(createBinaryResourceAction);
				if (result == null) result = caseModelElement(createBinaryResourceAction);
				if (result == null) result = caseMarked(createBinaryResourceAction);
				if (result == null) result = caseAdaptable(createBinaryResourceAction);
				if (result == null) result = caseIMarked(createBinaryResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.DELETE_RESOURCE_ACTION: {
				DeleteResourceAction deleteResourceAction = (DeleteResourceAction)theEObject;
				T result = caseDeleteResourceAction(deleteResourceAction);
				if (result == null) result = caseResourceAction(deleteResourceAction);
				if (result == null) result = caseAction(deleteResourceAction);
				if (result == null) result = caseNode(deleteResourceAction);
				if (result == null) result = caseRelationshipSource(deleteResourceAction);
				if (result == null) result = caseRelationshipTarget(deleteResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(deleteResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(deleteResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(deleteResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(deleteResourceAction);
				if (result == null) result = caseConnectionSource(deleteResourceAction);
				if (result == null) result = caseArchitectureElement(deleteResourceAction);
				if (result == null) result = caseUndergoer(deleteResourceAction);
				if (result == null) result = caseConnectionTarget(deleteResourceAction);
				if (result == null) result = caseGraphElement(deleteResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(deleteResourceAction);
				if (result == null) result = casePeriod(deleteResourceAction);
				if (result == null) result = caseStringIdentity(deleteResourceAction);
				if (result == null) result = caseSemanticElement(deleteResourceAction);
				if (result == null) result = caseDocumentedNamedElement(deleteResourceAction);
				if (result == null) result = caseNamedElement(deleteResourceAction);
				if (result == null) result = caseDocumented(deleteResourceAction);
				if (result == null) result = caseModelElement(deleteResourceAction);
				if (result == null) result = caseMarked(deleteResourceAction);
				if (result == null) result = caseAdaptable(deleteResourceAction);
				if (result == null) result = caseIMarked(deleteResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.MOVE_RESOURCE_ACTION: {
				MoveResourceAction moveResourceAction = (MoveResourceAction)theEObject;
				T result = caseMoveResourceAction(moveResourceAction);
				if (result == null) result = caseResourceAction(moveResourceAction);
				if (result == null) result = caseAction(moveResourceAction);
				if (result == null) result = caseNode(moveResourceAction);
				if (result == null) result = caseRelationshipSource(moveResourceAction);
				if (result == null) result = caseRelationshipTarget(moveResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(moveResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(moveResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(moveResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(moveResourceAction);
				if (result == null) result = caseConnectionSource(moveResourceAction);
				if (result == null) result = caseArchitectureElement(moveResourceAction);
				if (result == null) result = caseUndergoer(moveResourceAction);
				if (result == null) result = caseConnectionTarget(moveResourceAction);
				if (result == null) result = caseGraphElement(moveResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(moveResourceAction);
				if (result == null) result = casePeriod(moveResourceAction);
				if (result == null) result = caseStringIdentity(moveResourceAction);
				if (result == null) result = caseSemanticElement(moveResourceAction);
				if (result == null) result = caseDocumentedNamedElement(moveResourceAction);
				if (result == null) result = caseNamedElement(moveResourceAction);
				if (result == null) result = caseDocumented(moveResourceAction);
				if (result == null) result = caseModelElement(moveResourceAction);
				if (result == null) result = caseMarked(moveResourceAction);
				if (result == null) result = caseAdaptable(moveResourceAction);
				if (result == null) result = caseIMarked(moveResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.UPDATE_RESOURCE_ACTION: {
				UpdateResourceAction updateResourceAction = (UpdateResourceAction)theEObject;
				T result = caseUpdateResourceAction(updateResourceAction);
				if (result == null) result = caseResourceAction(updateResourceAction);
				if (result == null) result = caseAction(updateResourceAction);
				if (result == null) result = caseNode(updateResourceAction);
				if (result == null) result = caseRelationshipSource(updateResourceAction);
				if (result == null) result = caseRelationshipTarget(updateResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(updateResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(updateResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(updateResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(updateResourceAction);
				if (result == null) result = caseConnectionSource(updateResourceAction);
				if (result == null) result = caseArchitectureElement(updateResourceAction);
				if (result == null) result = caseUndergoer(updateResourceAction);
				if (result == null) result = caseConnectionTarget(updateResourceAction);
				if (result == null) result = caseGraphElement(updateResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(updateResourceAction);
				if (result == null) result = casePeriod(updateResourceAction);
				if (result == null) result = caseStringIdentity(updateResourceAction);
				if (result == null) result = caseSemanticElement(updateResourceAction);
				if (result == null) result = caseDocumentedNamedElement(updateResourceAction);
				if (result == null) result = caseNamedElement(updateResourceAction);
				if (result == null) result = caseDocumented(updateResourceAction);
				if (result == null) result = caseModelElement(updateResourceAction);
				if (result == null) result = caseMarked(updateResourceAction);
				if (result == null) result = caseAdaptable(updateResourceAction);
				if (result == null) result = caseIMarked(updateResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.UPDATE_TEXT_RESOURCE_ACTION: {
				UpdateTextResourceAction updateTextResourceAction = (UpdateTextResourceAction)theEObject;
				T result = caseUpdateTextResourceAction(updateTextResourceAction);
				if (result == null) result = caseUpdateResourceAction(updateTextResourceAction);
				if (result == null) result = caseTextResourceAction(updateTextResourceAction);
				if (result == null) result = caseResourceAction(updateTextResourceAction);
				if (result == null) result = caseAction(updateTextResourceAction);
				if (result == null) result = caseNode(updateTextResourceAction);
				if (result == null) result = caseRelationshipSource(updateTextResourceAction);
				if (result == null) result = caseRelationshipTarget(updateTextResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(updateTextResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(updateTextResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(updateTextResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(updateTextResourceAction);
				if (result == null) result = caseConnectionSource(updateTextResourceAction);
				if (result == null) result = caseArchitectureElement(updateTextResourceAction);
				if (result == null) result = caseUndergoer(updateTextResourceAction);
				if (result == null) result = caseConnectionTarget(updateTextResourceAction);
				if (result == null) result = caseGraphElement(updateTextResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(updateTextResourceAction);
				if (result == null) result = casePeriod(updateTextResourceAction);
				if (result == null) result = caseStringIdentity(updateTextResourceAction);
				if (result == null) result = caseSemanticElement(updateTextResourceAction);
				if (result == null) result = caseDocumentedNamedElement(updateTextResourceAction);
				if (result == null) result = caseNamedElement(updateTextResourceAction);
				if (result == null) result = caseDocumented(updateTextResourceAction);
				if (result == null) result = caseModelElement(updateTextResourceAction);
				if (result == null) result = caseMarked(updateTextResourceAction);
				if (result == null) result = caseAdaptable(updateTextResourceAction);
				if (result == null) result = caseIMarked(updateTextResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RulesPackage.UPDATE_BINARY_RESOURCE_ACTION: {
				UpdateBinaryResourceAction updateBinaryResourceAction = (UpdateBinaryResourceAction)theEObject;
				T result = caseUpdateBinaryResourceAction(updateBinaryResourceAction);
				if (result == null) result = caseUpdateResourceAction(updateBinaryResourceAction);
				if (result == null) result = caseBinaryResourceAction(updateBinaryResourceAction);
				if (result == null) result = caseResourceAction(updateBinaryResourceAction);
				if (result == null) result = caseAction(updateBinaryResourceAction);
				if (result == null) result = caseNode(updateBinaryResourceAction);
				if (result == null) result = caseRelationshipSource(updateBinaryResourceAction);
				if (result == null) result = caseRelationshipTarget(updateBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(updateBinaryResourceAction);
				if (result == null) result = caseArchitectureDescriptionElement(updateBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(updateBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedGraphElement(updateBinaryResourceAction);
				if (result == null) result = caseConnectionSource(updateBinaryResourceAction);
				if (result == null) result = caseArchitectureElement(updateBinaryResourceAction);
				if (result == null) result = caseUndergoer(updateBinaryResourceAction);
				if (result == null) result = caseConnectionTarget(updateBinaryResourceAction);
				if (result == null) result = caseGraphElement(updateBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(updateBinaryResourceAction);
				if (result == null) result = casePeriod(updateBinaryResourceAction);
				if (result == null) result = caseStringIdentity(updateBinaryResourceAction);
				if (result == null) result = caseSemanticElement(updateBinaryResourceAction);
				if (result == null) result = caseDocumentedNamedElement(updateBinaryResourceAction);
				if (result == null) result = caseNamedElement(updateBinaryResourceAction);
				if (result == null) result = caseDocumented(updateBinaryResourceAction);
				if (result == null) result = caseModelElement(updateBinaryResourceAction);
				if (result == null) result = caseMarked(updateBinaryResourceAction);
				if (result == null) result = caseAdaptable(updateBinaryResourceAction);
				if (result == null) result = caseIMarked(updateBinaryResourceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleSet(RuleSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViolation(Violation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailure(Failure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Waiver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Waiver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaiver(Waiver object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inspectable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inspectable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInspectable(Inspectable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inspection Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inspection Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInspectionResult(InspectionResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Severity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Severity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeverity(Severity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceAction(ResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextResourceAction(TextResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryResourceAction(BinaryResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateResourceAction(CreateResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Text Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Text Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateTextResourceAction(CreateTextResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Binary Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Binary Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateBinaryResourceAction(CreateBinaryResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteResourceAction(DeleteResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Move Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoveResourceAction(MoveResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateResourceAction(UpdateResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Text Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Text Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateTextResourceAction(UpdateTextResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Binary Resource Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Binary Resource Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateBinaryResourceAction(UpdateBinaryResourceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Identity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Identity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringIdentity(StringIdentity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticElement(SemanticElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphElement(GraphElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMarked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMarked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMarked(Marked object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Marked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Marked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarked(org.nasdanika.ncore.Marked object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adaptable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adaptable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdaptable(Adaptable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumented(Documented object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentedNamedElement(DocumentedNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Named String Identity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Named String Identity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentedNamedStringIdentity(DocumentedNamedStringIdentity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Named Graph Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Named Graph Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentedNamedGraphElement(DocumentedNamedGraphElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Connection<?>> T caseConnectionSource(ConnectionSource<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Named Connection Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Named Connection Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Connection<?>> T caseDocumentedNamedConnectionSource(DocumentedNamedConnectionSource<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Period</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Period</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeriod(Period object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitectureElement(ArchitectureElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Undergoer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Undergoer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUndergoer(Undergoer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitectureDescriptionElement(ArchitectureDescriptionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationshipSource(RelationshipSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Connection<?>> T caseConnectionTarget(ConnectionTarget<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Named Connection Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Named Connection Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Connection<?>> T caseDocumentedNamedConnectionTarget(DocumentedNamedConnectionTarget<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationshipTarget(RelationshipTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <E extends GraphElement> T caseGraph(Graph<E> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Named Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Named Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <E extends GraphElement> T caseDocumentedNamedGraph(DocumentedNamedGraph<E> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitectureDescription(ArchitectureDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomain(Domain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RulesSwitch

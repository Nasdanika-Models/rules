/**
 */
package org.nasdanika.models.rules.java.util;

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
import org.nasdanika.graph.model.DocumentedNamedGraphElement;
import org.nasdanika.graph.model.GraphElement;

import org.nasdanika.models.architecture.ArchitectureDescriptionElement;
import org.nasdanika.models.architecture.ArchitectureElement;
import org.nasdanika.models.architecture.Node;
import org.nasdanika.models.architecture.RelationshipSource;
import org.nasdanika.models.architecture.RelationshipTarget;
import org.nasdanika.models.architecture.Undergoer;

import org.nasdanika.models.rules.Action;

import org.nasdanika.models.rules.java.*;

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
 * @see org.nasdanika.models.rules.java.JavaPackage
 * @generated
 */
public class JavaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JavaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaSwitch() {
		if (modelPackage == null) {
			modelPackage = JavaPackage.eINSTANCE;
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
			case JavaPackage.COMPILATION_UNIT_ACTION: {
				CompilationUnitAction compilationUnitAction = (CompilationUnitAction)theEObject;
				T result = caseCompilationUnitAction(compilationUnitAction);
				if (result == null) result = caseAction(compilationUnitAction);
				if (result == null) result = caseNode(compilationUnitAction);
				if (result == null) result = caseRelationshipSource(compilationUnitAction);
				if (result == null) result = caseRelationshipTarget(compilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(compilationUnitAction);
				if (result == null) result = caseArchitectureDescriptionElement(compilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(compilationUnitAction);
				if (result == null) result = caseDocumentedNamedGraphElement(compilationUnitAction);
				if (result == null) result = caseConnectionSource(compilationUnitAction);
				if (result == null) result = caseArchitectureElement(compilationUnitAction);
				if (result == null) result = caseUndergoer(compilationUnitAction);
				if (result == null) result = caseConnectionTarget(compilationUnitAction);
				if (result == null) result = caseGraphElement(compilationUnitAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(compilationUnitAction);
				if (result == null) result = casePeriod(compilationUnitAction);
				if (result == null) result = caseStringIdentity(compilationUnitAction);
				if (result == null) result = caseSemanticElement(compilationUnitAction);
				if (result == null) result = caseDocumentedNamedElement(compilationUnitAction);
				if (result == null) result = caseNamedElement(compilationUnitAction);
				if (result == null) result = caseDocumented(compilationUnitAction);
				if (result == null) result = caseModelElement(compilationUnitAction);
				if (result == null) result = caseMarked(compilationUnitAction);
				if (result == null) result = caseAdaptable(compilationUnitAction);
				if (result == null) result = caseIMarked(compilationUnitAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.CREATE_COMPILATION_UNIT_ACTION: {
				CreateCompilationUnitAction createCompilationUnitAction = (CreateCompilationUnitAction)theEObject;
				T result = caseCreateCompilationUnitAction(createCompilationUnitAction);
				if (result == null) result = caseCompilationUnitAction(createCompilationUnitAction);
				if (result == null) result = caseAction(createCompilationUnitAction);
				if (result == null) result = caseNode(createCompilationUnitAction);
				if (result == null) result = caseRelationshipSource(createCompilationUnitAction);
				if (result == null) result = caseRelationshipTarget(createCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(createCompilationUnitAction);
				if (result == null) result = caseArchitectureDescriptionElement(createCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(createCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedGraphElement(createCompilationUnitAction);
				if (result == null) result = caseConnectionSource(createCompilationUnitAction);
				if (result == null) result = caseArchitectureElement(createCompilationUnitAction);
				if (result == null) result = caseUndergoer(createCompilationUnitAction);
				if (result == null) result = caseConnectionTarget(createCompilationUnitAction);
				if (result == null) result = caseGraphElement(createCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(createCompilationUnitAction);
				if (result == null) result = casePeriod(createCompilationUnitAction);
				if (result == null) result = caseStringIdentity(createCompilationUnitAction);
				if (result == null) result = caseSemanticElement(createCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedElement(createCompilationUnitAction);
				if (result == null) result = caseNamedElement(createCompilationUnitAction);
				if (result == null) result = caseDocumented(createCompilationUnitAction);
				if (result == null) result = caseModelElement(createCompilationUnitAction);
				if (result == null) result = caseMarked(createCompilationUnitAction);
				if (result == null) result = caseAdaptable(createCompilationUnitAction);
				if (result == null) result = caseIMarked(createCompilationUnitAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.DELETE_COMPILATION_UNIT_ACTION: {
				DeleteCompilationUnitAction deleteCompilationUnitAction = (DeleteCompilationUnitAction)theEObject;
				T result = caseDeleteCompilationUnitAction(deleteCompilationUnitAction);
				if (result == null) result = caseCompilationUnitAction(deleteCompilationUnitAction);
				if (result == null) result = caseAction(deleteCompilationUnitAction);
				if (result == null) result = caseNode(deleteCompilationUnitAction);
				if (result == null) result = caseRelationshipSource(deleteCompilationUnitAction);
				if (result == null) result = caseRelationshipTarget(deleteCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(deleteCompilationUnitAction);
				if (result == null) result = caseArchitectureDescriptionElement(deleteCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(deleteCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedGraphElement(deleteCompilationUnitAction);
				if (result == null) result = caseConnectionSource(deleteCompilationUnitAction);
				if (result == null) result = caseArchitectureElement(deleteCompilationUnitAction);
				if (result == null) result = caseUndergoer(deleteCompilationUnitAction);
				if (result == null) result = caseConnectionTarget(deleteCompilationUnitAction);
				if (result == null) result = caseGraphElement(deleteCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(deleteCompilationUnitAction);
				if (result == null) result = casePeriod(deleteCompilationUnitAction);
				if (result == null) result = caseStringIdentity(deleteCompilationUnitAction);
				if (result == null) result = caseSemanticElement(deleteCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedElement(deleteCompilationUnitAction);
				if (result == null) result = caseNamedElement(deleteCompilationUnitAction);
				if (result == null) result = caseDocumented(deleteCompilationUnitAction);
				if (result == null) result = caseModelElement(deleteCompilationUnitAction);
				if (result == null) result = caseMarked(deleteCompilationUnitAction);
				if (result == null) result = caseAdaptable(deleteCompilationUnitAction);
				if (result == null) result = caseIMarked(deleteCompilationUnitAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.UPDATE_COMPILATION_UNIT_ACTION: {
				UpdateCompilationUnitAction updateCompilationUnitAction = (UpdateCompilationUnitAction)theEObject;
				T result = caseUpdateCompilationUnitAction(updateCompilationUnitAction);
				if (result == null) result = caseCompilationUnitAction(updateCompilationUnitAction);
				if (result == null) result = caseAction(updateCompilationUnitAction);
				if (result == null) result = caseNode(updateCompilationUnitAction);
				if (result == null) result = caseRelationshipSource(updateCompilationUnitAction);
				if (result == null) result = caseRelationshipTarget(updateCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionSource(updateCompilationUnitAction);
				if (result == null) result = caseArchitectureDescriptionElement(updateCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedConnectionTarget(updateCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedGraphElement(updateCompilationUnitAction);
				if (result == null) result = caseConnectionSource(updateCompilationUnitAction);
				if (result == null) result = caseArchitectureElement(updateCompilationUnitAction);
				if (result == null) result = caseUndergoer(updateCompilationUnitAction);
				if (result == null) result = caseConnectionTarget(updateCompilationUnitAction);
				if (result == null) result = caseGraphElement(updateCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedStringIdentity(updateCompilationUnitAction);
				if (result == null) result = casePeriod(updateCompilationUnitAction);
				if (result == null) result = caseStringIdentity(updateCompilationUnitAction);
				if (result == null) result = caseSemanticElement(updateCompilationUnitAction);
				if (result == null) result = caseDocumentedNamedElement(updateCompilationUnitAction);
				if (result == null) result = caseNamedElement(updateCompilationUnitAction);
				if (result == null) result = caseDocumented(updateCompilationUnitAction);
				if (result == null) result = caseModelElement(updateCompilationUnitAction);
				if (result == null) result = caseMarked(updateCompilationUnitAction);
				if (result == null) result = caseAdaptable(updateCompilationUnitAction);
				if (result == null) result = caseIMarked(updateCompilationUnitAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compilation Unit Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompilationUnitAction(CompilationUnitAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Compilation Unit Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateCompilationUnitAction(CreateCompilationUnitAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Compilation Unit Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteCompilationUnitAction(DeleteCompilationUnitAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Compilation Unit Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Compilation Unit Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateCompilationUnitAction(UpdateCompilationUnitAction object) {
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

} //JavaSwitch

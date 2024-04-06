/**
 */
package org.nasdanika.models.rules.java;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.nasdanika.models.rules.RulesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.nasdanika.models.rules.java.JavaFactory
 * @model kind="package"
 * @generated
 */
public interface JavaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "java";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ecore://nasdanika.org/models/rules/java";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.models.rules.java";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavaPackage eINSTANCE = org.nasdanika.models.rules.java.impl.JavaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.java.impl.CompilationUnitActionImpl <em>Compilation Unit Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.java.impl.CompilationUnitActionImpl
	 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getCompilationUnitAction()
	 * @generated
	 */
	int COMPILATION_UNIT_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__ID = RulesPackage.ACTION__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__SEMANTIC_MAPPINGS = RulesPackage.ACTION__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__MARKERS = RulesPackage.ACTION__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__URIS = RulesPackage.ACTION__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__DESCRIPTION = RulesPackage.ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__UUID = RulesPackage.ACTION__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__LABEL_PROTOTYPE = RulesPackage.ACTION__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__REPRESENTATIONS = RulesPackage.ACTION__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__ANNOTATIONS = RulesPackage.ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__NAME = RulesPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__DOCUMENTATION = RulesPackage.ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__CONTEXT_HELP = RulesPackage.ACTION__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__OUTGOING_CONNECTIONS = RulesPackage.ACTION__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__START = RulesPackage.ACTION__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__END = RulesPackage.ACTION__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__DURATION = RulesPackage.ACTION__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__ICON = RulesPackage.ACTION__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__ROLES = RulesPackage.ACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION__INCOMING_CONNECTIONS = RulesPackage.ACTION__INCOMING_CONNECTIONS;

	/**
	 * The number of structural features of the '<em>Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION_FEATURE_COUNT = RulesPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_ACTION_OPERATION_COUNT = RulesPackage.ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.java.impl.CreateCompilationUnitActionImpl <em>Create Compilation Unit Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.java.impl.CreateCompilationUnitActionImpl
	 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getCreateCompilationUnitAction()
	 * @generated
	 */
	int CREATE_COMPILATION_UNIT_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__ID = COMPILATION_UNIT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__SEMANTIC_MAPPINGS = COMPILATION_UNIT_ACTION__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__MARKERS = COMPILATION_UNIT_ACTION__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__URIS = COMPILATION_UNIT_ACTION__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__DESCRIPTION = COMPILATION_UNIT_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__UUID = COMPILATION_UNIT_ACTION__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__LABEL_PROTOTYPE = COMPILATION_UNIT_ACTION__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__REPRESENTATIONS = COMPILATION_UNIT_ACTION__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__ANNOTATIONS = COMPILATION_UNIT_ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__NAME = COMPILATION_UNIT_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__DOCUMENTATION = COMPILATION_UNIT_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__CONTEXT_HELP = COMPILATION_UNIT_ACTION__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__OUTGOING_CONNECTIONS = COMPILATION_UNIT_ACTION__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__START = COMPILATION_UNIT_ACTION__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__END = COMPILATION_UNIT_ACTION__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__DURATION = COMPILATION_UNIT_ACTION__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__ICON = COMPILATION_UNIT_ACTION__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__ROLES = COMPILATION_UNIT_ACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__INCOMING_CONNECTIONS = COMPILATION_UNIT_ACTION__INCOMING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT = COMPILATION_UNIT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION_FEATURE_COUNT = COMPILATION_UNIT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Create Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_COMPILATION_UNIT_ACTION_OPERATION_COUNT = COMPILATION_UNIT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.java.impl.DeleteCompilationUnitActionImpl <em>Delete Compilation Unit Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.java.impl.DeleteCompilationUnitActionImpl
	 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getDeleteCompilationUnitAction()
	 * @generated
	 */
	int DELETE_COMPILATION_UNIT_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__ID = COMPILATION_UNIT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__SEMANTIC_MAPPINGS = COMPILATION_UNIT_ACTION__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__MARKERS = COMPILATION_UNIT_ACTION__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__URIS = COMPILATION_UNIT_ACTION__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__DESCRIPTION = COMPILATION_UNIT_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__UUID = COMPILATION_UNIT_ACTION__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__LABEL_PROTOTYPE = COMPILATION_UNIT_ACTION__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__REPRESENTATIONS = COMPILATION_UNIT_ACTION__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__ANNOTATIONS = COMPILATION_UNIT_ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__NAME = COMPILATION_UNIT_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__DOCUMENTATION = COMPILATION_UNIT_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__CONTEXT_HELP = COMPILATION_UNIT_ACTION__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__OUTGOING_CONNECTIONS = COMPILATION_UNIT_ACTION__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__START = COMPILATION_UNIT_ACTION__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__END = COMPILATION_UNIT_ACTION__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__DURATION = COMPILATION_UNIT_ACTION__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__ICON = COMPILATION_UNIT_ACTION__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__ROLES = COMPILATION_UNIT_ACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__INCOMING_CONNECTIONS = COMPILATION_UNIT_ACTION__INCOMING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT = COMPILATION_UNIT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION_FEATURE_COUNT = COMPILATION_UNIT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_COMPILATION_UNIT_ACTION_OPERATION_COUNT = COMPILATION_UNIT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.java.impl.UpdateCompilationUnitActionImpl <em>Update Compilation Unit Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.java.impl.UpdateCompilationUnitActionImpl
	 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getUpdateCompilationUnitAction()
	 * @generated
	 */
	int UPDATE_COMPILATION_UNIT_ACTION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__ID = COMPILATION_UNIT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__SEMANTIC_MAPPINGS = COMPILATION_UNIT_ACTION__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__MARKERS = COMPILATION_UNIT_ACTION__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__URIS = COMPILATION_UNIT_ACTION__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__DESCRIPTION = COMPILATION_UNIT_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__UUID = COMPILATION_UNIT_ACTION__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__LABEL_PROTOTYPE = COMPILATION_UNIT_ACTION__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__REPRESENTATIONS = COMPILATION_UNIT_ACTION__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__ANNOTATIONS = COMPILATION_UNIT_ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__NAME = COMPILATION_UNIT_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__DOCUMENTATION = COMPILATION_UNIT_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__CONTEXT_HELP = COMPILATION_UNIT_ACTION__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__OUTGOING_CONNECTIONS = COMPILATION_UNIT_ACTION__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__START = COMPILATION_UNIT_ACTION__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__END = COMPILATION_UNIT_ACTION__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__DURATION = COMPILATION_UNIT_ACTION__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__ICON = COMPILATION_UNIT_ACTION__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__ROLES = COMPILATION_UNIT_ACTION__ROLES;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__INCOMING_CONNECTIONS = COMPILATION_UNIT_ACTION__INCOMING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT = COMPILATION_UNIT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION_FEATURE_COUNT = COMPILATION_UNIT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Update Compilation Unit Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COMPILATION_UNIT_ACTION_OPERATION_COUNT = COMPILATION_UNIT_ACTION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.java.CompilationUnitAction <em>Compilation Unit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compilation Unit Action</em>'.
	 * @see org.nasdanika.models.rules.java.CompilationUnitAction
	 * @generated
	 */
	EClass getCompilationUnitAction();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.java.CreateCompilationUnitAction <em>Create Compilation Unit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Compilation Unit Action</em>'.
	 * @see org.nasdanika.models.rules.java.CreateCompilationUnitAction
	 * @generated
	 */
	EClass getCreateCompilationUnitAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.models.rules.java.CreateCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compilation Unit</em>'.
	 * @see org.nasdanika.models.rules.java.CreateCompilationUnitAction#getCompilationUnit()
	 * @see #getCreateCompilationUnitAction()
	 * @generated
	 */
	EReference getCreateCompilationUnitAction_CompilationUnit();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.java.DeleteCompilationUnitAction <em>Delete Compilation Unit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Compilation Unit Action</em>'.
	 * @see org.nasdanika.models.rules.java.DeleteCompilationUnitAction
	 * @generated
	 */
	EClass getDeleteCompilationUnitAction();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.models.rules.java.DeleteCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Compilation Unit</em>'.
	 * @see org.nasdanika.models.rules.java.DeleteCompilationUnitAction#getCompilationUnit()
	 * @see #getDeleteCompilationUnitAction()
	 * @generated
	 */
	EReference getDeleteCompilationUnitAction_CompilationUnit();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.java.UpdateCompilationUnitAction <em>Update Compilation Unit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Compilation Unit Action</em>'.
	 * @see org.nasdanika.models.rules.java.UpdateCompilationUnitAction
	 * @generated
	 */
	EClass getUpdateCompilationUnitAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.models.rules.java.UpdateCompilationUnitAction#getCompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compilation Unit</em>'.
	 * @see org.nasdanika.models.rules.java.UpdateCompilationUnitAction#getCompilationUnit()
	 * @see #getUpdateCompilationUnitAction()
	 * @generated
	 */
	EReference getUpdateCompilationUnitAction_CompilationUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavaFactory getJavaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.java.impl.CompilationUnitActionImpl <em>Compilation Unit Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.java.impl.CompilationUnitActionImpl
		 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getCompilationUnitAction()
		 * @generated
		 */
		EClass COMPILATION_UNIT_ACTION = eINSTANCE.getCompilationUnitAction();

		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.java.impl.CreateCompilationUnitActionImpl <em>Create Compilation Unit Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.java.impl.CreateCompilationUnitActionImpl
		 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getCreateCompilationUnitAction()
		 * @generated
		 */
		EClass CREATE_COMPILATION_UNIT_ACTION = eINSTANCE.getCreateCompilationUnitAction();

		/**
		 * The meta object literal for the '<em><b>Compilation Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT = eINSTANCE.getCreateCompilationUnitAction_CompilationUnit();

		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.java.impl.DeleteCompilationUnitActionImpl <em>Delete Compilation Unit Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.java.impl.DeleteCompilationUnitActionImpl
		 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getDeleteCompilationUnitAction()
		 * @generated
		 */
		EClass DELETE_COMPILATION_UNIT_ACTION = eINSTANCE.getDeleteCompilationUnitAction();

		/**
		 * The meta object literal for the '<em><b>Compilation Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT = eINSTANCE.getDeleteCompilationUnitAction_CompilationUnit();

		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.java.impl.UpdateCompilationUnitActionImpl <em>Update Compilation Unit Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.java.impl.UpdateCompilationUnitActionImpl
		 * @see org.nasdanika.models.rules.java.impl.JavaPackageImpl#getUpdateCompilationUnitAction()
		 * @generated
		 */
		EClass UPDATE_COMPILATION_UNIT_ACTION = eINSTANCE.getUpdateCompilationUnitAction();

		/**
		 * The meta object literal for the '<em><b>Compilation Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_COMPILATION_UNIT_ACTION__COMPILATION_UNIT = eINSTANCE.getUpdateCompilationUnitAction_CompilationUnit();

	}

} //JavaPackage

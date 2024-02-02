/**
 */
package org.nasdanika.models.rules;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.models.architecture.ArchitecturePackage;

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
 * @see org.nasdanika.models.rules.RulesFactory
 * @model kind="package"
 * @generated
 */
public interface RulesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rules";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ecore://nasdanika.org/models/rules";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.models.rules";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RulesPackage eINSTANCE = org.nasdanika.models.rules.impl.RulesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.impl.RuleImpl
	 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ID = ArchitecturePackage.NODE__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SEMANTIC_MAPPINGS = ArchitecturePackage.NODE__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__MARKERS = ArchitecturePackage.NODE__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__URIS = ArchitecturePackage.NODE__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DESCRIPTION = ArchitecturePackage.NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__UUID = ArchitecturePackage.NODE__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__LABEL_PROTOTYPE = ArchitecturePackage.NODE__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__REPRESENTATIONS = ArchitecturePackage.NODE__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ANNOTATIONS = ArchitecturePackage.NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = ArchitecturePackage.NODE__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DOCUMENTATION = ArchitecturePackage.NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__CONTEXT_HELP = ArchitecturePackage.NODE__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OUTGOING_CONNECTIONS = ArchitecturePackage.NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__START = ArchitecturePackage.NODE__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__END = ArchitecturePackage.NODE__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DURATION = ArchitecturePackage.NODE__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ICON = ArchitecturePackage.NODE__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ROLES = ArchitecturePackage.NODE__ROLES;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__INCOMING_CONNECTIONS = ArchitecturePackage.NODE__INCOMING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Suppress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SUPPRESS = ArchitecturePackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SEVERITY = ArchitecturePackage.NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = ArchitecturePackage.NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = ArchitecturePackage.NODE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.impl.RuleSetImpl <em>Rule Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.impl.RuleSetImpl
	 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getRuleSet()
	 * @generated
	 */
	int RULE_SET = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__ID = ArchitecturePackage.DOMAIN__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__SEMANTIC_MAPPINGS = ArchitecturePackage.DOMAIN__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__MARKERS = ArchitecturePackage.DOMAIN__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__URIS = ArchitecturePackage.DOMAIN__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__DESCRIPTION = ArchitecturePackage.DOMAIN__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__UUID = ArchitecturePackage.DOMAIN__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__LABEL_PROTOTYPE = ArchitecturePackage.DOMAIN__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__REPRESENTATIONS = ArchitecturePackage.DOMAIN__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__ANNOTATIONS = ArchitecturePackage.DOMAIN__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__NAME = ArchitecturePackage.DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__DOCUMENTATION = ArchitecturePackage.DOMAIN__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__CONTEXT_HELP = ArchitecturePackage.DOMAIN__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__START = ArchitecturePackage.DOMAIN__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__END = ArchitecturePackage.DOMAIN__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__DURATION = ArchitecturePackage.DOMAIN__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__ICON = ArchitecturePackage.DOMAIN__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__ROLES = ArchitecturePackage.DOMAIN__ROLES;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__ELEMENTS = ArchitecturePackage.DOMAIN__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__ACTORS = ArchitecturePackage.DOMAIN__ACTORS;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__EXTENDS = ArchitecturePackage.DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__EXTENSIONS = ArchitecturePackage.DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__RULES = ArchitecturePackage.DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rule Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_FEATURE_COUNT = ArchitecturePackage.DOMAIN_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Rule Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_OPERATION_COUNT = ArchitecturePackage.DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.impl.ViolationImpl <em>Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.impl.ViolationImpl
	 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getViolation()
	 * @generated
	 */
	int VIOLATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__ID = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__SEMANTIC_MAPPINGS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__MARKERS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__URIS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__DESCRIPTION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__UUID = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__LABEL_PROTOTYPE = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__REPRESENTATIONS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__ANNOTATIONS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__NAME = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__DOCUMENTATION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__CONTEXT_HELP = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__START = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__END = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__DURATION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__ICON = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__ROLES = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ROLES;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__RULE = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Waivers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__WAIVERS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION_FEATURE_COUNT = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION_OPERATION_COUNT = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.impl.WaiverImpl <em>Waiver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.impl.WaiverImpl
	 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getWaiver()
	 * @generated
	 */
	int WAIVER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__ID = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__SEMANTIC_MAPPINGS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__MARKERS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__URIS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__DESCRIPTION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__UUID = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__LABEL_PROTOTYPE = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__REPRESENTATIONS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__ANNOTATIONS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__NAME = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__DOCUMENTATION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__CONTEXT_HELP = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__START = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__END = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__DURATION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__ICON = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__ROLES = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ROLES;

	/**
	 * The feature id for the '<em><b>Violations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER__VIOLATIONS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Waiver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER_FEATURE_COUNT = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Waiver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIVER_OPERATION_COUNT = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.impl.InspectableImpl <em>Inspectable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.impl.InspectableImpl
	 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getInspectable()
	 * @generated
	 */
	int INSPECTABLE = 4;

	/**
	 * The feature id for the '<em><b>Violations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTABLE__VIOLATIONS = 0;

	/**
	 * The feature id for the '<em><b>Waivers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTABLE__WAIVERS = 1;

	/**
	 * The number of structural features of the '<em>Inspectable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTABLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Inspectable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.models.rules.impl.SeverityImpl <em>Severity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.models.rules.impl.SeverityImpl
	 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getSeverity()
	 * @generated
	 */
	int SEVERITY = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__ID = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Semantic Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__SEMANTIC_MAPPINGS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__SEMANTIC_MAPPINGS;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__MARKERS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__MARKERS;

	/**
	 * The feature id for the '<em><b>Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__URIS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__URIS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__DESCRIPTION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__UUID = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Label Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__LABEL_PROTOTYPE = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__LABEL_PROTOTYPE;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__REPRESENTATIONS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__ANNOTATIONS = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__NAME = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__DOCUMENTATION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Context Help</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__CONTEXT_HELP = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__CONTEXT_HELP;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__START = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__END = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__END;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__DURATION = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__DURATION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__ICON = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__ROLES = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT__ROLES;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY__RULES = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Severity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY_FEATURE_COUNT = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Severity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEVERITY_OPERATION_COUNT = ArchitecturePackage.ARCHITECTURE_DESCRIPTION_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.nasdanika.models.rules.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.models.rules.Rule#isSuppress <em>Suppress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suppress</em>'.
	 * @see org.nasdanika.models.rules.Rule#isSuppress()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Suppress();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.models.rules.Rule#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Severity</em>'.
	 * @see org.nasdanika.models.rules.Rule#getSeverity()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Severity();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.RuleSet <em>Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Set</em>'.
	 * @see org.nasdanika.models.rules.RuleSet
	 * @generated
	 */
	EClass getRuleSet();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.models.rules.RuleSet#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.nasdanika.models.rules.RuleSet#getExtends()
	 * @see #getRuleSet()
	 * @generated
	 */
	EReference getRuleSet_Extends();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.models.rules.RuleSet#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extensions</em>'.
	 * @see org.nasdanika.models.rules.RuleSet#getExtensions()
	 * @see #getRuleSet()
	 * @generated
	 */
	EReference getRuleSet_Extensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.models.rules.RuleSet#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.nasdanika.models.rules.RuleSet#getRules()
	 * @see #getRuleSet()
	 * @generated
	 */
	EReference getRuleSet_Rules();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.Violation <em>Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Violation</em>'.
	 * @see org.nasdanika.models.rules.Violation
	 * @generated
	 */
	EClass getViolation();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.models.rules.Violation#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see org.nasdanika.models.rules.Violation#getRule()
	 * @see #getViolation()
	 * @generated
	 */
	EReference getViolation_Rule();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.models.rules.Violation#getWaivers <em>Waivers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Waivers</em>'.
	 * @see org.nasdanika.models.rules.Violation#getWaivers()
	 * @see #getViolation()
	 * @generated
	 */
	EReference getViolation_Waivers();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.Waiver <em>Waiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Waiver</em>'.
	 * @see org.nasdanika.models.rules.Waiver
	 * @generated
	 */
	EClass getWaiver();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.models.rules.Waiver#getViolations <em>Violations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Violations</em>'.
	 * @see org.nasdanika.models.rules.Waiver#getViolations()
	 * @see #getWaiver()
	 * @generated
	 */
	EReference getWaiver_Violations();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.Inspectable <em>Inspectable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inspectable</em>'.
	 * @see org.nasdanika.models.rules.Inspectable
	 * @generated
	 */
	EClass getInspectable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.models.rules.Inspectable#getViolations <em>Violations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Violations</em>'.
	 * @see org.nasdanika.models.rules.Inspectable#getViolations()
	 * @see #getInspectable()
	 * @generated
	 */
	EReference getInspectable_Violations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.models.rules.Inspectable#getWaivers <em>Waivers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Waivers</em>'.
	 * @see org.nasdanika.models.rules.Inspectable#getWaivers()
	 * @see #getInspectable()
	 * @generated
	 */
	EReference getInspectable_Waivers();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.models.rules.Severity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Severity</em>'.
	 * @see org.nasdanika.models.rules.Severity
	 * @generated
	 */
	EClass getSeverity();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.models.rules.Severity#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rules</em>'.
	 * @see org.nasdanika.models.rules.Severity#getRules()
	 * @see #getSeverity()
	 * @generated
	 */
	EReference getSeverity_Rules();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RulesFactory getRulesFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.models.rules.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.impl.RuleImpl
		 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();
		/**
		 * The meta object literal for the '<em><b>Suppress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__SUPPRESS = eINSTANCE.getRule_Suppress();
		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__SEVERITY = eINSTANCE.getRule_Severity();
		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.impl.RuleSetImpl <em>Rule Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.impl.RuleSetImpl
		 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getRuleSet()
		 * @generated
		 */
		EClass RULE_SET = eINSTANCE.getRuleSet();
		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_SET__EXTENDS = eINSTANCE.getRuleSet_Extends();
		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_SET__EXTENSIONS = eINSTANCE.getRuleSet_Extensions();
		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_SET__RULES = eINSTANCE.getRuleSet_Rules();
		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.impl.ViolationImpl <em>Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.impl.ViolationImpl
		 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getViolation()
		 * @generated
		 */
		EClass VIOLATION = eINSTANCE.getViolation();
		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIOLATION__RULE = eINSTANCE.getViolation_Rule();
		/**
		 * The meta object literal for the '<em><b>Waivers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIOLATION__WAIVERS = eINSTANCE.getViolation_Waivers();
		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.impl.WaiverImpl <em>Waiver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.impl.WaiverImpl
		 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getWaiver()
		 * @generated
		 */
		EClass WAIVER = eINSTANCE.getWaiver();
		/**
		 * The meta object literal for the '<em><b>Violations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAIVER__VIOLATIONS = eINSTANCE.getWaiver_Violations();
		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.impl.InspectableImpl <em>Inspectable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.impl.InspectableImpl
		 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getInspectable()
		 * @generated
		 */
		EClass INSPECTABLE = eINSTANCE.getInspectable();
		/**
		 * The meta object literal for the '<em><b>Violations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSPECTABLE__VIOLATIONS = eINSTANCE.getInspectable_Violations();
		/**
		 * The meta object literal for the '<em><b>Waivers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSPECTABLE__WAIVERS = eINSTANCE.getInspectable_Waivers();
		/**
		 * The meta object literal for the '{@link org.nasdanika.models.rules.impl.SeverityImpl <em>Severity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.models.rules.impl.SeverityImpl
		 * @see org.nasdanika.models.rules.impl.RulesPackageImpl#getSeverity()
		 * @generated
		 */
		EClass SEVERITY = eINSTANCE.getSeverity();
		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEVERITY__RULES = eINSTANCE.getSeverity_Rules();

	}

} //RulesPackage

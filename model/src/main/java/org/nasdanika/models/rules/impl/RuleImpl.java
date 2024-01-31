/**
 */
package org.nasdanika.models.rules.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.nasdanika.models.architecture.impl.NodeImpl;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.models.rules.Severity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.RuleImpl#isSuppress <em>Suppress</em>}</li>
 *   <li>{@link org.nasdanika.models.rules.impl.RuleImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends NodeImpl implements Rule {
	/**
	 * The default value of the '{@link #isSuppress() <em>Suppress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppress()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSuppress() {
		return (Boolean)eDynamicGet(RulesPackage.RULE__SUPPRESS, RulesPackage.Literals.RULE__SUPPRESS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuppress(boolean newSuppress) {
		eDynamicSet(RulesPackage.RULE__SUPPRESS, RulesPackage.Literals.RULE__SUPPRESS, newSuppress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Severity getSeverity() {
		return (Severity)eDynamicGet(RulesPackage.RULE__SEVERITY, RulesPackage.Literals.RULE__SEVERITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Severity basicGetSeverity() {
		return (Severity)eDynamicGet(RulesPackage.RULE__SEVERITY, RulesPackage.Literals.RULE__SEVERITY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeverity(Severity newSeverity, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newSeverity, RulesPackage.RULE__SEVERITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeverity(Severity newSeverity) {
		eDynamicSet(RulesPackage.RULE__SEVERITY, RulesPackage.Literals.RULE__SEVERITY, newSeverity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RulesPackage.RULE__SEVERITY:
				Severity severity = basicGetSeverity();
				if (severity != null)
					msgs = ((InternalEObject)severity).eInverseRemove(this, RulesPackage.SEVERITY__RULES, Severity.class, msgs);
				return basicSetSeverity((Severity)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RulesPackage.RULE__SEVERITY:
				return basicSetSeverity(null, msgs);
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
			case RulesPackage.RULE__SUPPRESS:
				return isSuppress();
			case RulesPackage.RULE__SEVERITY:
				if (resolve) return getSeverity();
				return basicGetSeverity();
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
			case RulesPackage.RULE__SUPPRESS:
				setSuppress((Boolean)newValue);
				return;
			case RulesPackage.RULE__SEVERITY:
				setSeverity((Severity)newValue);
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
			case RulesPackage.RULE__SUPPRESS:
				setSuppress(SUPPRESS_EDEFAULT);
				return;
			case RulesPackage.RULE__SEVERITY:
				setSeverity((Severity)null);
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
			case RulesPackage.RULE__SUPPRESS:
				return isSuppress() != SUPPRESS_EDEFAULT;
			case RulesPackage.RULE__SEVERITY:
				return basicGetSeverity() != null;
		}
		return super.eIsSet(featureID);
	}

} //RuleImpl

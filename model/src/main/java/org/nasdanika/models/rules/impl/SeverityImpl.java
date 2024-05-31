/**
 */
package org.nasdanika.models.rules.impl;

import java.util.Objects;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.models.architecture.impl.ArchitectureDescriptionElementImpl;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.models.rules.Severity;
import org.nasdanika.ncore.util.NcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Severity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.rules.impl.SeverityImpl#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SeverityImpl extends ArchitectureDescriptionElementImpl implements Severity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeverityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RulesPackage.Literals.SEVERITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Rule> getRules() {		
		return NcoreUtil.getReferrers(this, Objects.requireNonNull(NcoreUtil.getOpposite(RulesPackage.Literals.SEVERITY__RULES), "Opposite is null: " + RulesPackage.Literals.SEVERITY__RULES));
		// return (EList<Rule>)eDynamicGet(RulesPackage.SEVERITY__RULES, RulesPackage.Literals.SEVERITY__RULES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RulesPackage.SEVERITY__RULES:
				return getRules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RulesPackage.SEVERITY__RULES:
				return !getRules().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SeverityImpl

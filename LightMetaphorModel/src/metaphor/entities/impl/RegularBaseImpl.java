/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.impl;

import java.util.Collection;

import metaphor.entities.EntitiesPackage;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularDistrict;

import metaphor.types.impl.Entity3DImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regular Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link metaphor.entities.impl.RegularBaseImpl#getDistricts <em>Districts</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RegularBaseImpl extends Entity3DImpl implements RegularBase {
	/**
	 * The cached value of the '{@link #getDistricts() <em>Districts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDistricts()
	 * @generated
	 * @ordered
	 */
	protected EList<RegularDistrict> districts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RegularBaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntitiesPackage.Literals.REGULAR_BASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RegularDistrict> getDistricts() {
		if (districts == null) {
			districts = new EObjectResolvingEList<RegularDistrict>(RegularDistrict.class, this, EntitiesPackage.REGULAR_BASE__DISTRICTS);
		}
		return districts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EntitiesPackage.REGULAR_BASE__DISTRICTS:
			return getDistricts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EntitiesPackage.REGULAR_BASE__DISTRICTS:
			getDistricts().clear();
			getDistricts().addAll((Collection<? extends RegularDistrict>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case EntitiesPackage.REGULAR_BASE__DISTRICTS:
			getDistricts().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case EntitiesPackage.REGULAR_BASE__DISTRICTS:
			return districts != null && !districts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // RegularBaseImpl

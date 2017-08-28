/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.impl;

import java.util.Collection;

import metaphor.entities.EntitiesPackage;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;

import metaphor.types.impl.Entity3DImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regular District</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link metaphor.entities.impl.RegularDistrictImpl#getChildDistricts <em>Child Districts</em>}</li>
 * <li>{@link metaphor.entities.impl.RegularDistrictImpl#getParentDistrict <em>Parent District</em>}</li>
 * <li>{@link metaphor.entities.impl.RegularDistrictImpl#getBuildungs <em>Buildungs</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RegularDistrictImpl extends Entity3DImpl implements RegularDistrict {
	/**
	 * The cached value of the '{@link #getChildDistricts() <em>Child Districts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getChildDistricts()
	 * @generated
	 * @ordered
	 */
	protected EList<RegularDistrict> childDistricts;

	/**
	 * The cached value of the '{@link #getParentDistrict() <em>Parent District</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getParentDistrict()
	 * @generated
	 * @ordered
	 */
	protected RegularDistrict parentDistrict;

	/**
	 * The cached value of the '{@link #getBuildungs() <em>Buildungs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBuildungs()
	 * @generated
	 * @ordered
	 */
	protected EList<RegularBuilding> buildungs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RegularDistrictImpl() {
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
		return EntitiesPackage.Literals.REGULAR_DISTRICT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RegularDistrict> getChildDistricts() {
		if (childDistricts == null) {
			childDistricts = new EObjectResolvingEList<RegularDistrict>(RegularDistrict.class, this, EntitiesPackage.REGULAR_DISTRICT__CHILD_DISTRICTS);
		}
		return childDistricts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegularDistrict getParentDistrict() {
		if (parentDistrict != null && parentDistrict.eIsProxy()) {
			InternalEObject oldParentDistrict = (InternalEObject) parentDistrict;
			parentDistrict = (RegularDistrict) eResolveProxy(oldParentDistrict);
			if (parentDistrict != oldParentDistrict) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EntitiesPackage.REGULAR_DISTRICT__PARENT_DISTRICT, oldParentDistrict, parentDistrict));
			}
		}
		return parentDistrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegularDistrict basicGetParentDistrict() {
		return parentDistrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentDistrict(RegularDistrict newParentDistrict) {
		RegularDistrict oldParentDistrict = parentDistrict;
		parentDistrict = newParentDistrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.REGULAR_DISTRICT__PARENT_DISTRICT, oldParentDistrict, parentDistrict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RegularBuilding> getBuildungs() {
		if (buildungs == null) {
			buildungs = new EObjectResolvingEList<RegularBuilding>(RegularBuilding.class, this, EntitiesPackage.REGULAR_DISTRICT__BUILDUNGS);
		}
		return buildungs;
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
		case EntitiesPackage.REGULAR_DISTRICT__CHILD_DISTRICTS:
			return getChildDistricts();
		case EntitiesPackage.REGULAR_DISTRICT__PARENT_DISTRICT:
			if (resolve)
				return getParentDistrict();
			return basicGetParentDistrict();
		case EntitiesPackage.REGULAR_DISTRICT__BUILDUNGS:
			return getBuildungs();
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
		case EntitiesPackage.REGULAR_DISTRICT__CHILD_DISTRICTS:
			getChildDistricts().clear();
			getChildDistricts().addAll((Collection<? extends RegularDistrict>) newValue);
			return;
		case EntitiesPackage.REGULAR_DISTRICT__PARENT_DISTRICT:
			setParentDistrict((RegularDistrict) newValue);
			return;
		case EntitiesPackage.REGULAR_DISTRICT__BUILDUNGS:
			getBuildungs().clear();
			getBuildungs().addAll((Collection<? extends RegularBuilding>) newValue);
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
		case EntitiesPackage.REGULAR_DISTRICT__CHILD_DISTRICTS:
			getChildDistricts().clear();
			return;
		case EntitiesPackage.REGULAR_DISTRICT__PARENT_DISTRICT:
			setParentDistrict((RegularDistrict) null);
			return;
		case EntitiesPackage.REGULAR_DISTRICT__BUILDUNGS:
			getBuildungs().clear();
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
		case EntitiesPackage.REGULAR_DISTRICT__CHILD_DISTRICTS:
			return childDistricts != null && !childDistricts.isEmpty();
		case EntitiesPackage.REGULAR_DISTRICT__PARENT_DISTRICT:
			return parentDistrict != null;
		case EntitiesPackage.REGULAR_DISTRICT__BUILDUNGS:
			return buildungs != null && !buildungs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // RegularDistrictImpl

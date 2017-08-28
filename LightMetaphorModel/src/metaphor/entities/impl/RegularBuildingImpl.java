/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.impl;

import java.util.Collection;

import metaphor.entities.Cable;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;

import metaphor.types.impl.Entity2DImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regular Building</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link metaphor.entities.impl.RegularBuildingImpl#getFloors <em>Floors</em>}</li>
 * <li>{@link metaphor.entities.impl.RegularBuildingImpl#getCables <em>Cables</em>}</li>
 * <li>{@link metaphor.entities.impl.RegularBuildingImpl#getDistrict <em>District</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RegularBuildingImpl extends Entity2DImpl implements RegularBuilding {
	/**
	 * The cached value of the '{@link #getFloors() <em>Floors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFloors()
	 * @generated
	 * @ordered
	 */
	protected EList<RegularFloor> floors;

	/**
	 * The cached value of the '{@link #getCables() <em>Cables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCables()
	 * @generated
	 * @ordered
	 */
	protected EList<Cable> cables;

	/**
	 * The cached value of the '{@link #getDistrict() <em>District</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDistrict()
	 * @generated
	 * @ordered
	 */
	protected RegularDistrict district;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RegularBuildingImpl() {
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
		return EntitiesPackage.Literals.REGULAR_BUILDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RegularFloor> getFloors() {
		if (floors == null) {
			floors = new EObjectResolvingEList<RegularFloor>(RegularFloor.class, this, EntitiesPackage.REGULAR_BUILDING__FLOORS);
		}
		return floors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Cable> getCables() {
		if (cables == null) {
			cables = new EObjectResolvingEList<Cable>(Cable.class, this, EntitiesPackage.REGULAR_BUILDING__CABLES);
		}
		return cables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegularDistrict getDistrict() {
		if (district != null && district.eIsProxy()) {
			InternalEObject oldDistrict = (InternalEObject) district;
			district = (RegularDistrict) eResolveProxy(oldDistrict);
			if (district != oldDistrict) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EntitiesPackage.REGULAR_BUILDING__DISTRICT, oldDistrict, district));
			}
		}
		return district;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegularDistrict basicGetDistrict() {
		return district;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDistrict(RegularDistrict newDistrict) {
		RegularDistrict oldDistrict = district;
		district = newDistrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.REGULAR_BUILDING__DISTRICT, oldDistrict, district));
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
		case EntitiesPackage.REGULAR_BUILDING__FLOORS:
			return getFloors();
		case EntitiesPackage.REGULAR_BUILDING__CABLES:
			return getCables();
		case EntitiesPackage.REGULAR_BUILDING__DISTRICT:
			if (resolve)
				return getDistrict();
			return basicGetDistrict();
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
		case EntitiesPackage.REGULAR_BUILDING__FLOORS:
			getFloors().clear();
			getFloors().addAll((Collection<? extends RegularFloor>) newValue);
			return;
		case EntitiesPackage.REGULAR_BUILDING__CABLES:
			getCables().clear();
			getCables().addAll((Collection<? extends Cable>) newValue);
			return;
		case EntitiesPackage.REGULAR_BUILDING__DISTRICT:
			setDistrict((RegularDistrict) newValue);
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
		case EntitiesPackage.REGULAR_BUILDING__FLOORS:
			getFloors().clear();
			return;
		case EntitiesPackage.REGULAR_BUILDING__CABLES:
			getCables().clear();
			return;
		case EntitiesPackage.REGULAR_BUILDING__DISTRICT:
			setDistrict((RegularDistrict) null);
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
		case EntitiesPackage.REGULAR_BUILDING__FLOORS:
			return floors != null && !floors.isEmpty();
		case EntitiesPackage.REGULAR_BUILDING__CABLES:
			return cables != null && !cables.isEmpty();
		case EntitiesPackage.REGULAR_BUILDING__DISTRICT:
			return district != null;
		}
		return super.eIsSet(featureID);
	}

} // RegularBuildingImpl

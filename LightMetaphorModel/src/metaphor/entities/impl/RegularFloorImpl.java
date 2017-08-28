/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.impl;

import metaphor.entities.EntitiesPackage;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularFloor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regular Floor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link metaphor.entities.impl.RegularFloorImpl#getBuilding <em>Building</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegularFloorImpl extends FloorImpl implements RegularFloor {
	/**
	 * The cached value of the '{@link #getBuilding() <em>Building</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBuilding()
	 * @generated
	 * @ordered
	 */
	protected RegularBuilding building;

	protected int classId=0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected RegularFloorImpl() {
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
		return EntitiesPackage.Literals.REGULAR_FLOOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularBuilding getBuilding() {
		if (building != null && building.eIsProxy()) {
			InternalEObject oldBuilding = (InternalEObject) building;
			building = (RegularBuilding) eResolveProxy(oldBuilding);
			if (building != oldBuilding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EntitiesPackage.REGULAR_FLOOR__BUILDING, oldBuilding, building));
			}
		}
		return building;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularBuilding basicGetBuilding() {
		return building;
	}

	public int getClassId(){
		return classId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setBuilding(RegularBuilding newBuilding) {
		RegularBuilding oldBuilding = building;
		building = newBuilding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.REGULAR_FLOOR__BUILDING, oldBuilding, building));
	}

	public void setClassId(int newClassId){
		int oldClassId = classId;
		classId = newClassId;
		//if(eNotificationRequired())
			//eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.REGULAR_FLOOR__BUILDING, oldClassId, classId));
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
		case EntitiesPackage.REGULAR_FLOOR__BUILDING:
			if (resolve)
				return getBuilding();
			return basicGetBuilding();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EntitiesPackage.REGULAR_FLOOR__BUILDING:
			setBuilding((RegularBuilding) newValue);
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
		case EntitiesPackage.REGULAR_FLOOR__BUILDING:
			setBuilding((RegularBuilding) null);
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
		case EntitiesPackage.REGULAR_FLOOR__BUILDING:
			return building != null;
		}
		return super.eIsSet(featureID);
	}

} // RegularFloorImpl

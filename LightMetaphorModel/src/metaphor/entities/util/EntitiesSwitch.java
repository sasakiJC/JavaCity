/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import metaphor.entities.Cable;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.Floor;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.Street;
import metaphor.types.Entity2D;
import metaphor.types.Entity3D;
import metaphor.types.VisualEntity;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see metaphor.entities.EntitiesPackage
 * @generated
 */
public class EntitiesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static EntitiesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EntitiesSwitch() {
		if (modelPackage == null) {
			modelPackage = EntitiesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @parameter ePackage the package in question.
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
	 *
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case EntitiesPackage.REGULAR_BUILDING: {
			RegularBuilding regularBuilding = (RegularBuilding) theEObject;
			T result = caseRegularBuilding(regularBuilding);
			if (result == null)
				result = caseEntity2D(regularBuilding);
			if (result == null)
				result = caseVisualEntity(regularBuilding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EntitiesPackage.STREET: {
			Street street = (Street) theEObject;
			T result = caseStreet(street);
			if (result == null)
				result = caseVisualEntity(street);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EntitiesPackage.FLOOR: {
			Floor floor = (Floor) theEObject;
			T result = caseFloor(floor);
			if (result == null)
				result = caseVisualEntity(floor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EntitiesPackage.REGULAR_FLOOR: {
			RegularFloor regularFloor = (RegularFloor) theEObject;
			T result = caseRegularFloor(regularFloor);
			if (result == null)
				result = caseFloor(regularFloor);
			if (result == null)
				result = caseVisualEntity(regularFloor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EntitiesPackage.CABLE: {
			Cable cable = (Cable) theEObject;
			T result = caseCable(cable);
			if (result == null)
				result = caseVisualEntity(cable);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EntitiesPackage.REGULAR_DISTRICT: {
			RegularDistrict regularDistrict = (RegularDistrict) theEObject;
			T result = caseRegularDistrict(regularDistrict);
			if (result == null)
				result = caseEntity3D(regularDistrict);
			if (result == null)
				result = caseEntity2D(regularDistrict);
			if (result == null)
				result = caseVisualEntity(regularDistrict);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EntitiesPackage.REGULAR_BASE: {
			RegularBase regularBase = (RegularBase) theEObject;
			T result = caseRegularBase(regularBase);
			if (result == null)
				result = caseEntity3D(regularBase);
			if (result == null)
				result = caseEntity2D(regularBase);
			if (result == null)
				result = caseVisualEntity(regularBase);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regular Building</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regular Building</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegularBuilding(RegularBuilding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Street</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Street</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStreet(Street object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Floor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Floor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloor(Floor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regular Floor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regular Floor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegularFloor(RegularFloor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCable(Cable object) {
		return null;
	}


	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regular District</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regular District</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegularDistrict(RegularDistrict object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regular Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regular Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegularBase(RegularBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visual Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visual Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisualEntity(VisualEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity2 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity2 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity2D(Entity2D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity3 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity3 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity3D(Entity3D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // EntitiesSwitch

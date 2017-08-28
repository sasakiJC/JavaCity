/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import metaphor.entities.Cable;
import metaphor.entities.EntitiesFactory;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.Status;
import metaphor.entities.Street;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EntitiesFactoryImpl extends EFactoryImpl implements EntitiesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static EntitiesFactory init() {
		try {
			EntitiesFactory theEntitiesFactory = (EntitiesFactory) EPackage.Registry.INSTANCE.getEFactory("http://pdo-thesis-SS12.de/metaphor-metamodel/entities");
			if (theEntitiesFactory != null) {
				return theEntitiesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EntitiesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EntitiesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case EntitiesPackage.REGULAR_BUILDING:
			return createRegularBuilding();
		case EntitiesPackage.STREET:
			return createStreet();
		case EntitiesPackage.REGULAR_FLOOR:
			return createRegularFloor();
		case EntitiesPackage.CABLE:
			return createCable();
		case EntitiesPackage.REGULAR_DISTRICT:
			return createRegularDistrict();
		case EntitiesPackage.REGULAR_BASE:
			return createRegularBase();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case EntitiesPackage.STATUS:
			return createStatusFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case EntitiesPackage.STATUS:
			return convertStatusToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularBuilding createRegularBuilding() {
		RegularBuildingImpl regularBuilding = new RegularBuildingImpl();
		return regularBuilding;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Street createStreet() {
		StreetImpl street = new StreetImpl();
		return street;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularFloor createRegularFloor() {
		RegularFloorImpl regularFloor = new RegularFloorImpl();
		return regularFloor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Cable createCable() {
		CableImpl cable = new CableImpl();
		return cable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularDistrict createRegularDistrict() {
		RegularDistrictImpl regularDistrict = new RegularDistrictImpl();
		return regularDistrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularBase createRegularBase() {
		RegularBaseImpl regularBase = new RegularBaseImpl();
		return regularBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Status createStatusFromString(EDataType eDataType, String initialValue) {
		Status result = Status.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EntitiesPackage getEntitiesPackage() {
		return (EntitiesPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EntitiesPackage getPackage() {
		return EntitiesPackage.eINSTANCE;
	}

} // EntitiesFactoryImpl

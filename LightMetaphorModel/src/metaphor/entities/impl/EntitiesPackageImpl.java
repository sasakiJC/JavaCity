/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import metaphor.MetaphorPackage;
import metaphor.entities.Cable;
import metaphor.entities.EntitiesFactory;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.Floor;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.Status;
import metaphor.entities.Street;
import metaphor.impl.MetaphorPackageImpl;
import metaphor.types.TypesPackage;
import metaphor.types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EntitiesPackageImpl extends EPackageImpl implements EntitiesPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass regularBuildingEClass = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass streetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass floorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass regularFloorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass cableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass regularDistrictEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass regularBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EEnum statusEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or
	 * returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see metaphor.entities.EntitiesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EntitiesPackageImpl() {
		super(eNS_URI, EntitiesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link EntitiesPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should
	 * simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EntitiesPackage init() {
		if (isInited)
			return (EntitiesPackage) EPackage.Registry.INSTANCE.getEPackage(EntitiesPackage.eNS_URI);

		// Obtain or create and register package
		EntitiesPackageImpl theEntitiesPackage = (EntitiesPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EntitiesPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new EntitiesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MetaphorPackageImpl theMetaphorPackage = (MetaphorPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(MetaphorPackage.eNS_URI) instanceof MetaphorPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(MetaphorPackage.eNS_URI) : MetaphorPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theEntitiesPackage.createPackageContents();
		theMetaphorPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theEntitiesPackage.initializePackageContents();
		theMetaphorPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEntitiesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EntitiesPackage.eNS_URI, theEntitiesPackage);
		return theEntitiesPackage;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getRegularBuilding() {
		return regularBuildingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularBuilding_Floors() {
		return (EReference) regularBuildingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularBuilding_Cables() {
		return (EReference) regularBuildingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularBuilding_District() {
		return (EReference) regularBuildingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getStreet() {
		return streetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getStreet_Source() {
		return (EReference) streetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getStreet_Target() {
		return (EReference) streetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getStreet_Status() {
		return (EAttribute) streetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getFloor() {
		return floorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getFloor_Height() {
		return (EAttribute) floorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getFloor_Streets() {
		return (EReference) floorEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getRegularFloor() {
		return regularFloorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularFloor_Building() {
		return (EReference) regularFloorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getCable() {
		return cableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getCable_Source() {
		return (EReference) cableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getCable_Target() {
		return (EReference) cableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getRegularDistrict() {
		return regularDistrictEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularDistrict_ChildDistricts() {
		return (EReference) regularDistrictEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularDistrict_ParentDistrict() {
		return (EReference) regularDistrictEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularDistrict_Buildungs() {
		return (EReference) regularDistrictEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getRegularBase() {
		return regularBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getRegularBase_Districts() {
		return (EReference) regularBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EEnum getStatus() {
		return statusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EntitiesFactory getEntitiesFactory() {
		return (EntitiesFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		regularBuildingEClass = createEClass(REGULAR_BUILDING);
		createEReference(regularBuildingEClass, REGULAR_BUILDING__FLOORS);
		createEReference(regularBuildingEClass, REGULAR_BUILDING__CABLES);
		createEReference(regularBuildingEClass, REGULAR_BUILDING__DISTRICT);


		streetEClass = createEClass(STREET);
		createEReference(streetEClass, STREET__SOURCE);
		createEReference(streetEClass, STREET__TARGET);
		createEAttribute(streetEClass, STREET__STATUS);

		floorEClass = createEClass(FLOOR);
		createEAttribute(floorEClass, FLOOR__HEIGHT);
		createEReference(floorEClass, FLOOR__STREETS);


		regularFloorEClass = createEClass(REGULAR_FLOOR);
		createEReference(regularFloorEClass, REGULAR_FLOOR__BUILDING);

		cableEClass = createEClass(CABLE);
		createEReference(cableEClass, CABLE__SOURCE);
		createEReference(cableEClass, CABLE__TARGET);


		regularDistrictEClass = createEClass(REGULAR_DISTRICT);
		createEReference(regularDistrictEClass, REGULAR_DISTRICT__CHILD_DISTRICTS);
		createEReference(regularDistrictEClass, REGULAR_DISTRICT__PARENT_DISTRICT);
		createEReference(regularDistrictEClass, REGULAR_DISTRICT__BUILDUNGS);

		regularBaseEClass = createEClass(REGULAR_BASE);
		createEReference(regularBaseEClass, REGULAR_BASE__DISTRICTS);


		// Create enums
		statusEEnum = createEEnum(STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		regularBuildingEClass.getESuperTypes().add(theTypesPackage.getEntity2D());
		streetEClass.getESuperTypes().add(theTypesPackage.getVisualEntity());
		floorEClass.getESuperTypes().add(theTypesPackage.getVisualEntity());
		regularFloorEClass.getESuperTypes().add(this.getFloor());
		cableEClass.getESuperTypes().add(theTypesPackage.getVisualEntity());
		regularDistrictEClass.getESuperTypes().add(theTypesPackage.getEntity3D());
		regularBaseEClass.getESuperTypes().add(theTypesPackage.getEntity3D());

		// Initialize classes and features; add operations and parameters

		initEClass(regularBuildingEClass, RegularBuilding.class, "RegularBuilding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegularBuilding_Floors(), this.getRegularFloor(), null, "floors", null, 1, -1, RegularBuilding.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRegularBuilding_Cables(), this.getCable(), null, "cables", null, 1, -1, RegularBuilding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegularBuilding_District(), this.getRegularDistrict(), null, "district", null, 1, 1, RegularBuilding.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);


		initEClass(streetEClass, Street.class, "Street", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStreet_Source(), this.getFloor(), null, "source", null, 1, 1, Street.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStreet_Target(), this.getFloor(), null, "target", null, 1, 1, Street.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStreet_Status(), this.getStatus(), "status", null, 1, 1, Street.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(floorEClass, Floor.class, "Floor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloor_Height(), ecorePackage.getEFloat(), "height", null, 1, 1, Floor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFloor_Streets(), this.getStreet(), null, "streets", null, 0, -1, Floor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);


		initEClass(regularFloorEClass, RegularFloor.class, "RegularFloor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegularFloor_Building(), this.getRegularBuilding(), null, "building", null, 1, 1, RegularFloor.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cableEClass, Cable.class, "Cable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCable_Source(), this.getRegularBuilding(), null, "source", null, 1, 1, Cable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCable_Target(), this.getRegularBuilding(), null, "target", null, 1, 1, Cable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);


		initEClass(regularDistrictEClass, RegularDistrict.class, "RegularDistrict", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegularDistrict_ChildDistricts(), this.getRegularDistrict(), null, "childDistricts", null, 0, -1, RegularDistrict.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegularDistrict_ParentDistrict(), this.getRegularDistrict(), null, "parentDistrict", null, 0, 1, RegularDistrict.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegularDistrict_Buildungs(), this.getRegularBuilding(), null, "buildungs", null, 0, -1, RegularDistrict.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regularBaseEClass, RegularBase.class, "RegularBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegularBase_Districts(), this.getRegularDistrict(), null, "districts", null, 1, -1, RegularBase.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);


		// Initialize enums and add enum literals
		initEEnum(statusEEnum, Status.class, "Status");
		addEEnumLiteral(statusEEnum, Status.OPENED);
		addEEnumLiteral(statusEEnum, Status.CLOSED);
	}

} // EntitiesPackageImpl

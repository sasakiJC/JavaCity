/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import metaphor.City;
import metaphor.MetaphorFactory;
import metaphor.MetaphorPackage;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.impl.EntitiesPackageImpl;
import metaphor.types.TypesPackage;
import metaphor.types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MetaphorPackageImpl extends EPackageImpl implements MetaphorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass cityEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or
	 * returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see metaphor.MetaphorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetaphorPackageImpl() {
		super(eNS_URI, MetaphorFactory.eINSTANCE);
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
	 * This method is used to initialize {@link MetaphorPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should
	 * simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetaphorPackage init() {
		if (isInited)
			return (MetaphorPackage) EPackage.Registry.INSTANCE.getEPackage(MetaphorPackage.eNS_URI);

		// Obtain or create and register package
		MetaphorPackageImpl theMetaphorPackage = (MetaphorPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetaphorPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new MetaphorPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		EntitiesPackageImpl theEntitiesPackage = (EntitiesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(EntitiesPackage.eNS_URI) instanceof EntitiesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EntitiesPackage.eNS_URI) : EntitiesPackage.eINSTANCE);

		// Create package meta-data objects
		theMetaphorPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theEntitiesPackage.createPackageContents();

		// Initialize created meta-data
		theMetaphorPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theEntitiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetaphorPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetaphorPackage.eNS_URI, theMetaphorPackage);
		return theMetaphorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getCity() {
		return cityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getCity_Streets() {
		return (EReference) cityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getCity_RegularCoverage() {
		return (EReference) cityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MetaphorFactory getMetaphorFactory() {
		return (MetaphorFactory) getEFactoryInstance();
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
		cityEClass = createEClass(CITY);
		createEReference(cityEClass, CITY__STREETS);
		createEReference(cityEClass, CITY__REGULAR_COVERAGE);
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
		EntitiesPackage theEntitiesPackage = (EntitiesPackage) EPackage.Registry.INSTANCE.getEPackage(EntitiesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theTypesPackage);
		getESubpackages().add(theEntitiesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(cityEClass, City.class, "City", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCity_Streets(), theEntitiesPackage.getStreet(), null, "streets", null, 0, -1, City.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCity_RegularCoverage(), theEntitiesPackage.getRegularBase(), null, "regularCoverage", null, 1, 1, City.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // MetaphorPackageImpl

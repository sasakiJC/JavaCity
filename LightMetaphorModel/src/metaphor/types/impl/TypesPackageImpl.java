/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.types.impl;



import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import metaphor.MetaphorPackage;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.impl.EntitiesPackageImpl;
import metaphor.impl.MetaphorPackageImpl;
import metaphor.types.Entity2D;
import metaphor.types.Entity3D;
import metaphor.types.TypesFactory;
import metaphor.types.TypesPackage;
import metaphor.types.VisualEntity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass visualEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass entity2DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass entity3DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType colorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType vector3DEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType nodeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or
	 * returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see metaphor.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl() {
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should
	 * simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init() {
		if (isInited)
			return (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new TypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MetaphorPackageImpl theMetaphorPackage = (MetaphorPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(MetaphorPackage.eNS_URI) instanceof MetaphorPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(MetaphorPackage.eNS_URI) : MetaphorPackage.eINSTANCE);
		EntitiesPackageImpl theEntitiesPackage = (EntitiesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(EntitiesPackage.eNS_URI) instanceof EntitiesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EntitiesPackage.eNS_URI) : EntitiesPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theMetaphorPackage.createPackageContents();
		theEntitiesPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theMetaphorPackage.initializePackageContents();
		theEntitiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getVisualEntity() {
		return visualEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getVisualEntity_Id() {
		return (EAttribute) visualEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getVisualEntity_Color() {
		return (EAttribute) visualEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getVisualEntity_Position() {
		return (EAttribute) visualEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getVisualEntity_DataObject() {
		return (EAttribute) visualEntityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getVisualEntity_Java3dObject() {
		return (EAttribute) visualEntityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getEntity2D() {
		return entity2DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getEntity2D_Length() {
		return (EAttribute) entity2DEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getEntity2D_Width() {
		return (EAttribute) entity2DEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getEntity3D() {
		return entity3DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getEntity3D_Height() {
		return (EAttribute) entity3DEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EDataType getColor() {
		return colorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EDataType getVector3D() {
		return vector3DEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EDataType getNode() {
		return nodeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public TypesFactory getTypesFactory() {
		return (TypesFactory) getEFactoryInstance();
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
		visualEntityEClass = createEClass(VISUAL_ENTITY);
		createEAttribute(visualEntityEClass, VISUAL_ENTITY__ID);
		createEAttribute(visualEntityEClass, VISUAL_ENTITY__COLOR);
		createEAttribute(visualEntityEClass, VISUAL_ENTITY__POSITION);
		createEAttribute(visualEntityEClass, VISUAL_ENTITY__DATA_OBJECT);
		createEAttribute(visualEntityEClass, VISUAL_ENTITY__JAVA3D_OBJECT);

		entity2DEClass = createEClass(ENTITY2_D);
		createEAttribute(entity2DEClass, ENTITY2_D__LENGTH);
		createEAttribute(entity2DEClass, ENTITY2_D__WIDTH);

		entity3DEClass = createEClass(ENTITY3_D);
		createEAttribute(entity3DEClass, ENTITY3_D__HEIGHT);

		// Create data types
		colorEDataType = createEDataType(COLOR);
		nodeEDataType = createEDataType(NODE);
		vector3DEDataType = createEDataType(VECTOR3_D);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		entity2DEClass.getESuperTypes().add(this.getVisualEntity());
		entity3DEClass.getESuperTypes().add(this.getEntity2D());

		// Initialize classes and features; add operations and parameters
		initEClass(visualEntityEClass, VisualEntity.class, "VisualEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisualEntity_Id(), ecorePackage.getELong(), "id", null, 0, 1, VisualEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualEntity_Color(), this.getColor(), "color", null, 0, 1, VisualEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualEntity_Position(), this.getVector3D(), "position", null, 0, 1, VisualEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualEntity_DataObject(), ecorePackage.getEJavaObject(), "dataObject", null, 0, 1, VisualEntity.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualEntity_Java3dObject(), this.getNode(), "java3dObject", null, 0, 1, VisualEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entity2DEClass, Entity2D.class, "Entity2D", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity2D_Length(), ecorePackage.getEFloat(), "length", null, 0, 1, Entity2D.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntity2D_Width(), ecorePackage.getEFloat(), "width", null, 0, 1, Entity2D.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entity3DEClass, Entity3D.class, "Entity3D", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity3D_Height(), ecorePackage.getEFloat(), "height", null, 0, 1, Entity3D.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(colorEDataType, Color.class, "Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(nodeEDataType, Node.class, "Node", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(vector3DEDataType, Point3D.class, "Vector3D", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} // TypesPackageImpl

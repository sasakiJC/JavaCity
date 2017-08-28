/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import metaphor.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see metaphor.entities.EntitiesFactory
 * @model kind="package"
 * @generated
 */
public interface EntitiesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "entities";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://pdo-thesis-SS12.de/metaphor-metamodel/entities";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "e";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	EntitiesPackage eINSTANCE = metaphor.entities.impl.EntitiesPackageImpl.init();


	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__ID = TypesPackage.ENTITY2_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__COLOR = TypesPackage.ENTITY2_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__POSITION = TypesPackage.ENTITY2_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__DATA_OBJECT = TypesPackage.ENTITY2_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__JAVA3D_OBJECT = TypesPackage.ENTITY2_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__LENGTH = TypesPackage.ENTITY2_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__WIDTH = TypesPackage.ENTITY2_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Floors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__FLOORS = TypesPackage.ENTITY2_D_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>District</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING__DISTRICT = TypesPackage.ENTITY2_D_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Administration Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BUILDING_FEATURE_COUNT = TypesPackage.ENTITY2_D_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link metaphor.entities.impl.RegularBuildingImpl <em>Regular Building</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.impl.RegularBuildingImpl
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularBuilding()
	 * @generated
	 */
	int REGULAR_BUILDING = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__ID = TypesPackage.ENTITY2_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__COLOR = TypesPackage.ENTITY2_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__POSITION = TypesPackage.ENTITY2_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__DATA_OBJECT = TypesPackage.ENTITY2_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__JAVA3D_OBJECT = TypesPackage.ENTITY2_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__LENGTH = TypesPackage.ENTITY2_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__WIDTH = TypesPackage.ENTITY2_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Floors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__FLOORS = TypesPackage.ENTITY2_D_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__CABLES = TypesPackage.ENTITY2_D_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>District</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING__DISTRICT = TypesPackage.ENTITY2_D_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Regular Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BUILDING_FEATURE_COUNT = TypesPackage.ENTITY2_D_FEATURE_COUNT + 3;


	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__ID = TypesPackage.ENTITY2_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__COLOR = TypesPackage.ENTITY2_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__POSITION = TypesPackage.ENTITY2_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__DATA_OBJECT = TypesPackage.ENTITY2_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__JAVA3D_OBJECT = TypesPackage.ENTITY2_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__LENGTH = TypesPackage.ENTITY2_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__WIDTH = TypesPackage.ENTITY2_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Floor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER__FLOOR = TypesPackage.ENTITY2_D_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Poster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int POSTER_FEATURE_COUNT = TypesPackage.ENTITY2_D_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link metaphor.entities.impl.StreetImpl <em>Street</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.impl.StreetImpl
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getStreet()
	 * @generated
	 */
	int STREET = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__ID = TypesPackage.VISUAL_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__COLOR = TypesPackage.VISUAL_ENTITY__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__POSITION = TypesPackage.VISUAL_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__DATA_OBJECT = TypesPackage.VISUAL_ENTITY__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__JAVA3D_OBJECT = TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__SOURCE = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__TARGET = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET__STATUS = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Street</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STREET_FEATURE_COUNT = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link metaphor.entities.impl.FloorImpl <em>Floor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.impl.FloorImpl
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getFloor()
	 * @generated
	 */
	int FLOOR = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR__ID = TypesPackage.VISUAL_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR__COLOR = TypesPackage.VISUAL_ENTITY__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR__POSITION = TypesPackage.VISUAL_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR__DATA_OBJECT = TypesPackage.VISUAL_ENTITY__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR__JAVA3D_OBJECT = TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR__HEIGHT = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Streets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR__STREETS = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Floor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FLOOR_FEATURE_COUNT = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 2;


	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__ID = FLOOR__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__COLOR = FLOOR__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__POSITION = FLOOR__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__DATA_OBJECT = FLOOR__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__JAVA3D_OBJECT = FLOOR__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__HEIGHT = FLOOR__HEIGHT;

	/**
	 * The feature id for the '<em><b>Streets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__STREETS = FLOOR__STREETS;

	/**
	 * The feature id for the '<em><b>Poster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__POSTER = FLOOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Building</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR__BUILDING = FLOOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Administration Floor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FLOOR_FEATURE_COUNT = FLOOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link metaphor.entities.impl.RegularFloorImpl <em>Regular Floor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.impl.RegularFloorImpl
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularFloor()
	 * @generated
	 */
	int REGULAR_FLOOR = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__ID = FLOOR__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__COLOR = FLOOR__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__POSITION = FLOOR__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__DATA_OBJECT = FLOOR__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__JAVA3D_OBJECT = FLOOR__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__HEIGHT = FLOOR__HEIGHT;

	/**
	 * The feature id for the '<em><b>Streets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__STREETS = FLOOR__STREETS;

	/**
	 * The feature id for the '<em><b>Building</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR__BUILDING = FLOOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regular Floor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_FLOOR_FEATURE_COUNT = FLOOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link metaphor.entities.impl.CableImpl <em>Cable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.impl.CableImpl
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getCable()
	 * @generated
	 */
	int CABLE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE__ID = TypesPackage.VISUAL_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE__COLOR = TypesPackage.VISUAL_ENTITY__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE__POSITION = TypesPackage.VISUAL_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE__DATA_OBJECT = TypesPackage.VISUAL_ENTITY__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE__JAVA3D_OBJECT = TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE__SOURCE = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE__TARGET = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CABLE_FEATURE_COUNT = TypesPackage.VISUAL_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__ID = TypesPackage.ENTITY3_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__COLOR = TypesPackage.ENTITY3_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__POSITION = TypesPackage.ENTITY3_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__DATA_OBJECT = TypesPackage.ENTITY3_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__JAVA3D_OBJECT = TypesPackage.ENTITY3_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__LENGTH = TypesPackage.ENTITY3_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__WIDTH = TypesPackage.ENTITY3_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__HEIGHT = TypesPackage.ENTITY3_D__HEIGHT;

	/**
	 * The feature id for the '<em><b>Buildings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT__BUILDINGS = TypesPackage.ENTITY3_D_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Administration District</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_DISTRICT_FEATURE_COUNT = TypesPackage.ENTITY3_D_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link metaphor.entities.impl.RegularDistrictImpl <em>Regular District</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.impl.RegularDistrictImpl
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularDistrict()
	 * @generated
	 */
	int REGULAR_DISTRICT = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__ID = TypesPackage.ENTITY3_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__COLOR = TypesPackage.ENTITY3_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__POSITION = TypesPackage.ENTITY3_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__DATA_OBJECT = TypesPackage.ENTITY3_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__JAVA3D_OBJECT = TypesPackage.ENTITY3_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__LENGTH = TypesPackage.ENTITY3_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__WIDTH = TypesPackage.ENTITY3_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__HEIGHT = TypesPackage.ENTITY3_D__HEIGHT;

	/**
	 * The feature id for the '<em><b>Child Districts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__CHILD_DISTRICTS = TypesPackage.ENTITY3_D_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent District</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__PARENT_DISTRICT = TypesPackage.ENTITY3_D_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Buildungs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT__BUILDUNGS = TypesPackage.ENTITY3_D_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Regular District</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_DISTRICT_FEATURE_COUNT = TypesPackage.ENTITY3_D_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link metaphor.entities.impl.RegularBaseImpl <em>Regular Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.impl.RegularBaseImpl
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularBase()
	 * @generated
	 */
	int REGULAR_BASE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__ID = TypesPackage.ENTITY3_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__COLOR = TypesPackage.ENTITY3_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__POSITION = TypesPackage.ENTITY3_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__DATA_OBJECT = TypesPackage.ENTITY3_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__JAVA3D_OBJECT = TypesPackage.ENTITY3_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__LENGTH = TypesPackage.ENTITY3_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__WIDTH = TypesPackage.ENTITY3_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__HEIGHT = TypesPackage.ENTITY3_D__HEIGHT;

	/**
	 * The feature id for the '<em><b>Districts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE__DISTRICTS = TypesPackage.ENTITY3_D_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regular Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int REGULAR_BASE_FEATURE_COUNT = TypesPackage.ENTITY3_D_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__ID = TypesPackage.ENTITY3_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__COLOR = TypesPackage.ENTITY3_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__POSITION = TypesPackage.ENTITY3_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__DATA_OBJECT = TypesPackage.ENTITY3_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__JAVA3D_OBJECT = TypesPackage.ENTITY3_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__LENGTH = TypesPackage.ENTITY3_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__WIDTH = TypesPackage.ENTITY3_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__HEIGHT = TypesPackage.ENTITY3_D__HEIGHT;

	/**
	 * The feature id for the '<em><b>District</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE__DISTRICT = TypesPackage.ENTITY3_D_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Administration Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_BASE_FEATURE_COUNT = TypesPackage.ENTITY3_D_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link metaphor.entities.Status <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.entities.Status
	 * @see metaphor.entities.impl.EntitiesPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 12;


	/**
	 * Returns the meta object for class '{@link metaphor.entities.RegularBuilding <em>Regular Building</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Regular Building</em>'.
	 * @see metaphor.entities.RegularBuilding
	 * @generated
	 */
	EClass getRegularBuilding();

	/**
	 * Returns the meta object for the reference list '{@link metaphor.entities.RegularBuilding#getFloors <em>Floors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Floors</em>'.
	 * @see metaphor.entities.RegularBuilding#getFloors()
	 * @see #getRegularBuilding()
	 * @generated
	 */
	EReference getRegularBuilding_Floors();

	/**
	 * Returns the meta object for the reference list '{@link metaphor.entities.RegularBuilding#getCables <em>Cables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Cables</em>'.
	 * @see metaphor.entities.RegularBuilding#getCables()
	 * @see #getRegularBuilding()
	 * @generated
	 */
	EReference getRegularBuilding_Cables();

	/**
	 * Returns the meta object for the reference '{@link metaphor.entities.RegularBuilding#getDistrict <em>District</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>District</em>'.
	 * @see metaphor.entities.RegularBuilding#getDistrict()
	 * @see #getRegularBuilding()
	 * @generated
	 */
	EReference getRegularBuilding_District();

	/**
	 * Returns the meta object for class '{@link metaphor.entities.Street <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Street</em>'.
	 * @see metaphor.entities.Street
	 * @generated
	 */
	EClass getStreet();

	/**
	 * Returns the meta object for the reference '{@link metaphor.entities.Street#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see metaphor.entities.Street#getSource()
	 * @see #getStreet()
	 * @generated
	 */
	EReference getStreet_Source();

	/**
	 * Returns the meta object for the reference '{@link metaphor.entities.Street#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see metaphor.entities.Street#getTarget()
	 * @see #getStreet()
	 * @generated
	 */
	EReference getStreet_Target();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.entities.Street#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see metaphor.entities.Street#getStatus()
	 * @see #getStreet()
	 * @generated
	 */
	EAttribute getStreet_Status();

	/**
	 * Returns the meta object for class '{@link metaphor.entities.Floor <em>Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Floor</em>'.
	 * @see metaphor.entities.Floor
	 * @generated
	 */
	EClass getFloor();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.entities.Floor#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see metaphor.entities.Floor#getHeight()
	 * @see #getFloor()
	 * @generated
	 */
	EAttribute getFloor_Height();

	/**
	 * Returns the meta object for the reference list '{@link metaphor.entities.Floor#getStreets <em>Streets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Streets</em>'.
	 * @see metaphor.entities.Floor#getStreets()
	 * @see #getFloor()
	 * @generated
	 */
	EReference getFloor_Streets();

	/**
	 * Returns the meta object for class '{@link metaphor.entities.RegularFloor <em>Regular Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Regular Floor</em>'.
	 * @see metaphor.entities.RegularFloor
	 * @generated
	 */
	EClass getRegularFloor();

	/**
	 * Returns the meta object for the reference '{@link metaphor.entities.RegularFloor#getBuilding <em>Building</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Building</em>'.
	 * @see metaphor.entities.RegularFloor#getBuilding()
	 * @see #getRegularFloor()
	 * @generated
	 */
	EReference getRegularFloor_Building();

	/**
	 * Returns the meta object for class '{@link metaphor.entities.Cable <em>Cable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Cable</em>'.
	 * @see metaphor.entities.Cable
	 * @generated
	 */
	EClass getCable();

	/**
	 * Returns the meta object for the reference '{@link metaphor.entities.Cable#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see metaphor.entities.Cable#getSource()
	 * @see #getCable()
	 * @generated
	 */
	EReference getCable_Source();

	/**
	 * Returns the meta object for the reference '{@link metaphor.entities.Cable#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see metaphor.entities.Cable#getTarget()
	 * @see #getCable()
	 * @generated
	 */
	EReference getCable_Target();

	/**
	 * Returns the meta object for class '{@link metaphor.entities.RegularDistrict <em>Regular District</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Regular District</em>'.
	 * @see metaphor.entities.RegularDistrict
	 * @generated
	 */
	EClass getRegularDistrict();

	/**
	 * Returns the meta object for the reference list '{@link metaphor.entities.RegularDistrict#getChildDistricts <em>Child Districts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Child Districts</em>'.
	 * @see metaphor.entities.RegularDistrict#getChildDistricts()
	 * @see #getRegularDistrict()
	 * @generated
	 */
	EReference getRegularDistrict_ChildDistricts();

	/**
	 * Returns the meta object for the reference '{@link metaphor.entities.RegularDistrict#getParentDistrict <em>Parent District</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Parent District</em>'.
	 * @see metaphor.entities.RegularDistrict#getParentDistrict()
	 * @see #getRegularDistrict()
	 * @generated
	 */
	EReference getRegularDistrict_ParentDistrict();

	/**
	 * Returns the meta object for the reference list '{@link metaphor.entities.RegularDistrict#getBuildungs <em>Buildungs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Buildungs</em>'.
	 * @see metaphor.entities.RegularDistrict#getBuildungs()
	 * @see #getRegularDistrict()
	 * @generated
	 */
	EReference getRegularDistrict_Buildungs();

	/**
	 * Returns the meta object for class '{@link metaphor.entities.RegularBase <em>Regular Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Regular Base</em>'.
	 * @see metaphor.entities.RegularBase
	 * @generated
	 */
	EClass getRegularBase();

	/**
	 * Returns the meta object for the reference list '{@link metaphor.entities.RegularBase#getDistricts <em>Districts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Districts</em>'.
	 * @see metaphor.entities.RegularBase#getDistricts()
	 * @see #getRegularBase()
	 * @generated
	 */
	EReference getRegularBase_Districts();


	/**
	 * Returns the meta object for enum '{@link metaphor.entities.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see metaphor.entities.Status
	 * @generated
	 */
	EEnum getStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EntitiesFactory getEntitiesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link metaphor.entities.impl.RegularBuildingImpl <em>Regular Building</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.impl.RegularBuildingImpl
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularBuilding()
		 * @generated
		 */
		EClass REGULAR_BUILDING = eINSTANCE.getRegularBuilding();

		/**
		 * The meta object literal for the '<em><b>Floors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_BUILDING__FLOORS = eINSTANCE.getRegularBuilding_Floors();

		/**
		 * The meta object literal for the '<em><b>Cables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_BUILDING__CABLES = eINSTANCE.getRegularBuilding_Cables();

		/**
		 * The meta object literal for the '<em><b>District</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_BUILDING__DISTRICT = eINSTANCE.getRegularBuilding_District();

		/**
		 * The meta object literal for the '{@link metaphor.entities.impl.StreetImpl <em>Street</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.impl.StreetImpl
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getStreet()
		 * @generated
		 */
		EClass STREET = eINSTANCE.getStreet();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference STREET__SOURCE = eINSTANCE.getStreet_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference STREET__TARGET = eINSTANCE.getStreet_Target();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute STREET__STATUS = eINSTANCE.getStreet_Status();

		/**
		 * The meta object literal for the '{@link metaphor.entities.impl.FloorImpl <em>Floor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.impl.FloorImpl
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getFloor()
		 * @generated
		 */
		EClass FLOOR = eINSTANCE.getFloor();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FLOOR__HEIGHT = eINSTANCE.getFloor_Height();

		/**
		 * The meta object literal for the '<em><b>Streets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FLOOR__STREETS = eINSTANCE.getFloor_Streets();


		/**
		 * The meta object literal for the '{@link metaphor.entities.impl.RegularFloorImpl <em>Regular Floor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.impl.RegularFloorImpl
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularFloor()
		 * @generated
		 */
		EClass REGULAR_FLOOR = eINSTANCE.getRegularFloor();

		/**
		 * The meta object literal for the '<em><b>Building</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_FLOOR__BUILDING = eINSTANCE.getRegularFloor_Building();

		/**
		 * The meta object literal for the '{@link metaphor.entities.impl.CableImpl <em>Cable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.impl.CableImpl
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getCable()
		 * @generated
		 */
		EClass CABLE = eINSTANCE.getCable();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CABLE__SOURCE = eINSTANCE.getCable_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CABLE__TARGET = eINSTANCE.getCable_Target();

		/**
		 * The meta object literal for the '{@link metaphor.entities.impl.RegularDistrictImpl <em>Regular District</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.impl.RegularDistrictImpl
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularDistrict()
		 * @generated
		 */
		EClass REGULAR_DISTRICT = eINSTANCE.getRegularDistrict();

		/**
		 * The meta object literal for the '<em><b>Child Districts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_DISTRICT__CHILD_DISTRICTS = eINSTANCE.getRegularDistrict_ChildDistricts();

		/**
		 * The meta object literal for the '<em><b>Parent District</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_DISTRICT__PARENT_DISTRICT = eINSTANCE.getRegularDistrict_ParentDistrict();

		/**
		 * The meta object literal for the '<em><b>Buildungs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_DISTRICT__BUILDUNGS = eINSTANCE.getRegularDistrict_Buildungs();

		/**
		 * The meta object literal for the '{@link metaphor.entities.impl.RegularBaseImpl <em>Regular Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.impl.RegularBaseImpl
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getRegularBase()
		 * @generated
		 */
		EClass REGULAR_BASE = eINSTANCE.getRegularBase();

		/**
		 * The meta object literal for the '<em><b>Districts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference REGULAR_BASE__DISTRICTS = eINSTANCE.getRegularBase_Districts();

		/**
		 * The meta object literal for the '{@link metaphor.entities.Status <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.entities.Status
		 * @see metaphor.entities.impl.EntitiesPackageImpl#getStatus()
		 * @generated
		 */
		EEnum STATUS = eINSTANCE.getStatus();

	}

} // EntitiesPackage

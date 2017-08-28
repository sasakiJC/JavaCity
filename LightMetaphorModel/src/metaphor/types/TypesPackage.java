/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
 * @see metaphor.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://pdo-thesis-SS12.de/metaphor-metamodel/types";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "t";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	TypesPackage eINSTANCE = metaphor.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link metaphor.types.impl.VisualEntityImpl <em>Visual Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see metaphor.types.impl.VisualEntityImpl
	 * @see metaphor.types.impl.TypesPackageImpl#getVisualEntity()
	 * @generated
	 */
	int VISUAL_ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISUAL_ENTITY__ID = 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISUAL_ENTITY__COLOR = 1;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISUAL_ENTITY__POSITION = 2;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISUAL_ENTITY__DATA_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISUAL_ENTITY__JAVA3D_OBJECT = 4;

	/**
	 * The number of structural features of the '<em>Visual Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISUAL_ENTITY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link metaphor.types.impl.Entity2DImpl <em>Entity2 D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see metaphor.types.impl.Entity2DImpl
	 * @see metaphor.types.impl.TypesPackageImpl#getEntity2D()
	 * @generated
	 */
	int ENTITY2_D = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D__ID = VISUAL_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D__COLOR = VISUAL_ENTITY__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D__POSITION = VISUAL_ENTITY__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D__DATA_OBJECT = VISUAL_ENTITY__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D__JAVA3D_OBJECT = VISUAL_ENTITY__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D__LENGTH = VISUAL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D__WIDTH = VISUAL_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity2 D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY2_D_FEATURE_COUNT = VISUAL_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link metaphor.types.impl.Entity3DImpl <em>Entity3 D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see metaphor.types.impl.Entity3DImpl
	 * @see metaphor.types.impl.TypesPackageImpl#getEntity3D()
	 * @generated
	 */
	int ENTITY3_D = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__ID = ENTITY2_D__ID;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__COLOR = ENTITY2_D__COLOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__POSITION = ENTITY2_D__POSITION;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__DATA_OBJECT = ENTITY2_D__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__JAVA3D_OBJECT = ENTITY2_D__JAVA3D_OBJECT;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__LENGTH = ENTITY2_D__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__WIDTH = ENTITY2_D__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D__HEIGHT = ENTITY2_D_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity3 D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY3_D_FEATURE_COUNT = ENTITY2_D_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see java.awt.Color
	 * @see metaphor.types.impl.TypesPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 3;

	/**
	 * The meta object id for the '<em>Vector3 D</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see javax.vecmath.Vector3d
	 * @see metaphor.types.impl.TypesPackageImpl#getVector3D()
	 * @generated
	 */
	int VECTOR3_D = 5;

	/**
	 * The meta object id for the '<em>Node</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see javax.media.j3d.Node
	 * @see metaphor.types.impl.TypesPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 4;

	/**
	 * Returns the meta object for class '{@link metaphor.types.VisualEntity <em>Visual Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Visual Entity</em>'.
	 * @see metaphor.types.VisualEntity
	 * @generated
	 */
	EClass getVisualEntity();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.VisualEntity#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see metaphor.types.VisualEntity#getId()
	 * @see #getVisualEntity()
	 * @generated
	 */
	EAttribute getVisualEntity_Id();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.VisualEntity#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see metaphor.types.VisualEntity#getColor()
	 * @see #getVisualEntity()
	 * @generated
	 */
	EAttribute getVisualEntity_Color();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.VisualEntity#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see metaphor.types.VisualEntity#getPosition()
	 * @see #getVisualEntity()
	 * @generated
	 */
	EAttribute getVisualEntity_Position();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.VisualEntity#getDataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Data Object</em>'.
	 * @see metaphor.types.VisualEntity#getDataObject()
	 * @see #getVisualEntity()
	 * @generated
	 */
	EAttribute getVisualEntity_DataObject();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.VisualEntity#getJava3dObject <em>Java3d Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Java3d Object</em>'.
	 * @see metaphor.types.VisualEntity#getJava3dObject()
	 * @see #getVisualEntity()
	 * @generated
	 */
	EAttribute getVisualEntity_Java3dObject();

	/**
	 * Returns the meta object for class '{@link metaphor.types.Entity2D <em>Entity2 D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Entity2 D</em>'.
	 * @see metaphor.types.Entity2D
	 * @generated
	 */
	EClass getEntity2D();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.Entity2D#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see metaphor.types.Entity2D#getLength()
	 * @see #getEntity2D()
	 * @generated
	 */
	EAttribute getEntity2D_Length();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.Entity2D#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see metaphor.types.Entity2D#getWidth()
	 * @see #getEntity2D()
	 * @generated
	 */
	EAttribute getEntity2D_Width();

	/**
	 * Returns the meta object for class '{@link metaphor.types.Entity3D <em>Entity3 D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Entity3 D</em>'.
	 * @see metaphor.types.Entity3D
	 * @generated
	 */
	EClass getEntity3D();

	/**
	 * Returns the meta object for the attribute '{@link metaphor.types.Entity3D#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see metaphor.types.Entity3D#getHeight()
	 * @see #getEntity3D()
	 * @generated
	 */
	EAttribute getEntity3D_Height();

	/**
	 * Returns the meta object for data type '{@link java.awt.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Color</em>'.
	 * @see java.awt.Color
	 * @model instanceClass="java.awt.Color"
	 * @generated
	 */
	EDataType getColor();

	/**
	 * Returns the meta object for data type '{@link javax.vecmath.Vector3d <em>Vector3 D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Vector3 D</em>'.
	 * @see javax.vecmath.Vector3d
	 * @model instanceClass="javax.vecmath.Vector3d"
	 * @generated
	 */
	EDataType getVector3D();

	/**
	 * Returns the meta object for data type '{@link javax.media.j3d.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Node</em>'.
	 * @see javax.media.j3d.Node
	 * @model instanceClass="javax.media.j3d.Node"
	 * @generated
	 */
	EDataType getNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

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
		 * The meta object literal for the '{@link metaphor.types.impl.VisualEntityImpl <em>Visual Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see metaphor.types.impl.VisualEntityImpl
		 * @see metaphor.types.impl.TypesPackageImpl#getVisualEntity()
		 * @generated
		 */
		EClass VISUAL_ENTITY = eINSTANCE.getVisualEntity();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISUAL_ENTITY__ID = eINSTANCE.getVisualEntity_Id();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISUAL_ENTITY__COLOR = eINSTANCE.getVisualEntity_Color();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISUAL_ENTITY__POSITION = eINSTANCE.getVisualEntity_Position();

		/**
		 * The meta object literal for the '<em><b>Data Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISUAL_ENTITY__DATA_OBJECT = eINSTANCE.getVisualEntity_DataObject();

		/**
		 * The meta object literal for the '<em><b>Java3d Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISUAL_ENTITY__JAVA3D_OBJECT = eINSTANCE.getVisualEntity_Java3dObject();

		/**
		 * The meta object literal for the '{@link metaphor.types.impl.Entity2DImpl <em>Entity2 D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see metaphor.types.impl.Entity2DImpl
		 * @see metaphor.types.impl.TypesPackageImpl#getEntity2D()
		 * @generated
		 */
		EClass ENTITY2_D = eINSTANCE.getEntity2D();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTITY2_D__LENGTH = eINSTANCE.getEntity2D_Length();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTITY2_D__WIDTH = eINSTANCE.getEntity2D_Width();

		/**
		 * The meta object literal for the '{@link metaphor.types.impl.Entity3DImpl <em>Entity3 D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see metaphor.types.impl.Entity3DImpl
		 * @see metaphor.types.impl.TypesPackageImpl#getEntity3D()
		 * @generated
		 */
		EClass ENTITY3_D = eINSTANCE.getEntity3D();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTITY3_D__HEIGHT = eINSTANCE.getEntity3D_Height();

		/**
		 * The meta object literal for the '<em>Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see java.awt.Color
		 * @see metaphor.types.impl.TypesPackageImpl#getColor()
		 * @generated
		 */
		EDataType COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '<em>Vector3 D</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see javax.vecmath.Vector3d
		 * @see metaphor.types.impl.TypesPackageImpl#getVector3D()
		 * @generated
		 */
		EDataType VECTOR3_D = eINSTANCE.getVector3D();

		/**
		 * The meta object literal for the '<em>Node</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see javax.media.j3d.Node
		 * @see metaphor.types.impl.TypesPackageImpl#getNode()
		 * @generated
		 */
		EDataType NODE = eINSTANCE.getNode();

	}

} // TypesPackage

/**
 */
package data;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see data.DataFactory
 * @model kind="package"
 * @generated
 */
public interface DataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "data";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://pdo-masterthesis-ss12.de/dataModel/data";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "data";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataPackage eINSTANCE = data.impl.DataPackageImpl.init();

	/**
	 * The meta object id for the '{@link data.impl.VisualizableElementImpl <em>Visualizable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.impl.VisualizableElementImpl
	 * @see data.impl.DataPackageImpl#getVisualizableElement()
	 * @generated
	 */
	int VISUALIZABLE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Metaphor Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZABLE_ELEMENT__METAPHOR_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Visualizable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZABLE_ELEMENT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link data.VisualizableElement <em>Visualizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visualizable Element</em>'.
	 * @see data.VisualizableElement
	 * @generated
	 */
	EClass getVisualizableElement();

	/**
	 * Returns the meta object for the attribute '{@link data.VisualizableElement#getMetaphorObject <em>Metaphor Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metaphor Object</em>'.
	 * @see data.VisualizableElement#getMetaphorObject()
	 * @see #getVisualizableElement()
	 * @generated
	 */
	EAttribute getVisualizableElement_MetaphorObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataFactory getDataFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link data.impl.VisualizableElementImpl <em>Visualizable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.impl.VisualizableElementImpl
		 * @see data.impl.DataPackageImpl#getVisualizableElement()
		 * @generated
		 */
		EClass VISUALIZABLE_ELEMENT = eINSTANCE.getVisualizableElement();

		/**
		 * The meta object literal for the '<em><b>Metaphor Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISUALIZABLE_ELEMENT__METAPHOR_OBJECT = eINSTANCE.getVisualizableElement_MetaphorObject();

	}

} //DataPackage

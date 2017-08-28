/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see metaphor.MetaphorFactory
 * @model kind="package"
 * @generated
 */
public interface MetaphorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "metaphor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://pdo-thesis-SS12.de/metaphor-metamodel/metaphor-metamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "m";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	MetaphorPackage eINSTANCE = metaphor.impl.MetaphorPackageImpl.init();

	/**
	 * The meta object id for the '{@link metaphor.impl.CityImpl <em>City</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see metaphor.impl.CityImpl
	 * @see metaphor.impl.MetaphorPackageImpl#getCity()
	 * @generated
	 */
	int CITY = 0;

	/**
	 * The feature id for the '<em><b>Streets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CITY__STREETS = 0;

	/**
	 * The feature id for the '<em><b>Regular Coverage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CITY__REGULAR_COVERAGE = 1;

	/**
	 * The number of structural features of the '<em>City</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CITY_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link metaphor.City <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>City</em>'.
	 * @see metaphor.City
	 * @generated
	 */
	EClass getCity();

	/**
	 * Returns the meta object for the reference list '{@link metaphor.City#getStreets <em>Streets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Streets</em>'.
	 * @see metaphor.City#getStreets()
	 * @see #getCity()
	 * @generated
	 */
	EReference getCity_Streets();

	/**
	 * Returns the meta object for the reference '{@link metaphor.City#getRegularCoverage <em>Regular Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Regular Coverage</em>'.
	 * @see metaphor.City#getRegularCoverage()
	 * @see #getCity()
	 * @generated
	 */
	EReference getCity_RegularCoverage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetaphorFactory getMetaphorFactory();

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
		 * The meta object literal for the '{@link metaphor.impl.CityImpl <em>City</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see metaphor.impl.CityImpl
		 * @see metaphor.impl.MetaphorPackageImpl#getCity()
		 * @generated
		 */
		EClass CITY = eINSTANCE.getCity();

		/**
		 * The meta object literal for the '<em><b>Streets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CITY__STREETS = eINSTANCE.getCity_Streets();

		/**
		 * The meta object literal for the '<em><b>Regular Coverage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CITY__REGULAR_COVERAGE = eINSTANCE.getCity_RegularCoverage();

	}

} // MetaphorPackage

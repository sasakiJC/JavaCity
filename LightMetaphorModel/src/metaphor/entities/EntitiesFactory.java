/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see metaphor.entities.EntitiesPackage
 * @generated
 */
public interface EntitiesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	EntitiesFactory eINSTANCE = metaphor.entities.impl.EntitiesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Regular Building</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Regular Building</em>'.
	 * @generated
	 */
	RegularBuilding createRegularBuilding();

	/**
	 * Returns a new object of class '<em>Street</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Street</em>'.
	 * @generated
	 */
	Street createStreet();

	/**
	 * Returns a new object of class '<em>Regular Floor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Regular Floor</em>'.
	 * @generated
	 */
	RegularFloor createRegularFloor();

	/**
	 * Returns a new object of class '<em>Cable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Cable</em>'.
	 * @generated
	 */
	Cable createCable();

	/**
	 * Returns a new object of class '<em>Regular District</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Regular District</em>'.
	 * @generated
	 */
	RegularDistrict createRegularDistrict();

	/**
	 * Returns a new object of class '<em>Regular Base</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Regular Base</em>'.
	 * @generated
	 */
	RegularBase createRegularBase();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	EntitiesPackage getEntitiesPackage();

} // EntitiesFactory

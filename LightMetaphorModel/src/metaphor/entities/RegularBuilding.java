/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

import metaphor.types.Entity2D;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regular Building</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.entities.RegularBuilding#getFloors <em>Floors</em>}</li>
 * <li>{@link metaphor.entities.RegularBuilding#getCables <em>Cables</em>}</li>
 * <li>{@link metaphor.entities.RegularBuilding#getDistrict <em>District</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.entities.EntitiesPackage#getRegularBuilding()
 * @model
 * @generated
 */
public interface RegularBuilding extends Entity2D {
	/**
	 * Returns the value of the '<em><b>Floors</b></em>' reference list.
	 * The list contents are of type {@link metaphor.entities.RegularFloor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Floors</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Floors</em>' reference list.
	 * @see metaphor.entities.EntitiesPackage#getRegularBuilding_Floors()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<RegularFloor> getFloors();

	/**
	 * Returns the value of the '<em><b>Cables</b></em>' reference list.
	 * The list contents are of type {@link metaphor.entities.Cable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cables</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cables</em>' reference list.
	 * @see metaphor.entities.EntitiesPackage#getRegularBuilding_Cables()
	 * @model required="true"
	 * @generated
	 */
	EList<Cable> getCables();

	/**
	 * Returns the value of the '<em><b>District</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>District</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>District</em>' reference.
	 * @see #setDistrict(RegularDistrict)
	 * @see metaphor.entities.EntitiesPackage#getRegularBuilding_District()
	 * @model required="true"
	 * @generated
	 */
	RegularDistrict getDistrict();

	/**
	 * Sets the value of the '{@link metaphor.entities.RegularBuilding#getDistrict <em>District</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>District</em>' reference.
	 * @see #getDistrict()
	 * @generated
	 */
	void setDistrict(RegularDistrict value);

} // RegularBuilding

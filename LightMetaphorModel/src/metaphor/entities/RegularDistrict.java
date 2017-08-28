/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

import metaphor.types.Entity3D;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regular District</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.entities.RegularDistrict#getChildDistricts <em>Child Districts</em>}</li>
 * <li>{@link metaphor.entities.RegularDistrict#getParentDistrict <em>Parent District</em>}</li>
 * <li>{@link metaphor.entities.RegularDistrict#getBuildungs <em>Buildungs</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.entities.EntitiesPackage#getRegularDistrict()
 * @model
 * @generated
 */
public interface RegularDistrict extends Entity3D {
	/**
	 * Returns the value of the '<em><b>Child Districts</b></em>' reference list.
	 * The list contents are of type {@link metaphor.entities.RegularDistrict}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Districts</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Child Districts</em>' reference list.
	 * @see metaphor.entities.EntitiesPackage#getRegularDistrict_ChildDistricts()
	 * @model
	 * @generated
	 */
	EList<RegularDistrict> getChildDistricts();

	/**
	 * Returns the value of the '<em><b>Parent District</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent District</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent District</em>' reference.
	 * @see #setParentDistrict(RegularDistrict)
	 * @see metaphor.entities.EntitiesPackage#getRegularDistrict_ParentDistrict()
	 * @model
	 * @generated
	 */
	RegularDistrict getParentDistrict();

	/**
	 * Sets the value of the '{@link metaphor.entities.RegularDistrict#getParentDistrict <em>Parent District</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parent District</em>' reference.
	 * @see #getParentDistrict()
	 * @generated
	 */
	void setParentDistrict(RegularDistrict value);

	/**
	 * Returns the value of the '<em><b>Buildungs</b></em>' reference list.
	 * The list contents are of type {@link metaphor.entities.RegularBuilding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buildungs</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Buildungs</em>' reference list.
	 * @see metaphor.entities.EntitiesPackage#getRegularDistrict_Buildungs()
	 * @model
	 * @generated
	 */
	EList<RegularBuilding> getBuildungs();

} // RegularDistrict

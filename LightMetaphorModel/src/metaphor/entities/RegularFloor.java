/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regular Floor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.entities.RegularFloor#getBuilding <em>Building</em>}</li>
 * </ul>
 * </p>
 *
 * @see metaphor.entities.EntitiesPackage#getRegularFloor()
 * @model
 * @generated
 */
public interface RegularFloor extends Floor {
	/**
	 * Returns the value of the '<em><b>Building</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Building</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Building</em>' reference.
	 * @see #setBuilding(RegularBuilding)
	 * @see metaphor.entities.EntitiesPackage#getRegularFloor_Building()
	 * @model required="true"
	 * @generated
	 */
	RegularBuilding getBuilding();

	int getClassId();
	/**
	 * Sets the value of the '{@link metaphor.entities.RegularFloor#getBuilding <em>Building</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Building</em>' reference.
	 * @see #getBuilding()
	 * @generated
	 */
	void setBuilding(RegularBuilding value);

	void setClassId(int value);

} // RegularFloor

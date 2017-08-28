/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

import metaphor.types.VisualEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cable</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.entities.Cable#getSource <em>Source</em>}</li>
 * <li>{@link metaphor.entities.Cable#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.entities.EntitiesPackage#getCable()
 * @model
 * @generated
 */
public interface Cable extends VisualEntity {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(RegularBuilding)
	 * @see metaphor.entities.EntitiesPackage#getCable_Source()
	 * @model required="true"
	 * @generated
	 */
	RegularBuilding getSource();

	/**
	 * Sets the value of the '{@link metaphor.entities.Cable#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(RegularBuilding value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(RegularBuilding)
	 * @see metaphor.entities.EntitiesPackage#getCable_Target()
	 * @model required="true"
	 * @generated
	 */
	RegularBuilding getTarget();

	/**
	 * Sets the value of the '{@link metaphor.entities.Cable#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(RegularBuilding value);

} // Cable

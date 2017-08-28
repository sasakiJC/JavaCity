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
 * A representation of the model object '<em><b>Street</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.entities.Street#getSource <em>Source</em>}</li>
 * <li>{@link metaphor.entities.Street#getTarget <em>Target</em>}</li>
 * <li>{@link metaphor.entities.Street#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.entities.EntitiesPackage#getStreet()
 * @model
 * @generated
 */
public interface Street extends VisualEntity {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Floor)
	 * @see metaphor.entities.EntitiesPackage#getStreet_Source()
	 * @model required="true"
	 * @generated
	 */
	Floor getSource();

	/**
	 * Sets the value of the '{@link metaphor.entities.Street#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Floor value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Floor)
	 * @see metaphor.entities.EntitiesPackage#getStreet_Target()
	 * @model required="true"
	 * @generated
	 */
	Floor getTarget();

	/**
	 * Sets the value of the '{@link metaphor.entities.Street#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Floor value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link metaphor.entities.Status}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see metaphor.entities.Status
	 * @see #setStatus(Status)
	 * @see metaphor.entities.EntitiesPackage#getStreet_Status()
	 * @model required="true"
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link metaphor.entities.Street#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Status</em>' attribute.
	 * @see metaphor.entities.Status
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

} // Street

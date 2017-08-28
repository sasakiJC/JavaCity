/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

import metaphor.types.VisualEntity;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Floor</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.entities.Floor#getHeight <em>Height</em>}</li>
 * <li>{@link metaphor.entities.Floor#getStreets <em>Streets</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.entities.EntitiesPackage#getFloor()
 * @model abstract="true"
 * @generated
 */
public interface Floor extends VisualEntity {

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(float)
	 * @see metaphor.entities.EntitiesPackage#getFloor_Height()
	 * @model required="true"
	 * @generated
	 */
	float getHeight();

	/**
	 * Sets the value of the '{@link metaphor.entities.Floor#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(float value);

	/**
	 * Returns the value of the '<em><b>Streets</b></em>' reference list.
	 * The list contents are of type {@link metaphor.entities.Street}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streets</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Streets</em>' reference list.
	 * @see metaphor.entities.EntitiesPackage#getFloor_Streets()
	 * @model
	 * @generated
	 */
	EList<Street> getStreets();
} // Floor

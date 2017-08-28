/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity3 D</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.types.Entity3D#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.types.TypesPackage#getEntity3D()
 * @model abstract="true"
 * @generated
 */
public interface Entity3D extends Entity2D {
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
	 * @see metaphor.types.TypesPackage#getEntity3D_Height()
	 * @model
	 * @generated
	 */
	float getHeight();

	/**
	 * Sets the value of the '{@link metaphor.types.Entity3D#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(float value);

} // Entity3D

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity2 D</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.types.Entity2D#getLength <em>Length</em>}</li>
 * <li>{@link metaphor.types.Entity2D#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.types.TypesPackage#getEntity2D()
 * @model abstract="true"
 * @generated
 */
public interface Entity2D extends VisualEntity {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(float)
	 * @see metaphor.types.TypesPackage#getEntity2D_Length()
	 * @model
	 * @generated
	 */
	float getLength();

	/**
	 * Sets the value of the '{@link metaphor.types.Entity2D#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(float value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(float)
	 * @see metaphor.types.TypesPackage#getEntity2D_Width()
	 * @model
	 * @generated
	 */
	float getWidth();

	/**
	 * Sets the value of the '{@link metaphor.types.Entity2D#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(float value);

} // Entity2D

/**
 */
package data;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visualizable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.VisualizableElement#getMetaphorObject <em>Metaphor Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.DataPackage#getVisualizableElement()
 * @model abstract="true"
 * @generated
 */
public interface VisualizableElement extends EObject, Serializable {
	/**
	 * Returns the value of the '<em><b>Metaphor Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaphor Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaphor Object</em>' attribute.
	 * @see #setMetaphorObject(Object)
	 * @see data.DataPackage#getVisualizableElement_MetaphorObject()
	 * @model
	 * @generated
	 */
	Object getMetaphorObject();

	/**
	 * Sets the value of the '{@link data.VisualizableElement#getMetaphorObject <em>Metaphor Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metaphor Object</em>' attribute.
	 * @see #getMetaphorObject()
	 * @generated
	 */
	void setMetaphorObject(Object value);

} // VisualizableElement

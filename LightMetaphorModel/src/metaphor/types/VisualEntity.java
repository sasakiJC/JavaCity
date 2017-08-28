/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

/*************************
 * java3Dからjavafxへ
 */

package metaphor.types;

import org.eclipse.emf.ecore.EObject;

import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.paint.Color;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visual Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.types.VisualEntity#getId <em>Id</em>}</li>
 * <li>{@link metaphor.types.VisualEntity#getColor <em>Color</em>}</li>
 * <li>{@link metaphor.types.VisualEntity#getPosition <em>Position</em>}</li>
 * <li>{@link metaphor.types.VisualEntity#getDataObject <em>Data Object</em>}</li>
 * <li>{@link metaphor.types.VisualEntity#getJava3dObject <em>Java3d Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see metaphor.types.TypesPackage#getVisualEntity()
 * @model abstract="true"
 * @generated
 */
public interface VisualEntity extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see metaphor.types.TypesPackage#getVisualEntity_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link metaphor.types.VisualEntity#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(Color)
	 * @see metaphor.types.TypesPackage#getVisualEntity_Color()
	 * @model dataType="metaphor.types.Color"
	 * @generated
	 */
	Color getColor();

	/**
	 * Sets the value of the '{@link metaphor.types.VisualEntity#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(Color value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(Vector3d)
	 * @see metaphor.types.TypesPackage#getVisualEntity_Position()
	 * @model dataType="metaphor.types.Vector3D"
	 * @generated
	 */
	Point3D getPosition();

	/**
	 * Sets the value of the '{@link metaphor.types.VisualEntity#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Point3D value);

	/**
	 * Returns the value of the '<em><b>Data Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Object</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Data Object</em>' attribute.
	 * @see #setDataObject(Object)
	 * @see metaphor.types.TypesPackage#getVisualEntity_DataObject()
	 * @model
	 * @generated
	 */
	Object getDataObject();

	/**
	 * Sets the value of the '{@link metaphor.types.VisualEntity#getDataObject <em>Data Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Data Object</em>' attribute.
	 * @see #getDataObject()
	 * @generated
	 */
	void setDataObject(Object value);

	/**
	 * Returns the value of the '<em><b>Java3d Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java3d Object</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Java3d Object</em>' attribute.
	 * @see #setJava3dObject(Node)
	 * @see metaphor.types.TypesPackage#getVisualEntity_Java3dObject()
	 * @model dataType="metaphor.types.Node"
	 * @generated
	 */
	Node getJava3dObject();

	/**
	 * Sets the value of the '{@link metaphor.types.VisualEntity#getJava3dObject <em>Java3d Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Java3d Object</em>' attribute.
	 * @see #getJava3dObject()
	 * @generated
	 */
	void setJava3dObject(Node value);

} // VisualEntity

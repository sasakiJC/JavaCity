/**
 */
package data.statics;

import data.VisualizableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.statics.CodeElement#getName <em>Name</em>}</li>
 *   <li>{@link data.statics.CodeElement#getKdmSignature <em>Kdm Signature</em>}</li>
 *   <li>{@link data.statics.CodeElement#getKdmId <em>Kdm Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.statics.StaticsPackage#getCodeElement()
 * @model abstract="true"
 * @generated
 */
public interface CodeElement extends VisualizableElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see data.statics.StaticsPackage#getCodeElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link data.statics.CodeElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kdm Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kdm Signature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kdm Signature</em>' attribute.
	 * @see #setKdmSignature(String)
	 * @see data.statics.StaticsPackage#getCodeElement_KdmSignature()
	 * @model required="true"
	 * @generated
	 */
	String getKdmSignature();

	/**
	 * Sets the value of the '{@link data.statics.CodeElement#getKdmSignature <em>Kdm Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kdm Signature</em>' attribute.
	 * @see #getKdmSignature()
	 * @generated
	 */
	void setKdmSignature(String value);

	/**
	 * Returns the value of the '<em><b>Kdm Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kdm Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kdm Id</em>' attribute.
	 * @see #setKdmId(String)
	 * @see data.statics.StaticsPackage#getCodeElement_KdmId()
	 * @model required="true"
	 * @generated
	 */
	String getKdmId();

	/**
	 * Sets the value of the '{@link data.statics.CodeElement#getKdmId <em>Kdm Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kdm Id</em>' attribute.
	 * @see #getKdmId()
	 * @generated
	 */
	void setKdmId(String value);

} // CodeElement

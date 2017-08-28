/**
 */
package data.statics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SMethod</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.statics.SMethod#getSClass <em>SClass</em>}</li>
 *   <li>{@link data.statics.SMethod#getSimpleSignature <em>Simple Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.statics.StaticsPackage#getSMethod()
 * @model
 * @generated
 */
public interface SMethod extends CodeElement {
	/**
	 * Returns the value of the '<em><b>SClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SClass</em>' reference.
	 * @see #setSClass(SClass)
	 * @see data.statics.StaticsPackage#getSMethod_SClass()
	 * @model required="true"
	 * @generated
	 */
	SClass getSClass();

	/**
	 * Sets the value of the '{@link data.statics.SMethod#getSClass <em>SClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SClass</em>' reference.
	 * @see #getSClass()
	 * @generated
	 */
	void setSClass(SClass value);

	/**
	 * Returns the value of the '<em><b>Simple Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Signature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Signature</em>' attribute.
	 * @see #setSimpleSignature(String)
	 * @see data.statics.StaticsPackage#getSMethod_SimpleSignature()
	 * @model
	 * @generated
	 */
	String getSimpleSignature();

	/**
	 * Sets the value of the '{@link data.statics.SMethod#getSimpleSignature <em>Simple Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Signature</em>' attribute.
	 * @see #getSimpleSignature()
	 * @generated
	 */
	void setSimpleSignature(String value);

} // SMethod

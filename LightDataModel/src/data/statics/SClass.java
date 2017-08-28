/**
 */
package data.statics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.statics.SClass#getRelations <em>Relations</em>}</li>
 *   <li>{@link data.statics.SClass#getSPackage <em>SPackage</em>}</li>
 *   <li>{@link data.statics.SClass#getSMethods <em>SMethods</em>}</li>
 *   <li>{@link data.statics.SClass#getInstances <em>Instances</em>}</li>
 *   <li>{@link data.statics.SClass#getNumAttributes <em>Num Attributes</em>}</li>
 *   <li>{@link data.statics.SClass#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.statics.StaticsPackage#getSClass()
 * @model
 * @generated
 */
public interface SClass extends CodeElement {
	/**
	 * Returns the value of the '<em><b>Relations</b></em>' reference list.
	 * The list contents are of type {@link data.statics.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' reference list.
	 * @see data.statics.StaticsPackage#getSClass_Relations()
	 * @model
	 * @generated
	 */
	EList<Relation> getRelations();

	/**
	 * Returns the value of the '<em><b>SPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPackage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPackage</em>' reference.
	 * @see #setSPackage(SPackage)
	 * @see data.statics.StaticsPackage#getSClass_SPackage()
	 * @model required="true"
	 * @generated
	 */
	SPackage getSPackage();

	/**
	 * Sets the value of the '{@link data.statics.SClass#getSPackage <em>SPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SPackage</em>' reference.
	 * @see #getSPackage()
	 * @generated
	 */
	void setSPackage(SPackage value);

	/**
	 * Returns the value of the '<em><b>SMethods</b></em>' reference list.
	 * The list contents are of type {@link data.statics.SMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SMethods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SMethods</em>' reference list.
	 * @see data.statics.StaticsPackage#getSClass_SMethods()
	 * @model
	 * @generated
	 */
	EList<SMethod> getSMethods();


	/**
	 * Returns the value of the '<em><b>Num Attributes</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Attributes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Attributes</em>' attribute.
	 * @see #setNumAttributes(int)
	 * @see data.statics.StaticsPackage#getSClass_NumAttributes()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getNumAttributes();

	/**
	 * Sets the value of the '{@link data.statics.SClass#getNumAttributes <em>Num Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Attributes</em>' attribute.
	 * @see #getNumAttributes()
	 * @generated
	 */
	void setNumAttributes(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link data.statics.ClassType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see data.statics.ClassType
	 * @see #setType(ClassType)
	 * @see data.statics.StaticsPackage#getSClass_Type()
	 * @model default="" required="true"
	 * @generated
	 */
	ClassType getType();

	/**
	 * Sets the value of the '{@link data.statics.SClass#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see data.statics.ClassType
	 * @see #getType()
	 * @generated
	 */
	void setType(ClassType value);

} // SClass

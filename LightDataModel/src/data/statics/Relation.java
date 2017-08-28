/**
 */
package data.statics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.statics.Relation#getType <em>Type</em>}</li>
 *   <li>{@link data.statics.Relation#getSource <em>Source</em>}</li>
 *   <li>{@link data.statics.Relation#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.statics.StaticsPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends CodeElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link data.statics.RelationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see data.statics.RelationType
	 * @see #setType(RelationType)
	 * @see data.statics.StaticsPackage#getRelation_Type()
	 * @model required="true"
	 * @generated
	 */
	RelationType getType();

	/**
	 * Sets the value of the '{@link data.statics.Relation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see data.statics.RelationType
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationType value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SClass)
	 * @see data.statics.StaticsPackage#getRelation_Source()
	 * @model required="true"
	 * @generated
	 */
	SClass getSource();

	/**
	 * Sets the value of the '{@link data.statics.Relation#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SClass value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SClass)
	 * @see data.statics.StaticsPackage#getRelation_Target()
	 * @model required="true"
	 * @generated
	 */
	SClass getTarget();

	/**
	 * Sets the value of the '{@link data.statics.Relation#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SClass value);

} // Relation

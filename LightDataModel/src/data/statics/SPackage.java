/**
 */
package data.statics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.statics.SPackage#getLevel <em>Level</em>}</li>
 *   <li>{@link data.statics.SPackage#getSubPackages <em>Sub Packages</em>}</li>
 *   <li>{@link data.statics.SPackage#getSuperPackage <em>Super Package</em>}</li>
 *   <li>{@link data.statics.SPackage#getSClasses <em>SClasses</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.statics.StaticsPackage#getSPackage()
 * @model
 * @generated
 */
public interface SPackage extends CodeElement {
	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(int)
	 * @see data.statics.StaticsPackage#getSPackage_Level()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link data.statics.SPackage#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Returns the value of the '<em><b>Sub Packages</b></em>' reference list.
	 * The list contents are of type {@link data.statics.SPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Packages</em>' reference list.
	 * @see data.statics.StaticsPackage#getSPackage_SubPackages()
	 * @model
	 * @generated
	 */
	EList<SPackage> getSubPackages();

	/**
	 * Returns the value of the '<em><b>Super Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Package</em>' reference.
	 * @see #setSuperPackage(SPackage)
	 * @see data.statics.StaticsPackage#getSPackage_SuperPackage()
	 * @model
	 * @generated
	 */
	SPackage getSuperPackage();

	/**
	 * Sets the value of the '{@link data.statics.SPackage#getSuperPackage <em>Super Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Package</em>' reference.
	 * @see #getSuperPackage()
	 * @generated
	 */
	void setSuperPackage(SPackage value);

	/**
	 * Returns the value of the '<em><b>SClasses</b></em>' reference list.
	 * The list contents are of type {@link data.statics.SClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SClasses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SClasses</em>' reference list.
	 * @see data.statics.StaticsPackage#getSPackage_SClasses()
	 * @model
	 * @generated
	 */
	EList<SClass> getSClasses();

} // SPackage

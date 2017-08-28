/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import metaphor.entities.RegularBase;
import metaphor.entities.Street;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>City</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.City#getStreets <em>Streets</em>}</li>
 * <li>{@link metaphor.City#getAdministrationCoverage <em>Administration Coverage</em>}</li>
 * <li>{@link metaphor.City#getRegularCoverage <em>Regular Coverage</em>}</li>
 * </ul>
 * </p>
 *
 * @see metaphor.MetaphorPackage#getCity()
 * @model
 * @generated
 */
public interface City extends EObject {
	/**
	 * Returns the value of the '<em><b>Streets</b></em>' reference list.
	 * The list contents are of type {@link metaphor.entities.Street}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Streets</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Streets</em>' reference list.
	 * @see metaphor.MetaphorPackage#getCity_Streets()
	 * @model
	 * @generated
	 */
	EList<Street> getStreets();

	/**
	 * Returns the value of the '<em><b>Regular Coverage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regular Coverage</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Regular Coverage</em>' reference.
	 * @see #setRegularCoverage(RegularBase)
	 * @see metaphor.MetaphorPackage#getCity_RegularCoverage()
	 * @model required="true"
	 * @generated
	 */
	RegularBase getRegularCoverage();

	/**
	 * Sets the value of the '{@link metaphor.City#getRegularCoverage <em>Regular Coverage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Regular Coverage</em>' reference.
	 * @see #getRegularCoverage()
	 * @generated
	 */
	void setRegularCoverage(RegularBase value);

} // City

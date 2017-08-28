/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities;

import metaphor.types.Entity3D;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regular Base</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link metaphor.entities.RegularBase#getDistricts <em>Districts</em>}</li>
 * </ul>
 * </p>
 * 
 * @see metaphor.entities.EntitiesPackage#getRegularBase()
 * @model
 * @generated
 */
public interface RegularBase extends Entity3D {
	/**
	 * Returns the value of the '<em><b>Districts</b></em>' reference list.
	 * The list contents are of type {@link metaphor.entities.RegularDistrict}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Districts</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Districts</em>' reference list.
	 * @see metaphor.entities.EntitiesPackage#getRegularBase_Districts()
	 * @model required="true"
	 * @generated
	 */
	EList<RegularDistrict> getDistricts();

} // RegularBase

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.impl;

import java.util.Collection;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.Floor;

import metaphor.entities.Street;
import metaphor.types.impl.VisualEntityImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Floor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link metaphor.entities.impl.FloorImpl#getHeight <em>Height</em>}</li>
 * <li>{@link metaphor.entities.impl.FloorImpl#getStreets <em>Streets</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class FloorImpl extends VisualEntityImpl implements Floor {
	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final float HEIGHT_EDEFAULT = 0.0F;
	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected float height = HEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStreets() <em>Streets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStreets()
	 * @generated
	 * @ordered
	 */
	protected EList<Street> streets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FloorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntitiesPackage.Literals.FLOOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHeight(float newHeight) {
		float oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.FLOOR__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Street> getStreets() {
		if (streets == null) {
			streets = new EObjectResolvingEList<Street>(Street.class, this, EntitiesPackage.FLOOR__STREETS);
		}
		return streets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EntitiesPackage.FLOOR__HEIGHT:
			return getHeight();
		case EntitiesPackage.FLOOR__STREETS:
			return getStreets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EntitiesPackage.FLOOR__HEIGHT:
			setHeight((Float) newValue);
			return;
		case EntitiesPackage.FLOOR__STREETS:
			getStreets().clear();
			getStreets().addAll((Collection<? extends Street>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case EntitiesPackage.FLOOR__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
			return;
		case EntitiesPackage.FLOOR__STREETS:
			getStreets().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case EntitiesPackage.FLOOR__HEIGHT:
			return height != HEIGHT_EDEFAULT;
		case EntitiesPackage.FLOOR__STREETS:
			return streets != null && !streets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} // FloorImpl

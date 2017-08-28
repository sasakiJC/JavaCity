/**
 */
package data.impl;

import data.DataPackage;
import data.VisualizableElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visualizable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.impl.VisualizableElementImpl#getMetaphorObject <em>Metaphor Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VisualizableElementImpl extends EObjectImpl implements VisualizableElement {
	
	/**
	 * The default {@code serialVersionUID} for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The default value of the '{@link #getMetaphorObject() <em>Metaphor Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaphorObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object METAPHOR_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaphorObject() <em>Metaphor Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaphorObject()
	 * @generated
	 * @ordered
	 */
	protected Object metaphorObject = METAPHOR_OBJECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualizableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.VISUALIZABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMetaphorObject() {
		return metaphorObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaphorObject(Object newMetaphorObject) {
		Object oldMetaphorObject = metaphorObject;
		metaphorObject = newMetaphorObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VISUALIZABLE_ELEMENT__METAPHOR_OBJECT, oldMetaphorObject, metaphorObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.VISUALIZABLE_ELEMENT__METAPHOR_OBJECT:
				return getMetaphorObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.VISUALIZABLE_ELEMENT__METAPHOR_OBJECT:
				setMetaphorObject(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataPackage.VISUALIZABLE_ELEMENT__METAPHOR_OBJECT:
				setMetaphorObject(METAPHOR_OBJECT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataPackage.VISUALIZABLE_ELEMENT__METAPHOR_OBJECT:
				return METAPHOR_OBJECT_EDEFAULT == null ? metaphorObject != null : !METAPHOR_OBJECT_EDEFAULT.equals(metaphorObject);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (metaphorObject: ");
		result.append(metaphorObject);
		result.append(')');
		return result.toString();
	}

} //VisualizableElementImpl

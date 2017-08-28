/**
 */
package data.statics.impl;

import data.statics.SClass;
import data.statics.SMethod;
import data.statics.StaticsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SMethod</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.statics.impl.SMethodImpl#getSClass <em>SClass</em>}</li>
 *   <li>{@link data.statics.impl.SMethodImpl#getSimpleSignature <em>Simple Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SMethodImpl extends CodeElementImpl implements SMethod {
	
	/**
	 * The default {@code serialVersionUID} for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The cached value of the '{@link #getSClass() <em>SClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSClass()
	 * @generated
	 * @ordered
	 */
	protected SClass sClass;

	/**
	 * The default value of the '{@link #getSimpleSignature() <em>Simple Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_SIGNATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleSignature() <em>Simple Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleSignature()
	 * @generated
	 * @ordered
	 */
	protected String simpleSignature = SIMPLE_SIGNATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticsPackage.Literals.SMETHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SClass getSClass() {
		if (sClass != null && sClass.eIsProxy()) {
			InternalEObject oldSClass = (InternalEObject)sClass;
			sClass = (SClass)eResolveProxy(oldSClass);
			if (sClass != oldSClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StaticsPackage.SMETHOD__SCLASS, oldSClass, sClass));
			}
		}
		return sClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SClass basicGetSClass() {
		return sClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSClass(SClass newSClass) {
		SClass oldSClass = sClass;
		sClass = newSClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.SMETHOD__SCLASS, oldSClass, sClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleSignature() {
		return simpleSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleSignature(String newSimpleSignature) {
		String oldSimpleSignature = simpleSignature;
		simpleSignature = newSimpleSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.SMETHOD__SIMPLE_SIGNATURE, oldSimpleSignature, simpleSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StaticsPackage.SMETHOD__SCLASS:
				if (resolve) return getSClass();
				return basicGetSClass();
			case StaticsPackage.SMETHOD__SIMPLE_SIGNATURE:
				return getSimpleSignature();
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
			case StaticsPackage.SMETHOD__SCLASS:
				setSClass((SClass)newValue);
				return;
			case StaticsPackage.SMETHOD__SIMPLE_SIGNATURE:
				setSimpleSignature((String)newValue);
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
			case StaticsPackage.SMETHOD__SCLASS:
				setSClass((SClass)null);
				return;
			case StaticsPackage.SMETHOD__SIMPLE_SIGNATURE:
				setSimpleSignature(SIMPLE_SIGNATURE_EDEFAULT);
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
			case StaticsPackage.SMETHOD__SCLASS:
				return sClass != null;
			case StaticsPackage.SMETHOD__SIMPLE_SIGNATURE:
				return SIMPLE_SIGNATURE_EDEFAULT == null ? simpleSignature != null : !SIMPLE_SIGNATURE_EDEFAULT.equals(simpleSignature);
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
		result.append(" (simpleSignature: ");
		result.append(simpleSignature);
		result.append(')');
		return result.toString();
	}

} //SMethodImpl

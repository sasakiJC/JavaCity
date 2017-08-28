/**
 */
package data.statics.impl;

import data.impl.VisualizableElementImpl;

import data.statics.CodeElement;
import data.statics.StaticsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.statics.impl.CodeElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link data.statics.impl.CodeElementImpl#getKdmSignature <em>Kdm Signature</em>}</li>
 *   <li>{@link data.statics.impl.CodeElementImpl#getKdmId <em>Kdm Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CodeElementImpl extends VisualizableElementImpl implements CodeElement {
	
	/**
	 * The default {@code serialVersionUID} for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKdmSignature() <em>Kdm Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKdmSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String KDM_SIGNATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKdmSignature() <em>Kdm Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKdmSignature()
	 * @generated
	 * @ordered
	 */
	protected String kdmSignature = KDM_SIGNATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getKdmId() <em>Kdm Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKdmId()
	 * @generated
	 * @ordered
	 */
	protected static final String KDM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKdmId() <em>Kdm Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKdmId()
	 * @generated
	 * @ordered
	 */
	protected String kdmId = KDM_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticsPackage.Literals.CODE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.CODE_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKdmSignature() {
		return kdmSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKdmSignature(String newKdmSignature) {
		String oldKdmSignature = kdmSignature;
		kdmSignature = newKdmSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.CODE_ELEMENT__KDM_SIGNATURE, oldKdmSignature, kdmSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKdmId() {
		return kdmId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKdmId(String newKdmId) {
		String oldKdmId = kdmId;
		kdmId = newKdmId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.CODE_ELEMENT__KDM_ID, oldKdmId, kdmId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StaticsPackage.CODE_ELEMENT__NAME:
				return getName();
			case StaticsPackage.CODE_ELEMENT__KDM_SIGNATURE:
				return getKdmSignature();
			case StaticsPackage.CODE_ELEMENT__KDM_ID:
				return getKdmId();
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
			case StaticsPackage.CODE_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case StaticsPackage.CODE_ELEMENT__KDM_SIGNATURE:
				setKdmSignature((String)newValue);
				return;
			case StaticsPackage.CODE_ELEMENT__KDM_ID:
				setKdmId((String)newValue);
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
			case StaticsPackage.CODE_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StaticsPackage.CODE_ELEMENT__KDM_SIGNATURE:
				setKdmSignature(KDM_SIGNATURE_EDEFAULT);
				return;
			case StaticsPackage.CODE_ELEMENT__KDM_ID:
				setKdmId(KDM_ID_EDEFAULT);
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
			case StaticsPackage.CODE_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StaticsPackage.CODE_ELEMENT__KDM_SIGNATURE:
				return KDM_SIGNATURE_EDEFAULT == null ? kdmSignature != null : !KDM_SIGNATURE_EDEFAULT.equals(kdmSignature);
			case StaticsPackage.CODE_ELEMENT__KDM_ID:
				return KDM_ID_EDEFAULT == null ? kdmId != null : !KDM_ID_EDEFAULT.equals(kdmId);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", kdmSignature: ");
		result.append(kdmSignature);
		result.append(", kdmId: ");
		result.append(kdmId);
		result.append(')');
		return result.toString();
	}

} //CodeElementImpl

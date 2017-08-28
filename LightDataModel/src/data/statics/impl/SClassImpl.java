/**
 */
package data.statics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import data.statics.ClassType;
import data.statics.Relation;
import data.statics.SClass;
import data.statics.SMethod;
import data.statics.SPackage;
import data.statics.StaticsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.statics.impl.SClassImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link data.statics.impl.SClassImpl#getSPackage <em>SPackage</em>}</li>
 *   <li>{@link data.statics.impl.SClassImpl#getSMethods <em>SMethods</em>}</li>
 *   <li>{@link data.statics.impl.SClassImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link data.statics.impl.SClassImpl#getNumAttributes <em>Num Attributes</em>}</li>
 *   <li>{@link data.statics.impl.SClassImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SClassImpl extends CodeElementImpl implements SClass {

	/**
	 * The default {@code serialVersionUID} for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> relations;

	/**
	 * The cached value of the '{@link #getSPackage() <em>SPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPackage()
	 * @generated
	 * @ordered
	 */
	protected SPackage sPackage;

	/**
	 * The cached value of the '{@link #getSMethods() <em>SMethods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<SMethod> sMethods;

	/**
	 * The default value of the '{@link #getNumAttributes() <em>Num Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumAttributes()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_ATTRIBUTES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumAttributes() <em>Num Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumAttributes()
	 * @generated
	 * @ordered
	 */
	protected int numAttributes = NUM_ATTRIBUTES_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ClassType TYPE_EDEFAULT = ClassType.REGULAR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ClassType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticsPackage.Literals.SCLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getRelations() {
		if (relations == null) {
			relations = new EObjectResolvingEList<Relation>(Relation.class, this, StaticsPackage.SCLASS__RELATIONS);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPackage getSPackage() {
		if (sPackage != null && sPackage.eIsProxy()) {
			InternalEObject oldSPackage = (InternalEObject)sPackage;
			sPackage = (SPackage)eResolveProxy(oldSPackage);
			if (sPackage != oldSPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StaticsPackage.SCLASS__SPACKAGE, oldSPackage, sPackage));
			}
		}
		return sPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPackage basicGetSPackage() {
		return sPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSPackage(SPackage newSPackage) {
		SPackage oldSPackage = sPackage;
		sPackage = newSPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.SCLASS__SPACKAGE, oldSPackage, sPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SMethod> getSMethods() {
		if (sMethods == null) {
			sMethods = new EObjectResolvingEList<SMethod>(SMethod.class, this, StaticsPackage.SCLASS__SMETHODS);
		}
		return sMethods;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumAttributes() {
		return numAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumAttributes(int newNumAttributes) {
		int oldNumAttributes = numAttributes;
		numAttributes = newNumAttributes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.SCLASS__NUM_ATTRIBUTES, oldNumAttributes, numAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ClassType newType) {
		ClassType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.SCLASS__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StaticsPackage.SCLASS__RELATIONS:
				return getRelations();
			case StaticsPackage.SCLASS__SPACKAGE:
				if (resolve) return getSPackage();
				return basicGetSPackage();
			case StaticsPackage.SCLASS__SMETHODS:
				return getSMethods();
			case StaticsPackage.SCLASS__NUM_ATTRIBUTES:
				return getNumAttributes();
			case StaticsPackage.SCLASS__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StaticsPackage.SCLASS__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection<? extends Relation>)newValue);
				return;
			case StaticsPackage.SCLASS__SPACKAGE:
				setSPackage((SPackage)newValue);
				return;
			case StaticsPackage.SCLASS__SMETHODS:
				getSMethods().clear();
				getSMethods().addAll((Collection<? extends SMethod>)newValue);
				return;
			case StaticsPackage.SCLASS__NUM_ATTRIBUTES:
				setNumAttributes((Integer)newValue);
				return;
			case StaticsPackage.SCLASS__TYPE:
				setType((ClassType)newValue);
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
			case StaticsPackage.SCLASS__RELATIONS:
				getRelations().clear();
				return;
			case StaticsPackage.SCLASS__SPACKAGE:
				setSPackage((SPackage)null);
				return;
			case StaticsPackage.SCLASS__SMETHODS:
				getSMethods().clear();
				return;
			case StaticsPackage.SCLASS__NUM_ATTRIBUTES:
				setNumAttributes(NUM_ATTRIBUTES_EDEFAULT);
				return;
			case StaticsPackage.SCLASS__TYPE:
				setType(TYPE_EDEFAULT);
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
			case StaticsPackage.SCLASS__RELATIONS:
				return relations != null && !relations.isEmpty();
			case StaticsPackage.SCLASS__SPACKAGE:
				return sPackage != null;
			case StaticsPackage.SCLASS__SMETHODS:
				return sMethods != null && !sMethods.isEmpty();
			case StaticsPackage.SCLASS__NUM_ATTRIBUTES:
				return numAttributes != NUM_ATTRIBUTES_EDEFAULT;
			case StaticsPackage.SCLASS__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (numAttributes: ");
		result.append(numAttributes);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //SClassImpl

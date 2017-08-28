/**
 */
package data.statics.impl;

import data.statics.SClass;
import data.statics.SPackage;
import data.statics.StaticsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.statics.impl.SPackageImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link data.statics.impl.SPackageImpl#getSubPackages <em>Sub Packages</em>}</li>
 *   <li>{@link data.statics.impl.SPackageImpl#getSuperPackage <em>Super Package</em>}</li>
 *   <li>{@link data.statics.impl.SPackageImpl#getSClasses <em>SClasses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SPackageImpl extends CodeElementImpl implements SPackage {
	
	/**
	 * The default {@code serialVersionUID} for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int LEVEL_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected int level = LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubPackages() <em>Sub Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<SPackage> subPackages;

	/**
	 * The cached value of the '{@link #getSuperPackage() <em>Super Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperPackage()
	 * @generated
	 * @ordered
	 */
	protected SPackage superPackage;

	/**
	 * The cached value of the '{@link #getSClasses() <em>SClasses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<SClass> sClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticsPackage.Literals.SPACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(int newLevel) {
		int oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.SPACKAGE__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SPackage> getSubPackages() {
		if (subPackages == null) {
			subPackages = new EObjectResolvingEList<SPackage>(SPackage.class, this, StaticsPackage.SPACKAGE__SUB_PACKAGES);
		}
		return subPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPackage getSuperPackage() {
		if (superPackage != null && superPackage.eIsProxy()) {
			InternalEObject oldSuperPackage = (InternalEObject)superPackage;
			superPackage = (SPackage)eResolveProxy(oldSuperPackage);
			if (superPackage != oldSuperPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StaticsPackage.SPACKAGE__SUPER_PACKAGE, oldSuperPackage, superPackage));
			}
		}
		return superPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPackage basicGetSuperPackage() {
		return superPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperPackage(SPackage newSuperPackage) {
		SPackage oldSuperPackage = superPackage;
		superPackage = newSuperPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticsPackage.SPACKAGE__SUPER_PACKAGE, oldSuperPackage, superPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SClass> getSClasses() {
		if (sClasses == null) {
			sClasses = new EObjectResolvingEList<SClass>(SClass.class, this, StaticsPackage.SPACKAGE__SCLASSES);
		}
		return sClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StaticsPackage.SPACKAGE__LEVEL:
				return getLevel();
			case StaticsPackage.SPACKAGE__SUB_PACKAGES:
				return getSubPackages();
			case StaticsPackage.SPACKAGE__SUPER_PACKAGE:
				if (resolve) return getSuperPackage();
				return basicGetSuperPackage();
			case StaticsPackage.SPACKAGE__SCLASSES:
				return getSClasses();
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
			case StaticsPackage.SPACKAGE__LEVEL:
				setLevel((Integer)newValue);
				return;
			case StaticsPackage.SPACKAGE__SUB_PACKAGES:
				getSubPackages().clear();
				getSubPackages().addAll((Collection<? extends SPackage>)newValue);
				return;
			case StaticsPackage.SPACKAGE__SUPER_PACKAGE:
				setSuperPackage((SPackage)newValue);
				return;
			case StaticsPackage.SPACKAGE__SCLASSES:
				getSClasses().clear();
				getSClasses().addAll((Collection<? extends SClass>)newValue);
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
			case StaticsPackage.SPACKAGE__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case StaticsPackage.SPACKAGE__SUB_PACKAGES:
				getSubPackages().clear();
				return;
			case StaticsPackage.SPACKAGE__SUPER_PACKAGE:
				setSuperPackage((SPackage)null);
				return;
			case StaticsPackage.SPACKAGE__SCLASSES:
				getSClasses().clear();
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
			case StaticsPackage.SPACKAGE__LEVEL:
				return level != LEVEL_EDEFAULT;
			case StaticsPackage.SPACKAGE__SUB_PACKAGES:
				return subPackages != null && !subPackages.isEmpty();
			case StaticsPackage.SPACKAGE__SUPER_PACKAGE:
				return superPackage != null;
			case StaticsPackage.SPACKAGE__SCLASSES:
				return sClasses != null && !sClasses.isEmpty();
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
		result.append(" (level: ");
		result.append(level);
		result.append(')');
		return result.toString();
	}

} //SPackageImpl

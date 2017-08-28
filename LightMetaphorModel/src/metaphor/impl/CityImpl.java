/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import metaphor.City;
import metaphor.MetaphorPackage;
import metaphor.entities.RegularBase;
import metaphor.entities.Street;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>City</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link metaphor.impl.CityImpl#getStreets <em>Streets</em>}</li>
 * <li>{@link metaphor.impl.CityImpl#getAdministrationCoverage <em>Administration Coverage</em>}</li>
 * <li>{@link metaphor.impl.CityImpl#getRegularCoverage <em>Regular Coverage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CityImpl extends EObjectImpl implements City {
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
	 * The cached value of the '{@link #getRegularCoverage() <em>Regular Coverage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRegularCoverage()
	 * @generated
	 * @ordered
	 */
	protected RegularBase regularCoverage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected CityImpl() {
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
		return MetaphorPackage.Literals.CITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<Street> getStreets() {
		if (streets == null) {
			streets = new EObjectResolvingEList<Street>(Street.class, this, MetaphorPackage.CITY__STREETS);
		}
		return streets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularBase getRegularCoverage() {
		if (regularCoverage != null && regularCoverage.eIsProxy()) {
			InternalEObject oldRegularCoverage = (InternalEObject) regularCoverage;
			regularCoverage = (RegularBase) eResolveProxy(oldRegularCoverage);
			if (regularCoverage != oldRegularCoverage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetaphorPackage.CITY__REGULAR_COVERAGE, oldRegularCoverage, regularCoverage));
			}
		}
		return regularCoverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public RegularBase basicGetRegularCoverage() {
		return regularCoverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setRegularCoverage(RegularBase newRegularCoverage) {
		RegularBase oldRegularCoverage = regularCoverage;
		regularCoverage = newRegularCoverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaphorPackage.CITY__REGULAR_COVERAGE, oldRegularCoverage, regularCoverage));
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
		case MetaphorPackage.CITY__STREETS:
			return getStreets();
		case MetaphorPackage.CITY__REGULAR_COVERAGE:
			if (resolve)
				return getRegularCoverage();
			return basicGetRegularCoverage();
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
		case MetaphorPackage.CITY__STREETS:
			getStreets().clear();
			getStreets().addAll((Collection<? extends Street>) newValue);
			return;
		case MetaphorPackage.CITY__REGULAR_COVERAGE:
			setRegularCoverage((RegularBase) newValue);
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
		case MetaphorPackage.CITY__STREETS:
			getStreets().clear();
			return;
		case MetaphorPackage.CITY__REGULAR_COVERAGE:
			setRegularCoverage((RegularBase) null);
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
		case MetaphorPackage.CITY__STREETS:
			return streets != null && !streets.isEmpty();
		case MetaphorPackage.CITY__REGULAR_COVERAGE:
			return regularCoverage != null;
		}
		return super.eIsSet(featureID);
	}

} // CityImpl

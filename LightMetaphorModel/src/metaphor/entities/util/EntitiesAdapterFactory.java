/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.entities.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import metaphor.entities.Cable;
import metaphor.entities.EntitiesPackage;
import metaphor.entities.Floor;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.Street;
import metaphor.types.Entity2D;
import metaphor.types.Entity3D;
import metaphor.types.VisualEntity;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see metaphor.entities.EntitiesPackage
 * @generated
 */
public class EntitiesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static EntitiesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EntitiesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EntitiesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 *
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EntitiesSwitch<Adapter> modelSwitch =
			new EntitiesSwitch<Adapter>() {
				@Override
				public Adapter caseRegularBuilding(RegularBuilding object) {
					return createRegularBuildingAdapter();
				}

				@Override
				public Adapter caseStreet(Street object) {
					return createStreetAdapter();
				}

				@Override
				public Adapter caseFloor(Floor object) {
					return createFloorAdapter();
				}

				@Override
				public Adapter caseRegularFloor(RegularFloor object) {
					return createRegularFloorAdapter();
				}

				@Override
				public Adapter caseCable(Cable object) {
					return createCableAdapter();
				}

				@Override
				public Adapter caseRegularDistrict(RegularDistrict object) {
					return createRegularDistrictAdapter();
				}

				@Override
				public Adapter caseRegularBase(RegularBase object) {
					return createRegularBaseAdapter();
				}

				@Override
				public Adapter caseVisualEntity(VisualEntity object) {
					return createVisualEntityAdapter();
				}

				@Override
				public Adapter caseEntity2D(Entity2D object) {
					return createEntity2DAdapter();
				}

				@Override
				public Adapter caseEntity3D(Entity3D object) {
					return createEntity3DAdapter();
				}

				@Override
				public Adapter defaultCase(EObject object) {
					return createEObjectAdapter();
				}
			};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link metaphor.entities.RegularBuilding <em>Regular Building</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.entities.RegularBuilding
	 * @generated
	 */
	public Adapter createRegularBuildingAdapter() {
		return null;
	}


	/**
	 * Creates a new adapter for an object of class '{@link metaphor.entities.Street <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.entities.Street
	 * @generated
	 */
	public Adapter createStreetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metaphor.entities.Floor <em>Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.entities.Floor
	 * @generated
	 */
	public Adapter createFloorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metaphor.entities.RegularFloor <em>Regular Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.entities.RegularFloor
	 * @generated
	 */
	public Adapter createRegularFloorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metaphor.entities.Cable <em>Cable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.entities.Cable
	 * @generated
	 */
	public Adapter createCableAdapter() {
		return null;
	}


	/**
	 * Creates a new adapter for an object of class '{@link metaphor.entities.RegularDistrict <em>Regular District</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.entities.RegularDistrict
	 * @generated
	 */
	public Adapter createRegularDistrictAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metaphor.entities.RegularBase <em>Regular Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.entities.RegularBase
	 * @generated
	 */
	public Adapter createRegularBaseAdapter() {
		return null;
	}


	/**
	 * Creates a new adapter for an object of class '{@link metaphor.types.VisualEntity <em>Visual Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.types.VisualEntity
	 * @generated
	 */
	public Adapter createVisualEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metaphor.types.Entity2D <em>Entity2 D</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.types.Entity2D
	 * @generated
	 */
	public Adapter createEntity2DAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metaphor.types.Entity3D <em>Entity3 D</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see metaphor.types.Entity3D
	 * @generated
	 */
	public Adapter createEntity3DAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // EntitiesAdapterFactory

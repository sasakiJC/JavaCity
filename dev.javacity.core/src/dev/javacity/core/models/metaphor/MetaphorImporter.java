/***************************************************************************
 * This file is part of Synchrovis - A prototypical implementation of the
 * visualization approach described in the author's master's thesis titled
 *
 * 							 Visualisierung von
 * 					Synchronisationspunkten in Kombination
 * 						  mit der Statik und Dynamik
 *							 eines Softwaresystems
 *
 * written at Software Engineering Group, Department of Computer Science at
 * Christian-Albrechts-University of Kiel.
 *
 * Author: Philipp D�hring, October 2012
 ***************************************************************************/

/************************
 * 8月12日　佐々木改定
 * dynamicsLoad関連の削除
 */


package dev.javacity.core.models.metaphor;

import java.util.List;

import org.apache.log4j.Logger;

import data.VisualizableElement;
import data.dynamics.SClassInstance;
import data.statics.Relation;
import data.statics.SClass;
import data.statics.SPackage;
import dev.javacity.core.models.city.CityModel;
import dev.javacity.core.models.metaphor.applier.ColorApplier;
import dev.javacity.core.models.metaphor.applier.DimensionApplier;
import dev.javacity.core.models.metaphor.applier.PositionApplier;
import dev.javacity.core.observer.AbstractObservable;
import dev.javacity.core.observer.IObserver;
import dev.javacity.core.observer.ObservableAction;
import dev.javacity.core.utils.LoggerUtils;
import metaphor.entities.Cable;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.impl.EntitiesFactoryImpl;
import metaphor.entities.impl.EntitiesPackageImpl;
import metaphor.types.VisualEntity;
/**
 * A metaphor importer to import all visualizable data objects in a given {@link CityModel} instance to a new {@link MetaphorModel} object.
 *
 * @author pdo
 *
 */
public final class MetaphorImporter implements IObserver {

	// ============================= Attributes ===============================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(MetaphorModel.class);

	/** The {@link MetaphorModel} instance to add all imported data to. */
	private final MetaphorModel metapher;

	/** A {@link DimensionApplier} to automatically set the dimensions of the imported metaphor objects. */
	private final DimensionApplier measuresApplier = new DimensionApplier();

	/** A {@link ColorApplier} to automatically set the color of the imported metaphor objects. */
	private final ColorApplier colorApplier = new ColorApplier();

	/** A {@link PositionApplier} to automatically set the position of the imported metaphor objects. */
	private final PositionApplier positionApplier = new PositionApplier();

	// ============================= Constructor ==============================

	/**
	 * Constructs a new {@link MetaphorImporter} instance with the given {@link MetaphorModel} object to import all data into.
	 *
	 * @param metapherModel
	 *            The metaphor instance to add all imported data to.
	 * @throws IllegalArgumentException
	 *             If the given metaphor model is {@code null}.
	 */
	public MetaphorImporter(final MetaphorModel metapherModel) throws IllegalArgumentException {

		if (metapherModel == null) {
			throw new IllegalArgumentException("You cannot pass in a null metaphor model.");
		}

		this.metapher = metapherModel;

		EntitiesPackageImpl.init();
		EntitiesFactoryImpl.init();
	}

	// =========================== Interface Methods ==========================

	@Override
	public void update(final AbstractObservable observable, final ObservableAction action, final Object object) {

		switch (action) {
		case STATICS_LOADED:
			this.onStaticsLoaded((SPackage) object);
			break;
		case ALL_CLEARED:
			this.onAllCleared();
			break;
//		case CLASS_INSTANCE_ADDED:
//			this.onClassInstanceAdded((SClassInstance) object);
//			break;
//		case CLASS_INSTANCE_REMOVED:
//			this.onClassInstanceRemoved((SClassInstance) object);
//			break;
		case RELATION_ADDED:
			this.onRelationInstanceAdded((Relation) object);
			break;
		case RELATION_REMOVED:
			this.onRelationInstanceRemoved((Relation) object);
			break;
		default:
			LOGGER.warn("ObservableAction '" + action + "' not supported.");
		}
	}

	// =============================== Methods ================================

	/**
	 * The method being automatically invoked when the {@link #update(AbstractObservable, ObservableAction, Object)} method has been called with the 'action'
	 * parameter set as {@link ObservableAction#STATICS_LOADED}. It imports the given {@link SPackage} by creating a representing {@link RegularBase} instance. All
	 * contained sub-packages and {@link SClass} objects will be added to this base using {@link RegularDistrict} and {@link RegularBuilding} objects.
	 * A (mostly) hard-coded {@link AdministrationBase} with its {@link AdministrationDistrict} and three {@link AdministrationBuilding} objects will be created
	 * and added to this metaphor model thereafter.
	 *
	 * @param root
	 *            The root package to be imported.
	 */
	private void onStaticsLoaded(final SPackage root) {

		// create new regular base instance and build package structure
		final RegularBase regBase = this.buildStaticStructure(root);

		// set attributes
		this.colorApplier.applyColor(regBase);
		this.measuresApplier.applyDimensions(regBase);
		this.positionApplier.applyPosition(regBase);

		// import static class instances
		this.buildGroundFloors(root);

		this.metapher.setStaticsLoaded((RegularBase) root.getMetaphorObject());
	}

	/**
	 * Creates a new {@link RegularFloor} instance for each {@link RegularBuilding} object contained in the specified package and adds them to the visualization.
	 * These floors are the ground floors of each building, i.e. represent the class object of each class itself.
	 *
	 * @param pack
	 *            The package containing all buildings for which a ground floor is to be created.
	 */
	private void buildGroundFloors(final SPackage pack) {

		for (SPackage child : pack.getSubPackages()) {
			this.buildGroundFloors(child);
		}

		for (SClass clazz : pack.getSClasses()) {
			this.buildGroundFloor(clazz);
		}
	}

	/**
	 * Creates a new {@link RegularFloor} instance representing the specified {@link SClassObject} and adds it as a floor to the building representing its class.
	 *
	 * @param sClassObject
	 *            The class object to create its representing (ground) floor.
	 */
	private void buildGroundFloor(final SClass sClassObject) {

		// create new floor instance
		final RegularFloor floor = EntitiesFactoryImpl.eINSTANCE.createRegularFloor();
//		this.map(floor, sClassObject);
		final RegularBuilding building = (RegularBuilding) sClassObject.getMetaphorObject();
		floor.setBuilding(building);

		// set attributes
		this.measuresApplier.applyDimensions(floor);
		this.positionApplier.applyPosition(floor);
		this.colorApplier.applyColor(floor);

		building.getFloors().add(building.getFloors().size(), floor);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully created and imported new regular floor with values: " + LoggerUtils.toLogString(floor) + ".");
		}
	}

	/**
	 * Builds the static city structure. It creates a new base for the given {@link SPackage} instance and buildings and districts for all its contained members.
	 *
	 * @param root
	 *            The root package of the application to visualize.
	 * @return The {@link RegularBase} instance representing the given root package.
	 */
	private RegularBase buildStaticStructure(final SPackage root) {

		// create new regular base instance
		final RegularBase base = EntitiesFactoryImpl.eINSTANCE.createRegularBase();
		this.map(base, root);
		this.measuresApplier.applyDimensions(base);

		// build package structure
		for (SPackage pack : root.getSubPackages()) {
			final RegularDistrict subDistrict = this.buildPackageStructure(pack);
			base.getDistricts().add(subDistrict);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully created and imported regular base with values: " + LoggerUtils.toLogString(base) + ".");
		}
		return (RegularBase) root.getMetaphorObject();
	}

	/**
	 * Builds the static package structure. It creates a new {@link RegularDistrict} for the given {@link SPackage} instance and buildings for all its contained
	 * {@link SClass} instance members.
	 *
	 * @param pack
	 *            The package to be imported.
	 * @return The {@link RegularDistrict} instance representing the given package.
	 */
	private RegularDistrict buildPackageStructure(final SPackage pack) {

		// create new regular district instance
		final RegularDistrict district = EntitiesFactoryImpl.eINSTANCE.createRegularDistrict();
		this.map(district, pack);
		this.measuresApplier.applyDimensions(district);

		// build class structure
		for (SClass sClass : pack.getSClasses()) {
			final RegularBuilding building = this.buildBuilding(sClass);
			district.getBuildungs().add(building);
			building.setDistrict(district);
		}

		// recursive call for each sub-package
		for (SPackage subPackage : pack.getSubPackages()) {
			final RegularDistrict subDistrict = this.buildPackageStructure(subPackage);
			district.getChildDistricts().add(subDistrict);
			subDistrict.setParentDistrict(district);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully imported new regular district with values: " + LoggerUtils.toLogString(district) + ".");
		}
		return (RegularDistrict) pack.getMetaphorObject();
	}

	/**
	 * The action to be performed when a change notification with {@link ObservableAction#ALL_CLEARED} has been received. It removes all static and dynamics
	 * elements from the metaphor model. It will be totally empty when this method returns.
	 */
	private void onAllCleared() {

		this.colorApplier.updateAttributes();
		this.measuresApplier.updateAttributes();
		this.positionApplier.updateAttributes();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully cleared both statics and dynamics.");
		}

		this.metapher.clearAll();
	}

	/**
	 * Creates a new {@link RegularBuilding} instance representing the specified {@link SClass} object.
	 *
	 * @param sClass
	 *            The class object to create its corresponding regular building.
	 * @return The regular building instance representing the specified sClass.
	 */
	private RegularBuilding buildBuilding(final SClass sClass) {

		// create new regular building instance
		final RegularBuilding building = EntitiesFactoryImpl.eINSTANCE.createRegularBuilding();
		this.map(building, sClass);

		final RegularDistrict district = (RegularDistrict) sClass.getSPackage().getMetaphorObject();
		district.getBuildungs().add(district.getBuildungs().size(), building);
		building.setDistrict(district);

		this.measuresApplier.applyDimensions(building);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully created and imported new regular building with values: " + LoggerUtils.toLogString(building) + ".");
		}
		return (RegularBuilding) sClass.getMetaphorObject();
	}

	/**
	 * The action to be performed when a change notification has been received with {@link ObservableAction#CLASS_INSTANCE_ADDED}. It creates a new
	 * {@link RegularFloor} instance representing the specified {@link SClassInstance} object (if not already existing) and adds it to the metaphor model.
	 *
	 * @param instance
	 *            The class instance to be imported into the metaphor model.
	 */
	private void onClassInstanceAdded(final SClassInstance instance) {

		// create new floor instance
		final RegularFloor floor = EntitiesFactoryImpl.eINSTANCE.createRegularFloor();
		this.map(floor, instance);

		final RegularBuilding building = (RegularBuilding) instance.getSClass().getMetaphorObject();
		floor.setBuilding(building);

		// set attributes
		this.colorApplier.applyColor(floor);
		this.measuresApplier.applyDimensions(floor);
		this.positionApplier.applyPosition(floor);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully created and imported new regular floor with values: " + LoggerUtils.toLogString(floor) + ".");
		}

		// add as floor
		final List<RegularFloor> floors = floor.getBuilding().getFloors();
		floors.add(floors.size(), floor);

		RegularFloor rgFloor = (RegularFloor) instance.getMetaphorObject();
		if(instance.getSClass().getName().equals("DPInstance")){
			rgFloor.setClassId(1);
		}else if(instance.getSClass().getName().equals("Stick")){
			rgFloor.setClassId(2);
		}else if(instance.getSClass().getName().equals("Philosopher")){
			rgFloor.setClassId(3);
		}

		this.metapher.addFloor(rgFloor);
	}

	/**
	 * The action to be performed when a change notification has been received with {@link ObservableAction#MONITOR_OBJECT_REMOVED} or
	 * {@link ObservableAction#WAIT_NOTIFY_OBJECT_REMOVED}. It removes the {@link SClassInstance}'s metaphor object from the metaphor model.
	 *
	 * @param instance
	 *            The class instance element to remove its metaphor object from the metaphor model.
	 */
	private void onClassInstanceRemoved(final SClassInstance instance) {

		// remove from building's floor list
		final RegularFloor floor = (RegularFloor) instance.getMetaphorObject();
		final List<RegularFloor> floors = floor.getBuilding().getFloors();
		floors.remove(floor);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully removed regular floor with values: " + LoggerUtils.toLogString(floor) + ".");
		}
		this.metapher.removeFloor(floor);
	}



	/**
	 * The action to be performed when a change notification has been received with {@link ObservableAction#RELATION_ADDED}. It creates a new {@link Cable} instance
	 * representing the specified {@link Relation} object (if not already existing) and adds it to the metaphor model.
	 *
	 * @param relation
	 *            The relation instance to be imported into the metaphor model.
	 */
	private void onRelationInstanceAdded(final Relation relation) {

		// create new cable instance
		final Cable cable = EntitiesFactoryImpl.eINSTANCE.createCable();
		this.map(cable, relation);

		// set source and target
		cable.setSource((RegularBuilding) relation.getSource().getMetaphorObject());
		cable.setTarget((RegularBuilding) relation.getTarget().getMetaphorObject());
		relation.getSource().getRelations().add(relation);
		if (!relation.getSource().equals(relation.getTarget())) {
			relation.getTarget().getRelations().add(relation);
		}

		// do not apply position since every cable will be translated to a bendable arrow anyways
		this.colorApplier.applyColor(cable);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully created and imported new cable with values: " + LoggerUtils.toLogString(cable) + ".");
		}
		this.metapher.addCable((Cable) relation.getMetaphorObject());
	}

	/**
	 * The action to be performed when a change notification has been received with {@link ObservableAction#MONITOR_OBJECT_REMOVED} or
	 * {@link ObservableAction#WAIT_NOTIFY_OBJECT_REMOVED}. It removes the {@link Relation}'s metaphor object from the metaphor model.
	 *
	 * @param relation
	 *            The relation element to remove its metaphor object from the metaphor model.
	 */
	private void onRelationInstanceRemoved(final Relation relation) {

		final Cable cable = (Cable) relation.getMetaphorObject();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully removed cable with values: " + LoggerUtils.toLogString(cable) + ".");
		}
		this.metapher.removeCable(cable);
	}


	/**
	 * Maps the given objects to each other. It sets the given {@code entity} as the {@code elements} metaphor object and the {@code element} as {@code entity}'s
	 * data object.
	 *
	 * @param entity
	 *            The visual entity to map to the given {@link VisualizableElement} object.
	 * @param element
	 *            The visualizable element to map to the given {@link VisualEntity} instance.
	 */
	private void map(final VisualEntity entity, final VisualizableElement element) {

		entity.setDataObject(element);
		element.setMetaphorObject(entity);
	}

}

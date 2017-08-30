package dev.javacity.core.models.city;
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


import org.apache.log4j.Logger;

import data.dynamics.SClassInstance;
import data.statics.Relation;
import data.statics.SPackage;
import dev.javacity.core.observer.AbstractObservable;
import dev.javacity.core.observer.ObservableAction;
import dev.javacity.core.utils.LoggerUtils;

/**
 * The data structure containing all data objects currently visible on screen.
 *
 * @author pdo
 *
 */
public class CityModel extends AbstractObservable {

	// ============================= Attributes ===============================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(CityModel.class);

	// ============================= Constructor ==============================

	/**
	 * Default constructor. It creates a new {@link CityModel} instance.
	 */
	public CityModel() {

		super();
	}

	// =============================== Methods ================================

	/**
	 * Removes all objects in this {@link CityModel} instance. This scene model will be empty after this call returns.
	 */
	public void clearAll() {

		super.notifyObservers(ObservableAction.ALL_CLEARED, null);
	}

	/**
	 * Sets the common root package in this {@link CityModel} instance. This operation will add all contained sub-packages to this scene model automatically.
	 *
	 * @param root
	 *            The common root package of all packages to add to this scene model.
	 * @throws IllegalArgumentException
	 *             If the given package is {@code null}.
	 */
	public void setRootPackage(final SPackage root) throws IllegalArgumentException {

		if (root == null) {
			throw new IllegalArgumentException("You cannot set a null package as root package.");
		}

		// initialize data structure
		for (SPackage sPack : root.getSubPackages()) {
			this.initClassInstancesList(sPack);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully set package with values: " + LoggerUtils.toLogString(root) + " as root package.");
		}
		super.notifyObservers(ObservableAction.STATICS_LOADED, root);
	}

	/**
	 * initializes the list of {@link SClassInstance} objects of each class contained in the given package.
	 *
	 * @param sPack
	 *            The package to initialize all class instances lists in.
	 */
	private void initClassInstancesList(final SPackage sPack) {

		// recursive call for each sub-package
		for (SPackage subPack : sPack.getSubPackages()) {
			this.initClassInstancesList(subPack);
		}
	}

	/**
	 * Adds the given {@link SClassInstance} instance to this {@link CityModel} instance. This method has no effect, if the given object already exists in this
	 * scene model.
	 *
	 * @param instance
	 *            The dynamic class instance to add to this scene model.
	 */
	private void addClassInstance(final SClassInstance instance) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully added new dynamic class instance with values: " + LoggerUtils.toLogString(instance) + " to this scene model.");
		}
		super.notifyObservers(ObservableAction.CLASS_INSTANCE_ADDED, instance);
	}

	/**
	 * Adds a new {@link Relation} instance to this {@link CityModel} instance. This method has no effect, if the given object is already contained in this
	 * scene model.
	 *
	 * @param relation
	 *            The relation to add to this scene model.
	 * @throws IllegalArgumentException
	 *             If the given relation is {@code null}.
	 */
	public void addRelation(final Relation relation) throws IllegalArgumentException {

		if (relation == null) {
			throw new IllegalArgumentException("You cannot add a null relation.");
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully added new relation object with values: " + LoggerUtils.toLogString(relation) + " to this scene model.");
		}
		super.notifyObservers(ObservableAction.RELATION_ADDED, relation);
	}

	/**
	 * Removes the given {@link Relation} instance from this {@link CityModel} instance. This method has no effect, if the given object is not contained
	 * in this model instance.
	 *
	 * @param relation
	 *            The relation object to remove from this scene model.
	 * @throws IllegalArgumentException
	 *             If the given instance is {@code null}.
	 */
	public void removeRelation(final Relation relation) throws IllegalArgumentException {

		if (relation == null) {
			throw new IllegalArgumentException("You cannot remove a null relation.");
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully removed relation instance with values: " + LoggerUtils.toLogString(relation) + " from this scene model");
		}
		super.notifyObservers(ObservableAction.RELATION_REMOVED, relation);
	}

	/**
	 * Removes the given {@link SClassInstance} instance from this {@link CityModel} instance. This method has no effect, if the given object is not contained
	 * in this model instance.
	 *
	 * @param instance
	 *            The class object to remove from this scene model.
	 * @throws IllegalArgumentException
	 *             If the given instance is {@code null}.
	 */
	private void removeClassInstance(final SClassInstance instance) throws IllegalArgumentException {

		if (instance == null) {
			throw new IllegalArgumentException("You cannot remove a null instance.");
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully removed class instance with values: " + LoggerUtils.toLogString(instance) + " from this scene model");
		}
		super.notifyObservers(ObservableAction.CLASS_INSTANCE_REMOVED, instance);
	}

}

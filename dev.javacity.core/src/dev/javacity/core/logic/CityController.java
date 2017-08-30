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
 * 実行trace表示関連の削除
 */

package dev.javacity.core.logic;

import org.apache.log4j.Logger;

import data.statics.SClass;
import data.statics.SPackage;
import dev.javacity.core.models.city.CityModel;
import dev.javacity.core.observer.AbstractObservable;
import dev.javacity.core.observer.IObserver;
import dev.javacity.core.observer.ObservableAction;
import javafx.util.Pair;

/**
 *
import visual.gui.Gui; A city controller to control the city metaphor style visualization on screen.
 *
 * @author pdo
 *
 */
public final class CityController implements IObserver {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(CityController.class);

	/** The {@link CityModel} instance currently being controlled by this city controller. */
	private CityModel model;

	/** The {@link RelationsManager} to display application relations. */
	private RelationsManager relationsController;


	// ========================== Constructor =================================

	/**
	 * Protected constructor. This class is not intended for instantiation from outside of this package.
	 */
	protected CityController() {
	}

	// ============================ Methods ===================================

	/**
	 * Initializes this city controller with the specified scene model to be controlled. Both this method and {@link #init(CityControlBar)} have to be invoked in
	 * order to initialize this city controller.
	 *
	 * @param sceneModel
	 *            The scene model to be controlled by this city controller.
	 * @throws IllegalArgumentException
	 *             If the scene model passed in is {@code null}.
	 */
	public void init(final CityModel sceneModel) throws IllegalArgumentException {

		if (sceneModel == null) {
			throw new IllegalArgumentException("You cannot control a null scene model.");
		}

		this.model = sceneModel;
	}


	@Override
	@SuppressWarnings("unchecked")
	public void update(final AbstractObservable observable, final ObservableAction action, final Object object) {

		switch (action) {
		case STATICS_LOADED:
			this.onStaticsLoaded((SPackage) object);
			break;
		case ALL_CLEARED:
			this.onAllCleared();
			break;
		default:
			LOGGER.warn("Unsupported observable action received: " + action.name() + ".");
		}
	}

	/**
	 * The action to be performed, when a notification with {@link ObservableAction#STATICS_LOADED} has been received. This method simply invokes
	 * {@link CityModel#setRootPackage(SPackage)} on the currently controlled scene model.
	 *
	 * @param rootPack
	 *            The root package of the application to visualize.
	 */
	private void onStaticsLoaded(final SPackage rootPack) {

		this.relationsController = new RelationsManager(this.model, rootPack);
		this.model.setRootPackage(rootPack);
	}

	/**
	 * The action to be performed, when a notification with {@link ObservableAction#ALL_CLEARED} has been received. This method simply invokes
	 * {@link CityModel#clearAll()} on the currently controlled scene model.
	 */
	private synchronized void onAllCleared() {

		this.removeVisibleRelations();
		this.model.clearAll();

//		Logic.getInstance().getMenuBarController().setShowGlobalRelationsItemEnabled(false);
	}

	// ======================== Delegating Methods ============================

	/**
	 * Adds all incoming and outgoing {@link Relation} instances to the scene model currently being controlled. This will make them visible on screen. This method
	 * has no effect, if no static data has been imported yet.
	 *
	 * @param dataObject
	 *            The data object to show all its outgoing relations on screen.
	 * @throws IllegalArgumentException
	 *             If the sClass object passed in is {@code null}.
	 */
	public void showLocalRelations(final SClass dataObject) throws IllegalArgumentException {

		if (this.relationsController == null) {
			LOGGER.warn("Relations controller is null in method 'showLocalRelations'.");
		} else {
			this.relationsController.showLocalRelations(dataObject);
		}
	}

	/**
	 * Adds all {@link Relation} instances available to the scene model currently being controlled. This will make them visible on screen. If no statics data has
	 * been imported yet, this method will have no effect.
	 *
	 */
	public void showGlobalRelations() {

		if (this.relationsController == null) {
			LOGGER.warn("Relations controller is null in method 'showGlobalRelations'.");
		} else {
			this.relationsController.showGlobalRelations();
		}
	}

	/**
	 * Removes all currently visible relations (i.e. all elements in {@link #visibleRelations}) from the visualization. This method has no effect, if no static data
	 * has been imported yet.
	 */
	public void removeVisibleRelations() {

		if (this.relationsController == null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Relations controller is null in method 'removeVisibleRelations'.");
			}
		} else {
			this.relationsController.removeVisibleRelations();
		}
	}

	/**
	 * Returns the current status of the relations manager. The pair's left component indicates, whether global or local relations are currently being displayed. If
	 * {@code false}, the {@link SClass} instance whose local relations are currently displayed is stored in the pair's right component ({@code null} otherwise, i.e.
	 * if no relations are currently visible at all). This method will return {@code null}, if no static data has been imported yet.
	 *
	 * @return The current status of the relations manager or {@code null}, if no static data has been imported yet.
	 */
	public Pair<Boolean, SClass> getRelationsStatus() {

		if (this.relationsController == null) {
			LOGGER.warn("Relations controller is null in method 'getRelationsStatus'.");
			return null;
		} else {
			return this.relationsController.getStatus();
		}
	}

	/**
	 * Updates the relation menu items in menu bar -> 'Relations' according to the currently selected class and relation visualization status ({@link #getStatus()}).
	 * If no statics data has been imported yet, this method will have no effect.
	 */
	public void updateRelationButtons() {

		if (this.relationsController == null) {
			LOGGER.warn("Relations controller is null in method 'showGlobalRelations'.");
		} else {
			this.relationsController.updateButtons();
		}
	}
}

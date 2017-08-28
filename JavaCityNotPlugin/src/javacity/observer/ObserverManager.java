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

package javacity.observer;

import javacity.logic.CityController;
import javacity.logic.Logic;
import javacity.models.city.CityModel;
import javacity.models.data.DataModel;
import javacity.models.metaphor.MetaphorImporter;
import javacity.models.metaphor.MetaphorModel;
import javacity.models.view.ViewImporter;

/**
 * An observer manager registering each given {@link IObserver} at his matching {@link AbstractObservable}.
 *
 * @author pdo
 *
 */
public final class ObserverManager {

	// ========================== Constructor =================================

	/**
	 * Private constructor. Class instances should not be constructible from outside.
	 */
	private ObserverManager() {}

	// ============================ Methods ===================================

	/**
	 * Registers each given {@link IObserver} at his matching {@link AbstractObservable}.
	 *
	 * @param dataModel
	 *            The {@link DataModel} to notify the {@link CityController} singleton instance about changes.
	 * @param sceneModel
	 *            The {@link CityModel} to notify the specified metaphor importer about changes.
	 * @param metaphorModel
	 *            The {@link MetaphorModel} to notify the specified view importer about changes.
	 * @param metaphorImporter
	 *            The {@link MetaphorImporter} to be notified about changes in specified scene model.
	 * @param viewImporter
	 *            The {@link ViewImporter} to be notified about changes in the specified metaphor model.
	 * @throws IllegalArgumentException
	 *             If any argument passed in is {@code null}.
	 */
	public void connect(final DataModel dataModel, final CityModel sceneModel, final MetaphorModel metaphorModel, final MetaphorImporter metaphorImporter,
			final ViewImporter viewImporter) throws IllegalArgumentException {

		if (dataModel == null || sceneModel == null || metaphorModel == null) {
			throw new IllegalArgumentException("You cannot observe a null model.");
		}
		if (metaphorImporter == null || viewImporter == null) {
			throw new IllegalArgumentException("A null importer cannot observe models.");
		}

		dataModel.addObserver(Logic.getInstance().getCityController());
		sceneModel.addObserver(metaphorImporter);
		metaphorModel.addObserver(viewImporter);
	}

	// ========================== Inner Classes ===============================

	/**
	 * Get the singleton instance of this class. Will be created if not existing yet. This method is thread save.
	 *
	 * @return The singleton instance of this class.
	 */
	public static ObserverManager getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * A class holding the only instance of the {@link ObserverManager} class.
	 *
	 * @author pdo
	 *
	 */
	private static final class InstanceHolder {
		/** The only instance of the {@link ObserverManager} class. */
		private static final ObserverManager INSTANCE = new ObserverManager();

		/** Private constructor. Class instances should not be constructible. */
		private InstanceHolder() {}
	}
}

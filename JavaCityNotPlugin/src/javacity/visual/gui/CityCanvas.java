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

package javacity.visual.gui;

import org.apache.log4j.Logger;

import javacity.configuration.Configuration;
import javacity.logic.Logic;
import javacity.models.view.ViewModel;
import javafx.scene.SubScene;

/**
 * A city canvas class representing the three-dimensional surface all Java3D objects are drawn on.
 *
 * @author pdo
 *
 */
public final class CityCanvas extends SubScene {

	// =========================== Attributes =================================

	/** The generated {@code serialVersionUID} for serialization. */
	private static final long serialVersionUID = -8562673007779668311L;

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(CityCanvas.class);

	/** The {@link ViewModel} containing all Java3D objects to be drawn on this city canvas. */
	private final ViewModel viewModel;

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link CityCanvas} instance to visualize the given {@link ViewModel}.
	 *
	 * @param viewModel
	 *            The view model to be visualized on this city canvas.
	 *
	 * @throws IllegalArgumentException
	 *             If the viewModel passed in is {@code null}.
	 */
	public CityCanvas(final ViewModel viewModel) throws IllegalArgumentException {

		super(640, 320);
		this.viewModel = viewModel;

		if (viewModel == null) {
			throw new IllegalArgumentException("You cannot pass in a null view model.");
		}

		viewModel.init(this);
		Logic.getInstance().getCanvasController().init(this);
		this.setAntiAliasingEnabled(Configuration.getInstance().isAntiAliasingEnabled());
	}

	// ============================ Methods ===================================

	/**
	 * Enables or disables anti-aliasing for this city canvas.
	 *
	 * @param enabled
	 *            {@code True}, if enabled, {@code false} otherwise.
	 */
	public void setAntiAliasingEnabled(final boolean enabled) {

		this.getView().setSceneAntialiasingEnable(enabled);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully set scene anti aliasing to " + Boolean.toString(enabled) + ".");
		}
	}

	/**
	 * Returns the {@link ViewModel} instance containing all Java3D objects to be drawn on this city canvas.
	 *
	 * @return The view model of this city canvas.
	 */
	public ViewModel getViewModel() {

		return this.viewModel;
	}
}

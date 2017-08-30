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

package dev.javacity.core.logic;

import dev.javacity.core.visual.gui.CityCanvas;

/**
 * A city canvas controller to control the anti aliasing setting of a given {@link CityCanvas}.
 *
 * @author pdo
 *
 */
public final class CityCanvasController {

	// =========================== Attributes =================================

	/** The {@link CityCanvas} object currently being controlled by this instance. */
	private CityCanvas canvas;

	// ========================== Constructor =================================

	/**
	 *  Protected constructor. This class is not intended for instantiation from outside of this package.
	 */
	protected CityCanvasController() { /* nothing to do*/ }

	// ============================ Methods ===================================

	/**
	 * Initializes this city canvas controller with the {@link CityCanvas} to be controlled.
	 *
	 * @param cityCanvas
	 *            The city canvas to be controlled by this controller.
	 * @throws IllegalArgumentException
	 *             If the canvas passed in is {@code null}.
	 */
	public void init(final CityCanvas cityCanvas) throws IllegalArgumentException {

		if (cityCanvas == null) {
			throw new IllegalArgumentException("You cannot control a null canvas.");
		}

		this.canvas = cityCanvas;
	}

	/**
	 * Enables or disables anti-aliasing for the controlled {@link CityCanvas}. This method has no effect, if this controller currently does not control any city
	 * canvas.
	 *
	 * @param enabled
	 *            {@code True}, if enabled, {@code false} otherwise.
	 */
	public void setAntiAliasingEnabled(final boolean enabled) {

		if (this.canvas != null) {
			this.canvas.setAntiAliasingEnabled(enabled);
		}
	}

	/**
	 * Clean up all memory used by the underlying simple universe and remove all references from it. This method should typically be invoked when the application is
	 * about to exit.
	 */
	public void cleanUp() {

		if (this.canvas != null) {
			this.canvas.getViewModel().cleanUpScene();
		}
	}

	/**
	 * Request focus for the {@link CityCanvas} instance currently being controlled.
	 */
	public void requestFocus() {

		if (this.canvas != null) {
			this.canvas.requestFocus();
		}
	}

}

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
package javacity.logic;

/**
 * A facade like class to easily access all controller instances available in Synchrovis.
 *
 * @author pdo
 *
 */
public final class Logic {

	// =========================== Attributes =================================

	/** The city controller to control the city visualization on screen. */
	private CityController cityController = new CityController();

	/** The city canvas controller to control the canvas the city visualization is drawn on. */
//	private CityCanvasController canvasController = new CityCanvasController();

	/** The menu bar controller to control the GUI's menu bar. */
//	private MenuBarController menuBarController = new MenuBarController();

	/** The mouse selection controller to react to user inputs by mouse selection. */
	private MouseSelectionController selectionController = new MouseSelectionController();

	/** The saves controller to save the current visualization to disk or load previously saved visualizations. */
	private SavesController savesManager = new SavesController();

	// ========================== Constructor =================================

	/**
	 * This class is not intended for instantiation from outside (singleton pattern).
	 */
	private Logic() {}

	// ============================ Methods ===================================

	/**
	 * Get the {@link CityController} instance.
	 *
	 * @return The city controller instance.
	 */
	public CityController getCityController() {
		return this.cityController;
	}

	/**
	 * Get the {@link CityCanvasController} instance.
	 *
	 * @return The city canvas controller instance.
	 */
//	public CityCanvasController getCanvasController() {
//		return this.canvasController;
//	}

	/**
	 * Get the {@link MenuBarController} instance.
	 *
	 * @return The menu bar Controller instance.
	 */
//	public MenuBarController getMenuBarController() {
//		return this.menuBarController;
//	}

	/**
	 * Get the {@link MouseSelectionController} instance.
	 *
	 * @return The mouse selection controller.
	 */
	public MouseSelectionController getSelectionController() {
		return this.selectionController;
	}

	/**
	 * Get the {@link SavesController} instance.
	 *
	 * @return The saves manager instance.
	 */
	public SavesController getSavesManager() {
		return this.savesManager;
	}

	// ========================== Inner Classes ===============================

	/**
	 * Get the only instance of this class.
	 *
	 * @return The only instance of this class.
	 */
	public static Logic getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * A class holding the only instance of the {@link Logic} class.
	 *
	 * @author pdo
	 *
	 */
	private static final class InstanceHolder {
		/** The only instance of the {@link TraceTreeViewController} class. */
		private static final Logic INSTANCE = new Logic();

		/** Private constructor. Class instances should not be constructible. */
		private InstanceHolder() {}
	}
}

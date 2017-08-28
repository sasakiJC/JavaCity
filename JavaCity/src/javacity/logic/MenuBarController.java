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
 * dynamics関連の削除
 */
package javacity.logic;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.Logger;

import com.sun.j3d.utils.geometry.Primitive;

import data.statics.SClass;
import javacity.configuration.Language;
import javacity.importer.kdm.AbstractKDMImporter;
import javacity.logic.executors.KdmImportExecutor;
import javacity.models.data.DataModel;
import javacity.models.data.DataModelUtils;
import javacity.visual.gui.CityCanvas;
import javacity.visual.gui.HelpWindow;
import javacity.visual.gui.SearchWindow;
import javacity.visual.gui.SettingsWindow;
import metaphor.entities.RegularFloor;

/**
 * A menu bar controller containing the control logic of a {@link MenuBar}.
 *
 * @author pdo
 *
 */
public final class MenuBarController {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(MenuBarController.class);

	/** The {@link MenuBar} this menu bar controller is controlling. */
	private MenuBar menuBar;

	/** The {@link SnapshotManager} instance used to print and save taken snapshots of the visualization. */
	private SnapshotManager snapshotManager;

	/** The {@link AbstractKDMImporter} used to import KDM files into a data model. */
	private AbstractKDMImporter kdmImporter;

	/** The {@link DataModel} to write all imported data into. */
	private DataModel model;

	/** The settings window allowing the user to change the application and visualization properties . */
	private final SettingsWindow settingsWindow = new SettingsWindow();

	/** The help window describing common user interactions. */
	private final HelpWindow helpWindow = new HelpWindow();

	/** The search window by which the user may search for specific classes or packages in the visualization. */
	private SearchWindow searchWindow;

	// ========================== Constructor =================================

	/**
	 * Protected constructor. This class is not intended for instantiation from outside of this package.
	 */
	protected MenuBarController() {}

	// ============================ Methods ===================================

	/**
	 * Initializes this menu bar controller with the given canvas, kieker import filter, and KDM importer to be controlled.
	 *
	 * @param theMenuBar
	 *            The {@link MenuBar} this menu bar controller is supposed to control.
	 * @param theCanvas
	 *            The {@link CityCanvas} instance to be controlled by this menu bar controller.
	 * @param theKdmImporter
	 *            The {@link AbstractKDMImporter} to be controlled by this menu bar controller.
	 * @param dataModel
	 *            The {@link DataModel} to write all imported data into.
	 *
	 * @throws IllegalArgumentException
	 *             If the given menu bar, canvas, data model instance, or KDM importer is {@code null}.
	 */
	public void init(final MenuBar theMenuBar, final CityCanvas theCanvas, final AbstractKDMImporter theKdmImporter, final DataModel dataModel)
		throws IllegalArgumentException {

		if (theMenuBar == null) {
			throw new IllegalArgumentException("You cannot pass in a null menu bar.");
		}
		if (theCanvas == null) {
			throw new IllegalArgumentException("You cannot pass in a null canvas.");
		}
		if (theKdmImporter == null) {
			throw new IllegalArgumentException("You cannot pass in a null KDM importer.");
		}
		if (dataModel == null) {
			throw new IllegalArgumentException("You cannot import data into a null model.");
		}

		this.menuBar = theMenuBar;
		this.snapshotManager = new SnapshotManager(theCanvas);
		this.searchWindow = new SearchWindow(dataModel);
		this.kdmImporter = theKdmImporter;
		this.model = dataModel;
	}

	/**
	 * Rebuilds the controlled menu bar, i.e. recreates the entire menu bar structure including all menu and menu item elements. This method has no effect if this
	 * controller currently does not control any menu bar.
	 */
	public void rebuild() {

		if (this.menuBar != null) {
			this.menuBar.rebuild();
		}
	}

	/**
	 * Opens the {@link JFileChooser} allowing the user to select the KDM file and performs its import into a {@link DataModel}. This method has no effect if this
	 * controller currently does not control any menu bar.
	 */
	public void loadStatics() {

		if (this.menuBar != null) {
			final JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setFileFilter(new FileNameExtensionFilter(Language.getInstance().get("filefilter.xml.description"), "xml"));

			// start importing
			if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
				final KdmImportExecutor executor = new KdmImportExecutor(this.kdmImporter, fileChooser.getSelectedFile());
				executor.start();
			}
		}
	}


	/**
	 * Saves the current visualization to disk.
	 */
	public void save() {

		if (this.menuBar != null) {
			final JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
			fileChooser.setSelectedFile(new File("save." + SavesController.SAVES_ENDING));
			fileChooser.setFileFilter(new FileNameExtensionFilter(Language.getInstance().get("filefilter." + SavesController.SAVES_ENDING + ".description"),
					SavesController.SAVES_ENDING));

			// start saving
			if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(null)) {
				String filename = fileChooser.getSelectedFile().getAbsolutePath();
				try {
					final String fileEnding = "." + SavesController.SAVES_ENDING;
					if (!filename.endsWith(fileEnding)) {
						filename += fileEnding;
					}
					Logic.getInstance().getSavesManager().save(new File(filename));
				} catch (IllegalArgumentException | IOException e) {
					LOGGER.error("Failed to save visualization.", e);
					DataModelUtils.restoreMappings(this.model.getRoot());
					new File(filename).delete();
					JOptionPane.showMessageDialog(this.menuBar, Language.getInstance().get("file.save.error.message"),
							Language.getInstance().get("file.save.error.title"), JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Loads the current visualization from disk.
	 */
	public void load() {

		if (this.menuBar != null) {
			final JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setFileFilter(new FileNameExtensionFilter(Language.getInstance().get("filefilter." + SavesController.SAVES_ENDING + ".description"),
					SavesController.SAVES_ENDING));

			if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
				try {
					Logic.getInstance().getSavesManager().load(fileChooser.getSelectedFile());
				} catch (IllegalArgumentException | ClassNotFoundException | IOException e) {
					LOGGER.error("Failed to load visualization.", e);
					JOptionPane.showMessageDialog(this.menuBar, Language.getInstance().get("file.load.error.message"),
							Language.getInstance().get("file.load.error.title"), JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Takes a snapshot of the current visualization and saves it to the file selected by the user in the opened {@link JFileChooser}.
	 */
	public void saveSnapshot() {

		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(Language.getInstance().get("snapshot.save.title"));
		fileChooser.setSelectedFile(new File("snapshot." + SnapshotManager.getImageFormat()));
		fileChooser.setFileFilter(new FileNameExtensionFilter(Language.getInstance().get("filefilter." + SnapshotManager.getImageFormat() + ".description"),
				SnapshotManager.getImageFormat()));
		if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(null)) {
			try {
				String filename = fileChooser.getSelectedFile().getAbsolutePath();
				final String fileEnding = "." + SnapshotManager.getImageFormat();
				if (!filename.endsWith(fileEnding)) {
					filename += fileEnding;
				}
				this.snapshotManager.saveSnapshot(filename);
			} catch (IOException | IllegalArgumentException e) {
				LOGGER.error("Failed to take or save snapshot.", e);
				JOptionPane.showMessageDialog(this.menuBar, Language.getInstance().get("snapshot.save.error.message"),
						Language.getInstance().get("snapshot.save.error.title"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Prints the current visualization on the system's default printing device.
	 */
	public void printSnapshot() {

		this.snapshotManager.printSnapshot();
	}

	/**
	 * Opens the {@link SettingsWindow}, i.e. sets {@link #settingsWindow} visible.
	 */
	public void openOptions() {

		this.settingsWindow.rebuild();
		this.settingsWindow.setVisible(true);
	}

	/**
	 * Opens the {@link HelpWindow}, i.e. sets {@link #helpWindow} visible.
	 */
	public void openHelpMenu() {

		this.helpWindow.rebuild();
		this.helpWindow.setVisible(true);
	}

	/**
	 * Opens the {@link SearchWindow}, i.e. sets {@link #searchWindow} visible.
	 */
	public void openSearchMenu() {

		this.searchWindow.rebuild();
		this.searchWindow.setVisible(true);
	}

	/**
	 * Rebuilds the entire {@link HelpWindow}.
	 */
	public void rebuildHelpWindow() {

		this.helpWindow.rebuild();
	}

	/**
	 * Rebuilds the entire {@link SearchWindow}.
	 */
	public void rebuildSearchWindow() {

		this.searchWindow.rebuild();
	}


	/**
	 * Display the relations of the regular floor currently being selected. This method has no effect, if no {@link RegularFloor} object is selected.
	 */
	public void showLocalRelations() {

		final Primitive selected = Logic.getInstance().getSelectionController().getSelectedNode();
		if (selected != null && selected.getUserData() instanceof RegularFloor) {

			// show relations
			Logic.getInstance().getSelectionController().hidePopup();
			Logic.getInstance().getCityController().showLocalRelations((SClass) ((RegularFloor) selected.getUserData()).getBuilding().getDataObject());
		}
	}

	/**
	 * Display all relations of the application currently visible on screen.
	 */
	public void showGlobalRelations() {

		// show relations
		Logic.getInstance().getSelectionController().hidePopup();
		Logic.getInstance().getCityController().showGlobalRelations();
	}

	/**
	 * Hides all relations currently visible on screen.
	 */
	public void hideAllRelations() {

		Logic.getInstance().getCityController().removeVisibleRelations();
	}

	/**
	 * Enables or disables the statics menu ({@code staticsItem}) of the controlled menu bar instance. This method has no effect if this controller currently
	 * does not control any menu bar.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setStaticsItemEnabled(final boolean enable) {

		if (this.menuBar != null) {
			this.menuBar.setStaticsItemEnabled(enable);
		} else {
			LOGGER.warn("Menu bar is null in method 'setStaticsItemEnabled'.");
		}
	}

	/**
	 * Enables or disables the save menu item ({@code saveItem}) of the controlled menu bar instance. This method has no effect if this controller currently
	 * does not control any menu bar.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setSaveItemEnabled(final boolean enable) {

		if (this.menuBar != null) {
			this.menuBar.setSaveItemEnabled(enable);
		} else {
			LOGGER.warn("Menu bar is null in method 'setSaveItemEnabled'.");
		}
	}

	/**
	 * Enables or disables the dynamics menu item ({@code showLocalRelationsItem}) of the controlled menu bar instance. This method has no effect if this controller
	 * currently does not control any menu bar.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setShowLocalRelationsItemEnabled(final boolean enable) {

		if (this.menuBar != null) {
			this.menuBar.setShowLocalRelationsItemEnabled(enable);
		} else {
			LOGGER.warn("Menu bar is null in method 'setShowLocalRelationsItemEnabled'.");
		}
	}

	/**
	 * Enables or disables the dynamics menu item ({@code showGlobalRelationsItem}) of the controlled menu bar instance. This method has no effect if this controller
	 * currently does not control any menu bar.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setShowGlobalRelationsItemEnabled(final boolean enable) {

		if (this.menuBar != null) {
			this.menuBar.setShowGlobalRelationsItemEnabled(enable);
		} else {
			LOGGER.warn("Menu bar is null in method 'setShowGlobalRelationsItemEnabled'.");
		}
	}

	/**
	 * Enables or disables the dynamics menu item ({@code relationsHideItem}) of the controlled menu bar instance. This method has no effect if this controller
	 * currently does not control any menu bar.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setRelationsHideItemEnabled(final boolean enable) {

		if (this.menuBar != null) {
			this.menuBar.setRelationsHideItemEnabled(enable);
		} else {
			LOGGER.warn("Menu bar is null in method 'setRelationsHideItemEnabled'.");
		}
	}

	/**
	 * Enables or disables the search menu ({@code searchItem}) of the controlled menu bar instance. This method has no effect if this controller currently
	 * does not control any menu bar.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setSearchItemEnabled(final boolean enable) {

		if (this.menuBar != null) {
			this.menuBar.setSearchItemEnabled(enable);
		} else {
			LOGGER.warn("Menu bar is null in method 'setSearchItemEnabled'.");
		}
	}

}

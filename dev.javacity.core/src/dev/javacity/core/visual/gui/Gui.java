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

package dev.javacity.core.visual.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import dev.javacity.core.importer.kdm.AbstractKDMImporter;
import dev.javacity.core.logic.Logic;
import dev.javacity.core.models.data.DataModel;
import dev.javacity.core.models.view.ViewModel;

/**
 * The main GUI window of the Synchrovis application.
 *
 * @author pdo
 *
 */
public final class Gui extends JFrame {

	// =========================== Attributes =================================

	/** The generated {@code serialVersionUID} for serialization. */
	private static final long serialVersionUID = -1487982241584499211L;

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(Gui.class);

	/** The name of this application. */
	private static final String APPLICATION_NAME = "Synchrovis";

	/** The {@link AbstractKDMImporter} used to import the static data contained in a KDM file into a {@link DataModel}. */
	private final AbstractKDMImporter kdmImporter;

	/** The {@link DataModel} instance to write all imported data from KDM and Kieker files into. */
	private final DataModel model;

	/** The {@link ViewModel} representing the visualization. */
	private final ViewModel viewModel;

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link Gui} instance to allow the user to control the specified KDM importer and Kieker import filter and sets itself visible on screen.
	 *
	 * @param kdmImporter
	 *            The KDM importer to be controlled by this GUI.
	 * @param dataModel
	 *            The data model instance to write all imported data from KDM and Kieker files into.
	 * @param viewModel
	 *            The view model all static and dynamic data is going to be imported into.
	 * @throws IllegalArgumentException
	 *             If either the KDM importer, view or data model instance is {@code null}.
	 */
	public Gui(final AbstractKDMImporter kdmImporter, final DataModel dataModel, final ViewModel viewModel) throws IllegalArgumentException {

		super();

		if (kdmImporter == null) {
			throw new IllegalArgumentException("The GUI does not work with a null KDM Importer.");
		}
		if (dataModel == null) {
			throw new IllegalArgumentException("The GUI does not work with a null data model.");
		}
		if (viewModel == null) {
			throw new IllegalArgumentException("The GUI does not work with a null view model.");
		}

		this.kdmImporter = kdmImporter;
		this.viewModel = viewModel;
		this.model = dataModel;

		this.setFrameDesign();
		this.addComponents();

		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		this.rebuildMenuBarOnResize();
		this.setVisible(true);
	}

	// ============================ Methods ===================================

	/**
	 * Sets the design of this {@link Gui}. I.e. it determines and sets the preferred window size for the current screen resolution and centers the window on screen.
	 * Furthermore, it sets the application title in the program's title bar to {@value #APPLICATION_NAME}, the frame's closing operation, resizing capabilities,
	 * and the GUI's look and feel.
	 */
	private void setFrameDesign() {

		// set size relative to screen size
		final Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();

		this.setSize((int) (resolution.getWidth() * 0.9), (int) (resolution.getHeight() * 0.9));
		this.setMinimumSize(new Dimension(800, 600));
		this.setResizable(true);

		// centering
		this.setLocationRelativeTo(null);

		// close options and title
		this.setTitle(APPLICATION_NAME);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent event) {
				Logic.getInstance().getCanvasController().cleanUp();
				System.exit(0);
			}
		});

		try {
			// use the system's look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			LOGGER.error("An error occurred while setting the GUI's look and feel.", e);
		}
	}

	/**
	 * Creates and adds all components to this {@link Gui}.
	 */
	private void addComponents() {

		this.setLayout(new BorderLayout());

		// add menu bar
		final CityCanvas canvas = new CityCanvas(this.viewModel);
		final MenuBar menuBar = new MenuBar(canvas, this.kdmImporter, this.model);
		this.add(menuBar, BorderLayout.NORTH);

		// create and add components


		this.add(canvas, BorderLayout.CENTER);
	}

	/**
	 * A little workaround to prevent the heavy weight canvas3d from overlapping the light weight menu bar (items). The method rebuilds the menu bar whenever the
	 * user resized the main GUI window.
	 */
	private void rebuildMenuBarOnResize() {

		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(final ComponentEvent event) {/* nothing to do */}

			@Override
			public void componentResized(final ComponentEvent event) {
				Logic.getInstance().getMenuBarController().rebuild();
			}

			@Override
			public void componentMoved(final ComponentEvent event) {/* nothing to do */}

			@Override
			public void componentHidden(final ComponentEvent event) {/* nothing to do */}
		});
	}

	/**
	 * Creates a new JSplitPane with the specified orientation and the specified components. Is divider size will be set to {@code 0} and the specified
	 * {@code topLeft} component will be considered first when distributing the space after the split pane was resized.
	 *
	 * @param topLeft
	 *            The Component that will appear on the left of a horizontally-split pane, or at the top of a vertically-split pane.
	 * @param bottomRight
	 *            The Component that will appear on the right of a horizontally-split pane, or at the bottom of a vertically-split pane.
	 * @param orientation
	 *            {@link JSplitPane#hHORIZONTAL_SPLIT} or {@link JSplitPane#VERTICAL_SPLIT}
	 * @param resizeWeight
	 *            Specifies how to distribute extra space when the size of the split pane changes. A value of 0, the default, indicates the right/bottom component
	 *            gets all the extra space (the left/top component acts fixed), where as a value of 1 specifies the left/top component gets all the extra space (the
	 *            right/bottom component acts fixed).
	 * @return The new split pane.
	 */
	private JSplitPane createSplitPane(final Component topLeft, final Component bottomRight, final int orientation, final int resizeWeight) {

		final JSplitPane splitpane = new JSplitPane(orientation, topLeft, bottomRight);
		splitpane.setResizeWeight(resizeWeight);
		splitpane.setDividerSize(0);

		return splitpane;
	}

}

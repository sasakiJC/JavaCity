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
 * dynamicsItem関連の削除
 */


package javacity.visual.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javacity.configuration.Language;
import javacity.importer.kdm.AbstractKDMImporter;
import javacity.logic.Logic;
import javacity.models.data.DataModel;
import javacity.visual.gui.utils.GuiUtils;

/**
 * The menu bar displayed at the top of the {@link Gui} window.
 *
 * @author pdo
 *
 */
public final class MenuBar extends JMenuBar {

	// =========================== Attributes =================================

	/** The generated {code serialVersionUID} for serialization. */
	private static final long serialVersionUID = 1L;

	/** The 'File' -> 'Load Statics' menu item. */
	private JMenuItem staticsItem;

	/** The 'File' -> 'Save' menu item. */
	private JMenuItem saveItem;

	/** The 'Edit' -> 'Search' menu item. */
	private JMenuItem searchItem;

	/** The 'Relations' -> 'Show Local Relations' menu item. */
	private JMenuItem showLocalRelationsItem;

	/** The 'Relations' -> 'Show Global Relations' menu item. */
	private JMenuItem showGlobalRelationsItem;

	/** The 'Relations' -> 'Hide All Relations' menu item. */
	private JMenuItem hideAllRelationsItem;

	/** A list containing all menu components currently added to this menu bar. */
	private final List<Component> components = new LinkedList<Component>();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link MenuBar} instance allowing the user to control the given canvas, KDM importer, and Kieker import filter.
	 *
	 * @param canvas3d
	 *            The canvas instance to be controlled by this menu bar.
	 * @param kdmImporter
	 *            The KDM importer used to import static data into Synchrovis for visualization.
	 * @param dataModel
	 *            The {@link DataModel} instance to write all imported data into.
	 * @throws IllegalArgumentException
	 *             If the given canvas, data model, or KDM importer is {@code null}.
	 */
	public MenuBar(final CityCanvas canvas3d, final AbstractKDMImporter kdmImporter, final DataModel dataModel) throws IllegalArgumentException {

		super();
		Logic.getInstance().getMenuBarController().init(this, canvas3d, kdmImporter, dataModel);
		this.rebuild();

		// set default locale
		GuiUtils.setJColorChooserDefaultLocale();
		GuiUtils.setJFileChooserDefaultLocale();
	}

	// ============================ Methods ===================================

	/**
	 * Rebuilds this menu bar, i.e. recreates the entire menu bar structure including all menu and menu item elements.
	 */
	public void rebuild() {

		// remove old components
		for (Component comp : this.components) {
			this.remove(comp);
		}
		this.components.clear();

		// rebuild menu structure
		this.createFileMenu();
		this.createEditMenu();
		this.createSnapshotMenu();
		this.createRelationsMenu();
		this.createHelpMenu();
		this.revalidate();
		this.repaint();
	}

	/**
	 * Creates the 'File' menu in this {@link MenuBar} instance and adds the menu items 'Load Statics', 'Load Dynamics', and 'Exit' to it.
	 */
	private void createFileMenu() {

		// create menu 'File'
		final JMenu file = new JMenu(Language.getInstance().get("menubar.file.title"));

		// create 'Load Dynamics'
		boolean wasEnabled = false;

		// create and add 'Load Statics' menu item
		this.staticsItem = new JMenuItem(Language.getInstance().get("menubar.file.statics.title"));
		this.staticsItem.setEnabled(true);
		this.staticsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().loadStatics();
			}
		});
		file.add(this.staticsItem);

		// add separator
		file.addSeparator();

		// add 'Load' item
		final JMenuItem load = new JMenuItem(Language.getInstance().get("menubar.file.load.title"));
		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().load();
			}
		});
		file.add(load);

		// add 'Save' item
		wasEnabled = false;
		if (this.saveItem != null) {
			// window has just been refreshed
			wasEnabled = this.saveItem.isEnabled();
		}

		this.saveItem = new JMenuItem(Language.getInstance().get("menubar.file.save.title"));
		this.saveItem.setEnabled(wasEnabled);
		this.saveItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().save();
			}
		});
		file.add(this.saveItem);

		// add separator
		file.addSeparator();

		// create and add 'Exit' menu item
		final JMenuItem exit = new JMenuItem(Language.getInstance().get("menubar.file.exit.title"));
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getCanvasController().cleanUp();
				System.exit(0);
			}
		});
		file.add(exit);
		this.add(file);
		this.components.add(file);
	}

	/**
	 * Creates the 'Edit' menu in this {@link MenuBar} instance and adds the menu item 'Settings' to it.
	 */
	private void createEditMenu() {

		// create menu 'Settings'
		final JMenu settings = new JMenu(Language.getInstance().get("menubar.edit.title"));

		// create and add 'Search menu item'
		boolean wasEnabled = false;
		if (this.searchItem != null) {
			// window has just been refreshed
			wasEnabled = this.searchItem.isEnabled();
		}
		this.searchItem = new JMenuItem(Language.getInstance().get("menubar.search.title"));
		this.searchItem.setEnabled(wasEnabled);

		this.searchItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().openSearchMenu();
			}
		});
		settings.add(this.searchItem);

		// create and add 'Settings' menu item
		final JMenuItem options = new JMenuItem(Language.getInstance().get("menubar.settings.title"));
		options.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().openOptions();
			}
		});
		settings.add(options);
		this.add(settings);
		this.components.add(settings);
	}

	/**
	 * Creates the 'Snapshot' menu in this {@link MenuBar} instance and adds the menu items 'Save Snapshot' and 'Print Snapshot' to it.
	 */
	private void createSnapshotMenu() {

		// create menu 'Functions'
		final JMenu functions = new JMenu(Language.getInstance().get("menubar.snapshot.title"));

		// create and add 'Save Snapshot' menu item
		final JMenuItem saveSnapshot = new JMenuItem(Language.getInstance().get("menubar.snapshot.save.title"));
		saveSnapshot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().saveSnapshot();
			}
		});
		functions.add(saveSnapshot);

		// create and add 'Save Snapshot' menu item
		final JMenuItem print = new JMenuItem(Language.getInstance().get("menubar.snapshot.print.title"));
		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().printSnapshot();
			}
		});

		functions.add(print);
		this.add(functions);
		this.components.add(functions);
	}

	/**
	 * Creates the 'Relations' menu in this {@link MenuBar} instance and adds the menu items 'Show local Relations', 'Show global Relations' and 'Hide all Relations'
	 * to it.
	 */
	private void createRelationsMenu() {

		// create menu 'Functions'
		final JMenu relations = new JMenu(Language.getInstance().get("menubar.relations.title"));

		// create and add 'Show Local Relations' menu item
		boolean wasEnabled = false;
		if (this.showLocalRelationsItem != null) {
			// window has just been refreshed
			wasEnabled = this.showLocalRelationsItem.isEnabled();
		}

		this.showLocalRelationsItem = new JMenuItem(Language.getInstance().get("menubar.relations.show.local.title"));
		this.showLocalRelationsItem.setEnabled(wasEnabled);
		this.showLocalRelationsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().showLocalRelations();
			}
		});
		relations.add(this.showLocalRelationsItem);

		// create and add 'Show Global Relations' menu item
		wasEnabled = false;
		if (this.showGlobalRelationsItem != null) {
			// window has just been refreshed
			wasEnabled = this.showGlobalRelationsItem.isEnabled();
		}

		this.showGlobalRelationsItem = new JMenuItem(Language.getInstance().get("menubar.relations.show.global.title"));
		this.showGlobalRelationsItem.setEnabled(wasEnabled);
		this.showGlobalRelationsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().showGlobalRelations();
			}
		});
		relations.add(this.showGlobalRelationsItem);

		// create and add 'Hide All Relations' menu item
		wasEnabled = false;
		if (this.hideAllRelationsItem != null) {
			// window has just been refreshed
			wasEnabled = this.hideAllRelationsItem.isEnabled();
		}

		this.hideAllRelationsItem = new JMenuItem(Language.getInstance().get("menubar.relations.hide.title"));
		this.hideAllRelationsItem.setEnabled(wasEnabled);
		this.hideAllRelationsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().hideAllRelations();
			}
		});
		relations.add(this.hideAllRelationsItem);

		this.add(relations);
		this.components.add(relations);
	}

	/**
	 * Creates the 'Help' menu in this {@link MenuBar} instance and adds the menu item 'User Interaction'
	 * to it.
	 */
	private void createHelpMenu() {

		// create menu 'Functions'
		final JMenu help = new JMenu(Language.getInstance().get("menubar.help.title"));

		final JMenuItem interactionItem = new JMenuItem(Language.getInstance().get("menubar.help.interaction.title"));
		interactionItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				Logic.getInstance().getMenuBarController().openHelpMenu();
			}
		});

		help.add(interactionItem);
		this.add(help);
		this.components.add(help);
	}

	/**
	 * Enables or disables the statics menu ({@link #staticsItem}) item.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setStaticsItemEnabled(final boolean enable) {

		if (this.staticsItem != null) {
			this.staticsItem.setEnabled(enable);
		}
	}

	/**
	 * Enables or disables the save menu ({@link #saveItem}) item.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setSaveItemEnabled(final boolean enable) {

		if (this.saveItem != null) {
			this.saveItem.setEnabled(enable);
		}
	}

	/**
	 * Enables or disables the dynamics menu ({@link #showLocalRelationsItem}) item.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setShowLocalRelationsItemEnabled(final boolean enable) {

		if (this.showLocalRelationsItem != null) {
			this.showLocalRelationsItem.setEnabled(enable);
		}
	}

	/**
	 * Enables or disables the dynamics menu ({@link #showGlobalRelationsItem}) item.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setShowGlobalRelationsItemEnabled(final boolean enable) {

		if (this.showGlobalRelationsItem != null) {
			this.showGlobalRelationsItem.setEnabled(enable);
		}
	}

	/**
	 * Enables or disables the dynamics menu ({@link #hideAllRelationsItem}) item.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setRelationsHideItemEnabled(final boolean enable) {

		if (this.hideAllRelationsItem != null) {
			this.hideAllRelationsItem.setEnabled(enable);
		}
	}

	/**
	 * Enables or disables the search menu ({@link #searchItem}) item.
	 *
	 * @param enable
	 *            {@code True} to enable, {@code false} to disable.
	 */
	public void setSearchItemEnabled(final boolean enable) {

		if (this.searchItem != null) {
			this.searchItem.setEnabled(enable);
		}
	}

}

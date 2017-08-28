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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.j3d.utils.geometry.Primitive;

import data.statics.SClass;
import data.statics.SPackage;
import javacity.configuration.Language;
import javacity.logic.Logic;
import javacity.models.data.DataModel;
import metaphor.types.VisualEntity;

/**
 * A search window allowing the user to search for specific packages or classes in the visualization.
 *
 * @author pdo
 *
 */
public class SearchWindow extends JDialog {

	// =========================== Attributes =================================

	/** The generated {@code serialVersionUID} for serialization. */
	private static final long serialVersionUID = 8992842225461138070L;

	/** A list containing all menu components currently added to this menu bar. */
	private final List<Component> components = new LinkedList<Component>();

	/** The {@link GridBagConstraints} object used to communicate the position and layout of all components to add to this {@link HelpWindow}. */
	private GridBagConstraints constants = new GridBagConstraints();

	/** The {@link DataModel} instance in which any class or package is searched. */
	private final DataModel model;

	/** The label indicating that the latest search entry was not found. */
	private JLabel notFoundLabel = null;

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link SearchWindow} instance to search for packages and classes in the specified {@link DataModel} instance.
	 *
	 * @param dataModel
	 *            The data model in which any class or package is searched.
	 * @throws IllegalArgumentException
	 *             If the data model passed in is {@code null}.
	 */
	public SearchWindow(final DataModel dataModel) throws IllegalArgumentException {

		super();

		if (dataModel == null) {
			throw new IllegalArgumentException("You cannot search for entities in a null model.");
		}
		this.model = dataModel;

		// set window properties
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setAlwaysOnTop(true);

		// set layout
		final GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		this.setFrameDesign();

		// add components
		this.rebuild();
	}

	// ============================ Methods ===================================

	/**
	 * Sets the design of this {@link SearchWindow}. I.e. it sets the window's size and centers the window on screen. Furthermore, it sets the window title in the
	 * title bar, the frame's closing operation, and resizing capabilities.
	 */
	private void setFrameDesign() {

		// fixed size
		this.setSize(450, 200);
		this.setResizable(false);

		// centering
		this.setLocationRelativeTo(null);

		// close options and title
		this.setTitle(Language.getInstance().get("menubar.search.title"));
	}

	/**
	 * Rebuilds this search window. It will rebuild all components of this dialog frame.
	 */
	public void rebuild() {

		// remove old components
		for (Component comp : this.components) {
			this.remove(comp);
		}
		this.components.clear();
		this.revalidate();

		// reset grid constants
		this.constants.gridx = 0;
		this.constants.gridy = 0;
		this.constants.fill = GridBagConstraints.HORIZONTAL;
		this.notFoundLabel = null;

		// add components
		this.addSearchMask();
		this.revalidate();
		this.repaint();
	}

	/**
	 * Adds the search mask to the position defined in {@link #constants}.
	 */
	private void addSearchMask() {

		// add label
		this.addLabel(Language.getInstance().get("menubar.search.text"));
		this.addEmptyLine();

		// add text field
		final JTextField textField = new JTextField();
		textField.setColumns(100);
		textField.setMinimumSize(new Dimension(100, 19));
		this.add(textField, this.constants);
		this.components.add(textField);
		this.addEmptyLine();

		// add search button
		final JButton button = new JButton(Language.getInstance().get("menubar.search.doSearch"));
		button.addActionListener(new SearchListener(textField));
		this.components.add(button);
		this.add(button, this.constants);
		this.constants.gridy++;
		this.addEmptyLine();
	}

	/**
	 * Adds an empty line at the position defined in {@link #constants}.
	 */
	private void addEmptyLine() {

		final JLabel dummy = new JLabel(" ");
		this.components.add(dummy);
		this.add(dummy, this.constants);
		this.constants.gridy++;
	}

	/**
	 * Adds a new label containing the specified text at the position defined in {@link #constants}.
	 *
	 * @param text
	 *            The text of the label to display.
	 * @return The label just added.
	 */
	private JLabel addLabel(final String text) {

		final JLabel label = new JLabel(text);
		this.components.add(label);
		this.add(label, this.constants);
		this.constants.gridy++;
		return label;
	}

	/**
	 * A search listener listening to the 'search' button and initiating the search when clicked on it.
	 *
	 * @author pdo
	 *
	 */
	private final class SearchListener implements ActionListener {

		/** The text field to whose text this search listener reacts to. */
		private final JTextField textField;

		/**
		 * Creates a new {@link SearchListener} instance reacting to the inputs in the specified text field.
		 *
		 * @param field
		 *            The text field to whose text this search listener reacts to.
		 */
		private SearchListener(final JTextField field) {

			this.textField = field;
		}

		@Override
		public void actionPerformed(final ActionEvent event) {
			final SPackage pack = SearchWindow.this.model.getPackageByName(this.textField.getText());
			if (pack == null) {
				final SClass clazz = SearchWindow.this.model.getClassByKiekerClassSignature(this.textField.getText());
				if (clazz == null) {
					if (SearchWindow.this.notFoundLabel == null) {
						SearchWindow.this.notFoundLabel = SearchWindow.this.addLabel(Language.getInstance().get("menubar.search.doSearch.notFound"));
						SearchWindow.this.notFoundLabel.setForeground(Color.RED);
						SearchWindow.this.revalidate();
					}
				} else {
					Logic.getInstance().getSelectionController()
							.select((Primitive) ((VisualEntity) clazz.getInstances().get(0).getMetaphorObject()).getJava3dObject());
					SearchWindow.this.setVisible(false);
					if (SearchWindow.this.notFoundLabel != null) {
						SearchWindow.this.remove(SearchWindow.this.notFoundLabel);
						SearchWindow.this.components.remove(SearchWindow.this.notFoundLabel);
					}
				}
			} else {
				Logic.getInstance().getSelectionController().select((Primitive) ((VisualEntity) pack.getMetaphorObject()).getJava3dObject());
				SearchWindow.this.setVisible(false);
				if (SearchWindow.this.notFoundLabel != null) {
					SearchWindow.this.remove(SearchWindow.this.notFoundLabel);
					SearchWindow.this.components.remove(SearchWindow.this.notFoundLabel);
				}
			}
		}
	}

}

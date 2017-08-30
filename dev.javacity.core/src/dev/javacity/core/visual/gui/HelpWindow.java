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

package dev.javacity.core.visual.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dev.javacity.core.configuration.Language;


/**
 * A help window informing the user about the user interaction functions in Synchrovis and how to invoke them.
 *
 * @author pdo
 *
 */
public class HelpWindow extends JDialog {

	/** The generated {@code serialVersionUID} for serialization. */
	private static final long serialVersionUID = 8992842225461138070L;

	/** A list containing all menu components currently added to this menu bar. */
	private final List<Component> components = new LinkedList<Component>();

	/** The {@link GridBagConstraints} object used to communicate the position and layout of all components to add to this {@link HelpWindow}. */
	private GridBagConstraints constants = new GridBagConstraints();

	/**
	 * Creates a new {@link HelpWindow} instance.
	 */
	public HelpWindow() {

		super();

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

	/**
	 * Sets the design of this {@link HelpWindow}. I.e. it sets the window's size and centers the window on screen. Furthermore, it sets the window title in the
	 * title bar, the frame's closing operation, and resizing capabilities.
	 */
	private void setFrameDesign() {

		// fixed size
		this.setSize(650, 350);
		this.setResizable(false);

		// centering
		this.setLocationRelativeTo(null);

		// close options and title
		this.setTitle(Language.getInstance().get("menubar.help.interaction.title"));
	}

	/**
	 * Rebuilds this help window. It will rebuild all components of this dialog frame.
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

		// add components
		this.addHelpText();
		this.revalidate();
		this.repaint();
	}

	/**
	 * Adds the entire help text at the position defined in {@link #constants}.
	 */
	private void addHelpText() {

		final String helpText = Language.getInstance().get("menubar.help.interaction.text");
		// final JTextArea text = new JTextArea();
		final String[] sections = helpText.split("\\n\\n");

		// display text
		boolean isHeadline = true;
		boolean isFirstLine = true;
		for (String section : sections) {
			final String[] lines = section.split("\\n");
			for (String line : lines) {

				if (isHeadline) {
					final JLabel field = this.addLabel(line);
					field.setHorizontalAlignment(JTextField.CENTER);
					field.setFont(new java.awt.Font(field.getFont().getName(), field.getFont().getStyle(), 20));
					for (int i = 0; i < 2; i++) {
						this.addEmptyLine();
					}
					isHeadline = false;
				} else if (isFirstLine) {
					this.addEmptyLine();
					final JLabel field = this.addLabel(line);
					field.setFont(new java.awt.Font("Dialog", Font.BOLD, 13));
					this.addEmptyLine();
					isFirstLine = false;
				} else {
					this.addLabel("     " + line);
				}
			}
			isFirstLine = true;
		}
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

}

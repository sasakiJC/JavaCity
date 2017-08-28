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

package javacity.visual.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javacity.configuration.Language;
import javacity.configuration.Language.SupportedLanguages;
import javacity.configuration.VisualProperties;
import javacity.logic.SettingsListeners;
import javacity.utils.StringUtils;
import javacity.visual.gui.utils.GuiUtils;

/**
 * The settings window allowing the user to change selected visualization and application properties.
 *
 * @author pdo
 *
 */
public final class SettingsWindow extends JDialog {

	// =========================== Attributes =================================

	/** The generated {@code serialVersionUID} for serialization. */
	private static final long serialVersionUID = -4143795419855635095L;

	/** The default headline font size used in {@link #addHeadline(String, int)}. */
	private static final int HEADLINE_FONTSIZE = 20;

	/** The default column width used in this settings window. */
	private static final int EMPTY_COLUMN_WIDTH = 12;

	/** The default number of columns in a {@link JTextField} component of this settings window. */
	private static final int TEXTFIELD_COLUMNS = 5;

	/** The number of effectively used rows in this {@link SettingsWindow}. */
	private int effRowCount = 0;

	/** The {@link GridBagConstraints} object used to communicate the position and layout of all components to add to this {@link SettingsWindow}. */
	private GridBagConstraints constants = new GridBagConstraints();

	/** A list of all components currently added to this dialog window. */
	private final List<Component> components = new LinkedList<Component>();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link SettingsWindow} instance.
	 */
	public SettingsWindow() {

		super();

		// preparation
		GuiUtils.setJColorChooserDefaultLocale();

		// set window properties
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(new GridBagLayout());

		// set size and position on screen
		this.setSize(770, 835);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// add components
		this.rebuild();
	}

	// ============================ Methods ===================================

	/**
	 * Reloads this settings window. It will rebuild all components of this dialog frame and reload all property settings saved in {@link VisualProperties} and
	 * {@link Configuration} respectively.
	 */
	public void rebuild() {

		// remove old components
		for (Component comp : this.components) {
			this.remove(comp);
		}
		this.components.clear();
		this.effRowCount = 0;

		// reset frame title
		this.setTitle(Language.getInstance().get("menubar.settings.title"));

		// reset grid constants
		this.constants.gridx = 0;
		this.constants.gridy = 0;

		// reload components
		this.addEmptyColumn(12);
		this.addVisualSettings();
		this.addVerticalSeparator(2 * EMPTY_COLUMN_WIDTH);
		this.addApplicationSettings();
		this.addEmptyColumn(EMPTY_COLUMN_WIDTH);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Adds all 'visual settings' section to this {@link SettingsWindow} allowing the user to change the look and feel of the city on screen.
	 */
	private void addVisualSettings() {

		this.constants.fill = GridBagConstraints.HORIZONTAL;
		this.addHeadline(Language.getInstance().get("menubar.settings.visualization.title"), 3);

		// convert visual key set to string list and sort it
		final List<String> keySet = new LinkedList<String>();
		for (Object obj : VisualProperties.getInstance().getKeySet()) {
			keySet.add((String) obj);
		}
		Collections.sort(keySet);

		// add concrete visualization options
		String prevKey = "";
		for (String key : keySet) {
			if (!prevKey.isEmpty() && !StringUtils.cutFromFirst(prevKey, '.').equals(StringUtils.cutFromFirst(key, '.'))) {
				this.addHorizontalSeparator(2);
			}
			this.addVisualSettingsOption(key);
			prevKey = key;
		}

		this.addNotification();
		this.constants.gridx += 3;
		this.constants.gridy = 0;
	}

	/**
	 * Adds the window components allowing the user to change the setting defined by the given {@link VisualProperties} key.
	 *
	 * @param key
	 *            The key to create the component for.
	 */
	private void addVisualSettingsOption(final String key) {

		// add label
		this.constants.gridx = 1;
		this.constants.gridwidth = 1;
		this.addLabel(Language.getInstance().get(key) + "     ");

		final String value = VisualProperties.getInstance().get(key);
		try {
			StringUtils.parseFloatArray(value);
			// value represents a color: add color label
			this.addColorLabel(key);
		} catch (IllegalArgumentException e) {
			// add regular text field
			this.addTextField(key);
		}
		this.effRowCount++;
		this.constants.gridx = 1;
		this.constants.gridy++;
	}

	/**
	 * Adds a new text field to this window at the position defined in {@link #constants} allowing the user to type in a new value for the property identified by the
	 * specified key. By default, it will contain the current properties value.
	 *
	 * @param key
	 *            The key of the property to create a new text field for.
	 */
	private void addTextField(final String key) {

		final JTextField textField = new JTextField(VisualProperties.getInstance().get(key));
		textField.setColumns(TEXTFIELD_COLUMNS);
		textField.setMinimumSize(new Dimension(40, 19));
		textField.addKeyListener(SettingsListeners.createTextListener(key));

		this.add(textField, this.constants);
		this.components.add(textField);
	}

	/**
	 * Adds a new color label to this window at the position defined in {@link #constants} allowing the user to actually see the current color value of the specified
	 * key.
	 *
	 * @param key
	 *            The key of the color property to create the new color label for.
	 */
	private void addColorLabel(final String key) {

		final float[] floats = StringUtils.parseFloatArray(VisualProperties.getInstance().get(key));
		final JTextField colorField = new JTextField();
		colorField.setColumns(TEXTFIELD_COLUMNS);
		colorField.setBackground(new Color(floats[0] / 256, floats[1] / 256, floats[2] / 256));
		colorField.setEditable(false);
		this.add(colorField, this.constants);
		this.components.add(colorField);

		// create 'choose color' button
		final JButton button = new JButton(Language.getInstance().get("menubar.settings.colorchooser.title"));
		button.addActionListener(SettingsListeners.createColorListener(colorField, key));

		this.constants.gridx++;
		this.add(button, this.constants);
		this.components.add(button);
	}

	/**
	 * Adds the 'application settings' section to this settings window allowing the user to change the more general application settings.
	 */
	private void addApplicationSettings() {

		this.addHeadline(Language.getInstance().get("menubar.settings.application.title"), 2);
		this.addLanguageOption();
		this.addAntiAliasingOption();
		this.addEmptyLine();
		//this.addEmptyLine();
		this.addHorizontalSeparator(2);

		this.addEmptyLine();

		this.addHorizontalSeparator(2);

		this.addEmptyLine();
		this.addEmptyLine();
		this.addHorizontalSeparator(2);
		this.addRestoreDefaultsButton();

		this.constants.gridx += 3;
	}

	/**
	 * Adds the check box allowing the user to turn anti-aliasing on and off to this window at the position defined in {@link #constants}.
	 */
	private void addAntiAliasingOption() {

		this.addLabel(Language.getInstance().get("menubar.settings.antialiasing"));
		final JCheckBox checkBox = new JCheckBox();
		checkBox.setSelected(Configuration.getInstance().isAntiAliasingEnabled());
		checkBox.addActionListener(SettingsListeners.createAntiAliasingListener());

		this.add(checkBox, this.constants);
		this.components.add(checkBox);
		this.constants.gridx--;
		this.constants.gridy++;
	}


	/**
	 * Adds the combo box allowing the user to change the current GUI's language to this window at the position defined in {@link #constants}.
	 */
	private void addLanguageOption() {

		this.addLabel(Language.getInstance().get("language.title") + "     ");
		final JComboBox<String> comboBox = new JComboBox<String>();
		for (SupportedLanguages lang : SupportedLanguages.values()) {
			comboBox.addItem(Language.getInstance().get("language." + lang.name().toLowerCase()));
		}
		comboBox.setSelectedIndex(Configuration.getInstance().getGUILanguage().ordinal());
		comboBox.addActionListener(SettingsListeners.createLanguageListener(this, comboBox));

		this.add(comboBox, this.constants);
		this.components.add(comboBox);
		this.constants.gridx--;
		this.constants.gridy++;
	}

	/**
	 * Adds a button to this settings window instantly restoring the default application and visualization properties when clicked on it.
	 */
	private void addRestoreDefaultsButton() {

		final JButton button = new JButton(Language.getInstance().get("menubar.settings.reset.title"));
		button.addActionListener(SettingsListeners.createDefaultsListener(this));
		this.constants.gridwidth = 2;
		this.add(button, this.constants);
		this.components.add(button);
		this.constants.gridwidth = 1;
		this.constants.gridy++;
	}

	/**
	 * Adds the given string as a headline to this window. It will be placed at the top of this window width a font height of {@value #HEADLINE_FONTSIZE}.
	 *
	 * @param headline
	 *            The string to add as a headline to this window.
	 * @param columnSpan
	 *            The number of columns the given headline is supposed to span.
	 */
	private void addHeadline(final String headline, final int columnSpan) {

		this.constants.gridy = 0;
		this.addEmptyLine();
		final JLabel label = new JLabel(headline, SwingConstants.CENTER);
		label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), HEADLINE_FONTSIZE));
		this.constants.gridwidth = columnSpan;
		this.add(label, this.constants);
		this.components.add(label);
		this.constants.gridwidth = 1;
		this.constants.gridy++;
		this.addEmptyLine();
		this.addEmptyLine();
		this.effRowCount -= 4; // don't consider headline as effective rows
	}

	/**
	 * Adds the notification identified by the key 'menubar.settings.notification' in the language files to this settings window. It will be placed directly in the
	 * center of this window.
	 */
	private void addNotification() {

		this.addEmptyLine();
		this.addEmptyLine();
		final JLabel notification = new JLabel(Language.getInstance().get("menubar.settings.notification"), SwingConstants.CENTER);
		notification.setForeground(Color.RED);
		this.constants.gridwidth = 8;
		this.add(notification, this.constants);
		this.components.add(notification);
		this.constants.gridwidth = 1;
		this.constants.gridy++;
		this.addEmptyLine();
	}

	/**
	 * Adds an empty line at the position defined in {@link #constants}.
	 */
	private void addEmptyLine() {

		this.addLabel(" ");
		this.constants.gridx--;
		this.constants.gridy++;
		this.effRowCount++;
	}

	/**
	 * Adds a new label containing the specified text at the position defined in {@link #constants}.
	 *
	 * @param text
	 *            The text of the label to display.
	 */
	private void addLabel(final String text) {

		final JLabel label = new JLabel(text);
		this.add(label, this.constants);
		this.components.add(label);
		this.constants.gridx++;
	}

	/**
	 * Adds a horizontal {@link JSeparator} of given length at the position defined in {@link #constants}.
	 *
	 * @param length
	 *            The length of the separator to add.
	 */
	private void addHorizontalSeparator(final int length) {

		this.constants.gridwidth = length;
		final JSeparator separator = new JSeparator();
		this.add(separator, this.constants);
		this.components.add(separator);
		this.constants.gridwidth = 1;
		this.constants.gridy++;
		this.effRowCount++;
	}

	/**
	 * Adds a vertical {@link JSeparator} at the position defined in {@link #constants}.
	 *
	 * @param width
	 *            The width in rows this vertical separator is supposed to span.
	 */
	private void addVerticalSeparator(final int width) {

		this.constants.fill = GridBagConstraints.VERTICAL;
		this.constants.gridheight = this.effRowCount;
		this.constants.gridy = 2;

		final JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		this.add(separator, this.constants);
		this.components.add(separator);
		final StringBuffer buffer = new StringBuffer(width);
		for (int i = 0; i < width; i++) {
			buffer.append(' ');
		}
		this.addLabel(buffer.toString());
		this.constants.gridheight = 1;
		this.constants.fill = GridBagConstraints.HORIZONTAL;
		this.constants.gridy = 0;
	}

	/**
	 * Adds an empty column of given width to this window at the position defined in {@link #constants}.
	 *
	 * @param width
	 *            The width of the empty column to add.
	 */
	private void addEmptyColumn(final int width) {

		final StringBuffer buffer = new StringBuffer(width);
		for (int i = 0; i < width; i++) {
			buffer.append(' ');
		}
		this.addLabel(buffer.toString());
	}

}

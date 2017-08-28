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
 * traceViewLayout関連の削除
 */


package javacity.logic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import javacity.configuration.Language;
import javacity.configuration.Language.SupportedLanguages;
import javacity.configuration.VisualProperties;
import javacity.visual.gui.SettingsWindow;
import javacity.visual.gui.utils.GuiUtils;

/**
 * A container class containing custom listeners reacting to user inputs in the {@link SettingsWindow}.
 *
 * @author pdo
 *
 */
public final class SettingsListeners {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(SettingsListeners.class);

	/** A dummy instance used for the instantiation of concrete listeners only. */
	private static final SettingsListeners INSTANCE = new SettingsListeners();

	// ========================== Constructor =================================

	/**
	 * This class is not intended for instantiation since it contains custom listeners for the {@link SettingsWindow} only.
	 */
	private SettingsListeners() {}

	// ============================ Methods ===================================

	/**
	 * Creates a new {@link DefaultsListener} instance with the given {@link SettingsWindow} object.
	 *
	 * @param settings
	 *            The settings window to be rebuilt when the listener fires.
	 * @return The new instance.
	 * @throws IllegalArgumentException
	 *             If the settings window passed in is {@code null}.
	 */
	public static DefaultsListener createDefaultsListener(final SettingsWindow settings) throws IllegalArgumentException {
		return INSTANCE.new DefaultsListener(settings);
	}

	/**
	 * Creates a new {@link LanguageListener} instance with the given {@link SettingsWindow} and {@link JComboBox} object.
	 *
	 * @param settings
	 *            The settings window to be rebuilt when the listener fires.
	 * @param box
	 *            The combo box to be updated when the listener fires.
	 * @return The new instance.
	 * @throws IllegalArgumentException
	 *             If the settings window or the combo box passed in is {@code null}.
	 */
	public static LanguageListener createLanguageListener(final SettingsWindow settings, final JComboBox<String> box) throws IllegalArgumentException {
		return INSTANCE.new LanguageListener(settings, box);
	}

	/**
	 * Creates a new {@link AntiAliasingListener} instance.
	 *
	 * @return The new instance.
	 */
	public static AntiAliasingListener createAntiAliasingListener() {
		return INSTANCE.new AntiAliasingListener();
	}


	/**
	 * Creates a new {@link ColorListener} instance with the given properties key and {@link JTextField} object. This class is not intended for
	 * instantiation from outside of the surrounding class.
	 *
	 * @param key
	 *            The visualization property identifying the concrete setting to be applied when this listener fires.
	 * @param field
	 *            The text field whose background color is be updated when the listener fires.
	 * @return The new instance.
	 * @throws IllegalArgumentException
	 *             If the key or text field passed in is {@code null}.
	 */
	public static ColorListener createColorListener(final JTextField field, final String key) throws IllegalArgumentException {
		return INSTANCE.new ColorListener(key, field);
	}

	/**
	 * Creates a new {@link TextListener} instance with the given properties key. This class is not intended for instantiation from outside of the surrounding
	 * class.
	 *
	 * @param key
	 *            The visualization property identifying the concrete setting to be applied when this listener fires.
	 * @return The new instance.
	 * @throws IllegalArgumentException
	 *             If the key passed in is {@code null}.
	 */
	public static TextListener createTextListener(final String key) throws IllegalArgumentException {
		return INSTANCE.new TextListener(key);
	}

	// ========================== Inner Classes ===============================

	/**
	 * A defaults listener listening for the event received when the user presses the 'Restore Defaults' button to perform the corresponding action.
	 *
	 * @author pdo
	 *
	 */
	private final class DefaultsListener implements ActionListener {

		/** The settings window to be rebuilt when the listener fires. */
		private final SettingsWindow window;

		/**
		 * Creates a new {@link DefaultsListener} instance with the given {@link SettingsWindow} object. This class is not intended for instantiation from outside of
		 * the surrounding class.
		 *
		 * @param settings
		 *            The settings window to be rebuilt when the listener fires.
		 * @throws IllegalArgumentException
		 *             If the settings window passed in is {@code null}.
		 */
		private DefaultsListener(final SettingsWindow settings) throws IllegalArgumentException {

			if (settings == null) {
				throw new IllegalArgumentException("You cannot pass in a null settings window.");
			}

			this.window = settings;
		}

		@Override
		public void actionPerformed(final ActionEvent event) {
			// restore defaults
			VisualProperties.getInstance().restoreDefaults();
			Configuration.getInstance().restoreDefaults();
			Language.getInstance().reload();
			Logic.getInstance().getMenuBarController().rebuild();
			Logic.getInstance().getMenuBarController().rebuildHelpWindow();
			GuiUtils.setJColorChooserDefaultLocale();
			GuiUtils.setJFileChooserDefaultLocale();
			this.window.rebuild();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Successfully restored all default properties.");
			}
		}
	}

	/**
	 * A defaults listener listening for the event received when the user changes the language setting to perform the corresponding action.
	 *
	 * @author pdo
	 *
	 */
	private final class LanguageListener implements ActionListener {

		/** The settings window to be rebuilt when the listener fires. */
		private final SettingsWindow window;

		/** The combo box to be updated when the listener fires. */
		private final JComboBox<String> comboBox;

		/**
		 * Creates a new {@link LanguageListener} instance with the given {@link SettingsWindow} and {@link JComboBox} object. This class is not intended for
		 * instantiation from outside of the surrounding class.
		 *
		 * @param settings
		 *            The settings window to be rebuilt when the listener fires.
		 * @param box
		 *            The combo box to be updated when the listener fires.
		 * @throws IllegalArgumentException
		 *             If the settings window or the combo box passed in is {@code null}.
		 */
		private LanguageListener(final SettingsWindow settings, final JComboBox<String> box) throws IllegalArgumentException {

			if (settings == null) {
				throw new IllegalArgumentException("You cannot pass in a null settings window.");
			}
			if (box == null) {
				throw new IllegalArgumentException("You cannot update a null combo box.");
			}

			this.window = settings;
			this.comboBox = box;
		}

		@Override
		public void actionPerformed(final ActionEvent event) {
			final SupportedLanguages lang = SupportedLanguages.values()[((JComboBox<String>) this.comboBox).getSelectedIndex()];
			Configuration.getInstance().setGUILanguage(lang);
			Logic.getInstance().getMenuBarController().rebuild();
			Logic.getInstance().getMenuBarController().rebuildHelpWindow();
			Logic.getInstance().getMenuBarController().rebuildSearchWindow();
			GuiUtils.setJColorChooserDefaultLocale();
			GuiUtils.setJFileChooserDefaultLocale();
			this.window.rebuild();

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Successfully set language setting to " + lang.name() + ".");
			}
		}
	}


	/**
	 * A defaults listener listening for the event received when the user changes the anti-aliasing setting to perform the corresponding action.
	 *
	 * @author pdo
	 *
	 */
	private final class AntiAliasingListener implements ActionListener {

		/**
		 * Creates a new {@link AntiAliasingListener} instance. This class is not intended for instantiation from outside of the surrounding class.
		 */
		private AntiAliasingListener() { /* nothing to do */}

		@Override
		public void actionPerformed(final ActionEvent event) {
			final boolean activate = ((JCheckBox) event.getSource()).isSelected();
			Configuration.getInstance().setAntiAliasing(activate);
			Logic.getInstance().getCanvasController().setAntiAliasingEnabled(activate);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Successfully set anti aliasing setting to " + Boolean.toString(activate) + ".");
			}
		}
	}


	/**
	 * A defaults listener listening for the event received when the user changes a color setting in the visualization section to perform the corresponding action.
	 *
	 * @author pdo
	 *
	 */
	private final class ColorListener implements ActionListener {

		/** The visualization property identifying the concrete setting to be applied when this listener fires. */
		private final String key;

		/** The text field whose background color is be updated when the listener fires. */
		private final JTextField field;

		/**
		 * Creates a new {@link ColorListener} instance with the given properties key and {@link JTextField} object. This class is not intended for
		 * instantiation from outside of the surrounding class.
		 *
		 * @param theKey
		 *            The visualization property identifying the concrete setting to be applied when this listener fires.
		 * @param textField
		 *            The text field whose background color is be updated when the listener fires.
		 * @throws IllegalArgumentException
		 *             If the key or text field passed in is {@code null}.
		 */
		private ColorListener(final String theKey, final JTextField textField) throws IllegalArgumentException {

			if (theKey == null) {
				throw new IllegalArgumentException("You cannot pass in a null key.");
			}
			if (textField == null) {
				throw new IllegalArgumentException("You cannot update a null text field.");
			}

			this.key = theKey;
			this.field = textField;
		}

		@Override
		public void actionPerformed(final ActionEvent event) {
			// add color chooser
			final Color color = JColorChooser.showDialog(null, Language.getInstance().get("menubar.settings.colorchooser.title"), Color.WHITE);
			if (color != null) {
				this.field.setBackground(color);
				VisualProperties.getInstance().setColorValue(this.key, color);

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Successfully set color value " + color.toString() + " to key " + this.key + ".");
				}
			}
		}
	}

	/**
	 * A defaults listener listening for the event received when the user changes a text value setting in the visualization section to perform the corresponding
	 * action.
	 *
	 * @author pdo
	 *
	 */
	private final class TextListener implements KeyListener {

		/** The visualization property identifying the concrete setting to be applied when this listener fires. */
		private final String key;

		/**
		 * Creates a new {@link TextListener} instance with the given properties key. This class is not intended for instantiation from outside of the surrounding
		 * class.
		 *
		 * @param theKey
		 *            The visualization property identifying the concrete setting to be applied when this listener fires.
		 * @throws IllegalArgumentException
		 *             If the key passed in is {@code null}.
		 */
		private TextListener(final String theKey) throws IllegalArgumentException {

			if (theKey == null) {
				throw new IllegalArgumentException("You cannot pass in a null key.");
			}

			this.key = theKey;
		}

		@Override
		public void keyReleased(final KeyEvent event) {
			final JTextField textField = (JTextField) event.getSource();
			try {
				final float value = Float.valueOf(textField.getText());
				VisualProperties.getInstance().setFloatValue(value, this.key);
				textField.setBackground(Color.WHITE);

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Successfully set float value " + value + " to key " + this.key + ".");
				}
			} catch (IllegalArgumentException ex) {
				textField.setBackground(Color.RED);
			}
		}

		@Override
		public void keyTyped(final KeyEvent event) { /* nothing to do */}

		@Override
		public void keyPressed(final KeyEvent event) { /* nothing to do */}
	}
}

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

package javacity.configuration;

import java.util.Properties;

import org.apache.log4j.Logger;

import javacity.configuration.Language.SupportedLanguages;

/**
 * A utility class to read data from the 'config.properties' file.
 *
 * @author pdo
 *
 */
public final class Configuration extends AbstractPropertiesHandler {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(Configuration.class);

	// ========================== Constructor =================================

	/**
	 * Private default constructor of this class. Instances not constructible from outside.
	 */
	private Configuration() {

		super(FileSystem.getInstance().getConfigFile());
	}

	// ============================ Methods ===================================

	@Override
	protected void initDefaultProperties() {

		if (super.defaultProperties == null) {

			final Properties defaults = new Properties();

			defaults.put("system.language", SupportedLanguages.DE.name());
			defaults.put("visualization.antiAliasingEnabled", Boolean.FALSE.toString());
//			defaults.put("traceviewer.layout", TreeStructure.CHRONOLOGICAL.name());
//			defaults.put("visualization.showPathEnabled", Boolean.FALSE.toString());
//			defaults.put("menubar.settings.replay.step", "1000");
//			defaults.put("menubar.settings.jump.interval", "2000");

			super.defaultProperties = defaults;
		}
	}

	/**
	 * Returns the GUI language property from the configuration file. Default value will be loaded, if the property does not exist.
	 *
	 * @return The GUI language property.
	 */
	public SupportedLanguages getGUILanguage() {

		final String key = "system.language";
		String value = this.get(key);
		try {
			SupportedLanguages.valueOf(value);
		} catch (IllegalArgumentException e) {
			LOGGER.error("Found illegal property value for key " + key + ": " + value + ". Loading default.");
			value = this.handleError(key);
		}
		return SupportedLanguages.valueOf(value);
	}

	/**
	 * Set the GUI language property value, immediately save any changes to disk and reload the language file.
	 *
	 * @param lang
	 *            The GUI language property value.
	 * @throws IllegalArgumentException
	 *             If the language passed in is {@code null}.
	 */
	public void setGUILanguage(final SupportedLanguages lang) throws IllegalArgumentException {

		if (lang == null) {
			throw new IllegalArgumentException("You cannot set a null value.");
		}

		super.properties.setProperty("system.language", lang.name());
		save();
		Language.getInstance().reload();
	}

	/**
	 * Sets the 'visualization.antiAliasingEnabled' property value and immediately saves any changes to disk.
	 *
	 * @param enabled
	 *            Use {@code true} to enable anti aliasing. {@code False} otherwise.
	 */
	public void setAntiAliasing(final boolean enabled) {

		super.properties.setProperty("visualization.antiAliasingEnabled", Boolean.toString(enabled));
		super.save();
	}

	/**
	 * Get the 'visualization.antiAliasingEnabled' property value. Equals {@code true}, if anti aliasing is supposed to be enabled. {@code False} otherwise. Default
	 * value of 'true' will be loaded, if the property value does not exist in the file or the property text is not {@code true} or {@code false}.
	 *
	 * @return The value of the property 'visualization.antiAliasingEnabled'.
	 */
	public boolean isAntiAliasingEnabled() {

		final String key = "visualization.antiAliasingEnabled";
		String value = this.get(key);
		try {
			Boolean.valueOf(value);
		} catch (IllegalArgumentException e) {
			LOGGER.error("Found illegal property value for key " + key + ": " + value + ". Loading default.");
			value = this.handleError(key);
		}
		return Boolean.valueOf(value);
	}


	/**
	 * To be invoked when an {@link IllegalArgumentException} is thrown in one of the property value getter methods. It initializes the default properties and
	 * returns the default value of the specified key.
	 *
	 * @param key
	 *            The key to get the default value for.
	 * @return The default property of the specified key.
	 */
	private String handleError(final String key) {

		this.initDefaultProperties();
		final String value = super.defaultProperties.getProperty(key);
		super.properties.put(key, value);
		return value;
	}


	/**
	 * Returns the value stored by the given key in the configuration file.
	 *
	 * @param key
	 *            The key to get its value
	 * @return The value of the specified key
	 * @throws IllegalArgumentException
	 *             If the key passed in is {@code null}.
	 */
	public String get(final String key) throws IllegalArgumentException {

		if (key == null) {
			throw new IllegalArgumentException("You cannot get the value of a null key.");
		}

		String value = super.properties.getProperty(key);
		if (value == null) {
			// load default
			LOGGER.error("Property '" + key + "' not found. Loading default.");
			value = this.handleError(key);
		}
		return super.properties.getProperty(key);
	}

	/**
	 * Sets the integer value of the specified key.
	 *
	 * @param theInteger
	 *            The integer value of the key to set.
	 * @param key
	 *            The key to set its value
	 * @throws IllegalArgumentException
	 *             If the specified key does not require a integer as value, the given integer is non-positive, or if the key passed in is {@code null}.
	 */
	public void setIntegerValue(final int theInteger, final String key) throws IllegalArgumentException {

		if (key == null) {
			throw new IllegalArgumentException("You cannot pass in a null key.");
		}

		// test integer value
		if (theInteger <= 0) {
			throw new IllegalArgumentException("The given integer has to be a positive number.");
		}

		// key contained in properties file?
		if (!super.properties.containsKey(key)) {
			LOGGER.error("Properties file does not contain key " + key);
			throw new IllegalArgumentException("Properties file does not contain key " + key);
		}

		try {
			// does the key represent an integer?
			Float.parseFloat((String) super.properties.getProperty(key));
		} catch (NumberFormatException e) {
			LOGGER.error("The given key does not represent an integer value entry: " + super.properties.getProperty(key));
			throw new IllegalArgumentException("The given key does not represent an integer value entry.");
		}

		// put integer into properties object
		final String intString = Integer.toString(theInteger);
		this.properties.put(key, intString);
		super.save();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully saved integer value " + intString + " for key " + key + ".");
		}
	}

	// ========================== Inner Classes ===============================

	/**
	 * Get the singleton instance of this class. Will be created if not existing yet. This method is thread save.
	 *
	 * @return The singleton instance of this class.
	 */
	public static Configuration getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * A class holding the only instance of the {@link Configuration} class.
	 *
	 * @author pdo
	 *
	 */
	private static final class InstanceHolder {
		/** The only instance of the {@link Configuration} class. */
		private static final Configuration INSTANCE = new Configuration();

		/** Private constructor. Class instances should not be constructible. */
		private InstanceHolder() {}
	}

}

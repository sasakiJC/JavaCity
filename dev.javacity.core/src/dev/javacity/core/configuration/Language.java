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

package dev.javacity.core.configuration;

import org.apache.log4j.Logger;

/**
 * A utility class to manage the GUI's language.
 *
 * @author pdo
 *
 */
public final class Language extends AbstractPropertiesHandler {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(Language.class);

	// ========================== Constructor =================================

	/**
	 * Constructor of this class. Instances not constructible from outside.
	 */
	private Language() {

		super(FileSystem.getInstance().getLanguagePropertiesFile(Configuration.getInstance().getGUILanguage()));

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully loaded " + Configuration.getInstance().getGUILanguage().name() + " language propeties.");
		}
	}

	// ============================ Methods ===================================

	/**
	 * Returns the language property stored by the given key.
	 *
	 * @param key
	 *            The key to get its language string value.
	 * @return The language string identified by the specified key.
	 */
	public String get(final String key) {

		return super.properties.getProperty(key);
	}

	@Override
	public void restoreDefaults() {

		// there are no default properties, just reload file
		this.reload();
	}

	@Override
	protected void initDefaultProperties() {
		// there are no default properties, just reload file
		this.reload();
		super.defaultProperties = super.properties;
	}

	/**
	 * Reimports the language properties file into this properties handler.
	 */
	public void reload() {

		super.filename = FileSystem.getInstance().getLanguagePropertiesFile(Configuration.getInstance().getGUILanguage());
		super.load();
	}

	// ========================== Inner Classes ===============================

	/**
	 * Get the singleton instance of this class. Will be created if not existing yet. This method is thread save.
	 *
	 * @return The singleton instance of this class.
	 */
	public static Language getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * A class holding the only instance of the {@link Language} class.
	 *
	 * @author pdo
	 *
	 */
	private static final class InstanceHolder {
		/** The only instance of the {@link Language} class. */
		static final Language INSTANCE = new Language();

		/** Private constructor. Class instances should not be constructible. */
		private InstanceHolder() {}
	}

	/**
	 * An enumeration of the currently supported languages in the Synchrovis user interface.
	 *
	 * @author pdo
	 *
	 */
	public enum SupportedLanguages {

		/** English. */
		EN,

		/** German. */
		DE,
	}

}

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

package javacity.configuration;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import javacity.configuration.Language.SupportedLanguages;



/**
 * A utility class offering methods to manage the underlying file system.
 *
 * @author pdo
 *
 */
public final class FileSystem {

	// ============================ Attributes ================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(FileSystem.class);

	/** The name of the folder containing all data files of this application. */
	private static final String DATA_FOLDER_NAME = "data";

	/** The name of the configuration file of this application. */
	private static final String CONFIG_FILE_NAME = "config.properties";

	/** The name of the visual properties file of this application. */
	private static final String VISUAL_PROPS_FILE_NAME = "visual.properties";

	/** The name of the folder containing all language files of this application. */
	private static final String LANG_FOLDER_NAME = "lang";

	/** The name of the folder containing all icons used in this application. */
	private static final String ICONS_FOLDER_NAME = "icons";

	// ========================== Constructor =================================

	/**
	 * Private constructor of this class. Not visible from outside.
	 */
	private FileSystem() {}

	// ============================ Methods ===================================

	/**
	 * Get the current runtime folder of this application appended by a {@code seperatorChar}.
	 *
	 * @return The current runtime folder appended by {@code seperatorChar}.
	 */
	public String getRuntimeFolder() {
		return System.getProperty("user.dir") + File.separatorChar;
	}

	/**
	 * Get the visual properties file.
	 *
	 * @return The visual properties file.
	 */
	public String getVisualPropertiesFile() {
		return this.getDataFolder() + VISUAL_PROPS_FILE_NAME;
	}

	/**
	 * Get the folder containing all language files. Folder path will be appended by a {@code seperatorChar}.
	 *
	 * @return Get the folder containing all language files appended by {@code seperatorChar}.
	 */
	public String getLanguagesFolder() {
		return this.getDataFolder() + LANG_FOLDER_NAME + File.separatorChar;
	}

	/**
	 * Get the folder containing all data files (data folder). Folder path will be appended by a {@code seperatorChar}.
	 *
	 * @return Get the folder containing all data files appended by {@code seperatorChar}.
	 */
	public String getDataFolder() {
		return this.getRuntimeFolder() + DATA_FOLDER_NAME + File.separatorChar;
	}

	/**
	 * Get the folder containing all icons used in this application (icons folder). Folder path will be appended by a {@code seperatorChar}.
	 *
	 * @return Get the folder containing all icons appended by {@code seperatorChar}.
	 */
	public String getIconsFolder() {
		return this.getDataFolder() + ICONS_FOLDER_NAME + File.separatorChar;
	}

	/**
	 * Get the config file.
	 *
	 * @return The config file.
	 */
	public String getConfigFile() {
		return this.getDataFolder() + CONFIG_FILE_NAME;
	}

	/**
	 * Returns the language file matching the given language enumeration constant.
	 *
	 * @param lang
	 *            The language to get its corresponding language file.
	 * @return The corresponding language file of the given language.
	 * @throws IllegalArgumentException
	 *             If the given language enumeration constant is {@code null},
	 */
	public String getLanguagePropertiesFile(final SupportedLanguages lang) throws IllegalArgumentException {

		if (lang == null) {
			throw new IllegalArgumentException("The given language enumeration constant is null.");
		}

		final String filename = "language_" + lang.name().toLowerCase() + ".properties";
		return this.getLanguagesFolder() + filename;
	}

	/**
	 * Checks whether the given filename identifies a real existing file on hard drive.
	 *
	 * @param filename
	 *            The absolute path of the file to check for existence.
	 * @return {@code True}, if the given file exists on hard drive, {@code false} otherwise.
	 * @throws IllegalArgumentException
	 *             If the filename passed in is {@code null}.
	 */
	public boolean isExistingFile(final String filename) throws IllegalArgumentException {

		if (filename == null) {
			throw new IllegalArgumentException("You cannot check a null file for existence.");
		}

		return new File(filename).exists();
	}

	/**
	 * Opens the given file using the operation system's default document reading application. This operation fails silently, if the {@link Desktop} is not supported
	 * on the current platform.
	 *
	 * @param filename
	 *            The absolute path of the file to open.
	 * @throws IllegalArgumentException
	 *             If the given filename is {@code null} or its corresponding file does not exist on disk. To avoid this exception, it is recommended to check the
	 *             file's existence by calling {@link #isExistingFile(String)} first.
	 */
	public void openFile(final String filename) throws IllegalArgumentException {

		if (filename == null) {
			throw new IllegalArgumentException("The given filename is null.");
		}

		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().open(new File(filename));
			} catch (FileNotFoundException e) {
				throw new IllegalArgumentException("The given file does not exist on hard drive.");
			} catch (IOException e) {
				LOGGER.error("Unable to open file " + filename + ".", e);
			}
		} else {
			LOGGER.error("Unable to open file " + filename + ", since the desktop is not supported on the current platform.");
		}
	}

	/**
	 * Extracts the entire content of the given file and return it as a single {@link String}. This operation fails silently and returns an empty string, if an
	 * {@link IOException} (but not {@link FileNotFoundException}) occurred while parsing the given file.
	 *
	 * @param filename
	 *            The absolute path of the file to extract all its content.
	 * @return The entire content of the given file or an empty string, if an internal error occurred.
	 * @throws IllegalArgumentException
	 *             If the given filename is {@code null} or its corresponding file does not exist on disk. To avoid this exception, it is recommended to check the
	 *             file's existence by calling {@link #isExistingFile(String)} first.
	 */
	public String extractFileContent(final String filename) throws IllegalArgumentException {

		if (filename == null) {
			throw new IllegalArgumentException("The given filename is null.");
		}

		// parsing file line by line
		final StringBuilder content = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			final FileReader fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);
			String currentLine = null;
			while ((currentLine = bufferedReader.readLine()) != null) {
				content.append(currentLine);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("The given file does not exist on hard drive.");
		} catch (IOException e) {
			LOGGER.error("An error occurred while parsing the file.", e);
			return "";
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					LOGGER.error("An error occurred while closing a reader.", e);
				}
			}
		}
		return content.toString();
	}

	// ========================== Inner Classes ===============================

	/**
	 * Get the only instance of this class.
	 *
	 * @return The only instance of this class.
	 */
	public static FileSystem getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * A class holding the only instance of the {@link FileSystem} class.
	 *
	 * @author pdo
	 *
	 */
	private static final class InstanceHolder {
		/** The only instance of the {@link FileSystem} class. */
		static final FileSystem INSTANCE = new FileSystem();

		/** Private constructor. Class instances should not be constructible. */
		private InstanceHolder() {}
	}

}

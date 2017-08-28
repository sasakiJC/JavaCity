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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * An abstract class defining abstract methods and offering common concrete methods for concrete properties file handlers.
 *
 * @author pdo
 *
 */
public abstract class AbstractPropertiesHandler {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(AbstractPropertiesHandler.class);

	/** The {@link Properties} instance containing the default value for each key. Will be instantiated on demand only. */
	protected Properties defaultProperties;

	/** The properties object extracted from the properties file. */
	protected Properties properties;

	/** The filename of the properties file, this properties handler was created for. */
	protected String filename;

	// ========================== Constructor =================================

	/**
	 * Construct a new instance {@link AbstractPropertiesHandler}. Since this class is abstract, it might be used by subclasses as part of their constructor only.
	 *
	 * @param filename
	 *            The file name of the properties file to create this properties handler for.
	 * @throws IllegalArgumentException
	 *             If the given filename is {@code null}.
	 */
	protected AbstractPropertiesHandler(final String filename) throws IllegalArgumentException {

		if (filename == null) {
			throw new IllegalArgumentException("The given filename is null.");
		}

		this.filename = filename;
		load();
	}

	// ============================ Methods ===================================

	/**
	 * Save the properties to the properties file on disk. This operation fails silently, if an {@link IOException} occurred while saving the properties.
	 */
	public final void save() {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(this.filename);
			this.properties.store(fos, null);
			LOGGER.debug("Successfully saved changes to " + this.filename + ".");
		} catch (IOException e) {
			LOGGER.error("Unable so save properties file.", e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					LOGGER.error("Unable to close file output stream.", e);
				}
			}
		}
	}

	/**
	 * Load the default value of each property.
	 */
	protected final void loadDefaults() {

		this.initDefaultProperties();
		this.properties = (Properties) this.defaultProperties.clone();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully loaded defaults.");
		}
	}

	/**
	 * Replace all values in the visual properties file with their default values. This method will change the file on disk.
	 */
	public void restoreDefaults() {

		this.loadDefaults();
		this.save();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully restored defaults.");
		}
	}

	/**
	 * Load the properties file given by its filename and store them in {@link #properties}.
	 */
	protected final void load() {

		this.properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(this.filename);
			this.properties.load(fis);
			LOGGER.debug("Configuration file successfully loaded.");
		} catch (FileNotFoundException e) {
			LOGGER.error("Unable to load configurations file. Restoring defaults.", e);
			this.loadDefaults();
		} catch (IOException e) {
			LOGGER.error("Unable so load configurations file. Restoring defaults.", e);
			this.loadDefaults();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					LOGGER.error("Unable to close file input stream.", e);
				}
			}
		}
	}

	// ======================= Abstract Methods ===============================

	/**
	 * Initialize the default properties attribute ({@link #defaultProperties}). It will contain the default properties (key-value pairs) of the inherited concrete
	 * properties handler after this method return. This method has no effect, if the default properties are already initialized, i.e. if this was already invoked
	 * earlier.
	 */
	protected abstract void initDefaultProperties();

}

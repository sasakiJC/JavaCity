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

package dev.javacity.core.importer.kdm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import data.statics.impl.StaticsFactoryImpl;
import data.statics.impl.StaticsPackageImpl;
import dev.javacity.core.importer.exception.KDMImportException;
import dev.javacity.core.models.data.DataModel;

/**
 * A KDM importer based on the SAX technology parsing any given KDM object and extracting its static information to fill the data model.
 *
 * @author pdo
 *
 * @see DataModel
 */
public class KDMImporter extends AbstractKDMImporter {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(KDMImporter.class);

	// ========================== Constructor =================================

	/**
	 * Public constructor. It creates a new {@link KDMImporter} instance to import static data from a KDM file into the given {@link DataModel} instance using the
	 * SAX technology.
	 *
	 * @param dataModel
	 *            The data model to add all imported static elements to.
	 */
	public KDMImporter(final DataModel dataModel) {

		super(dataModel);
	}

	// ============================ Methods ===================================

	@Override
	public void importFromFile(final InputStream stream) throws KDMImportException, IllegalArgumentException {

		if (stream == null) {
			throw new IllegalArgumentException("The filename passed in is null.");
		}

		// preparing data model
		LOGGER.info("Importing KDM file...");
		this.dataModel.clearAll();
		StaticsPackageImpl.init();
		StaticsFactoryImpl.init();

		try {
			// setting up reader
			final XMLReader xmlReader = XMLReaderFactory.createXMLReader();
//			final FileReader reader = new FileReader(file);
			final InputSource inputSource = new InputSource(stream);
			xmlReader.setContentHandler(new KDMContentHandler(this.dataModel));

			InputSource test = new InputSource();

			// extracting KDM content
			LOGGER.info("Extracting static data...");
			xmlReader.parse(inputSource);

		} catch (FileNotFoundException e) {
			LOGGER.error("Unable to find KDM file " + stream.toString() + ".", e);
			throw new KDMImportException(e);
		} catch (IOException e) {
			LOGGER.error("Failed to read KDM file " + stream.toString() + ".");
			throw new KDMImportException(e);
		} catch (SAXException e) {
			LOGGER.error("Failed to parse KDM tree in file " + stream.toString() + ".", e);
			throw new KDMImportException(e);
		}

		// post-processing
		LOGGER.info("Post-processing data...");
		this.buildPackageHierarchy();
		this.addBasePackage();

		LOGGER.info("KDM import complete.\n");
		this.dataModel.setStaticsLoaded();

		LOGGER.info("Statics loaded. Currently " + ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed()
				+ " bytes of heap memory in use.\n");
	}

}

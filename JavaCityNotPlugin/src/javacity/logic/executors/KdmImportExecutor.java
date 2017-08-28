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
 * dynamics関連の削除
 */
package javacity.logic.executors;

import java.io.File;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import javacity.configuration.Language;
import javacity.importer.exception.KDMImportException;
import javacity.importer.kdm.AbstractKDMImporter;
import javacity.logic.Logic;

/**
 * A KDM import executor performing the import of a KDM file into the Synchrovis application in a separate thread.
 *
 * @author pdo
 *
 */
public final class KdmImportExecutor extends Thread {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(KdmImportExecutor.class);

	/** The {@link AbstractKDMImporter} performing the import. */
	private final AbstractKDMImporter importer;

	/** The KDM file containing the static data to be imported. */
	private final File file;

	// ========================== Constructor =================================

	/**
	 * Constructs a new {@link KdmImportExecutor} performing the import of given KDM file using the specified KDM importer in a separate thread.
	 *
	 * @param kdmImporter
	 *            The KDM importer to use when performing the import.
	 * @param file
	 *            The KDM file containing all static data to be imported.
	 * @throws IllegalArgumentException
	 *             If the KDM importer is {@code null} or the file passed in is either {@code null}, does not exist on disc, or does not represent a regular file.
	 */
	public KdmImportExecutor(final AbstractKDMImporter kdmImporter, final File file) throws IllegalArgumentException {

		super();

		if (kdmImporter == null) {
			throw new IllegalArgumentException("KDM files cannot be imported with a null importer.");
		}
		if (file == null || !file.exists() || !file.isFile()) {
			throw new IllegalArgumentException("The file passed in is either null, does not exist on disc, or does not represent a regular file.");
		}

		this.importer = kdmImporter;
		this.file = file;
	}

	// ============================ Methods ===================================

	@Override
	public void run() {

		try {
			Logic.getInstance().getMenuBarController().setStaticsItemEnabled(false);
			this.importer.importFromFile(this.file.getAbsolutePath());
			Logic.getInstance().getMenuBarController().setSaveItemEnabled(true);
			Logic.getInstance().getMenuBarController().setSearchItemEnabled(true);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Successfully imported statics from file " + this.file.getAbsolutePath() + ".");
			}
		} catch (KDMImportException | IllegalStateException e) {
			LOGGER.error("Failed to import KDM file", e);
			JOptionPane.showMessageDialog(null, Language.getInstance().get("kdm.error.message"), Language.getInstance().get("kdm.error.title"),
					JOptionPane.ERROR_MESSAGE);
		} finally {
			Logic.getInstance().getMenuBarController().setStaticsItemEnabled(true);
		}
	}

}

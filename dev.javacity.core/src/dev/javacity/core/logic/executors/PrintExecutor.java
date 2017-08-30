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

package dev.javacity.core.logic.executors;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import dev.javacity.core.configuration.Language;




/**
 * A print executor to execute the given {@link PrinterJob} in a separate thread, i.e. print the associated image on the system's default printing device.
 *
 * @author pdo
 *
 */
public final class PrintExecutor extends Thread {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(PrintExecutor.class);

	/** The {@link PrinterJob} to be executed. */
	private final PrinterJob printerJob;

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link PrintExecutor} instance to execute the specified printer job.
	 *
	 * @param job
	 *            The printer job to execute.
	 * @throws IllegalArgumentException
	 *             If the printer job passed in is {@code null}.
	 */
	public PrintExecutor(final PrinterJob job) throws IllegalArgumentException {

		super();

		if (job == null) {
			throw new IllegalArgumentException("You cannot execute a null printer job.");
		}

		this.printerJob = job;
	}

	// ============================ Methods ===================================

	@Override
	public void run() {

		try {
			this.printerJob.print();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Successfully printed snapshot on the system's default printing device.");
			}
		} catch (PrinterException e) {
			LOGGER.error("An error occurred while printing the snapshot on the system's default printing device.", e);
			JOptionPane.showMessageDialog(null, Language.getInstance().get("snapshot.print.error.message"),
					Language.getInstance().get("snapshot.print.error.title"), JOptionPane.ERROR_MESSAGE);
		}
	}
}

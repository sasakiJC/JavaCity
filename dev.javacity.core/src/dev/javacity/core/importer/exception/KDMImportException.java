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

package dev.javacity.core.importer.exception;

/**
 * An exception class to indicate the occurrence of an severe error during KDM import.
 * 
 * @author pdo
 * 
 */
public class KDMImportException extends RuntimeException {

	// =========================== Attributes =================================

	/**
	 * Generated {@code serialVersionUID} for serialization.
	 */
	private static final long serialVersionUID = -6881642855833135243L;

	// ========================== Constructors ================================

	/**
	 * Constructs a new {@code KDMImportException} instance with the specified detail message.
	 * 
	 * @param message
	 *            The detail message of the error.
	 */
	public KDMImportException(final String message) {
		super(message);
	}

	/**
	 * Constructs a new {@code KDMImportException} instance with the specified cause and a detail message of {@code (cause==null ? null : cause.toString())} (which
	 * typically contains the class and detail message of cause).
	 * 
	 * @param cause
	 *            The cause of the error.
	 */
	public KDMImportException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new {@code KDMImportException} instance with the specified detail message and cause.
	 * 
	 * @param message
	 *            The detail message of the error.
	 * @param cause
	 *            The cause of the error.
	 */
	public KDMImportException(final String message, final Throwable cause) {
		super(message, cause);
	}
}

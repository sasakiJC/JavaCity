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

package dev.javacity.core.importer.utils;

/**
 * A utility class offering commonly used methods to manipulate or extract information from of simplified signature string.
 *
 * @author pdo
 *
 */
public final class SimplifiedSignatureUtils {

	// ========================== Constructor =================================

	/**
	 * This class is not intended for instantiation since it contains static methods only.
	 */
	private SimplifiedSignatureUtils() {}

	// ============================ Methods ===================================

	/**
	 * Returns the method name of the specified simple method signature.
	 *
	 * @param simpleSignature
	 *            The Kieker signature string to extract its method name.
	 * @return The method name in the specified Kieker method signature.
	 * @throws IllegalArgumentException
	 *             If the Kieker signature passed in is {@code null}.
	 */
	public static String getMethodName(final String simpleSignature) throws IllegalArgumentException {

		if (simpleSignature == null) {
			throw new IllegalArgumentException("Input String is null.");
		}

		String retval = simpleSignature;
		if (!"static".equals(simpleSignature)) {

			// handle <init> and <clinit>
			if (simpleSignature.endsWith("<init>") || simpleSignature.endsWith("<clinit>")) {
				retval = simpleSignature.substring(simpleSignature.lastIndexOf('<'));
			} else {
				final int indexBracketIndex = simpleSignature.lastIndexOf('(');
				final String[] splits = simpleSignature.substring(0, indexBracketIndex).split("\\s+");
				retval = splits[splits.length - 1];
			}
		}
		return retval;
	}

}

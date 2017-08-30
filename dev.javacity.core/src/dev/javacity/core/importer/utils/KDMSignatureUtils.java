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

import dev.javacity.core.utils.StringUtils;

/**
 * A utility class offering commonly used methods to manipulate the method signature string (i.e. a 'snippet' attribute value) contained in KDM files.
 *
 * @author pdo
 *
 */
public final class KDMSignatureUtils {

	// ========================== Constructor =================================

	/**
	 * Private constructor. This class should not be instantiated since it contains static methods only.
	 */
	private KDMSignatureUtils() {}

	// ============================ Methods ===================================

	/**
	 * Converts a given KDM method signature string (i.e. a 'snippet' attribute value) into a general simplified signature, which equals the usual method signature,
	 * but all its parameter names and parameter modifiers are removed. Example: {@code toSimplifiedSignature( "public static native String op(final long arg)" )}
	 * will return {@code "public static native String op(long)" }.
	 *
	 * @param signature
	 *            The KDM method signature to simplify.
	 * @return The simplified signature extracted from the given KDM signature string.
	 * @throws IllegalArgumentException
	 *             If the input string is {@code null}.
	 */
	public static String toSimplifiedSignature(final String signature) throws IllegalArgumentException {

		if (signature == null) {
			throw new IllegalArgumentException("Input String is null.");
		}

		if ("static".equals(signature)) {
			// static block executions, considered as method as well
			return signature;
		}

		// determine index of opening and closing bracket, they enclose the parameter list
		final int opBracketIndex = signature.lastIndexOf('(');
		final int clBracketIndex = signature.lastIndexOf(')'); // most likely at last index

		// just copy everything up to the opening bracket (i.e. method modifiers and method name)
		final StringBuffer buffer = new StringBuffer();
		buffer.append(signature.substring(0, opBracketIndex) + '(');

		// parse method parameters separately, each string in 'params' contains one parameter including its name, type and (optional) modifiers
		final String[] params = signature.substring(opBracketIndex + 1, clBracketIndex).split(",");
		if (!(params.length == 1 && "".equals(params[0]))) {
			// method does contain parameters
			// now split each string in 'params' into its single 'words'
			final String[][] paramComponents = new String[params.length][];
			for (int i = 0; i < params.length; i++) {
				paramComponents[i] = params[i].trim().split("\\s+");
			}

			// determine, which 'word' describes which component
			for (int i = 0; i < paramComponents.length; i++) {
				int typeIndex = 0;
				int nameIndex = 1;
				if (paramComponents[i].length == 3) {
					// array contains "final" at index '0';
					typeIndex = 1;
					nameIndex = 2;
				}
				buffer.append(StringUtils.cutToLast(paramComponents[i][typeIndex], '.'));
				if (paramComponents[i][nameIndex].endsWith("[]")) {
					// handle array brackets correctly
					buffer.append("[]");
				}
				if (i < paramComponents.length - 1) {
					buffer.append(", ");
				}
			}
		}
		buffer.append(')');
		return buffer.toString();
	}

}

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

package javacity.utils;

import java.util.Arrays;

/**
 * A utility class to offer array related methods, which are not part of the {@link java.util.Arrays Arrays} class or not offered by a corresponding data type
 * wrapper class.
 *
 * @author pdo
 *
 */
public final class ArrayUtils {

	// ========================== Constructor =================================

	/**
	 * Private constructor. This class should not be instantiated since it contains static methods only.
	 */
	private ArrayUtils() {}

	// ============================ Methods ===================================

	/**
	 * Returns the index of the given string in the specified string array in terms of {@code equals} or {@code -1}, if the object is not contained. If
	 * the element is contained multiple times, the index of its first occurrence will be returned.
	 *
	 * @param array
	 *            The array to check for containment.
	 * @param string
	 *            The string to get its index in the given array.
	 * @return The index of the array element which contains the given object or {@code -1}, if the object is not contained.
	 * @throws IllegalArgumentException
	 *             If either the given array or the specified string is {@code null}.
	 */
	public static int indexOf(final String[] array, final String string) throws IllegalArgumentException {

		if (array == null) {
			throw new IllegalArgumentException("You cannot pass in a null array.");
		}
		if (string == null) {
			throw new IllegalArgumentException("You cannot pass in a null string.");
		}

		for (int i = 0; i < array.length; i++) {
			if (string.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the indices of the strings in {@code objects} in the given string array {@code array} in terms of {@code equals}. If some element is contained
	 * multiple times, the index of its first occurrence will be taken only.
	 *
	 * @param array
	 *            The array to check for containment.
	 * @param objects
	 *            The strings to get their indices in the given string array.
	 * @return An array of indices each indicating the position of an input element in {@code array} in proper order relating their order in {@code objects}. An
	 *         index will be {@code -1}, if the object at that index is not contained in the {@code objects} parameter.
	 * @throws IllegalArgumentException
	 *             If at least one input parameter is {@code null}.
	 */
	public static int[] indicesOf(final String[] array, final String[] objects) throws IllegalArgumentException {

		if (array == null || objects == null) {
			throw new IllegalArgumentException("You cannot pass in a null array.");
		}

		final int[] indices = new int[objects.length];
		Arrays.fill(indices, -1);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < objects.length; j++) {
				if (indices[j] == -1 && objects[j].equals(array[i])) {
					indices[j] = i;
				}
			}
		}
		return indices;
	}

	/**
	 * Returns {@code true} if and only if this string array contains the specified string in terms of {@code equals}.
	 *
	 * @param array
	 *            The array to check for containment.
	 * @param string
	 *            The string to search for.
	 * @return {@code true} if this string array contains the given string, false otherwise.
	 * @throws IllegalArgumentException
	 *             If either the given array or the specified string is {@code null}.
	 */
	public static boolean contains(final String[] array, final String string) throws IllegalArgumentException {

		if (array == null) {
			throw new IllegalArgumentException("You cannot pass in a null array.");
		}
		if (string == null) {
			throw new IllegalArgumentException("You cannot pass in a null string.");
		}

		return indexOf(array, string) != -1;
	}
}

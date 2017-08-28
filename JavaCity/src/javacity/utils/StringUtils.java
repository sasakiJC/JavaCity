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

import java.util.LinkedList;
import java.util.List;

/**
 * A utility class to offer String related methods, which are not part of the {@link java.lang.String String} class or not offered by a corresponding data type
 * wrapper class.
 *
 * @author pdo
 *
 */
public final class StringUtils {

	// ========================== Constructor =================================

	/**
	 * Private constructor. This class should not be instantiated since it contains static methods only.
	 */
	private StringUtils() {}

	// ============================ Methods ===================================

	/**
	 * Parses a string representation of a float array and returns it as a float array.
	 *
	 * @param string
	 *            The string representation of the float array to parse.
	 * @return The float array representing the given string.
	 *
	 * @throws IllegalArgumentException
	 *             If the input string is {@code null}, contains a non-float value, or does not begin and end with the correct array brackets ('[' and ']'
	 *             respectively).
	 */
	public static float[] parseFloatArray(final String string) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		// check and remove brackets
		String temp = string.trim();
		if (!(temp.endsWith("]") && temp.startsWith("["))) {
			throw new NumberFormatException("String does not start or end with the correct array brackets '[' and ']'.");
		}

		temp = string.substring(1, temp.length() - 1);
		temp = temp.trim();

		// split sequence and parse to floats
		final String[] strings = temp.split(",");
		final float[] floats = new float[strings.length];
		for (int i = 0; i < strings.length; i++) {
			floats[i] = Float.parseFloat(strings[i].trim());
		}
		return floats;
	}

	public static double[] parseDoubleArray(final String string) throws IllegalArgumentException {
		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		// check and remove brackets
		String temp = string.trim();
		if (!(temp.endsWith("]") && temp.startsWith("["))) {
			throw new NumberFormatException("String does not start or end with the correct array brackets '[' and ']'.");
		}

		temp = string.substring(1, temp.length() - 1);
		temp = temp.trim();

		// split sequence and parse to floats
		final String[] strings = temp.split(",");
		final double[] doubles = new double[strings.length];
		for (int i = 0; i < strings.length; i++) {
			doubles[i] = Double.parseDouble(strings[i].trim());
		}
		return doubles;
	}

	/**
	 * Returns a substring of the given String or the unchanged string itself. The substring up to the first occurrence of the input character (inclusive) is cut
	 * off.
	 * E.g. {@code cutToFirst("floor", 'o')} will return {@code "or"}. If the given character is not contained in the input string, the unchanged input String will
	 * be returned.
	 *
	 * @param string
	 *            The input String to cut off.
	 * @param character
	 *            The cut character.
	 * @return The substring of the given String cut up to the first occurrence of the input character (inclusive) or the unchanged input string itself, if the input
	 *         character is not contained.
	 * @throws IllegalArgumentException
	 *             If the input string is {@code null}.
	 */
	public static String cutToFirst(final String string, final char character) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		final int firstOccurrence = string.indexOf(character);
		if (firstOccurrence != -1) {
			return string.substring(firstOccurrence + 1);
		}
		return string;
	}

	/**
	 * Returns a substring of the given String or the unchanged string itself. It is cut off at the last occurrence of the input character (inclusive). E.g.
	 * {@code cutFromLast("floor", 'o')} will return {@code "flo"}. If the given character is not contained in the input string, the unchanged input String will be
	 * returned.
	 *
	 * @param string
	 *            The input String to cut off.
	 * @param character
	 *            The cut character.
	 * @return The substring of the given String cut at the last occurrence of the input character (inclusive) or the unchanged input string itself, if the input
	 *         character is not contained.
	 * @throws IllegalArgumentException
	 *             If the input string is {@code null}.
	 */
	public static String cutFromLast(final String string, final char character) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		final int lastOccurrence = string.lastIndexOf(character);
		if (lastOccurrence != -1) {
			return string.substring(0, lastOccurrence);
		}
		return string;
	}

	/**
	 * Returns a substring of the given String or the unchanged string itself. It is cut off at the first occurrence of the input character (inclusive). E.g.
	 * {@code cutFromLast("floor", 'o')} will return {@code "fl"}. If the given character is not contained in the input string, the unchanged input String will be
	 * returned.
	 *
	 * @param string
	 *            The input String to cut off.
	 * @param character
	 *            The cut character.
	 * @return The substring of the given String cut at the first occurrence of the input character (inclusive) or the unchanged input string itself, if the input
	 *         character is not contained.
	 * @throws IllegalArgumentException
	 *             If the input string is {@code null}.
	 */
	public static String cutFromFirst(final String string, final char character) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		final int firstOccurrence = string.indexOf(character);
		if (firstOccurrence != -1) {
			return string.substring(0, firstOccurrence);
		}
		return string;
	}

	/**
	 * Return the number of occurrences of the given character in the given string.
	 *
	 * @param string
	 *            The string in which the input character's occurrences are to be counted.
	 * @param character
	 *            The character to count its occurrences in the given string.
	 * @return The number of occurrences of the given character in the given string.
	 * @throws IllegalArgumentException
	 *             If the input string is {@code null}.
	 */
	public static int occurrenceCount(final String string, final char character) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		int count = 0;
		final char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == character) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Return the indices within the given string of all occurrences of the specified character. If no such character occurs in this string, then {@code null} is
	 * returned. The String is searched forwards starting at the first character.
	 *
	 * @param string
	 *            The string in which the indices of character occurrences are determined.
	 * @param character
	 *            The character whose occurrence indices in the given string are determined.
	 * @return The indices of all occurrences of the character in the character sequence represented by this object, or {@code null} if the character does not occur
	 * @throws IllegalArgumentException
	 *             If the character is {@code null}.
	 */
	public static List<Integer> indicesOf(final String string, final char character) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		final List<Integer> indices = new LinkedList<Integer>();
		final char[] chars = string.toCharArray();
		for (int i = 0; i < string.length(); i++) {
			if (chars[i] == character) {
				indices.add(i);
			}
		}
		return indices;
	}

	/**
	 * Return a list of all substrings of the given string, which are generated by cutting the original string at the position, the input character occurs. The
	 * string is traversed backwards. So, the strings in the resulting list, are sorted by ascending size. For Example, {@code getSubstringsFromLast("a.b.c.d", '.')}
	 * returns the list {@code "a.b.c", "a.b", "a" }.
	 *
	 * @param string
	 *            The string to determine all substrings cut at an index, where the input character occurs.
	 * @param character
	 *            The character used to cut the given string into substrings.
	 * @return A list of all substrings of the given string, which are generated by cutting the original string at a position, the input character occurs.
	 * @throws IllegalArgumentException
	 *             If the given string is {@code null}.
	 */
	public static List<String> getSubstringsFromLast(final String string, final char character) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		final List<String> substrings = new LinkedList<String>();
		String string1 = string;
		String string2 = cutFromLast(string1, character);

		while (string1 != string2) {
			substrings.add(string2);
			string1 = string2;
			string2 = cutFromLast(string2, character);
		}
		return substrings;
	}

	/**
	 * Returns a substring of the input string or the unchanged string itself. The first part of the given string up to the last occurrence of the input character
	 * (inclusive) will be cut off. E.g. {@code cutToLast("floor", 'o')} will return {@code "r"}. If the given character is not contained in the input string, the
	 * unchanged input String will be returned.
	 *
	 * @param string
	 *            The input String to cut off.
	 * @param character
	 *            The cut character.
	 * @return The substring of the given String cut to the last occurrence of the input character (inclusive) or the unchanged input string itself, if the input
	 *         character is not contained.
	 * @throws IllegalArgumentException
	 *             If the input string is {@code null}.
	 */
	public static String cutToLast(final String string, final char character) throws IllegalArgumentException {

		if (string == null) {
			throw new IllegalArgumentException("String argument is null.");
		}

		final int lastOccurrence = string.lastIndexOf(character);
		if (lastOccurrence != -1) {
			return string.substring(lastOccurrence + 1);
		}
		return string;
	}
}

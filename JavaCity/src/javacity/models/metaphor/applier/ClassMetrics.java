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

package javacity.models.metaphor.applier;

import data.statics.Relation;
import data.statics.SClass;

/**
 * A collection of class metrics each returning an integer value between {@code 0} and {@code 5} (each inclusive) representing the value of the metric applied.
 * 
 * @author pdo
 * 
 */
public final class ClassMetrics {

	// ========================== Constructor =================================

	/**
	 * Private constructor. This class is not intended for instantiation, since it contains static methods only.
	 */
	private ClassMetrics() {}

	// ============================ Methods ===================================

	/**
	 * Returns a positive integer between {@code 0} and {@code 5} (each inclusive) abstractly measuring the number of methods contained in the given class. More
	 * precisely, it returns the value {@code Math.max(Math.ceil(sClass.getSMethods() / 5), 5)}.
	 * 
	 * @param sClass
	 *            The {@link SClass} instance to apply this metric on.
	 * @return The metric value of the given class.
	 * @throws IllegalArgumentException
	 *             If the given class is {@code null}.
	 */
	public static int numMethodsMetric(final SClass sClass) throws IllegalArgumentException {

		if (sClass == null) {
			throw new IllegalArgumentException("Given class is null.");
		}

		return (int) Math.min(Math.floor(sClass.getSMethods().size() / 5), 5);
	}

	/**
	 * Returns a positive integer between {@code 0} and {@code 5} (each inclusive) abstractly measuring the number of attributes (i.e. outgoing relation) contained
	 * in the given class. More precisely, it returns the value {@code Math.max(Math.ceil(<numberOfAttributes> / 5), 5)}.
	 * 
	 * @param sClass
	 *            The {@link SClass} instance to apply this metric on.
	 * @return The metric value of the given class.
	 * @throws IllegalArgumentException
	 *             If the given class is {@code null}.
	 */
	public static int numAttributesMetric(final SClass sClass) throws IllegalArgumentException {

		if (sClass == null) {
			throw new IllegalArgumentException("Given class is null.");
		}

		// determine number of attributes (i.e. outgoing relations)
		int numAttributes = 0;
		for (Relation relation : sClass.getRelations()) {
			if (relation.getSource().equals(sClass)) {
				numAttributes++;
			}
		}

		return (int) Math.min(Math.floor(numAttributes / 5), 5);
	}

	/**
	 * Returns a positive integer between {@code 0} and {@code 5} (each inclusive) abstractly measuring the number of incoming or outgoing relations if the given
	 * class. More precisely, it returns the value {@code Math.max(Math.ceil(sClass.getRelations().size() / 3), 5)}.
	 * 
	 * @param sClass
	 *            The {@link SClass} instance to apply this metric on.
	 * @return The metric value of the given class.
	 * @throws IllegalArgumentException
	 *             If the given class is {@code null}.
	 */
	public static int numRelationsMetric(final SClass sClass) throws IllegalArgumentException {

		if (sClass == null) {
			throw new IllegalArgumentException("Given class is null.");
		}

		return (int) Math.min(Math.floor(sClass.getRelations().size() / 3), 5);
	}

	/**
	 * Returns a positive integer between {@code 0} and {@code 5} (each inclusive) abstractly measuring the number of characters in the simple name of the given
	 * class. More precisely, it returns the value {@code Math.max(Math.ceil(sClass.getName().length() / 5), 5)}.
	 * 
	 * @param sClass
	 *            The {@link SClass} instance to apply this metric on.
	 * @return The metric value of the given class.
	 * @throws IllegalArgumentException
	 *             If the given class is {@code null}.
	 */
	public static int nameLengthMetric(final SClass sClass) throws IllegalArgumentException {

		if (sClass == null) {
			throw new IllegalArgumentException("Given class is null.");
		}

		return (int) Math.min(Math.floor(sClass.getName().length() / 5), 5);
	}

}

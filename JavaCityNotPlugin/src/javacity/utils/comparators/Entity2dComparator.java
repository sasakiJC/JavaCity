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

package javacity.utils.comparators;

import java.util.Comparator;

import metaphor.types.Entity2D;

/**
 * A custom comparator to compare two {@link Entity2D} instances by their 'width' attribute. Applying this comparator to a list of entity2Ds will result in a list,
 * whose elements are sorted by its width in descending order. If two elements and share the same width, the object with the shorter length in considered as the
 * lesser object, i.e. will be placed after the the other element in the sorted list.
 *
 * @author pdo
 *
 */
public class Entity2dComparator implements Comparator<Entity2D> {

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link Entity2dComparator} instance.
	 */
	public Entity2dComparator() {/* nothing to do */}

	// ============================ Methods ===================================

	@Override
	public int compare(final Entity2D ent1, final Entity2D ent2) throws IllegalArgumentException {

		if (ent1 == null || ent2 == null) {
			throw new IllegalArgumentException("You cannot compare null elements.");
		}

		int comparation = -Float.compare(ent1.getWidth(), ent2.getWidth());
		if (comparation == 0) {
			comparation = -Float.compare(ent1.getLength(), ent2.getLength());
		}
		return comparation;
	}

}

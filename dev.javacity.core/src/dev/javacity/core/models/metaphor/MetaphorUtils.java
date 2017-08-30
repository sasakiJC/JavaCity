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

package dev.javacity.core.models.metaphor;

import data.statics.SPackage;

import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;

/**
 * A utility class offering methods performing common operations on metaphor objects.
 * 
 * @author pdo
 * 
 */
public final class MetaphorUtils {

	// ========================== Constructor =================================
	
	/**
	 * Private constructor. Instances of this class should not be constructible, since it contains static methods only.
	 */
	private MetaphorUtils() {}
	
	// ============================ Methods ===================================

	/**
	 * Returns the nesting level of the {@link SPackage} represented by the given {@link RegularDistrict} instance in the application's package hierarchy.
	 * 
	 * @param district
	 *            The district to get the nesting level of the package it represents.
	 * @return The nesting level of the package represented by the given entity2d element in the package hierarchy.
	 * @throws IllegalArgumentException
	 *             If the district passed in is {@code null}.
	 */
	public static int computeLevel(final RegularDistrict district) throws IllegalArgumentException {

		if (district == null) {
			throw new IllegalArgumentException("You cannot compute the level of a null district.");
		}

		return ((SPackage) district.getDataObject()).getLevel();
	}

	/**
	 * Returns the nesting level of the {@link SClass} represented by the given {@link RegularBuilding} instance in the application's package hierarchy.
	 * 
	 * @param building
	 *            The regular building to get the nesting level of the class it represents.
	 * @return The nesting level of the class represented by the given regular building in the package hierarchy.
	 * @throws IllegalArgumentException
	 *             If the building passed in is {@code null}.
	 */
	public static int computeLevel(final RegularBuilding building) throws IllegalArgumentException {

		if (building == null) {
			throw new IllegalArgumentException("You cannot compute the level of a null building.");
		}

		return ((SPackage) building.getDistrict().getDataObject()).getLevel() + 1; // + 1 since we consider the given building as well
	}

	/**
	 * Returns the height of a {@link RegularBuilding}, which is defined as the sum of the height of all its {@link RegularFloor} instances.
	 * 
	 * @param building
	 *            The building to compute its height.
	 * @return The height of the given building.
	 * @throws IllegalArgumentException
	 *             If the building passed in is {@code null}.
	 */
	public static double computeHeigth(final RegularBuilding building) throws IllegalArgumentException {

		if (building == null) {
			throw new IllegalArgumentException("You cannot compute the heigth of a null building.");
		}

		double heigth = 0;
		for (RegularFloor floor : building.getFloors()) {
			heigth += floor.getHeight();
		}

		return heigth;
	}
}

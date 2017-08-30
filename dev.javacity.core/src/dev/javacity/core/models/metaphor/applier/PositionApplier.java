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

package dev.javacity.core.models.metaphor.applier;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import dev.javacity.core.configuration.VisualProperties;
import dev.javacity.core.models.metaphor.MetaphorUtils;
import dev.javacity.core.utils.comparators.Entity2dComparator;
import javafx.geometry.Point3D;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.Street;
import metaphor.entities.impl.EntitiesFactoryImpl;
import metaphor.types.Entity2D;


/**
 * A position applier responsible for arranging all metaphor elements within the city, i.e. setting their absolute position in the final visualization.
 *
 * @author pdo
 *
 */
public final class PositionApplier {

	// =========================== Attributes =================================

	/** The default interspace between the borders of two consecutively nested districts. */
	private float districtBorder = VisualProperties.getInstance().getDistrictBorder();

	/** The minimal interspace between two buildings or districts of the same nesting level. */
	private float buildingInterspace = VisualProperties.getInstance().getBuildingInterspace();

	/** The minimal interspace between two bases. */
	private float baseInterspace = VisualProperties.getInstance().getBaseInterspace();

	/** The minimal length of a {@link RegularBuilding} or {@link AdministrationBuilding}. */
	private float buildingInitLength = VisualProperties.getInstance().getBuildingInitLength();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link PositionApplier} instance.
	 */
	public PositionApplier() {}

	// ============================ Methods ===================================

	/**
	 * Updates all visual settings attributes of this instance.
	 */
	public void updateAttributes() {

		this.districtBorder = VisualProperties.getInstance().getDistrictBorder();
		this.buildingInterspace = VisualProperties.getInstance().getBuildingInterspace();
		this.baseInterspace = VisualProperties.getInstance().getBaseInterspace();
		this.buildingInitLength = VisualProperties.getInstance().getBuildingInitLength();
	}

	/**
	 * Arranges a given {@link RegularFloor} instance within the city, i.e. sets its absolute position in the final visualization.
	 *
	 * Precondition: The height, width and length attribute of the given floor is set (correctly).
	 *
	 * @param floor
	 *            The floor to arrange within the city.
	 * @throws IllegalArgumentException
	 *             If the floor passed in is {@code null}.
	 */
	public void applyPosition(final RegularFloor floor) throws IllegalArgumentException {

		if (floor == null) {
			throw new IllegalArgumentException("The floor passed in is null.");
		}

		// computing y-position
		final RegularBuilding building = floor.getBuilding();
		final double yPos = building.getPosition().getY() + MetaphorUtils.computeHeigth(building) + (floor.getHeight() / 2);

		// setting final position
		floor.setPosition(new Point3D(building.getPosition().getX(), -yPos, building.getPosition().getZ()));
	}

	/**
	 * Arranges a given {@link AdministrationBase} instance and all its (nested) child entities within the city, i.e. sets their absolute centered positions in the
	 * final visualization.
	 *
	 * Precondition: The given regular base has already been arranged in the city and the width, height and length attribute of the base itself and of all contained
	 * buildings and districts are set (correctly).
	 *
	 * @param adBase
	 *            The administration base to arrange within the city.
	 * @param regBase
	 *            The regular base already arranged within the city.
	 * @throws IllegalArgumentException
	 *             If either the administration or regular base passed in is {@code null}.
	 */


/*
	public void applyPosition(final RegularBase regBase) throws IllegalArgumentException {

		if (regBase == null) {
			throw new IllegalArgumentException("The regular base passed in is null.");
		}

		// the position of the regular base's front right corner
		final double regX = regBase.getPosition().getX() + regBase.getLength() / 2;
		final double regZ = regBase.getPosition().getZ() + regBase.getWidth() / 2;

		// set base position
		final double xPos = regX + this.baseInterspace;
		final double yPos = regBase.getPosition().getY();
		final double zPos = regZ;

		final Vector3d pos = new Vector3d(xPos, yPos, zPos);
		adBase.setPosition(pos);
	}
*/
	/**
	 * Arranges a given {@link Street} instance within the city, i.e. sets its absolute position in the final visualization.
	 *
	 * @param street
	 *            The street to arrange within the city.
	 * @throws IllegalArgumentException
	 *             If the street passed in or either its source or target floor is {@code null}.
	 */
	public void applyPosition(final Street street) throws IllegalArgumentException {

		if (street == null) {
			throw new IllegalArgumentException("The street passed in is null.");
		}
		if (street.getSource() == null) {
			throw new IllegalArgumentException("The street's source is null.");
		}
		if (street.getTarget() == null) {
			throw new IllegalArgumentException("The street's target is null.");
		}

		final Point3D sourcePos = street.getSource().getPosition();
		final Point3D targetPos = street.getTarget().getPosition();

		// set position = sourcePos + 0.5 * (targetPos - sourcePos)
		Point3D pos = new Point3D(0,0,0);
		pos = targetPos.subtract(sourcePos);
		pos.multiply(0.5);
		pos = pos.add(sourcePos);
	}

	/**
	 * Arranges a given {@link RegularBase} instance and all its (nested) child entities within the city, i.e. their absolute centered positions in the final
	 * visualization.
	 *
	 * Precondition: The width, height and height of all contained buildings and districts are set.
	 *
	 * @param base
	 *            The base to arrange within the city.
	 * @throws IllegalArgumentException
	 *             If the base passed in or any sub-entity in it is {@code null}.
	 */
	public void applyPosition(final RegularBase base) throws IllegalArgumentException {

		if (base == null) {
			throw new IllegalArgumentException("The base passed in is null.");
		}

		// arrange the base and all its sub-entities in the visualization
		final RegularDistrict temp = EntitiesFactoryImpl.eINSTANCE.createRegularDistrict();
		for (RegularDistrict dist : base.getDistricts()) {
			temp.getChildDistricts().add(dist);
			dist.setParentDistrict(temp);
		}
		base.setPosition(new Point3D(0, 0, 0));
		temp.setPosition(new Point3D(0, 0, 0));
		temp.setHeight(base.getHeight());
		this.applyPosition(temp);

		// apply attributes
		base.setLength(temp.getLength());
		base.setWidth(temp.getWidth());

		// convert non-centered coordinates to centered coordinates
		this.convertToAbsoluteCoordinates(temp);
		this.convertToCenteredCoordinaltes(temp);
		base.setPosition(temp.getPosition());
		for (RegularDistrict dist : base.getDistricts()) {
			dist.setParentDistrict(null);
		}
	}

	/**
	 * Arranges a given {@link RegularDistrict} instance within the city, i.e. sets its absolute, but no centered, position.
	 *
	 * Precondition: The width, height and height of all contained buildings and districts are set.
	 *
	 * @param district
	 *            The district to arrange within the city.
	 * @throws IllegalArgumentException
	 *             If the district passed in is {@code null}.
	 */
	private void applyPosition(final RegularDistrict district) throws IllegalArgumentException {

		if (district == null) {
			throw new IllegalArgumentException("The district passed in is null.");
		}

		// a list containing all direct children (both districts and buildings) of this district
		final List<Entity2D> children = new LinkedList<Entity2D>();
		for (RegularBuilding building : district.getBuildungs()) {
			children.add(building);
		}

		district.setPosition(new Point3D(0, 0, 0));
		for (RegularDistrict childDistrict : district.getChildDistricts()) {
			// recursive call for each child district
			children.add(childDistrict);
			this.applyPosition(childDistrict);
		}

		// arrange child elements within district
		final Pair<Float, Float> measures = this.arrange(children);

		// set width and length of current district
		district.setWidth(measures.getLeft());
		district.setLength(measures.getRight());
	}

	/**
	 * Arranges a given {@link Entity2D} instances within the city, i.e. sets their relative positions in the final visualization.
	 *
	 * Side effect: This method sorts the given entities list by non-decreasing width using a {@link Entity2dComparator}.
	 *
	 * @param entities
	 *            The entities to arrange within the city, which have to be all direct children of a common (super-) package.
	 * @return A {@link Pair} containing the width (left element) and length (right element) of the area comprising the given set of entities. In other words: The
	 *         width and length of the entities' direct super-package in the final visualization.
	 */
	private Pair<Float, Float> arrange(final List<Entity2D> entities) {

		Collections.sort(entities, new Entity2dComparator());
		final double orientationWidth = Math.max(Math.sqrt(this.computeMinimalArea(entities)), entities.get(0).getWidth()) * 1.6;

		float width = this.districtBorder;
		float length = this.districtBorder;

		float currentZpos = this.districtBorder;
		float currentXpos = this.districtBorder;

		for (Entity2D entity : entities) {

			// add interspace
			if (currentZpos > this.districtBorder) {
				currentZpos += this.buildingInterspace;
			}

			// break line, if demanded
			if (currentZpos + entity.getWidth() + this.districtBorder > orientationWidth) {
				// placing entity in same column would exceed maxWidth
				length += this.buildingInterspace;
				currentXpos = length;
				currentZpos = this.districtBorder;
			}

			// set relative position
			entity.setPosition(new Point3D(currentXpos, this.computeHeight(entity), currentZpos));

			// update position pointer
			currentZpos += entity.getWidth();

			// update dimensions
			width = Math.max(currentZpos, width);
			length = Math.max(currentXpos + entity.getLength(), length);
		}

		return Pair.of(width + this.districtBorder, length + this.districtBorder);
	}

	/**
	 * Computes the side length of the minimal quadratic area, which may comprise the given {@link Entity2D} instances including any {@link #districtBorder} and
	 * {@link #buildingInterspace}.
	 *
	 * @param entities
	 *            The entities to compute the minimal comprising area's side length.
	 * @return The side length of the minimal quadratic area being able to comprise the given entities.
	 */
	private double computeMinimalArea(final List<Entity2D> entities) {

		// compute minimal area
		double result = 0;
		for (Entity2D ent : entities) {
			result += (ent.getLength() + this.buildingInterspace) * ent.getWidth();
		}

		// add district border
		return Math.sqrt(result) + (this.districtBorder * 2);
	}

	/**
	 * Computes the absolute height of the given {@link Entity2D} instance in the visualization assuming that the origin y-coordinate is horizontally centered on
	 * the location of all level 0 packages.
	 *
	 * @param entity
	 *            The entity2d element to compute its absolute height.
	 * @return The absolute height of the given entity.
	 * @throws IllegalArgumentException
	 *             If the entity passed in of a different type than {@link RegularBuilding} or {@link RegularDistrict}.
	 */
	private double computeHeight(final Entity2D entity) throws IllegalArgumentException {

		if (entity instanceof RegularBuilding) {
			final RegularDistrict district = ((RegularBuilding) entity).getDistrict();
			return -(this.computeHeight(district) + 0.5 * district.getHeight());

		} else if (entity instanceof RegularDistrict) {
			RegularDistrict currentDistrict = (RegularDistrict) entity;
			float heigth = 0;

			while (true) {
				// iterate through all parent districts
				heigth += currentDistrict.getHeight();
				if (currentDistrict.getParentDistrict() == null) {
					break;
				}
				currentDistrict = currentDistrict.getParentDistrict();
			}
			// origin y-coordinate is located at all level 0 packages (centered)
			return -(heigth - 0.5 * (currentDistrict.getHeight() + ((RegularDistrict) entity).getHeight()));
		}
		throw new IllegalArgumentException("You cannot pass in an entity of a different type than 'RegularBuilding' or 'RegularDistrict'.");
	}

	/**
	 * Converts the relative position attributes of the given {@link RegularDistrict} and all its (nested) child instances into absolute positions. After the
	 * {@link #arrange(List, double)} method was invoked, all position coordinates are set relative to the {@link RegularDistrict} object on which they will be
	 * placed in the final visualization. The relative position {@code (0,0,0)} is individually defined as the location of the rear left corner of that district.
	 * This method sets all position of the given entities relative to their common base, where {@code (0,0,0)} denotes analogically the same corner.
	 *
	 * @param district
	 *            The district to convert its children's relative positions into absolute ones.
	 */
	private void convertToAbsoluteCoordinates(final RegularDistrict district) {

		for (Entity2D child : district.getBuildungs()) {
			final Point3D childPos = child.getPosition();
			Point3D tempPos = new Point3D(childPos.getX()+district.getPosition().getX(), childPos.getY(), childPos.getZ()+district.getPosition().getZ());
			child.setPosition(tempPos);
		}

		for (Entity2D child : district.getChildDistricts()) {
			final Point3D childPos = child.getPosition();
			Point3D tempPos = new Point3D(childPos.getX()+district.getPosition().getX(), childPos.getY(), childPos.getZ()+district.getPosition().getZ());
			child.setPosition(tempPos);
		}

		for (RegularDistrict child : district.getChildDistricts()) {
			this.convertToAbsoluteCoordinates(child);
		}
	}

	/**
	 * Converts the positions of the given base and of all its (nested) child entities to centered positions, where location {@code (0,0,0)} denotes the center point
	 * of the given {@link RegularDistrict}.
	 *
	 * @param base
	 *            The base to convert its and all its contained entities' absolute positions to centered positions.
	 */
	private void convertToCenteredCoordinaltes(final RegularDistrict base) {

		// use base's center as the entire visualization's center
		this.convertToCenteredCoordinatesHelper(base, (base.getLength() - this.baseInterspace - this.buildingInitLength) / 2 - 2 * this.districtBorder,
				base.getWidth() / 2);
	}

	/**
	 * Helper method to {@link #convertToCenteredCoordinaltes(RegularDistrict)}. It converts the positions of the given entities into centered ones.
	 *
	 * @param entity
	 *            The entities to convert their absolute positions into centered positions.
	 * @param xCoordinate
	 *            The x-coordinate of the city's regular base's center.
	 * @param zCoordinate
	 *            The z-coordinate of the city's regular base's center.
	 */
	private void convertToCenteredCoordinatesHelper(final Entity2D entity, final double xCoordinate, final double zCoordinate) {

		// compute and apply correction
		final double xPos = -entity.getPosition().getX() + xCoordinate - (entity.getLength() / 2);
		final double zPos = -entity.getPosition().getZ() + zCoordinate - (entity.getWidth() / 2);

		entity.setPosition(new Point3D(xPos, entity.getPosition().getY(), zPos));

		// recursive call for each direct child
		if (entity instanceof RegularDistrict) {
			final RegularDistrict dist = (RegularDistrict) entity;
			for (RegularDistrict district : dist.getChildDistricts()) {
				this.convertToCenteredCoordinatesHelper(district, xCoordinate, zCoordinate);
			}
			for (RegularBuilding building : dist.getBuildungs()) {
				this.convertToCenteredCoordinatesHelper(building, xCoordinate, zCoordinate);
			}
		}
	}

}

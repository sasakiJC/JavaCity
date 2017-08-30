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

import data.statics.SClass;
import dev.javacity.core.configuration.VisualProperties;
import metaphor.entities.Floor;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;

/**
 * A dimension applier responsible for assigning the correct height, width and length attribute values to any given metaphor model element.
 *
 * @author pdo
 *
 */
public class DimensionApplier {

	// =========================== Attributes =================================

	/** The height of each {@link RegularDistrict} and {@link AdministrationDistrict} instance. */
	private float districtHeight = VisualProperties.getInstance().getDistrictHeight();

	/** The height of each {@link RegularBase} and {@link AdministrationBase} instance. */
	private float baseHeight = VisualProperties.getInstance().getBaseHeight();

	/** The default height of a {@link Floor}. */
	private float floorHeight = VisualProperties.getInstance().getFloorHeight();

	/** The minimal width of a {@link RegularBuilding} or {@link AdministrationBuilding}. */
	private float buildingInitWidth = VisualProperties.getInstance().getBuildingInitWidth();

	/** The width increase of a {@link RegularBuilding} or {@link AdministrationBuilding} per metric value unit. */
	private float buildingWidthStep = VisualProperties.getInstance().getBuildingWidthStep();

	/** The minimal length of a {@link RegularBuilding} or {@link AdministrationBuilding}. */
	private float buildingInitLength = VisualProperties.getInstance().getBuildingInitLength();

	/** The length increase of a {@link RegularBuilding} or {@link AdministrationBuilding} per metric value unit. */
	private float buildingLengthStep = VisualProperties.getInstance().getBuildingLengthStep();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link DimensionApplier} instance.
	 */
	public DimensionApplier() {/* nothing to do */}

	// ============================ Methods ===================================

	/**
	 * Updates all visual settings attributes of this instance.
	 */
	public void updateAttributes() {

		this.districtHeight = VisualProperties.getInstance().getDistrictHeight();
		this.baseHeight = VisualProperties.getInstance().getBaseHeight();
		this.floorHeight = VisualProperties.getInstance().getFloorHeight();
		this.buildingInitWidth = VisualProperties.getInstance().getBuildingInitWidth();
		this.buildingWidthStep = VisualProperties.getInstance().getBuildingWidthStep();
		this.buildingInitLength = VisualProperties.getInstance().getBuildingInitLength();
		this.buildingLengthStep = VisualProperties.getInstance().getBuildingLengthStep();
//		this.districtBorder = VisualProperties.getInstance().getDistrictBorder();
//		this.buildingInterspace = VisualProperties.getInstance().getBuildingInterspace();
	}

	/**
	 * Sets all dimensions attributes (width, length and height) of the given {@link RegularBuilding} instance.
	 *
	 * @param building
	 *            The regular building to set all its dimension attributes.
	 * @throws IllegalArgumentException
	 *             If the given building is {@code null}.
	 */
	public void applyDimensions(final RegularBuilding building) throws IllegalArgumentException {

		if (building == null) {
			throw new IllegalArgumentException("Given building is null.");
		}

		final int widthMetric = ClassMetrics.numMethodsMetric((SClass) building.getDataObject());
		final int lengthMetric = ClassMetrics.numMethodsMetric((SClass) building.getDataObject());

		building.setWidth(this.buildingInitWidth + widthMetric * this.buildingWidthStep);
		building.setLength(this.buildingInitLength + lengthMetric * this.buildingLengthStep);
	}

	/**
	 * Sets the size of the given {@link RegularDistrict} instance. The width and length of a district depends on the size of its containing buildings and
	 * sub-districts. Since they might not have been computed, this method just sets the height attribute. To also compute and set the width and length attribute
	 * value of this district use 'applyPosition(RegularBase)' of class {@link PositionApplier}. That method takes the common regular base of all regular districts
	 * as input.
	 *
	 * @param district
	 *            The regular district to sets its height.
	 * @throws IllegalArgumentException
	 *             If the given district is {@code null}.
	 */
	public void applyDimensions(final RegularDistrict district) throws IllegalArgumentException {

		if (district == null) {
			throw new IllegalArgumentException("Given district is null.");
		}

		district.setHeight(this.districtHeight);
	}

	/**
	 * Sets the height of the given {@link RegularBase} instance, The width and length of a base depend on the size and arrangement of its containing
	 * sub-districts and buildings. Since this might not have been computed jet, this method just sets the height attribute. To also compute and set the width and
	 * length attribute value of this base use 'applyPosition(RegularBase)' of class {@link PositionApplier}.
	 *
	 * @param base
	 *            The regular base to sets its size.
	 * @throws IllegalArgumentException
	 *             If the given base is {@code null}.
	 */
	public void applyDimensions(final RegularBase base) throws IllegalArgumentException {

		if (base == null) {
			throw new IllegalArgumentException("Given base is null.");
		}

		base.setHeight(this.baseHeight);
	}

	/**
	 * Sets the all dimensions (height) of the given {@link RegularFloor} instance.
	 *
	 * @param floor
	 *            The regular floor to sets all its dimension attributes.
	 * @throws IllegalArgumentException
	 *             If the given floor is {@code null}.
	 */
	public void applyDimensions(final RegularFloor floor) throws IllegalArgumentException {

		if (floor == null) {
			throw new IllegalArgumentException("Given floor is null.");
		}

		floor.setHeight(this.floorHeight);
	}

}

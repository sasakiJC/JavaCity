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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.statics.Relation;
import data.statics.SPackage;
import javacity.configuration.VisualProperties;
import javacity.models.data.DataModelUtils;
import javafx.scene.paint.Color;
import metaphor.entities.Cable;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;

/**
 * A color applier to assign the correct color to all metaphor objects.
 *
 * @author pdo
 */
public class ColorApplier {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(ColorApplier.class);

	/** The default color of a {@link RegularBase} or {@link AdministrationBase} instance in the visualization. */
	private Color baseColor = VisualProperties.getInstance().getBaseColor();

	/** The {@link Color} of the innermost district, i.e. the color of the district with the highest nesting level. */
	private Color districtInitColor = VisualProperties.getInstance().getDistrictColorBase();

	/** The color saturation reduction per package nesting level. */
	private float districtColorReduction = VisualProperties.getInstance().getDistrictSaturationDecrease();

	/** The default color of a ground {@link RegularFloor}. */
	private Color groundFloorReduction = VisualProperties.getInstance().getGroundFloorColor();

	/** The default color of a non-ground {@link RegularFloor} or any {@link AdministrationFloor}. */
	private Color upperFloorColor = VisualProperties.getInstance().getUpperFloorColor();

	/** The default color of a an association representing {@link Cable} instance. */
	private Color assiciationColor = VisualProperties.getInstance().getCableAssociationColor();

	/** The default color of a an inheritance representing {@link Cable} instance. */
	private Color inheritanceColor = VisualProperties.getInstance().getCableInheritanceColor();

	/** The default color of a an implementation representing {@link Cable} instance. */
	private Color implementationColor = VisualProperties.getInstance().getCableImplementationColor();

	/** The set of colors uniquely assignable to a thread. */
	private Color[] threadColors;

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link ColorApplier} instance.
	 */
	public ColorApplier() {

		this.initThreadColors();
	}

	// ============================ Methods ===================================

	/**
	 * Updates all visual settings attributes of this instance.
	 */
	public void updateAttributes() {

		this.baseColor = VisualProperties.getInstance().getBaseColor();
		this.districtInitColor = VisualProperties.getInstance().getDistrictColorBase();
		this.districtColorReduction = VisualProperties.getInstance().getDistrictSaturationDecrease();
		this.groundFloorReduction = VisualProperties.getInstance().getGroundFloorColor();
		this.upperFloorColor = VisualProperties.getInstance().getUpperFloorColor();
		this.assiciationColor = VisualProperties.getInstance().getCableAssociationColor();
		this.inheritanceColor = VisualProperties.getInstance().getCableInheritanceColor();
		this.implementationColor = VisualProperties.getInstance().getCableImplementationColor();
	}

	/**
	 * Initializes the {@link #threadColors} attribute, i.e. the array of all uniquely assignable thread colors.
	 */
	private void initThreadColors() {

		final List<Color> threadcolors = new ArrayList<Color>(10);
		for (int i = 1; true; i++) {
			final Color color = VisualProperties.getInstance().getStreetColorX(i);
			if (color == null) {
				break;
			} else {
				threadcolors.add(color);
			}
		}
		this.threadColors = threadcolors.toArray(new Color[0]);
	}

	/**
	 * Returns the {@link Color} representing the {@link SThread} with the given execution order. All method calls of this thread will be visualized in this color.
	 *
	 * @param execOrder
	 *            The execution order of the thread to get its representing color.
	 * @return The color representing the given thread.
	 */
	public Color getThreadColor(final long execOrder) {

		return this.threadColors[(int) (execOrder % this.threadColors.length)];
	}

	/**
	 * Sets the 'color' attribute of the given {@link RegularBase} instance and all contained {@link RegularDistrict} and {@link RegularBuilding} instances.
	 *
	 * @param base
	 *            The base to set its and all contained elements' color.
	 * @throws IllegalArgumentException
	 *             If the base passed in is {@code null}.
	 */
	public void applyColor(final RegularBase base) throws IllegalArgumentException {

		if (base == null) {
			throw new IllegalArgumentException("The base passed in is null.");
		}

		base.setColor(this.baseColor);

		// determine maximum nesting depth of all sub-packages
		int maxLevel = 0;
		for (RegularDistrict district : base.getDistricts()) {
			maxLevel = Math.max(maxLevel, DataModelUtils.maxLevel((SPackage) district.getDataObject()));
		}

		// traverse all sub-packages
		for (RegularDistrict district : base.getDistricts()) {
			this.applyColor(district, maxLevel);
		}
	}

	/**
	 * Sets the 'color' attribute of the given {@link RegularDistrict} instance and of all contained {@link RegularDistrict} and {@link RegularBuilding} instances.
	 * This method is automatically invoked when calling {@link #applyColor(RegularBase)}.
	 *
	 * @param district
	 *            The district to set its and all contained entities' color.
	 * @param maxLevel
	 *            The maximal nesting depth of all regular districts in the currently imported regular base.
	 */
	private void applyColor(final RegularDistrict district, final int maxLevel) {

		final SPackage pack = (SPackage) district.getDataObject();

		// applying color to district
//		final int red = Math.max((int) (this.districtInitColor.getRed() - (maxLevel - pack.getLevel()) * this.districtColorReduction), 0);
//		final int green = Math.max((int) (this.districtInitColor.getGreen() - (maxLevel - pack.getLevel()) * this.districtColorReduction), 0);
//		final int blue = Math.max((int) (this.districtInitColor.getBlue() - (maxLevel - pack.getLevel()) * this.districtColorReduction), 0);

		final int red = Math.max((int) (districtInitColor.getRed()*256 - (maxLevel - pack.getLevel()) * districtColorReduction), 0);
		final int green = Math.max((int) (districtInitColor.getGreen()*256 - (maxLevel - pack.getLevel()) * districtColorReduction), 0);
		final int blue = Math.max((int) (districtInitColor.getBlue()*256 - (maxLevel - pack.getLevel()) * districtColorReduction), 0);

		district.setColor(Color.rgb(red, green, blue));

		// recursive call for each child district
		for (RegularDistrict childDistrict : district.getChildDistricts()) {
			this.applyColor(childDistrict, maxLevel);
		}

		// apply color to static class instance
		for (RegularBuilding building : district.getBuildungs()) {
			if (building.getFloors().size() > 0) {
				this.applyColor(building.getFloors().get(0));
			}
		}
	}

	/**
	 * Sets the 'color' attribute of the given {@link RegularFloor} instance as specified in {@link #groundFloorReduction} and {@link #upperFloorColor} respectively.
	 *
	 * @param floor
	 *            The floor to set its color.
	 * @throws IllegalArgumentException
	 *             If the floor passed in is {@code null}.
	 * @throws UnsupportedOperationException
	 *             If the data object of the specified floor is no instance of {@link SClassInstance} or {@link SClassObject}.
	 */
	public void applyColor(final RegularFloor floor) throws IllegalArgumentException, UnsupportedOperationException {

		if (floor == null) {
			throw new IllegalArgumentException("The floor passed in is null.");
		}

		floor.setColor(groundFloorReduction);

//		if (floor.getDataObject() instanceof SClassInstance) {
//			if (floor.getBuilding().getFloors().isEmpty()) {
//				// floor represents static class object
//				floor.setColor(this.groundFloorReduction);
//			} else {
//				// floor represents dynamic class instance
//				floor.setColor(this.upperFloorColor);
//			}
//		} else {
//			final String error = "Unknown data object detected. Its class is: " + floor.getDataObject().getClass().getName();
//			LOGGER.warn(error);
//			throw new UnsupportedOperationException(error);
//		}
	}


	/**
	 * Sets the 'color' attribute of the given {@link Cable} instance as specified in {@link #assiciationColor} and {@link #inheritanceColor} respectively.
	 *
	 * @param cable
	 *            The cable to set its color.
	 * @throws IllegalArgumentException
	 *             If the cable passed in is {@code null}.
	 * @throws UnsupportedOperationException
	 *             If the {@link RelationType} of the {@link Relation} this cable represents is not {@link #assiciationColor} or {@link #inheritanceColor}.
	 */
	public void applyColor(final Cable cable) throws UnsupportedOperationException, IllegalArgumentException {

		if (cable == null) {
			throw new IllegalArgumentException("The cable passed in is null.");
		}

		final Relation relation = (Relation) cable.getDataObject();

		switch (relation.getType()) {
		case ASSOCIATION:
			cable.setColor(this.assiciationColor);
			break;
		case EXTENSION:
			cable.setColor(this.inheritanceColor);
			break;
		case IMPLEMENTATION:
			cable.setColor(this.implementationColor);
			break;
		default:
			final String error = "Unknown relation type detected. Its class is: " + relation.getClass().getName();
			LOGGER.error(error);
			throw new UnsupportedOperationException(error);
		}
	}

}

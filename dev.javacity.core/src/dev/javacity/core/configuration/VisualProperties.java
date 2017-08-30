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

package dev.javacity.core.configuration;

import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import dev.javacity.core.utils.StringUtils;
import javafx.scene.paint.Color;

/**
 * A utility class to read data from 'visual.properties' file.
 *
 * @author pdo
 *
 */
public final class VisualProperties extends AbstractPropertiesHandler {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(VisualProperties.class);

	// ========================== Constructor =================================

	/**
	 * Private constructor of this class. Instances not constructible from outside.
	 */
	private VisualProperties() {

		super(FileSystem.getInstance().getVisualPropertiesFile());
	}

	// ============================ Methods ===================================

	@Override
	protected void initDefaultProperties() {

		if (super.defaultProperties == null) {

			final Properties defaults = new Properties();

			defaults.put("border.color", "[0,0,0,1]");
			defaults.put("border.width", "1");
			defaults.put("district.border", "0.1");
			defaults.put("district.height", "0.02");
			defaults.put("district.colorBase", "[0,204,204,1]");
			defaults.put("district.saturationDecrease", "20");
			defaults.put("building.initLength", "0.07");
			defaults.put("building.lengthIncrease", "0.035");
			defaults.put("building.initWidth", "0.07");
			defaults.put("building.widthIncrease", "0.035");
			defaults.put("building.interspace", "0.08");
			defaults.put("floor.height", "0.1");
			defaults.put("floor.groundFloor.color", "[153,153,255,1]");
			defaults.put("floor.upperFloor.color", "[102,102,255,1]");
			defaults.put("poster.horizontalSpace", "0.01");
			defaults.put("poster.verticalSpace", "0.01");
			defaults.put("street.color1", "[0,102,0,1]");
			defaults.put("street.color2", "[102,0,102,1]");
			defaults.put("street.color3", "[255,51,51,1]");
			defaults.put("street.color4", "[255,255,0,1]");
			defaults.put("street.color5", "[102,102,0,1]");
			defaults.put("cable.association.color", "[255,255,255,1]");
			defaults.put("cable.inheritance.color", "[51,51,51,1]");
			defaults.put("cable.implementation.color", "[153,153,153,1]");
			defaults.put("line.arrowhead.diameter", "0.015");
			defaults.put("line.arrowhead.height", "0.05");
			defaults.put("line.diameter", "0.01");
			defaults.put("base.height", "0.02");
			defaults.put("base.color", "[204,204,204,1]");
			defaults.put("base.interspace", "0.4");

			super.defaultProperties = defaults;
		}
	}

	/**
	 * Returns the set of all keys in the visual properties file currently loaded.
	 *
	 * @return The set of all keys in this properies file.
	 */
	public Set<Object> getKeySet() {

		return this.properties.keySet();
	}

	/**
	 * Returns the properties value stored with the given key in the visual properties file just loaded.
	 *
	 * @param key
	 *            The key to get its value.
	 * @return The value of the specified key
	 * @throws IllegalArgumentException
	 *             If the loaded properties file does not contain the specified key.
	 */
	public String get(final String key) throws IllegalArgumentException {

		final String retval = this.properties.getProperty(key);
		if (retval == null) {
			final String error = "Properties file does not contain key " + key;
			LOGGER.error(error);
			throw new IllegalArgumentException(error);
		}

		return retval;
	}

	/**
	 * Sets the float value of the specified key.
	 *
	 * @param theFloat
	 *            The float value of the key to set.
	 * @param key
	 *            The key to set its value
	 * @throws IllegalArgumentException
	 *             If the specified key does not require a float as value, the float passed in is {@code null}, the given float is not a number (NaN), is negative,
	 *             or if the key passed in is {@code null}.
	 */
	public void setFloatValue(final float theFloat, final String key) throws IllegalArgumentException {

		if (key == null) {
			throw new IllegalArgumentException("You cannot pass in a null key.");
		}

		// test float value
		if (theFloat < 0 || Float.isNaN(theFloat) || Float.isInfinite(theFloat)) {
			throw new IllegalArgumentException("The given float has to be a positive and finite number.");
		}

		// key contained in properties file?
		if (!this.properties.containsKey(key)) {
			LOGGER.error("Properties file does not contain key " + key);
			throw new IllegalArgumentException("Properties file does not contain key " + key);
		}

		try {
			// does the key represent a float?
			Float.parseFloat((String) this.properties.getProperty(key));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The given key does not represent a float value entry.");
		}

		// put float into properties object
		final String floatString = Float.toString(theFloat);
		this.properties.put(key, floatString);
		super.save();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully saved float value " + floatString + " for key " + key + ".");
		}
	}

	/**
	 * Sets the color value of the specified key.
	 *
	 * @param color
	 *            The color value of the key to set.
	 * @param key
	 *            The key to set its value
	 * @throws IllegalArgumentException
	 *             If the specified key does not require a color as value or either the color or key passed in is {@code null},
	 */
	public void setColorValue(final String key, final Color color) throws IllegalArgumentException {

		if (key == null) {
			throw new IllegalArgumentException("You cannot pass in a null key.");
		}

		if (color == null) {
			throw new IllegalArgumentException("You cannot pass in a null color.");
		}

		// key contained in properties file?
		if (!this.properties.containsKey(key)) {
			final String error = "Properties file does not contain key " + key;
			LOGGER.error(error);
			throw new IllegalArgumentException(error);
		}

		try {
			// does the key represent a color?
			StringUtils.parseFloatArray(this.properties.getProperty(key));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The given key does not represent a color value entry.");
		}

		// put color into properties object
		final String colorString = "[" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "]";
		this.properties.put(key, colorString);
		super.save();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully saved color value " + colorString + " for key " + key + ".");
		}
	}

	/**
	 * Get the value of a property defined by the given key parsed as {@code float}, its default value if parsing process failed, or {@link Float#NaN}, if the
	 * specified
	 * key does not exist in the visual properties file.
	 *
	 * @param key
	 *            The key of the property to get.
	 * @return The value of a property defined by the given key parsed as {@code float}.
	 */
	private float getFloatValue(final String key) {

		float retval = Float.NaN;
		try {
			retval = Float.parseFloat((String) this.properties.getProperty(key));
			if (retval < 0) {
				throw new NumberFormatException("Value is less than zero.");
			}
		} catch (IllegalArgumentException e) { // may also be thrown by 'Float.parseFloat(...)'. A NumberFormatException is an IllegalArgumentException.
			// return and restore default value
			this.initDefaultProperties();
			final String valueString = this.defaultProperties.getProperty(key);
			if (valueString != null) {
				LOGGER.error("Found illegal property value for key " + key + ": " + this.properties.getProperty(key), e);
				super.properties.put(key, valueString);
				retval = Float.parseFloat(valueString);
				super.save();
			}
		}
		return retval;
	}

	/**
	 * Get the value of the given properties parsed as {@link java.awt.Color Color}, its default value if parsing process failed, or {@code null}, if the specified
	 * key does not exist in the visual properties file.
	 *
	 * @param key
	 *            The key of the color property to get.
	 * @return The color representing the value of the given key.
	 */
	private Color getColorValue(final String key) {

		Color retval = null;
		double[] doubles = null;
		try {
			doubles = StringUtils.parseDoubleArray(this.properties.getProperty(key));
			if (doubles.length != 4 || doubles[0] < 0 || doubles[0] > 255 || doubles[1] < 0 || doubles[1] > 255 || doubles[2] < 0 || doubles[2] > 255 || doubles[3] < 0.0 || doubles[3] > 1.0) {
				throw new NumberFormatException("Found illegal property values for key " + key + ": " + doubles.toString());
			}
			retval = new Color(doubles[0]/256, doubles[1]/256, doubles[2]/256, doubles[3]);
		} catch (IllegalArgumentException e) { // may also be thrown by 'ArrayUtils.parseFloatArray(...)'. A NumberFormatException is an IllegalArgumentException.
			this.initDefaultProperties();
			final String valueString = this.defaultProperties.getProperty(key);
			if (valueString != null) {
				LOGGER.error("Found illegal property value for key " + key + ": " + this.properties.getProperty(key), e);
				super.properties.put(key, valueString);
				doubles = StringUtils.parseDoubleArray(valueString);
				retval = new Color(doubles[0]/256, doubles[1]/256, doubles[2]/256, doubles[3]);
				super.save();
			}
		}
		return retval;
	}

	/**
	 * Get the value of the property 'district.border'.
	 *
	 * @return The value of the property.
	 */
	public float getDistrictBorder() {
		return this.getFloatValue("district.border");
	}

	/**
	 * Get the value of the property 'district.height'.
	 *
	 * @return The value of the property.
	 */
	public float getDistrictHeight() {
		return this.getFloatValue("district.height");
	}

	/**
	 * Get the value of the property 'district.colorBase'.
	 *
	 * @return The value of the property.
	 */
	public Color getDistrictColorBase() {
		return this.getColorValue("district.colorBase");
	}

	/**
	 * Get the value of the property 'district.saturationDecrease'.
	 *
	 * @return The value of the property.
	 */
	public float getDistrictSaturationDecrease() {
		return this.getFloatValue("district.saturationDecrease");
	}

	/**
	 * Get the value of the property 'building.initLength'.
	 *
	 * @return The value of the property.
	 */
	public float getBuildingInitLength() {
		return this.getFloatValue("building.initLength");
	}

	/**
	 * Get the value of the property 'building.lengthIncrease'.
	 *
	 * @return The value of the property.
	 */
	public float getBuildingLengthStep() {
		return this.getFloatValue("building.lengthIncrease");
	}

	/**
	 * Get the value of the property 'building.initWidth'.
	 *
	 * @return The value of the property.
	 */
	public float getBuildingInitWidth() {
		return this.getFloatValue("building.initWidth");
	}

	/**
	 * Get the value of the property 'building.widthIncrease'.
	 *
	 * @return The value of the property.
	 */
	public float getBuildingWidthStep() {
		return this.getFloatValue("building.widthIncrease");
	}

	/**
	 * Get the value of the property 'building.interspace'.
	 *
	 * @return The value of the property.
	 */
	public float getBuildingInterspace() {
		return this.getFloatValue("building.interspace");
	}

	/**
	 * Get the value of the property 'floor.height'.
	 *
	 * @return The value of the property.
	 */
	public float getFloorHeight() {
		return this.getFloatValue("floor.height");
	}

	/**
	 * Get the value of the property 'floor.groundFloor.color'.
	 *
	 * @return The value of the property.
	 */
	public Color getGroundFloorColor() {
		return this.getColorValue("floor.groundFloor.color");
	}

	/**
	 * Get the value of the property 'poster.verticalSpace'.
	 *
	 * @return The value of the property.
	 */
	public float getPosterVerticalDistance() {
		return this.getFloatValue("poster.verticalSpace");
	}

	/**
	 * Get the value of the property 'poster.horizontalSpace'.
	 *
	 * @return The value of the property.
	 */
	public float getPosterHorizontalDistance() {
		return this.getFloatValue("poster.horizontalSpace");
	}

	/**
	 * Get the value of the property 'poster.distanceToWall'.
	 *
	 * @return The value of the property.
	 */
	public float getPosterDistanceToWall() {
		return this.getFloatValue("poster.distanceToWall");
	}

	/**
	 * Get the value of the property 'floor.upperFloor.color'.
	 *
	 * @return The value of the property.
	 */
	public Color getUpperFloorColor() {
		return this.getColorValue("floor.upperFloor.color");
	}

	/**
	 * Get the value of the property 'street.colorX', where 'X' is the index of the color property.
	 * The method returns {@code null}, if no color property with the given {@code index} exists.
	 *
	 * @param index
	 *            The index of the street color.
	 *
	 * @return The value of the property or {@code null}, if no color property with the given {@code index} exists.
	 */
	public Color getStreetColorX(final int index) {
		return this.getColorValue("street.color" + index);
	}

	/**
	 * Get the value of the property 'line.arrowhead.diameter'.
	 *
	 * @return The value of the property.
	 */
	public float getLineArrowheadDiameter() {
		return this.getFloatValue("line.arrowhead.diameter");
	}

	/**
	 * Get the value of the property 'line.arrowhead.height'.
	 *
	 * @return The value of the property.
	 */
	public float getLineArrowheadHeight() {
		return this.getFloatValue("line.arrowhead.height");
	}

	/**
	 * Get the value of the property 'line.diameter'.
	 *
	 * @return The value of the property.
	 */
	public float getLineDiameter() {
		return this.getFloatValue("line.diameter");
	}

	/**
	 * Get the value of the property 'cable.association.color'.
	 *
	 * @return The value of the property.
	 */
	public Color getCableAssociationColor() {
		return this.getColorValue("cable.association.color");
	}

	/**
	 * Get the value of the property 'cable.inheritance.color'.
	 *
	 * @return The value of the property.
	 */
	public Color getCableInheritanceColor() {
		return this.getColorValue("cable.inheritance.color");
	}

	/**
	 * Get the value of the property 'cable.implementation.color'.
	 *
	 * @return The value of the property.
	 */
	public Color getCableImplementationColor() {
		return this.getColorValue("cable.implementation.color");
	}

	/**
	 * Get the value of the property 'border.color'.
	 *
	 * @return The value of the property.
	 */
	public Color getBorderColor() {
		return this.getColorValue("border.color");
	}

	/**
	 * Get the value of the property 'border.width'.
	 *
	 * @return The value of the property.
	 */
	public float getBorderWidth() {
		return this.getFloatValue("border.width");
	}

	/**
	 * Get the value of the property 'cable.arrowhead.diameter'.
	 *
	 * @return The value of the property.
	 */
	public float getCableArrowheadDiameter() {
		return this.getFloatValue("cable.arrowhead.radius");
	}

	/**
	 * Get the value of the property 'base.height'.
	 *
	 * @return The value of the property.
	 */
	public float getBaseHeight() {
		return this.getFloatValue("base.height");
	}

	/**
	 * Get the value of the property 'base.color'.
	 *
	 * @return The value of the property.
	 */
	public Color getBaseColor() {
		return this.getColorValue("base.color");
	}

	/**
	 * Get the value of the property 'base.interspace'.
	 *
	 * @return The value of the property.
	 */
	public float getBaseInterspace() {
		return this.getFloatValue("base.interspace");
	}

	// ========================== Inner Classes ===============================

	/**
	 * Get the singleton instance of this class. Will be created if not existing yet. This method is thread save.
	 *
	 * @return The singleton instance of this class.
	 */
	public static VisualProperties getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * A class holding the only instance of the {@link VisualProperties} class.
	 *
	 * @author pdo
	 *
	 */
	private static final class InstanceHolder {
		/** The only instance of the {@link VisualProperties} class. */
		private static final VisualProperties INSTANCE = new VisualProperties();

		/** Private constructor. Class instances should not be constructible. */
		private InstanceHolder() {}
	}

}

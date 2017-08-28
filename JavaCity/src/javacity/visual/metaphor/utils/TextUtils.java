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

/***************************************************************************
 * java3Dからjavafxへ
 *
 * 改定
 **************************************************************************/

package javacity.visual.metaphor.utils;

import javafx.geometry.BoundingBox;
import javafx.scene.shape.Shape3D;
import metaphor.entities.RegularDistrict;

/**
 * A custom utility class to create three-dimensional text strings ({@link Text3D}) to visually identify the java3d objects in the visualization.
 *
 * @author pdo
 *
 */
public final class TextUtils {

	// ========================== Constructor =================================

	/**
	 * This class is not intended for instantiation since it contains static methods only.
	 */
	private TextUtils() {/* Nothing to do. */}

	// ============================ Methods ===================================

	/**
	 * Creates a three-dimensional text string to be placed on a {@link RegularDistrict} in the visualization and returns it as the first child of the
	 * {@link TransformGroup} returned by this method.
	 *
	 * @param text
	 *            The text to be displayed of the {@link Text3D} object.
	 * @param location
	 *            The location of the text 3d object in the visualization.
	 * @return The transform group containing the text object as first child.
	 * @throws IllegalArgumentException
	 *             If the specified location is {@code null}.
	 */
	public static TransformGroup createDistrictText(final String text, final Point3f location) throws IllegalArgumentException {

		if (location == null) {
			throw new IllegalArgumentException("Text cannot be placed at a null location.");
		}

		final Font3D font = new Font3D(new Font("SansSerif", Font.PLAIN, 1), new FontExtrusion());
		final Text3D label3D = new Text3D(font, text, location);

		final Transform3D trans = new Transform3D();
		trans.setScale(0.045d);

		// arrange it on district
		final Transform3D transZ = new Transform3D();
		transZ.setRotation(TransformUtils.computeRotationMatrix(new Vector3d(0, 0, -1)));

		final Transform3D transY = new Transform3D();
		transY.setRotation(TransformUtils.computeRotationMatrix(new Vector3d(-1, 0, 0)));

		final Transform3D transX = new Transform3D();
		transX.setRotation(TransformUtils.computeRotationMatrix(new Vector3d(1, 0, 0)));

		trans.mul(transZ);
		trans.mul(transZ);
		trans.mul(transX);
		trans.mul(transY);

		final TransformGroup subTg = new TransformGroup();
		subTg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		subTg.addChild(new Shape3D(label3D, new Appearance()));
		subTg.setTransform(trans);
		return subTg;
	}

	/**
	 * Computes the dimensions of the {@link Text3D} instance passed in.
	 *
	 * @param text3d
	 *            The text 3d object to determine its dimensions
	 * @return A {@link Point3d} object with the length, height and width of the specified text3d object.
	 * @throws IllegalArgumentException
	 *             If the text3d instance passed in is {@code null}.
	 */
	public static Point3d computeDimensions(final Text3D text3d) throws IllegalArgumentException {

		if (text3d == null) {
			throw new IllegalArgumentException("Null text3ds have no dimensions.");
		}

		final BoundingBox box = new BoundingBox();
		text3d.getBoundingBox(box);

		final Point3d upper = new Point3d();
		final Point3d lower = new Point3d();
		box.getLower(lower);
		box.getUpper(upper);

		upper.sub(lower);
		return upper;
	}
}

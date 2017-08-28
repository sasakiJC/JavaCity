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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sun.javafx.geom.transform.SingularMatrixException;

import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

/**
 * A utility class offering commonly used transformation related methods.
 *
 * @author pdo
 *
 */
public final class TransformUtils {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(TransformUtils.class);

	// ========================== Constructor =================================

	/** Private constructor. This class should not be instantiated since it contains static methods only. */
	private TransformUtils() {}

	// ============================ Methods ===================================

	/**
	 * Computes the rotation matrix equivalent to the given direction vector assuming that visual element to be rotated is currently oriented in direction (0,1,0).
	 *
	 * @param direction
	 *            The direction to compute the equivalent rotation matrix for.
	 * @return The rotation matrix equivalent to the given direction.
	 * @throws IllegalArgumentException
	 *             If the given direction vector is {@code null}.
	 * @throws SingularMatrixException
	 *             If the computed rotation matrix could not be inverted.
	 */
	public static double[] computeRotationMatrix(final Point3D direction) throws IllegalArgumentException {

		if (direction == null) {
			throw new IllegalArgumentException("Given direction vector is null.");
		}

		final Point3D yDim =  new Point3D(direction.getX(),direction.getY(),direction.getZ());
		yDim.normalize();

		Point3D xDim;
		if (yDim.getX() == 0 && yDim.getZ() == 0) {
			xDim = new Point3D(-yDim.getY(), 0f, 0f);
		} else {
			xDim = new Point3D(0f, -1f, 0f);
		}

		Point3D zDim = new Point3D(0,0,0);
		zDim = xDim.crossProduct(yDim);
		zDim.normalize();

		xDim = zDim.crossProduct(yDim);
		xDim.normalize();
		//xDim.negate();
		xDim = new Point3D(-xDim.getX(),-xDim.getY(),-xDim.getZ());

		final double[] rotation = {xDim.getX(), yDim.getX(), zDim.getX(), 0, xDim.getY(), yDim.getY(), zDim.getY(), 0, xDim.getZ(), yDim.getZ(), zDim.getZ(), 0};

		return rotation;
	}

	public static Rotate computeRotation(final Point3D direction) {
		if (direction == null) {
			throw new IllegalArgumentException("Given direction vector is null.");
		}

		final Point3D yDim =  new Point3D(direction.getX(),direction.getY(),direction.getZ());
		yDim.normalize();


		Point3D xDim;
		if (yDim.getX() == 0 && yDim.getZ() == 0) {
			xDim = new Point3D(-yDim.getY(), 0f, 0f);
			return new Rotate(0,new Point3D(0,0,0));
		} else {
			xDim = new Point3D(0f, -1f, 0f);
		}

		double angle = xDim.angle(yDim);

		Point3D zDim = new Point3D(0,0,0);
		zDim = xDim.crossProduct(yDim);
		zDim.normalize();

		return new Rotate(angle,zDim);
	}

	/**
	 * Creates a new {@link TransformGroup} performing the rotations specified by the given rotation angles.
	 *
	 * @param rotX
	 *            The rotation around the x-axis to perform.
	 * @param rotY
	 *            The rotation around the y-axis to perform.
	 * @param rotZ
	 *            The rotation around the z-axis to perform.
	 * @return A transform group performing the specified rotations.
	 */
	public static Transform createTransformation(final double rotX, final double rotY, final double rotZ) {

		final Rotate rot1 = new Rotate(rotX);
		final Rotate rot2 = new Rotate(rotY);
		final Rotate rot3 = new Rotate(rotZ);

		Transform t1 = rot1.createConcatenation(rot2);
		Transform t2 = t1.createConcatenation(rot3);

		return t2;
	}

	/**
	 * Instantiates a {@link TransformGroup} making any visual object on which this group is applied to point from the {@code source} to the {@code target} point in
	 * space. I.e. the object's bottom end will start at {@code source} and its top will point and and at the given {@code target} coordinate.
	 *
	 * @param source
	 *            The point in space a visual object this transform group is applied to will start.
	 * @param target
	 *            The point in space a visual object this transform group is applied to will point at.
	 * @return A transform group making any object go from the given {@code source} to the {@code target} point.
	 * @throws IllegalArgumentException
	 *             If at least one vector passed in is {@code null}.
	 */
	public static List<Transform> computeTransformation(final Point3D source, final Point3D target) throws IllegalArgumentException {

		if (source == null || target == null) {
			throw new IllegalArgumentException("You may not pass in null vectors.");
		}

		// computing length
		Point3D diff = new Point3D(0,0,0);
		diff = target.subtract(source);

		// computing position
		Point3D pos = new Point3D(0,0,0);
		pos = source.add(diff.multiply(0.5));

		// creating transform group
		Rotate rot = TransformUtils.computeRotation(diff);
		final List<Transform> trans = TransformUtils.createTransformGroup(pos, rot);

		return trans;
	}

	/**
	 * Creates a new {@link TransformGroup} instance performing the given translation and rotation on any object this group is applied to. I.e. it shifts an attached
	 * object to the defined point in space and rotates it using the given rotation matrix.
	 *
	 * @param translation
	 *            The translation vector to add to the transform group being created.
	 * @param rotation
	 *            The rotation matrix to add to the transform group being created.
	 * @return A new transform group performing the given translation and rotation.
	 * @throws IllegalArgumentException
	 *             If at least one argument is {@code null}.
	 */
	public static List<Transform> createTransformGroup(final Point3D translation, final Rotate rotation) throws IllegalArgumentException {

		if (translation == null) {
			throw new IllegalArgumentException("The given translation vector is null.");
		}
		if (rotation == null) {
			throw new IllegalArgumentException("The given rotation matrix is null.");
		}

		ArrayList<Transform> list = new ArrayList<Transform>();
		list.add(new Translate(translation.getX(), translation.getY(), translation.getZ()));
		list.add(rotation);
		return list;
	}

	/**
	 * Creates a new {@link TransformGroup} instance performing the given translation on any object this group is applied to. I.e. it shifts an attached object to
	 * the defined point in space.
	 *
	 * @param translation
	 *            The translation vector to add to the transform group being created.
	 * @return A new transform group performing the given translation and rotation.
	 * @throws IllegalArgumentException
	 *             If the given translation is {@code null}.
	 */
	public static List<Transform> createTransformGroup(final Point3D translation) throws IllegalArgumentException {

		if (translation == null) {
			throw new IllegalArgumentException("The given translation vector is null.");
		}

		ArrayList<Transform> list = new ArrayList<Transform>();
		list.add(new Translate(translation.getX(), translation.getY(), translation.getZ()));
		return list;
	}
}

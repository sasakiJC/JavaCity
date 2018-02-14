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


package javacity.view.metaphor.ambience;

import org.apache.log4j.Logger;

import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 * A class to manage the point and angle, the user watches the city from.
 *
 * @author pdo
 */
public final class ViewPoint {

	// =========================== Attributes =================================

	/** The default and initial viewpoint angle. */
	private static final double DEFAULT_ANGLE = -40;

	/** The default and initial viewpoint position. */
	private static final Point3D DEFAULT_POSITION = new Point3D(1, -1, -2.5);

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(ViewPoint.class);

	/** The simple universe, in which the viewpoint is set. */
//	private SimpleUniverse universe;
	private SubScene scene;

	/** The current viewpoint angle. */
	private double angle = DEFAULT_ANGLE;

	/** The current viewpoint position. */
	private Point3D position = DEFAULT_POSITION;

	// ========================== Constructor =================================

	/**
	 * Private default constructor of this class. Instances not constructible from outside.
	 */
	private ViewPoint() {}

	// ============================ Methods ===================================

	/**
	 * Initializes this viewpoint controller with the universe, in which the viewpoint is to be set.
	 *
	 * @param theUniverse
	 *            The universe, in which the viewpoint is to be set.
	 * @throws IllegalArgumentException
	 *             If the simple universe passed in is {@code null}.
	 */
	public void init(final SubScene scene) throws IllegalArgumentException {

		if (scene == null) {
			throw new IllegalArgumentException("You may not pass in a null universe.");
		}

//		this.universe = theUniverse;
		this.scene = scene;

	}

	/**
	 * Sets the viewpoint in the given {@link SimpleUniverse} instance to the specified position and angle.
	 *
	 * @param newPosition
	 *            The new viewpoint position.
	 * @param newAngle
	 *            The new viewpoint angle.
	 * @throws IllegalArgumentException
	 *             If either the universe or the position vector is {@code null}.
	 */
	public void setViewpoint(final Point3D newPosition, final double newAngle) throws IllegalArgumentException {

		if (newPosition == null) {
			throw new IllegalArgumentException("You may not pass in a null vector.");
		}

		PerspectiveCamera cam = (PerspectiveCamera) this.scene.getCamera();

		if(cam.getTransforms().size()!=0){
			cam.getTransforms().clear();
		}

		Rotate rot = new Rotate(newAngle);
		rot.setAxis(new Point3D(1,1,0));

		cam.getTransforms().addAll(
				new Translate(newPosition.getX(),newPosition.getY(),newPosition.getZ())
				,rot);



//		// retrieve current transform group and transformation
//		final TransformGroup group = this.universe.getViewingPlatform().getViewPlatformTransform();
//		final Transform3D transform = new Transform3D();
//		group.getTransform(transform);
//
//		// set new transformation
//		transform.setTranslation(newPosition);
//		transform.setRotation(new AxisAngle4f(1, 0, 0, (float) Math.toRadians(newAngle)));
//		group.setTransform(transform);

		// update attributes
		this.angle = newAngle;
		this.position = newPosition;

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully set viewpoint to position " + newPosition.toString() + " with an angle of " + newAngle + ".");
		}
	}

	/**
	 * Resets the current viewpoint to its default position as defined in {@link #DEFAULT_ANGLE} and {@link #DEFAULT_POSITION}.
	 */
	public void resetViewpoint() {

		this.setViewpoint(DEFAULT_POSITION, DEFAULT_ANGLE);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully reset viewpoint to position " + DEFAULT_POSITION + " with an angle of " + DEFAULT_ANGLE + ".");
		}
	}

	/**
	 * Returns the viewpoint position currently set.
	 *
	 * @return The current viewpoint position.
	 */
	public Point3D getViewpointPosition() {

		return this.position;
	}

	/**
	 * Returns the viewpoint angle currently set.
	 *
	 * @return The current viewpoint angle.
	 */
	public double getViewpointAngle() {

		return this.angle;
	}

	// ========================== Inner Classes ===============================

	/**
	 * Get the singleton instance of this class. Will be created if not existing yet. This method is thread save.
	 *
	 * @return The singleton instance of this class.
	 */
	public static ViewPoint getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * A static class holding the only instance of the {@link Viewpoint} class to realize the singleton pattern.
	 *
	 * @author pdo
	 *
	 */
	private static final class InstanceHolder {
		/** The only instance of the {@link Viewpoint} class. */
		private static final ViewPoint INSTANCE = new ViewPoint();

		/** Private constructor. Class instances should not be constructible. */
		private InstanceHolder() {}
	}

}

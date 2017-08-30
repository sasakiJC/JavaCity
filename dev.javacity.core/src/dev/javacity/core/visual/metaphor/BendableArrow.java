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

package dev.javacity.core.visual.metaphor;

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

/**
 * A bendable arrow composed of multiple {@link Pipe} instances and one {@link Arrow} instance. It behaves like a usual arrow, but it is is bended on an arbitrary
 * set of points in three-dimensional space.
 *
 * @author pdo
 *
 */
public class BendableArrow extends Group {

	// =========================== Attributes =================================

	/** The default interspace between the bendable and its surrounding border. */
	private static final float BORDER_OFFSET = 0.0005f;

	/** The corner points of this {@link BendableArrow} instance represented by {@link Vector3d} objects in proper order. */
	private final Point3D[] points;

	/** The common {@link TransformGroup} instance to add all components of this bendable arrow to. */
//	private final TransformGroup group = new TransformGroup();

	/** The {@link Appearance} instance all components of this bendable arrow commonly share. */
//	private Appearance app = AppearanceUtils.createReadWriteAppearance();
	private PhongMaterial mat = new PhongMaterial();

//	private Appearance borderApp = AppearanceUtils.createBorderAppearance();

	/** A list of all {@link Pipe} components this bendable arrow is composed of. */
	private final List<Pipe> pipes = new LinkedList<Pipe>();

	/** The diameter of this bendable arrow. */
	private final float diameter;

	// ========================== Constructors ================================

	/**
	 * Creates a new {@link BendableArrow} instance connecting the given coordinates in given order.
	 *
	 * @param pos
	 *            An array of {@link Vector3d} instances, each representing one bendpoint coordinate in proper order.
	 * @param diameter
	 *            The diameter of the bendable arrow to create.
	 * @throws IllegalArgumentException
	 *             If any vector passed in is {@code null} or the given diameter is negative.
	 */
	public BendableArrow(final Point3D[] pos, final float diameter) throws IllegalArgumentException {

		super();

		for (Point3D vec : pos) {
			if (vec == null) {
				throw new IllegalArgumentException("You may not pass in null vectors.");
			}
		}

		if (diameter < 0) {
			throw new IllegalArgumentException("The given diameter is negative.");
		}

//		this.setCapability(ALLOW_PARENT_READ);

		this.points = pos.clone();
		this.diameter = diameter;
		this.sharedConstructor();
	}

	/**
	 * Creates a new {@link BendableArrow} instance starting from and reaching to to given point in space with the defined bendpoints.
	 *
	 * @param source
	 *            The point, where the bottom end of this bendable arrow will be begin.
	 * @param target
	 *            The point, where the top end of this bendable arrow will end.
	 * @param diameter
	 *            The diameter of the bendable arrow to create.
	 * @param bends
	 *            The set of points in space on at which this bendable arrow will be bended.
	 * @throws IllegalArgumentException
	 *             If any vector passed in is {@code null} or the given diameter is negative.
	 */
	public BendableArrow(final Point3D source, final Point3D target, final float diameter, final Point3D... bends) throws IllegalArgumentException {

		super();

		if (source == null || target == null) {
			throw new IllegalArgumentException("You may not pass in null vectors.");
		}
		if (diameter < 0) {
			throw new IllegalArgumentException("The given diameter is negative.");
		}

		// set points attribute
		this.points = new Point3D[bends.length + 2];
		this.points[0] = source;
		this.points[bends.length + 1] = target;

		int index = 1;
		for (Point3D bendpoint : bends) {
			if (bendpoint == null) {
				throw new IllegalArgumentException("You may not pass in a null vector.");
			}
			this.points[index++] = bendpoint;
		}

		this.diameter = diameter;
		this.sharedConstructor();
	}

	// ============================ Methods ===================================

	/**
	 * Constructor operations commonly executed by all constructors of this class. They create this {@link BendableArrow} instance from a number of {@link Pipe} and
	 * {@link Arrow} components and enable pick reporting on this object's appearance ({@link #app}).
	 */
	private void sharedConstructor() {

		// set pick reporting and collidable
//		this.app.setCapability(ENABLE_PICK_REPORTING);
//		this.setCollidable(true);

		// create components
		final int arrowPos = (this.points.length - 1) >> 1;
		for (int i = 0; i < this.points.length - 1; i++) {
			if (i == arrowPos) {
//				TransformGroup arrowTG = BendableArrowBuilder.createArrowComponent(this.points[i], this.points[i + 1], this.diameter, this.app);
				Arrow arrowG = BendableArrowBuilder.createArrowComponent(this.points[i], this.points[i + 1], this.diameter, this.mat);
				this.pipes.add((Arrow) arrowG);
				this.getChildren().add(arrowG);

				// add border
//				arrowTG = BendableArrowBuilder.createArrowComponent(this.points[i], this.points[i + 1], this.diameter + BORDER_OFFSET * 2, this.app);
				arrowG = BendableArrowBuilder.createArrowComponent(this.points[i], this.points[i + 1], this.diameter + BORDER_OFFSET * 2, this.mat);
				final Arrow arrow = arrowG;
//				arrow.getShape(Pipe.TOP).setAppearance(this.borderApp);
//				arrow.getShape(Pipe.BOTTOM).setAppearance(this.borderApp);
//				arrow.setAppearance(Arrow.ARROWHEAD, this.borderApp);
				this.getChildren().add(arrowG);
			} else {
//				TransformGroup pipeTG = BendableArrowBuilder.createPipeComponent(this.points[i], this.points[i + 1], this.diameter, this.app);
				Pipe pipeG = BendableArrowBuilder.createPipeComponent(this.points[i], this.points[i + 1], this.diameter, this.mat);
				this.pipes.add((Pipe) pipeG);
				this.getChildren().add(pipeG);

				// add border
//				pipeTG = BendableArrowBuilder.createPipeComponent(this.points[i], this.points[i + 1], this.diameter + BORDER_OFFSET * 2, this.app);
				pipeG = BendableArrowBuilder.createPipeComponent(this.points[i], this.points[i + 1], this.diameter + BORDER_OFFSET * 2, this.mat);
				final Pipe pipe = pipeG;
//				pipe.getShape(Pipe.TOP).setAppearance(this.borderApp);
//				pipe.getShape(Pipe.BOTTOM).setAppearance(this.borderApp);
				this.getChildren().add(pipeG);
			}
		}
//		this.addChild(this.group);
	}

	/**
	 * Sets the color of this {@link BendableArrow} instance.
	 *
	 * @param color
	 *            The new color of this pipe.
	 * @throws IllegalArgumentException
	 *             If the given color is {@code null}.
	 */
	public final void setColor(final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("The given color is null.");
		}

//		this.app.getColoringAttributes().setColor(new Color3f(color));
		this.mat.setDiffuseColor(color);

		for (Pipe pipe : this.pipes) {
			if (pipe instanceof Arrow) {
				final Arrow arrow = (Arrow) pipe;
//				arrow.getAppearance().setColoringAttributes((ColoringAttributes) arrow.getAppearance().getColoringAttributes());
				arrow.setColor(Arrow.ARROWHEAD, color);
				return;
			}
		}
	}

//	@Override
//	public Shape3D getShape(final int partid) {
//
//		if (partid >= 0 && partid <= this.pipes.size() - 1 << 1) {
//			return (Shape3D) ((Pipe) this.pipes.get(partid >> 1)).getShape(partid % 2);
//		}
//		return null;
//	}

}

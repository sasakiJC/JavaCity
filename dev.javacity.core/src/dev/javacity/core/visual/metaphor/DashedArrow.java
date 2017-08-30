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
 * A dashed arrow used to represent monitor lock releases and notify() / notifyAll() method invocations in the final visualization.
 *
 * @author pdo
 *
 */
public class DashedArrow extends Group {

	// =========================== Attributes =================================

	/** The number of visible line segments per length unit. */
	private static final int SEGMENTS_PER_LENGTH_UNIT = 70;

	/** The default interspace between a pipe and its surrounding border. */
	private static final float BORDER_OFFSET = 0.0005f;

	/** The common {@link TransformGroup} instance to add all components of this dashed arrow to. */
//	private final TransformGroup group = new TransformGroup();

	/** The solid appearance to be applied on all visible components of this dashed arrow. */
//	private final Appearance app = AppearanceUtils.createReadWriteAppearance();
	private final PhongMaterial mat = new PhongMaterial();

	/** The border appearance to be applied on all visible components of this dashed arrow. */
//	private final Appearance borderApp = AppearanceUtils.createBorderAppearance();

	/** A list of all visible pipe components of this dashed arrow with their transform groups. */
//	private final List<TransformGroup> visiblePipes = new LinkedList<TransformGroup>();
	private final List<Pipe> visiblePipes = new LinkedList<Pipe>();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link DashedArrow} instance with the given diameter connecting the specified source with the given target point.
	 *
	 * @param source
	 *            The source point of the dashed arrow to create. This will be the point in 3d space, where the arrow points from.
	 * @param target
	 *            The target point of the dashed arrow to create. This will be the point in 3d space, where the arrow points at.
	 * @param diameter
	 *            The diameter of the dashed arrow to create.
	 * @throws IllegalArgumentException
	 *             If either the source or target vector passed is {@code null} or the given diameter is negative.
	 */
	public DashedArrow(final Point3D source, final Point3D target, final float diameter) throws IllegalArgumentException {

		super();

		if (source == null || target == null) {
			throw new IllegalArgumentException("You cannot pass in a null vector.");
		}
		if (diameter < 0) {
			throw new IllegalArgumentException("A dashed arrow cannot have a negative diameter.");
		}

//		this.setCollidable(true);
//		this.setCapability(ALLOW_PARENT_READ);
		this.createComponents(source, target, diameter, true);
//		this.addChild(this.group);
	}

	/**
	 * Creates a new {@link DashedArrow} instance with the given diameter connecting the specified source with the given target point.
	 *
	 * @param source
	 *            The source point of the dashed arrow to create. This will be the point in 3d space, where the arrow points from.
	 * @param target
	 *            The target point of the dashed arrow to create. This will be the point in 3d space, where the arrow points at.
	 * @param diameter
	 *            The diameter of the dashed arrow to create.
	 * @param bend1
	 *            The first bendpoint of the dashed arrow to be created.
	 * @param bend2
	 *            The second bendpoint of the dashed arrow to be created.
	 * @throws IllegalArgumentException
	 *             If either the source, target, bend1, or bend2 vector passed is {@code null} or the given diameter is negative.
	 */
	public DashedArrow(final Point3D source, final Point3D target, final float diameter, final Point3D bend1, final Point3D bend2)
		throws IllegalArgumentException {

		this(bend1, bend2, diameter);

		if (source == null || target == null) {
			throw new IllegalArgumentException("You cannot pass in a null vector.");
		}

		this.createComponents(source, bend1, diameter, false);
		this.createComponents(bend2, target, diameter, false);
	}

	// ============================ Methods ===================================

	/**
	 * Creates all components (i.e. pipes and arrowhead) of this dashed arrow and adds them as child nodes to this instance.
	 *
	 * @param source
	 *            The source point of the dashed arrow to create. This will be the point in 3d space, where the dashed arrow points from.
	 * @param target
	 *            The target point of the dashed arrow to create. This will be the point in 3d space, where the dashed arrow points at.
	 * @param diameter
	 *            The diameter of the dashed arrow components to create.
	 * @param directed
	 *            {@code True} to direct the dashed line (i.e. display an arrowhead), {@code false} otherwise.
	 */
	private void createComponents(final Point3D source, final Point3D target, final float diameter, final boolean directed) {

		if (directed) {
			// create arrow component
			final Point3D connector = new Point3D(target.getX(),target.getY(),target.getZ());
			connector.subtract(source);
			connector.multiply(0.42f);

			final Point3D from = new Point3D(source.getX(),source.getY(),source.getZ());
			from.add(connector);

			final Point3D to = new Point3D(target.getX(),target.getY(),target.getZ());
			to.subtract(connector);

//			final TransformGroup arrowTG = BendableArrowBuilder.createArrowComponent(from, to, diameter, this.app);
			final Arrow arrowG = BendableArrowBuilder.createArrowComponent(from, to, diameter,this.mat);
			this.visiblePipes.add(arrowG);
			this.getChildren().add(arrowG);

//			final TransformGroup arrowBorderTG = BendableArrowBuilder.createArrowComponent(from, to, diameter + BORDER_OFFSET * 2, this.app);
//			final Arrow arrow = (Arrow) arrowBorderTG.getChild(0);
//			arrow.getShape(Arrow.BOTTOM).setAppearance(this.borderApp);
//			arrow.getShape(Arrow.TOP).setAppearance(this.borderApp);
//			arrow.setAppearance(Arrow.ARROWHEAD, this.borderApp);
//			arrow.setPickable(false);
//			this.group.addChild(arrowBorderTG);

			// create pipe components
			this.createDashedPipes(source, from, diameter, false);
			this.createDashedPipes(to, target, diameter, true);
		} else {
			this.createDashedPipes(source, target, diameter, false);
		}
	}

	/**
	 * Creates a series of dashed pipes (i.e. a connected series of visible / invisible pipes) reaching from the given source to target point in space.
	 *
	 * @param from
	 *            The point in space the created dashed pipe sequence is supposed to start.
	 * @param to
	 *            The point in space the created dashed pipe sequence is supposed to end.
	 * @param withInterspace
	 *            {@code True} to add one {@code 1 / #SEGMENTS_PER_LENGTH_UNIT} as interspace in front of the first dashed pipe element being placed. {@code False}
	 *            otherwise.
	 * @param diameter
	 *            The diameter of the pipes to create.
	 */
	private void createDashedPipes(final Point3D from, final Point3D to, final float diameter, final boolean withInterspace) {

		// compute length
		final Point3D connector = new Point3D(to.getX(),to.getY(),to.getZ());
		connector.subtract(from);
		final double length = connector.magnitude();
		final float increment = 2f / SEGMENTS_PER_LENGTH_UNIT;

		connector.normalize();
		connector.multiply(increment / 2f);
		double curLength = 0;

		final Point3D temp1 = new Point3D(from.getX(),from.getY(),from.getZ());
		final Point3D temp2 = new Point3D(from.getX(),from.getY(),from.getZ());
		temp2.add(connector);

		// handle interspace
		if (withInterspace) {
			curLength = increment;
			temp1.add(connector);
			temp2.add(connector);
		}

		while (curLength + increment < length) {
			// create solid pipe
//			TransformGroup pipeTG = BendableArrowBuilder.createPipeComponent(temp1, temp2, diameter, this.app);
			Pipe pipeG = BendableArrowBuilder.createPipeComponent(temp1, temp2, diameter, this.mat);
			this.getChildren().add(pipeG);

			// add border
//			pipeTG = BendableArrowBuilder.createPipeComponent(temp1, temp2, diameter + BORDER_OFFSET * 2, this.app);
//			final Pipe pipe = (Pipe) pipeTG.getChild(0);
//			pipe.getShape(Pipe.TOP).setAppearance(this.borderApp);
//			pipe.getShape(Pipe.BOTTOM).setAppearance(this.borderApp);
//			this.group.addChild(pipeTG);

			// update bendpoints
			temp1.add(connector);
			temp1.add(connector);
			temp2.add(connector);
			temp2.add(connector);
			curLength += increment;
		}

		if (curLength < length) {
			// connect remaining space
//			final TransformGroup solidTG = BendableArrowBuilder.createPipeComponent(temp1, temp2, diameter, this.app);
			final Pipe solidG = BendableArrowBuilder.createPipeComponent(temp1, temp2, diameter, this.mat);
			this.visiblePipes.add(solidG);
			this.getChildren().add(solidG);

			// add border
//			final TransformGroup pipeTG = BendableArrowBuilder.createPipeComponent(temp1, temp2, diameter + BORDER_OFFSET * 2, this.app);
//			final Pipe pipe = (Pipe) pipeTG.getChild(0);
//			pipe.getShape(Pipe.TOP).setAppearance(this.borderApp);
//			pipe.getShape(Pipe.BOTTOM).setAppearance(this.borderApp);
//			this.group.addChild(pipeTG);
		}
	}

	/**
	 * Returns the body {@link Shape3D} of the visible component with the specified part id or {@code null}, if no such component exists.
	 *
	 * @param partId
	 *            The id of the visible component to get its body shape.
	 * @return The body shape of the specified component.
	 */
//	@Override
//	public Shape3D getShape(final int partId) {
//
//		if (partId >= 0 && partId < this.visiblePipes.size()) {
//			return ((Pipe) ((TransformGroup) this.visiblePipes.get(partId)).getChild(0)).getShape(Pipe.BODY);
//		}
//
//		return null;
//	}


	/**
	 * Sets the color of all visible components of this dashed arrow.
	 *
	 * @param color
	 *            The color to be applied to all visible components.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null}.
	 */
	public void setColor(final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("You cannot set a null color.");
		}

		for (Pipe transG : this.visiblePipes) {
			transG.setColor(color);
		}
	}

}

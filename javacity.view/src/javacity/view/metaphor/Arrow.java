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

package javacity.view.metaphor;


import javafx.scene.paint.Color;

/**
 * An arrow with the arrow head in the middle. Pick reporting and read/write access to its {@link Appearance} and {@link ColoringAttributes} is enabled since this
 * class is an extension of {@link Pipe}.
 *
 * @author pdo
 *
 */
public class Arrow extends Pipe {

	// =========================== Attributes =================================

	/** The id representing the pipe of this arrow. */
	public static final int PIPE = 0;

	/** The id representing the arrowhead of this arrow. */
	public static final int ARROWHEAD = 1;

	/** The maximal ratio of the arrowhead to arrow pipe length. */
	private static final float MAX_RATIO = 0.5f;

	/** The cone representing the arrowhead of this arrow. */
	private final Cone arrowhead;

	// ========================== Constructors =================================

	/**
	 * Constructs a new {@link Arrow} with a given radius and length.
	 *
	 * @param radius
	 *            The radius of the new arrow's pipe.
	 * @param length
	 *            The length of the new arrow.
	 * @throws IllegalArgumentException
	 *             If either the given radius or length value is negative.
	 */
	public Arrow(final float radius, final float length) throws IllegalArgumentException {

		super(radius, length);
//		this.setCollidable(true);

//		final float arrowheadDiameter = VisualProperties.getInstance().getLineArrowheadDiameter();
//		float arrowheadHeigth = VisualProperties.getInstance().getLineArrowheadHeight();

		final float arrowheadDiameter = 1.0f;
		float arrowheadHeigth = 1.0f;

		// correct arrow measures, if necessary
		final float ratio = arrowheadHeigth / length;
		if (ratio > MAX_RATIO) {
			final float newArrowheadHeigth = MAX_RATIO * length;
			arrowheadHeigth = newArrowheadHeigth;
		}

		// create arrowhead
//		final Appearance app = AppearanceUtils.createReadWriteAppearance();
//		this.arrowhead = new Cone(arrowheadDiameter, arrowheadHeigth, app);
		this.arrowhead = new Cone(arrowheadDiameter, arrowheadHeigth);
		this.getChildren().add(this.arrowhead);
//		super.setAppearance(app);
	}

	/**
	 * Constructs a new {@link Arrow} with a given radius, length, arrowhead color, and pipe color.
	 *
	 * @param radius
	 *            The radius of the new arrow.
	 * @param length
	 *            The length of the new arrow.
	 * @param pipeColor
	 *            The color of the pipe.
	 * @param arrowheadColor
	 *            The color of the arrowhead.
	 * @throws IllegalArgumentException
	 *             If any color passed in is {@code null} or the given length or radius is negative.
	 */
	public Arrow(final float radius, final float length, final Color pipeColor, final Color arrowheadColor) throws IllegalArgumentException {

		this(radius, length);

		if (pipeColor == null || arrowheadColor == null) {
			throw new IllegalArgumentException("You may not pass in null colors.");
		}

		this.setColor(PIPE, pipeColor);
		this.setColor(ARROWHEAD, arrowheadColor);
	}

	// ============================ Methods ===================================

	/**
	 * Set the {@link Color} of the arrowhead or pipe of this arrow.
	 *
	 * @param partid
	 *            The Id of the component to set its color. Use {@value #PIPE} for the pipe or {@value #ARROWHEAD} for the arrowhead. Otherwise, this method has no
	 *            effect.
	 * @param color
	 *            The color to set.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null}.
	 */
	public final void setColor(final int partid, final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("The given color is null.");
		}

		if (partid == PIPE) {
			super.setColor(color);
		} else if (partid == ARROWHEAD) {
//			this.arrowhead.getAppearance().getColoringAttributes().setColor(new Color3f(color));
			this.arrowhead.setColor(color);
		}
	}

	/**
	 * Set the {@link Color} of the arrowhead and pipe of this arrow.
	 *
	 * @param color
	 *            The color to set.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null}.
	 */
	@Override
	public void setColor(final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("The given color is null.");
		}

		this.setColor(PIPE, color);
		this.setColor(ARROWHEAD, color);
	}

}

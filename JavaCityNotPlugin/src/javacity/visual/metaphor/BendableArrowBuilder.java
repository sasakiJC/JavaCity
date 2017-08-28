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

package javacity.visual.metaphor;

import javacity.visual.metaphor.utils.TransformUtils;
import javafx.geometry.Point3D;
import javafx.scene.paint.PhongMaterial;

/**
 * A bendable arrow builder to build the components of a {@link BendableArrow} instance.
 *
 * @author pdo
 *
 */
public final class BendableArrowBuilder {

	// ========================== Constructor =================================

	/**
	 * Private constructor of this class. This class is not intended for instantiation, since it contains static methods only.
	 */
	private BendableArrowBuilder() {}

	// ============================ Methods ===================================

	/**
	 * Constructs a {@link Pipe} component for a {@link BendableArrow} instance starting from and reaching to to given point in space with the defined
	 * {@link Appearance}.
	 *
	 * @param source
	 *            The point, where the bottom end of this pipe will be begin.
	 * @param target
	 *            The point, where the top end of this pipe will end.
	 * @param diameter
	 *            The diameter of the pipe to create.
	 * @param app
	 *            The appearance to set in this pipe component.
	 * @return A {@link TransformGroup} instance holding the created pipe along with the matching rotation matrix and translation vector placing this pipe between
	 *         the given points.
	 * @throws IllegalArgumentException
	 *             If any vector passed in is {@code null} or the given diameter is negative.
	 */
	public static Pipe createPipeComponent(final Point3D source, final Point3D target, final float diameter, final PhongMaterial mat)
		throws IllegalArgumentException {

		if (source == null || target == null || mat == null) {
			throw new IllegalArgumentException("You may not pass in a null argument.");
		}

		if (diameter < 0) {
			throw new IllegalArgumentException("The given diameter is negative.");
		}

		// computing length
		final Point3D diff = source.subtract(target);

		// creating transform group
//		final TransformGroup trans = TransformUtils.computeTransformation(source, target);

		// creating pipe
		final Pipe pipe = new Pipe(diameter, (float) diff.magnitude());
		pipe.setMaterial(mat);
		pipe.getTransforms().addAll(TransformUtils.computeTransformation(source, target));
//		trans.addChild(pipe);

		return pipe;
	}

	/**
	 * Constructs a {@link Arrow} component for a {@link BendableArrow} instance starting from and reaching to to given point in space with the defined
	 * {@link Appearance}.
	 *
	 * @param source
	 *            The point, where the bottom end of this arrow will be begin.
	 * @param target
	 *            The point, where the top end of this arrow will end.
	 * @param diameter
	 *            The diameter of the pipe to create.
	 * @param app
	 *            The appearance to set in this pipe component.
	 * @return A {@link TransformGroup} instance holding the created arrow along with a matching rotation matrix and translation vector placing this arrow between
	 *         the
	 *         given points.
	 * @throws IllegalArgumentException
	 *             If any given parameter is {@code null}.
	 */
	public static Arrow createArrowComponent(final Point3D source, final Point3D target, final float diameter, final PhongMaterial mat)
		throws IllegalArgumentException {

		if (source == null || target == null || mat == null) {
			throw new IllegalArgumentException("You may not pass in a null argument.");
		}

		// computing length
		final Point3D diff = source.subtract(target);

		// creating transform group
//		final TransformGroup trans = TransformUtils.computeTransformation(source, target);

		// creating arrow
		final Arrow arrow = new Arrow(diameter, (float) diff.magnitude());
		arrow.setMaterial(mat);
		arrow.getTransforms().addAll(TransformUtils.computeTransformation(source, target));
//		trans.addChild(arrow);

		return arrow;
	}

}

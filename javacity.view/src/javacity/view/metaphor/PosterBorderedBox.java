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

import javacity.view.configuration.VisualProperties;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

/**
 * A regular {@link BorderedBox} with one poster (i.e. a separately colored and bordered rectangular) centered on each vertical face.
 *
 * @author pdo
 *
 */
public class PosterBorderedBox extends BorderedBox {

	// =========================== Attributes =================================

	/** The horizontal distance of a poster to the wall of its floor. */
	private static float xPosterDistance = VisualProperties.getInstance().getPosterHorizontalDistance();

	/** The vertical distance of a poster to the wall of its floor. */
	private static float yPosterDistance = VisualProperties.getInstance().getPosterVerticalDistance();

	/** The posters ({@link BorderedBox} objects with border appearances) of this {@link PosterBorderedBox}. */
	private final BorderedBox[] posters = new BorderedBox[2];

	/** The {@link BranchGroup} to add all posters to. */
//	private BranchGroup group = new BranchGroup();
	private Group group = new Group();

	/** A solid appearance used to make each poster of this {@link PosterBorderedBox} visible on demand. */
//	private final Appearance visibility = AppearanceUtils.createReadWriteAppearance();
	private final PhongMaterial material = new PhongMaterial();

	/** A flag indicating whether the posters are currently visible. */
	private boolean isPosterVisible = false;

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link PosterBorderedBox} of given x-, y-, and z-dimension.
	 *
	 * @param length
	 *            The length (x-dimension) of the new bordered box. *
	 * @param height
	 *            The height (y-dimension) of the new bordered box.
	 * @param width
	 *            The width (z-dimension) of the new bordered box.
	 * @throws IllegalArgumentException
	 *             If either the given width, height or length is negative.
	 */
	public PosterBorderedBox(final float length, final float height, final float width) throws IllegalArgumentException {

		super(length, height, width);
//		this.setCapability(ALLOW_CHILDREN_WRITE);
//		this.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
//		this.group.setCapability(BranchGroup.ALLOW_DETACH);
		this.addPosters();
	}

	// ============================ Methods ===================================

	/**
	 * Adds a new poster to each vertical face of this bordered Box, but does not show them yet.
	 */
	private final void addPosters() {
		Box borderBox = null;
		for(Node node : super.getChildren()) {
			if(node instanceof Box) {
				borderBox = (Box)node;
			}
		}

		// retrieving height, length and depth of the posters to add
		final double vDist = Math.min(yPosterDistance, borderBox.getHeight() - 0.01f);
		final double hDist = Math.min(xPosterDistance, borderBox.getWidth() - 0.01f);
		final double wDist = 0.0005f;

		// creating four posters by creating two borderedBoxes
		this.posters[0] = new BorderedBox((borderBox.getWidth() - hDist) , (borderBox.getHeight() - vDist) , (borderBox.getDepth() + wDist) );
		this.posters[1] = new BorderedBox((borderBox.getWidth() + wDist) , (borderBox.getHeight() - vDist) , (borderBox.getDepth() - hDist) );

		this.posters[0].setMaterial(this.material);
		this.posters[1].setMaterial(this.material);

		this.group.getChildren().add(this.posters[0]);
		this.group.getChildren().add(this.posters[1]);
	}

	/**
	 * Sets the {@link Color} of the posters in this poster bordered box.
	 *
	 * @param color
	 *            The new color of the posters.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null}.
	 */
	public final void setPosterColor(final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("The color passed in is null.");
		}

		this.material.setDiffuseColor(color);
	}

	/**
	 * Sets the visibility status of all four posters of this poster bordered box.
	 *
	 * @param visible
	 *            {@code True} to set the posters visible, {@code false} to hide them.
	 */
	public final void setPostersVisible(final boolean visible) {

		if (visible && !this.isPosterVisible) {
			this.getChildren().add(this.group);
			this.isPosterVisible = true;
		} else if (this.isPosterVisible) {
			this.getChildren().remove(this.group);
			this.isPosterVisible = false;
		}
	}

	/**
	 * Reloads all visual settings attributes of this {@link PosterBorderedBox}.
	 */
	public static void reloadAttributes() {

		xPosterDistance = VisualProperties.getInstance().getPosterVerticalDistance();
		yPosterDistance = VisualProperties.getInstance().getPosterVerticalDistance();
	}

}

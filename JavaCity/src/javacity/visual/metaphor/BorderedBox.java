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
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;

/**
 * A regular {@link com.sun.j3d.utils.geometry.Box Box}, which differs from the original implementation in the way, that
 * its edges are emphasized by solid (dyeable) lines, its {@link javax.media.j3d.Appearance Appearance} is readable and setable
 * and pick reporting is enabled.
 *
 * @author pdo
 *
 */
public class BorderedBox extends Group {

	// =========================== Attributes =================================

	/** The default interspace between the box and its surrounding border. */
	private static final float BORDER_OFFSET = 0.0005f;

	// ========================== Constructors ================================

	/**
	 * Constructs a new {@link BorderedBox} instance with a given length, width and height.
	 *
	 * @param length
	 *            The length (x-dimension) of the new bordered box.
	 * @param height
	 *            The height (y-dimension) of the new bordered box.
	 * @param width
	 *            The width (z-dimension) of the new bordered box.
	 * @throws IllegalArgumentException
	 *             If either the given width, height or length is negative.
	 */
	public BorderedBox(final double length, final double height, final double width) throws IllegalArgumentException {

//		super(length / 2, height / 2, width / 2, AppearanceUtils.createReadWriteAppearance());
		Box box = new Box(length, height, width);

		if (length < 0 || height < 0 || width < 0) {
			throw new IllegalArgumentException("A box cannot have negative dimension attributes.");
		}

//		this.setCapability(ENABLE_PICK_REPORTING);
//		this.setCapability(ALLOW_PARENT_READ);
//		this.setCollidable(true);

		// create a new cuboid whose edges are visible only
		final Cuboid border = new Cuboid(box.getWidth() + BORDER_OFFSET, box.getHeight(), box.getDepth() + BORDER_OFFSET);
//		final TransformGroup trans = TransformUtils.createTransformGroup(new Vector3d(0, BORDER_OFFSET, 0));
//		trans.addChild(border);
//		border.setAppearance(AppearanceUtils.createBorderAppearance());
//		border.setPickable(false);
//		this.addChild(trans);
		border.getTransforms().addAll(TransformUtils.createTransformGroup(new Point3D(0, BORDER_OFFSET, 0)));
		this.getChildren().addAll(box,border);

	}

	/**
	 * Construct a new {@link BorderedBox} instance with the specified length, width, height and color.
	 *
	 * @param length
	 *            The length (x-dimension) of the bordered box.
	 * @param height
	 *            The height (y-dimension) of the bordered box.
	 * @param width
	 *            The width (z-dimension) of the bordered box.
	 * @param color
	 *            The {@link Color} of the bordered box.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null} or if either the given width, height, or length is negative.
	 */
	public BorderedBox(final float length, final float height, final float width, final Color color) throws IllegalArgumentException {

		this(length, height, width);
		this.setColor(color);
	}

	// ============================ Methods ===================================

	/**
	 * Set the {@link Color} of this {@link BorderedBox} instance.
	 *
	 * @param color
	 *            The new color of this bordered box.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null}.
	 */
	public final void setColor(final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("You cannot set a null color.");
		}

		PhongMaterial material = (PhongMaterial) this.getMaterial();
		material.setDiffuseColor(color);
		this.setMaterial(material);
	}

	public void setMaterial(Material material) {
		Shape3D shape = (Shape3D) this.getChildren().get(0);
		shape.setMaterial(material);
	}

	public Material getMaterial() {
		Shape3D shape = (Shape3D) this.getChildren().get(0);
		Material material = shape.getMaterial();
		if(material == null){
			material = new PhongMaterial();
		}
		return material;
	}
}

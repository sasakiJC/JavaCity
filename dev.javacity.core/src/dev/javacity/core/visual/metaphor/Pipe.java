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
 */

package dev.javacity.core.visual.metaphor;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;

/**
 * A regular {@link Cylinder} with pick reporting and read/write access to its {@link Appearance} and {@link ColoringAttributes} enabled.
 *
 * @author pdo
 *
 */
public class Pipe extends Group {

	// ========================== Constructors ================================

	/**
	 * Constructs a new {@link Pipe} instance with a given radius and height.
	 *
	 * @param diameter
	 *            The diameter of the new pipe.
	 * @param length
	 *            The length of the new pipe.
	 * @throws IllegalArgumentException
	 *             If either the given radius or length value is negative.
	 */
	public Pipe(final float diameter, final float length) throws IllegalArgumentException {

		super();
		Cylinder cyl = new Cylinder(diameter / 2, length);

		if (diameter < 0 || length < 0) {
			throw new IllegalArgumentException("You cannot pass in negative dimension sizes.");
		}

		this.getChildren().add(cyl);

//		super.getAppearance().setCapability(ENABLE_PICK_REPORTING);
//		this.setCapability(ALLOW_PARENT_READ);
//		this.setCollidable(true);
	}

	/**
	 * Constructs a new {@link Pipe} instance with a given radius, height, and color.
	 *
	 * @param radius
	 *            The radius of the new pipe.
	 * @param length
	 *            The length of the new pipe.
	 * @param color
	 *            The color of the new pipe.
	 * @throws IllegalArgumentException
	 *             If the given radius or length value is negative or the color passed in is {@code null}.
	 */
	public Pipe(final float radius, final float length, final Color color) throws IllegalArgumentException {

		this(radius, length);
		PhongMaterial material = (PhongMaterial) this.getMaterial();
		material.setDiffuseColor(color);
		this.setMaterial(material);

//		this.getAppearance().getColoringAttributes().setColor(new Color3f(color));
	}

	// ============================ Methods ===================================

	/**
	 * Set the {@link Color} of this pipe.
	 *
	 * @param color
	 *            The new color of this pipe.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null}.
	 */
	public void setColor(final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("The color passed in is null.");
		}
//		this.getAppearance().getColoringAttributes().setColor(new Color3f(color));
//		for (int i = BODY; i <= BOTTOM; i++) {
//			super.getShape(i).getAppearance().getColoringAttributes().setColor(new Color3f(color));
//		}
		PhongMaterial material = (PhongMaterial) this.getMaterial();
		material.setDiffuseColor(color);
		this.setMaterial(material);
		//((PhongMaterial)this.getMaterial()).setDiffuseColor(color);

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

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

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Shape3D;

/**
 * A regular cuboid created with a given length, width, and height centered at the origin located at {@code (0,0,0)}. In contrast to Java3D's regular
 * {@link com.sun.j3d.utils.geometry.Box Box} implementation, the faces of this cuboid are comprised of rectangulars instead of triangulars.
 *
 * @author pdo
 */
public class Cuboid extends Group {

	// =========================== Attributes =================================

	/** The id representing the front face of this {@link Cuboid} instance. */
	public static final int FRONT = 0;

	/** The id representing the back face of this {@link Cuboid} instance. */
	public static final int BACK = 1;

	/** The id representing the right face of this {@link Cuboid} instance. */
	public static final int RIGHT = 2;

	/** The id representing the left face of this {@link Cuboid} instance. */
	public static final int LEFT = 3;

	/** The id representing the top face of this {@link Cuboid} instance. */
	public static final int TOP = 4;

	/** The id representing the bottom face of this {@link Cuboid} instance. */
	public static final int BOTTOM = 5;

	/** The six faces of this cuboid. */
	private final Shape3D[] faces = new Shape3D[6];

	/** The {@link Appearance} of this {@link Cuboid}. */
//	private Appearance app;

	// ========================== Constructor =================================

	/**
	 * Constructs a new {@link Cuboid} instance with the given dimension attributes centered at the origin {@code (0,0,0)}.
	 *
	 * @param length
	 *            The x-dimension size (length) of the cuboid to create.
	 * @param heigth
	 *            The y-dimension size (height) of the cuboid to create.
	 * @param width
	 *            the z-dimension size (width) of the cuboid to create.
	 * @throws IllegalArgumentException
	 *             If at least one dimension value passed in is negative.
	 */
	public Cuboid(final double length, final double heigth, final double width) throws IllegalArgumentException {

		super();
		if (length < 0 || heigth < 0 || width < 0) {
			throw new IllegalArgumentException("You cannot create a cuboid with negative dimension sizes.");
		}

		for (int i = FRONT; i <= BOTTOM; i++) {
			final Shape3D face = CuboidBuilder.createFace((float)length, (float)heigth, (float)width, i);
//			face.setAppearance(this.app);
//			face.setCollidable(true);
			this.faces[i] = face;

			this.getChildren().add(face);
		}
	}

	// ============================ Methods ===================================

	/**
	 * Sets the color of this {@link Cuboid} instance.
	 *
	 * @param color
	 *            The new color of this cuboid.
	 * @throws IllegalArgumentException
	 *             If the color passed in is {@code null}.
	 */
	public final void setColor(final Color color) throws IllegalArgumentException {

		if (color == null) {
			throw new IllegalArgumentException("You cannot set a null color.");
		}
		PhongMaterial material = new PhongMaterial();
    	material.setDiffuseColor(color);

		for (int i = FRONT; i <= BOTTOM; i++) {
//			this.faces[i].getAppearance().getColoringAttributes().setColor(new Color3f(color));
			this.faces[i].setMaterial(material);
		}
	}

	/**
	 * Returns the specified face's ({@link Shape3D}) object of this {@link Cuboid}.
	 *
	 * @param face
	 *            The Id of the face's shape to return. Use {@value #FRONT} for the front, {@value #BACK} for the back, {@value #LEFT} for the left, {@value #RIGHT}
	 *            for the right, {@value #TOP} for the top, and {@value #BOTTOM} for the bottom face.
	 * @return The Shape3D object associated with the specified partID. If an invalid partID is passed in, {@code null} is returned.
	 */
	public Shape3D getShape(final int face) {

		if (face >= FRONT && face <= BOTTOM) {
			return (Shape3D) this.faces[face];
		}
		return null;
	}

}

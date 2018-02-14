package javacity.view.metaphor.ambience;
///***************************************************************************
// * This file is part of Synchrovis - A prototypical implementation of the
// * visualization approach described in the author's master's thesis titled
// *
// * 							 Visualisierung von
// * 					Synchronisationspunkten in Kombination
// * 						  mit der Statik und Dynamik
// *							 eines Softwaresystems
// *
// * written at Software Engineering Group, Department of Computer Science at
// * Christian-Albrechts-University of Kiel.
// *
// * Author: Philipp D�hring, October 2012
// ***************************************************************************/
//
//package dev.javacity.core.visual.metaphor.ambience;
//
//
//import javafx.geometry.Point3D;
//import javafx.scene.AmbientLight;
//import javafx.scene.paint.Color;
//
///**
// * A utility class creating special ambient and directional lights to make the visualization nice and shiny.
// *
// * @author pdo
// *
// */
//public final class Lightning {
//
//	// =========================== Attributes =================================
//
//	/** The default bounding point used for each light object created by any method in this class. */
//	private static final Point3D BOUNDING_POINT = new Point3D(0, 0, 0);
//
//	/** The ambient color used in {@link #DEFAULT_MATERIAL}. */
//	private static final Color AMBIENT_COLOR = Color.WHITE;
//
//	/** The diffuse color used in {@link #DEFAULT_MATERIAL}. */
//	private static final Color DIFFUSE_COLOR = Color.WHITE;
//
//	/** The emissive color used in {@link #DEFAULT_MATERIAL}. */
//	private static final Color EMISSIVE_COLOR = Color.WHITE;
//
//	/** The spectacular color used in {@link #DEFAULT_MATERIAL}. */
//	private static final Color SPECTACULAR_COLOR = Color.WHITE;
//
//	/** The shininess setting used in {@link #DEFAULT_MATERIAL}. */
//	private static final float SHININESS = 1;
//
//	/** The default {@link Material} to be applied to any Java 3D object which interferes with lightning. It defines their behavior when light shines on them. */
//	private static final Material DEFAULT_MATERIAL = new Material(AMBIENT_COLOR, EMISSIVE_COLOR, DIFFUSE_COLOR, SPECTACULAR_COLOR, SHININESS);
//
//	/** The default radius used for each light object created by any method in this class. */
//	private static final double RADIUS = 100;
//
//	// ========================== Constructor =================================
//
//	/**
//	 * Private constructor. This class is not intended for instantiation, since it contains static methods only.
//	 */
//	private Lightning() {}
//
//	// ============================ Methods ===================================
//
//	/**
//	 * Creates a new {@link AmbientLight} instance with a bounding point as defined in {@link #BOUNDING_POINT}, a radius of {@value #RADIUS} and given color.
//	 *
//	 * @param color
//	 *            The color of the ambient light to create.
//	 * @return A ambient light instance with given color.
//	 * @throws IllegalArgumentException
//	 *             If the color passed in is {@code null}.
//	 */
//	public static AmbientLight createAmbienceLight(final Color color) throws IllegalArgumentException {
//
//		if (color == null) {
//			throw new IllegalArgumentException("You may not pass in a null color.");
//		}
//
//		final AmbientLight light = new AmbientLight();
//		light.setInfluencingBounds(new BoundingSphere(BOUNDING_POINT, RADIUS));
//		light.setColor(new Color(color));
//		return light;
//	}
//
//	/**
//	 * Creates a new {@link DirectionalLight} instance with a bounding point as defined in {@link #BOUNDING_POINT}, a radius of {@value #RADIUS}, and given
//	 * {@link Color}.
//	 *
//	 * @param color
//	 *            The color of the directional light to create.
//	 * @return A directional light instance with given color.
//	 * @throws IllegalArgumentException
//	 *             If the color passed in is {@code null}.
//	 */
//	public static DirectionalLight createDirectionalLight(final Color color) throws IllegalArgumentException {
//
//		if (color == null) {
//			throw new IllegalArgumentException("You may not pass in a null color.");
//		}
//
//		final DirectionalLight light = new DirectionalLight();
//		light.setInfluencingBounds(new BoundingSphere(BOUNDING_POINT, RADIUS));
//		light.setColor(new Color(color));
//		return light;
//	}
//
//	/**
//	 * Returns the default {@link Material} which is supposed to applied to any Java3D node instance which interferes with lightning.
//	 *
//	 * @return The default material as specified in {@link #DEFAULT_MATERIAL}.
//	 */
//	public static Material getDefaultMaterial() {
//
//		return DEFAULT_MATERIAL;
//	}
//
//}

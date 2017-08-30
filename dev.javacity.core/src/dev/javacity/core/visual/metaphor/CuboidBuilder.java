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

import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

/**
 * A cuboid builder to build the faces of a {@link visual.metaphor.Cuboid Cuboid} (separately).
 *
 * @author pdo
 *
 */
public final class CuboidBuilder {

	// =========================== Attributes =================================

	/**
	 * The edge coordinates of each face of the default cuboid with x-, y-, and z-dimensions of {@code 1}. Every three value sequence beginning at an index being
	 * a multiplicative of three represents one coordinates vector and therefore defines the location of one edge of the {@link Cuboid} in three dimensional space.
	 */
	private static final float[] EDGES = {
		// front face
		1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f,
		// back face
		-1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f,
		// right face
		1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f,
		// left face
		-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f,
		// top face
		1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f,
		// bottom face
		-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f,
	};

	// ========================== Constructor =================================

	/**
	 * Private Constructor of this class. This class is not intended for instantiation, since it contains static methods only.
	 */
	private CuboidBuilder() {}

	// ============================ Methods ===================================

	/**
	 * Creates the face of a {@link Cuboid} with the specified face id and given x-, y-, and z-dimension sizes.
	 *
	 * @param xdim
	 *            The x-dimension of the cuboid to create this face for.
	 * @param ydim
	 *            The y-dimension of the cuboid to create this face for.
	 * @param zdim
	 *            The z-dimension of the cuboid to create this face for.
	 * @param faceId
	 *            The faceId of the cuboid to create. See {@link visual.metaphor.Cuboid Cuboid} for the definition of the faceIds.
	 * @return The requested face of a cuboid or {@code null}, if the faceId passed in does not identify a cuboid's face.
	 * @throws IllegalArgumentException
	 *             If at least one dimension value passed in is negative.
	 *
	 * @see visual.metaphor.Cuboid Cuboid
	 */
	public static MeshView createFace(final float xdim, final float ydim, final float zdim, final int faceId) throws IllegalArgumentException {

		if (xdim < 0 || ydim < 0 || zdim < 0) {
			throw new IllegalArgumentException("You cannot pass in a negativ dimension value.");
		}


		if (faceId >= Cuboid.FRONT && faceId <= Cuboid.BOTTOM) {
	        TriangleMesh mesh = new TriangleMesh();
			//final Point3D[] coords = new Point3D[4];
			for (int i = 0; i < 4; i++) {
				mesh.getPoints().addAll(
						EDGES[3 * i + faceId * 12] * xdim,
						EDGES[3 * i + 1 + faceId * 12] * ydim,
						EDGES[3 * i + 2 + faceId * 12] * zdim);
			}
			return new MeshView(mesh);
		}
		return null;
	}
}

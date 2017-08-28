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

package javacity.visual.actions;

import javax.media.j3d.PickInfo;
import javax.swing.SwingUtilities;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.pickfast.behaviors.PickMouseBehavior;

import javacity.logic.Logic;
import javacity.visual.gui.CityCanvas;
import javafx.scene.shape.Shape3D;

/**
 * A mouse selection behavior to handle object selections in the current scene.
 *
 * @author pdo
 *
 */
public final class MouseSelectionBehavior extends PickMouseBehavior {

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link MouseSelectionBehavior} instance to select visual entities drawn on the given {@link CityCanvas} instance.
	 *
	 * @param canvas
	 *            The canvas object representing the visualization in which the user may pick an visual entity.
	 */
	public MouseSelectionBehavior(final CityCanvas canvas) {

		super(canvas, canvas.getViewModel().getRootBranchGroup(), null);
	}

	// ============================ Methods ===================================

	@Override
	public void initialize() {

		super.initialize();

		// settings
		super.pickCanvas.setMode(PickInfo.PICK_GEOMETRY);
		super.pickCanvas.setFlags(PickInfo.NODE);
		super.pickCanvas.setTolerance(0);
	}

	@Override
	public void updateScene(final int xpos, final int ypos) {

		if (SwingUtilities.isLeftMouseButton(super.mevent)) {

			// unselect previous node
			Logic.getInstance().getSelectionController().hidePopup();
			Logic.getInstance().getSelectionController().unselect();

			final Primitive pickedNode = this.getPickedNode(xpos, ypos);
			if (pickedNode != null) {
				if (super.mevent.isControlDown()) {
					Logic.getInstance().getSelectionController().openPopup(super.mevent, pickedNode);
				}
				// just select node
				Logic.getInstance().getSelectionController().select(pickedNode);
			}
		}
	}

	/**
	 * The closest {@link Primitive} relative to the given position on which the user just tried to pick a visual node or {@code null}, if no node could be found at
	 * the given coordinates.
	 *
	 * @param xPos
	 *            The x-axis position of the mouse selection.
	 * @param yPos
	 *            The y-axis position of the mouse selection.
	 * @return The closest primitive relative to the given position on which the user just tried to pick a visual node.
	 */
	private Primitive getPickedNode(final int xPos, final int yPos) {

		super.pickCanvas.setShapeLocation(xPos, yPos);
		final PickInfo pickInfo = super.pickCanvas.pickClosest();
		if (pickInfo != null) {
			final Node node = pickInfo.getNode();
			if (node instanceof Shape3D) {
				final Shape3D shape = (Shape3D) node;
				if (shape.getParent() instanceof Primitive) {
					return (Primitive) shape.getParent();
				}
			}
		}
		return null;
	}
}

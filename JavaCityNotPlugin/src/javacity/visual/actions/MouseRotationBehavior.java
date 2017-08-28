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

import java.awt.AWTEvent;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupCriterion;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.media.j3d.WakeupOr;
import javax.swing.SwingUtilities;

import com.sun.j3d.utils.behaviors.mouse.MouseBehavior;

/**
 * A mouse rotation behavior rotating the current scene around the y-axis when the user drags the mouse on the scene.
 *
 * @author pdo
 *
 */
public class MouseRotationBehavior extends MouseBehavior {

	/** The set of {@link WakeupCriterion} instances to wake up on. */
	private WakeupOr criterions;

	/** The {@link Transform3D} instance used realizing this mouse rotation behavior. */
	private final Transform3D transform = new Transform3D();

	/** The {@link Transform3D} object bearing the rotation axis and angle to rotate the current scene. */
	private final Transform3D rotation = new Transform3D();

	/** The angle to rotate the associated transform3D object ({@link #rotation}) by. */
	private final double angle = Math.toRadians(1.0);

	// ========================== Constructor =================================

	/**
	 * Constructs a new {@link MouseRotationBehavior} instance with the specified {@link TransformGroup} to operate on.
	 *
	 * @param group
	 *            The transform group this mouse rotation behavior will operate on.
	 */
	public MouseRotationBehavior(final TransformGroup group) {

		super(group);
	}

	// ============================ Methods ===================================

	@Override
	public void initialize() {

		super.initialize();

		// set wake-up conditions
		final WakeupCriterion[] crits = new WakeupCriterion[2];
		crits[0] = new WakeupOnAWTEvent(MouseEvent.MOUSE_PRESSED);
		crits[1] = new WakeupOnAWTEvent(MouseEvent.MOUSE_DRAGGED);
		this.criterions = new WakeupOr(crits);

		this.wakeupOn(this.criterions);
	}

	@Override
	public void processStimulus(@SuppressWarnings("rawtypes") final Enumeration criteria) {

		while (criteria.hasMoreElements()) {
			final WakeupCriterion crit = (WakeupCriterion) criteria.nextElement();
			if (crit instanceof WakeupOnAWTEvent) {
				for (AWTEvent event : ((WakeupOnAWTEvent) crit).getAWTEvent()) {
					if (event instanceof MouseEvent) {
						this.handleEvent((MouseEvent) event);
					}
				}
			}
			wakeupOn(this.criterions);
		}
	}

	/**
	 * Handles the specified mouse event by rotating the current scene.
	 *
	 * @param event
	 *            The event to be handled.
	 */
	private void handleEvent(final MouseEvent event) {

		if (SwingUtilities.isRightMouseButton(event)) {
			switch (event.getID()) {
			case MouseEvent.MOUSE_PRESSED:
				this.saveCursorPosition(event);
				break;
			case MouseEvent.MOUSE_DRAGGED:
				this.rotate(event);
				this.saveCursorPosition(event);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Stores the current mouse cursor position stated by the given mouse event in {@code super.x_last} and {@code super.y_last} respectively.
	 *
	 * @param event
	 *            The mouse event containing the mouse cursor position to save.
	 */
	private void saveCursorPosition(final MouseEvent event) {

		super.x_last = event.getPoint().x;
		super.y_last = event.getPoint().y;
	}

	/**
	 * Rotates the current scene to the left, if the mouse has been dragged to the left. Otherwise, it rotates the scene to the right.
	 *
	 * @param event
	 *            The event to cause the scene rotation.
	 */
	private void rotate(final MouseEvent event) {

		// reset transform3D
		this.rotation.rotY(0);

		// rotate around y-axis
		if (super.x_last - event.getPoint().x > 0) {
			// rotate leftwards
			this.rotation.rotY(this.angle);
		} else {
			// rotate rightwards
			this.rotation.rotY(-this.angle);
		}

		// apply rotation
		super.transformGroup.getTransform(this.transform);
		this.transform.mul(this.rotation);
		super.transformGroup.setTransform(this.transform);
	}
}

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

package dev.javacity.core.visual.actions;

import java.awt.AWTEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Enumeration;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupCriterion;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.vecmath.Vector3d;

import org.apache.log4j.Logger;

import com.sun.j3d.utils.behaviors.mouse.MouseBehavior;

/**
 * A mouse wheel zoom behavior allowing the user to zoom in and out in the current scene using the mouse wheel.
 *
 * @author pdo
 *
 */
public class MouseWheelZoomBehavior extends MouseBehavior {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(MouseWheelZoomBehavior.class);

	/** The default zooming speed. */
	private static final double ZOOM_FACTOR = 0.4;

	/** The {@link WakeupCriterion}, this keyboard behavior reacts to. */
	private final WakeupCriterion criterion = new WakeupOnAWTEvent(MouseEvent.MOUSE_WHEEL);

	/** The {@link Transform3D} instance used to implement this keyboard behavior. */
	private final Transform3D transform = new Transform3D();

	/** The {@link Transform3D} instance to help implementing the zoom-in behavior. */
	private final Transform3D zoomIn = new Transform3D();

	/** The {@link Transform3D} instance to help implementing the zoom-out behavior. */
	private final Transform3D zoomOut = new Transform3D();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link MouseWheelZoomBehavior} instance to manipulate the given {@link TransformGroup} instance.
	 *
	 * @param transformGroup
	 *            The transform group to manipulate by the new mouse wheel zoom behavior object.
	 * @throws IllegalArgumentException
	 *             If the transform group passed in is {@code null}.
	 */
	public MouseWheelZoomBehavior(final TransformGroup transformGroup) throws IllegalArgumentException {

		super(transformGroup);

		if (transformGroup == null) {
			throw new IllegalArgumentException("The transform group passed in is null.");
		}

		this.zoomOut.setTranslation(new Vector3d(0, 0, ZOOM_FACTOR));
		this.zoomIn.invert(this.zoomOut);
	}

	@Override
	public void initialize() {

		super.wakeupOn(this.criterion);
	}

	@Override
	public void processStimulus(@SuppressWarnings("rawtypes") final Enumeration criteria) {
		while (criteria.hasMoreElements()) {
			final WakeupCriterion element = (WakeupCriterion) criteria.nextElement();
			if (element instanceof WakeupOnAWTEvent) {
				final AWTEvent[] events = ((WakeupOnAWTEvent) element).getAWTEvent();
				for (AWTEvent event : events) {
					if (event instanceof MouseWheelEvent) {
						this.handleMouseWheelEvent((MouseWheelEvent) event);
					}
				}
			}
			super.wakeupOn(this.criterion);
		}
	}

	/**
	 * Handles a mouse wheel event by zooming in, if the measured wheel rotation ({@code event.getWheelRotation()}) is greater than zero, and zooms out, if this
	 * value is less than zero. However, this action will only take place, if {@link #enableWheelUp} is {@code true}. Otherwise, this method will have no effect.
	 *
	 * @param event
	 *            The mouse wheel event being handled.
	 */
	private void handleMouseWheelEvent(final MouseWheelEvent event) {

		super.transformGroup.getTransform(this.transform);

		if (event.getWheelRotation() > 0) {
			this.transform.mul(this.zoomOut);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Detected mouse wheel down.");
			}
		} else {
			this.transform.mul(this.zoomIn);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Detected mouse wheel up.");
			}
		}

		super.transformGroup.setTransform(this.transform);
	}

}

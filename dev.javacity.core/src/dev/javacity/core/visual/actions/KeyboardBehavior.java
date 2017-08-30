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
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.media.j3d.Behavior;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupCriterion;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.vecmath.Vector3d;

import org.apache.log4j.Logger;

/**
 * A keyboard behavior to handle user inputs on the keyboard.
 *
 * @author pdo
 *
 */
public class KeyboardBehavior extends Behavior {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(KeyboardBehavior.class);

	/** The speed in which the current viewpoint moves to all four directions when pressing any key. */
	private static final double SPEED = 0.02f;

	/** The {@link TransformGroup} instance to manipulate when pressing a key. */
	private final TransformGroup group;

	/** The {@link WakeupCriterion}, this keyboard behavior reacts to. */
	private final WakeupCriterion criterion = new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);

	/** The {@link Transform3D} instance used to implement this keyboard behavior. */
	private final Transform3D transform = new Transform3D();

	/** The {@link Vector3d} indicating the direction or angle of the translation or rotation to perform. */
	private final Vector3d direction = new Vector3d();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link KeyboardBehavior} instance to manipulate the given {@link TransformGroup} instance.
	 *
	 * @param transformGroup
	 *            The transform group to manipulate by the new keyboard behavior object.
	 * @throws IllegalArgumentException
	 *             If the transform group passed in is {@code null}.
	 */
	public KeyboardBehavior(final TransformGroup transformGroup) throws IllegalArgumentException {

		super();

		if (transformGroup == null) {
			throw new IllegalArgumentException("The transform group passed in is null.");
		}

		this.group = transformGroup;
	}

	// ============================ Methods ===================================

	@Override
	public void initialize() {

		super.wakeupOn(this.criterion);
	}

	@Override
	public void processStimulus(@SuppressWarnings("rawtypes") final Enumeration criteria) {
		while (criteria.hasMoreElements()) {
			final WakeupCriterion element = (WakeupCriterion) criteria.nextElement();
			if (element instanceof WakeupOnAWTEvent) {
				for (AWTEvent event : ((WakeupOnAWTEvent) element).getAWTEvent()) {
					if (event instanceof KeyEvent) {
						this.handleEvent((KeyEvent) event);
					}
				}
			}
			super.wakeupOn(this.criterion);
		}
	}

	/**
	 * Handles the given {@link KeyEvent}. It will move the current scene downwards, when 'up' is pressed, upwards, if 'down' is pressed, to the right,
	 * if 'right' is pressed, and to the left, when 'left' is pressed by the user.
	 *
	 * @param event
	 *            The key event to handle.
	 */
	private void handleEvent(final KeyEvent event) {

		// prepare
		final Transform3D trans = new Transform3D();
		this.group.getTransform(trans);
		this.transform.setIdentity();

		// determine key pressed and react to it
		switch (event.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			this.handleUpKeyPressed();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			this.handleDownKeyPressed();
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			this.handleLeftKeyPressed();
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			this.handleRightKeyPressed();
			break;
		default:
			// ignore
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Ignoring key event caused by pressed key " + KeyEvent.getExtendedKeyCodeForChar(event.getKeyCode()));
			}
			break;
		}

		// perform the action
		trans.mul(this.transform);
		this.group.setTransform(trans);
	}

	/**
	 * Handles a pressed 'up' key event by moving the current scene downwards.
	 */
	private void handleUpKeyPressed() {

		this.direction.set(0, SPEED, 0);
		this.transform.setTranslation(this.direction);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Received key event 'key up'.");
		}
	}

	/**
	 * Handles a pressed 'down' key event by moving the current scene upwards.
	 */
	private void handleDownKeyPressed() {

		this.direction.set(0, -SPEED, 0);
		this.transform.setTranslation(this.direction);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Received key event 'key down'.");
		}
	}

	/**
	 * Handles a pressed 'left' key event by moving the current scene to the right.
	 */
	private void handleLeftKeyPressed() {

		this.direction.set(-SPEED, 0, 0);
		this.transform.setTranslation(this.direction);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Received key event 'key left'.");
		}
	}

	/**
	 * Handles a pressed 'right' key event by moving the current scene to the left.
	 */
	private void handleRightKeyPressed() {

		this.direction.set(SPEED, 0, 0);
		this.transform.setTranslation(this.direction);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Received key event 'key right'.");
		}
	}

}

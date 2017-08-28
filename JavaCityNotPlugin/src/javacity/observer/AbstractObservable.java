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

package javacity.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * A custom observable implementation enriching the regular observer pattern's {@code notifyObservers(..)} method by an {@link ObservableAction} indicating the kind
 * or cause of a change.
 *
 * @author pdo
 *
 */
public abstract class AbstractObservable {

	// =========================== Attributes =================================

	/** A list of all observers currently observing this class. */
	private final List<IObserver> observers = new LinkedList<IObserver>();

	// ========================== Constructor =================================

	/**
	 * Protected constructor. May be used by subclasses only.
	 */
	protected AbstractObservable() {/* nothing to do */}

	// ============================ Methods ===================================

	/**
	 * Adds an observer to this {@link AbstractObservable} instance to receive notifications when changes occurred.
	 *
	 * @param obs
	 *            The observer to add. Cannot be {@code null}. If the observer is already contained in this observable instance, this method has no effect.
	 * @throws IllegalArgumentException
	 *             If the given observer is {@code null}.
	 */
	public final void addObserver(final IObserver obs) throws IllegalArgumentException {

		if (obs == null) {
			throw new IllegalArgumentException("You cannot remove a null observer.");
		}

		if (!this.observers.contains(obs)) {
			this.observers.add(obs);
		}
	}

	/**
	 * Removes an observer in this {@link AbstractObservable} instance.
	 *
	 * @param obs
	 *            The observer to remove. Cannot be {@code null}. If the observer is not contained in this observable instance, this method has no effect.
	 * @throws IllegalArgumentException
	 *             If the given observer is {@code null}.
	 */
	public final void removeObserver(final IObserver obs) throws IllegalArgumentException {

		if (obs == null) {
			throw new IllegalArgumentException("You cannot remove a null observer.");
		}

		this.observers.remove(obs);
	}

	/**
	 * Notifies all registered observers about a change.
	 *
	 * @param action
	 *            The {@link ObservableAction} element indicating the kind or cause of this change.
	 * @param object
	 *            The object associated to this change (optional parameter). May be {@code null}, if the given observable action does not have an associated object.
	 */
	protected final void notifyObservers(final ObservableAction action, final Object object) {

		for (IObserver obs : this.observers) {
			obs.update(this, action, object);
		}
	}
}

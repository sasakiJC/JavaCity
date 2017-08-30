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

package dev.javacity.core.observer;

/**
 * An interface for observer classes according to the observer pattern.
 *
 * @author pdo
 *
 */
public interface IObserver {

	/**
	 * Handles all notifications received from the observed object(s).
	 *
	 * @param observable
	 *            The {@link AbstractObservable} object in which the indicated change has occurred.
	 * @param action
	 *            The {@link ObservableAction} indicating the kind or cause of the change.
	 * @param object
	 *            The object related to the change (optional parameter, {@code null} otherwise).
	 */
	void update(AbstractObservable observable, ObservableAction action, Object object);
}

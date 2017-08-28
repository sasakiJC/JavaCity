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

/************************
 * 8月12日　佐々木改定
 * dynamicsLoad関連の削除
 */


package javacity.models.metaphor;

import javacity.observer.AbstractObservable;
import javacity.observer.ObservableAction;
import metaphor.entities.Cable;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularFloor;
import metaphor.entities.Street;

/**
 * The metaphor model of the Synchrovis application containing all metaphor elements currently being displayed on screen.
 *
 * @author pdo
 *
 */
public final class MetaphorModel extends AbstractObservable {

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link MetaphorModel} instance.
	 */
	public MetaphorModel() {

		super();
	}

	// ============================ Methods ===================================

	/**
	 * Adds a new {@link RegularBase} to this metaphor model.
	 *
	 * @param base
	 *            The regular base to add.
	 */
	public void setStaticsLoaded(final RegularBase base) {

		super.notifyObservers(ObservableAction.STATICS_LOADED, base);
	}

	/**
	 * Clears all elements in this metaphor model.
	 */
	public void clearAll() {

		super.notifyObservers(ObservableAction.ALL_CLEARED, null);
	}

	/**
	 * Adds a new {@link RegularFloor} to this metaphor model.
	 *
	 * @param floor
	 *            The regular floor to add.
	 */
	public void addFloor(final RegularFloor floor) {

		super.notifyObservers(ObservableAction.FLOOR_ADDED, floor);
	}

	/**
	 * Removes a {@link RegularFloor} from this metaphor model.
	 *
	 * @param floor
	 *            The regular floor to remove.
	 */
	public void removeFloor(final RegularFloor floor) {

		super.notifyObservers(ObservableAction.FLOOR_REMOVED, floor);
	}

	/**
	 * Adds a new {@link Cable} to this metaphor model.
	 *
	 * @param cable
	 *            The cable to add.
	 */
	public void addCable(final Cable cable) {

		super.notifyObservers(ObservableAction.CABLE_ADDED, cable);
	}

	/**
	 * Removes a {@link Cable} from this metaphor model.
	 *
	 * @param cable
	 *            The cable to remove.
	 */
	public void removeCable(final Cable cable) {

		super.notifyObservers(ObservableAction.CABLE_REMOVED, cable);
	}

	/**
	 * Adds a new {@link Street} to this metaphor model.
	 *
	 * @param street
	 *            The street to add.
	 */
	public void addStreet(final Street street) {

		super.notifyObservers(ObservableAction.STREET_ADDED, street);
	}

	/**
	 * Removes a {@link Street} from this metaphor model.
	 *
	 * @param street
	 *            The street to remove.
	 */
	public void removeStreet(final Street street) {

		super.notifyObservers(ObservableAction.STREET_REMOVED, street);
	}

}

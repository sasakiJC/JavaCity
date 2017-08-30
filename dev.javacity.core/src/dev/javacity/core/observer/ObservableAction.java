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
 * DYNAMICS_LOADEDの削除
 */

package dev.javacity.core.observer;


import metaphor.entities.Cable;
import metaphor.entities.Floor;
import metaphor.entities.Street;

/**
 * An enumeration indicating the kind of or the action causing a change in the {@link AbstractObservable} object.
 *
 * @author pdo
 *
 * @see IObserver
 */
public enum ObservableAction {

	/*
	 * Data model related actions. To be handled by the metaphor importer.
	 */

	/** Indicates that all static program data has been successfully loaded into the observed object. */
	STATICS_LOADED,

	/** Indicates that all objects have been removed from the observed object. */
	ALL_CLEARED,

	/** Indicates that a new {@link SClassInstance} has been added to the observed object. The added instance will be passed by the optional parameter. */
	CLASS_INSTANCE_ADDED,

	/** Indicates that a {@link SClassInstance} has been removed from the observed object. The removed instance will be passed by the optional parameter. */
	CLASS_INSTANCE_REMOVED,

	/** Indicates that a new {@link Relation} has been added to the observed object. The added instance will be passed by the optional parameter. */
	RELATION_ADDED,

	/** Indicates that a {@link Relation} has been removed from the observed object. The removed instance will be passed by the optional parameter. */
	RELATION_REMOVED,

	/*
	 * Metaphor model related actions. To be handled by the view importer.
	 */

	/** Indicates that a {@link Floor} has been removed from the observed object. The removed instance will be passed by the optional parameter. */
	FLOOR_REMOVED,

	/** Indicates that a new {@link Floor} has been added to the observed object. The added instance will be passed by the optional parameter. */
	FLOOR_ADDED,

	/** Indicates that a new {@link Cable} has been added to the observed object. The added instance will be passed by the optional parameter. */
	CABLE_ADDED,

	/** Indicates that a {@link Cable} has been removed from the observed object. The removed instance will be passed by the optional parameter. */
	CABLE_REMOVED,

	/** Indicates that a new {@link Street} has been added to the observed object. The added instance will be passed by the optional parameter. */
	STREET_ADDED,

	/** Indicates that a {@link Street} has been removed from the observed object. The removed instance will be passed by the optional parameter. */
	STREET_REMOVED,


}

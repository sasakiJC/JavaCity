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

package javacity.logic;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import data.statics.Relation;
import data.statics.SClass;
import data.statics.SPackage;
import javacity.models.city.CityModel;

/**
 * A relations manager offering methods to display or hide certain relations outgoing from or incoming to specified classes.
 *
 * @author pdo
 *
 */
public class RelationsManager {

	// =========================== Attributes =================================

	/** A list of all {@link Relation} instances currently visible on screen. */
	private final List<Relation> visibleRelations = new LinkedList<Relation>();

	/** The {@link CityModel} instance currently being controlled by this scene controller. */
	private CityModel model;

	/** The root {@link SPackage} object of the application to visualize. */
	private SPackage root;

	/**
	 * The current status of this relations manager. The pair's left component indicates, whether global or local relations are currently being displayed. If
	 * {@code false}, the {@link SClass} instance whose local relations are currently displayed is stored in the pair's right component ({@code null} otherwise, i.e.
	 * if no relations are currently visible at all).
	 */
	private Pair<Boolean, SClass> status = Pair.of(Boolean.FALSE, null);

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link RelationsManager} instance to control the displayed relations in the specified {@link CityModel} instance.
	 *
	 * @param sceneModel
	 *            The scene model to be controlled by this relations controller.
	 * @param rootPack
	 *            The root package of the application to visualize.
	 * @throws IllegalArgumentException
	 *             If either the scene model or the root package passed in is {@code null}.
	 */
	public RelationsManager(final CityModel sceneModel, final SPackage rootPack) throws IllegalArgumentException {

		if (sceneModel == null) {
			throw new IllegalArgumentException("You cannot control a null scene model.");
		}
		if (rootPack == null) {
			throw new IllegalArgumentException("You cannot set a null root package.");
		}

		this.model = sceneModel;
		this.root = rootPack;

//		Logic.getInstance().getMenuBarController().setShowGlobalRelationsItemEnabled(true);
	}

	// ============================ Methods ===================================

	/**
	 * Displays all relations incoming to or outgoing from the specified {@link SClass} object. All relations visible before this method was invoked will be hidden.
	 *
	 * @param dataObject
	 *            The sClass to display all its relations.
	 * @throws IllegalArgumentException
	 *             If the class passed in is {@code null}.
	 */
	public void showLocalRelations(final SClass dataObject) throws IllegalArgumentException {

		if (dataObject == null) {
			throw new IllegalArgumentException("You cannot show relations of a null class.");
		}

		// remove previous relations
		this.removeVisibleRelations();

		// display requested relations
		for (Relation relation : dataObject.getRelations()) {
			this.visibleRelations.add(relation);
			this.model.addRelation(relation);
		}
		if (!dataObject.getRelations().isEmpty()) {
			this.status = Pair.of(Boolean.FALSE, dataObject);
		}

		// enable 'Hide Relations' item in the menu bar
//		this.updateButtons();
	}

	/**
	 * Adds all {@link Relation} instances available to the scene model currently being controlled. This will make them visible on screen. If no statics data has
	 * been imported yet, this method will have no effect.
	 */
	public void showGlobalRelations() {

		if (this.root != null) {
			// remove previous relations
			this.removeVisibleRelations();

			// display requested relations
			boolean success = false;
			this.status = Pair.of(Boolean.TRUE, null);
			for (SPackage subPack : this.root.getSubPackages()) {
				final boolean newRelations = this.showRelations(subPack);
				success = success || newRelations;
			}
			// enable 'Hide Relations' item in the menu bar
//			this.updateButtons();
		}
	}

	/**
	 * Displays all relations incoming to or outgoing from an {@link SClass} object contained in the specified class.
	 *
	 * @param pack
	 *            The package containing all classes of which relations are going to be displayed.
	 * @return {@code True}, if there is at least one relation to be displayed, {@code false} otherwise.
	 */
	private boolean showRelations(final SPackage pack) {

		boolean success = false;

		// display relations
		for (SClass clazz : pack.getSClasses()) {
			for (Relation relation : clazz.getRelations()) {
				if (relation.getSource().equals(clazz)) {
					this.visibleRelations.add(relation);
					this.model.addRelation(relation);
					success = true;
				}
			}
		}

		// traverse each child package
		for (SPackage subPack : pack.getSubPackages()) {
			final boolean newRelations = this.showRelations(subPack);
			success = success || newRelations;
		}

		return success;
	}

	/**
	 * Removes all currently visible relations (i.e. all elements in {@link #visibleRelations}) from the visualization.
	 */
	public void removeVisibleRelations() {

		for (Relation relation : this.visibleRelations) {
			this.model.removeRelation(relation);
		}
		this.visibleRelations.clear();
		this.status = Pair.of(Boolean.FALSE, null);
//		this.updateButtons();
	}

	/**
	 * Updates the relation menu items in menu bar -> 'Relations' according to the currently selected entity and relation visualization status ({@link #getStatus()}
	 * ).
	 */
//	public void updateButtons() {
//
//		final Primitive selected = Logic.getInstance().getSelectionController().getSelectedNode();
//
//		final Pair<Boolean, SClass> stat = this.getStatus();
//		Logic.getInstance().getMenuBarController().setShowGlobalRelationsItemEnabled(!stat.getLeft());
//		Logic.getInstance().getMenuBarController().setRelationsHideItemEnabled(stat.getLeft() || stat.getRight() != null);
//
//		if (selected == null) {
//			Logic.getInstance().getMenuBarController().setRelationsHideItemEnabled(stat.getLeft() || stat.getRight() != null);
//		} else {
//			final VisualEntity visual = (VisualEntity) selected.getUserData();
//			Logic.getInstance()
//					.getMenuBarController().setShowLocalRelationsItemEnabled(
//							visual instanceof RegularFloor && !((RegularFloor) visual).getBuilding().getDataObject().equals(stat.getRight()));
//		}
//	}
//
	/**
	 * Returns the current status of this relations manager. The pair's left component indicates, whether global or local relations are currently being displayed. If
	 * {@code false}, the {@link SClass} instance whose local relations are currently displayed is stored in the pair's right component ({@code null} otherwise, i.e.
	 * if no relations are currently visible at all).
	 *
	 * @return The current stats of this relations manager.
	 */
	public Pair<Boolean, SClass> getStatus() {
		return Pair.of(this.status.getLeft(), this.status.getRight());
	}

}

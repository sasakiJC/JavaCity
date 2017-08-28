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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.apache.log4j.Logger;

import com.sun.j3d.utils.geometry.Primitive;

import data.VisualizableElement;
import data.statics.SClass;
import javacity.configuration.Language;
import javacity.utils.LoggerUtils;
import javacity.visual.metaphor.Arrow;
import javacity.visual.metaphor.BorderedBox;
import javacity.visual.metaphor.Cone;
import javacity.visual.metaphor.utils.NodeSelector;
import metaphor.entities.Cable;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.Street;
import metaphor.types.VisualEntity;

/**
 * A mouse selection controller managing and controlling all actions related to the selection of visual entities (i.e. Java3D objects) in the visualization on
 * screen.
 *
 * @author pdo
 *
 */
public final class MouseSelectionController {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(MouseSelectionController.class);

	/** The {@link NodeSelector} used to optically select or unselect any given node passed to a method of this class. */
	private final NodeSelector selector = new NodeSelector();

	/** The {@link JPopupMenu} to be opened whenever a user presses the right mouse key on a (selected) visual node displayed on the city canvas. */
	private final JPopupMenu popUp = new JPopupMenu();

	// ========================== Constructor =================================

	/**
	 * Protected constructor. This class is not intended for instantiation from outside of this package.
	 */
	protected MouseSelectionController() {/* nothing to do */}

	// ============================ Methods ===================================

	/**
	 * Builds the pop-up structure of {@link #popUp}. I.e. adds a new menu item to it causing all relations of the specified node's representing class to be shown in
	 * the visualization when clicked on it.
	 *
	 * @param regularFloor
	 *            The node representing an instance if the class to show its relations.
	 */
	private void buildPopUp(final RegularFloor regularFloor) {

		this.popUp.removeAll();
		final JMenuItem item = new JMenuItem(Language.getInstance().get("selection.popup.showRelations"));
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {

				// show relations
				Logic.getInstance().getCityController().showLocalRelations((SClass) regularFloor.getBuilding().getDataObject());
				MouseSelectionController.this.hidePopup();
			}
		});
		this.popUp.add(item);
	}

	/**
	 * Selects the specified node on screen. This method will visually highlight the given node and show its properties in the {@link PropertiesPanel} instance of
	 * Synchrovis' GUI. This method has no effect, if the specified node's user data object is no instance of {@link Street}, {@link Cable}, {@link RegularFloor},
	 * {@link AdministrationFloor}, or {@link RegularDistrict}
	 *
	 * @param node
	 *            The node to be selected.
	 * @throws IllegalArgumentException
	 *             If the node passed in is {@code null}.
	 */
	public void select(final Primitive node) throws IllegalArgumentException {

		if (node == null) {
			throw new IllegalArgumentException("You cannot select a null node.");
		}

		// show properties
		final Primitive mainNode = this.getMainNode(node);
		if (mainNode.getUserData() instanceof VisualEntity && !(mainNode.getUserData() instanceof RegularBase)) {
			// select main node and display properties
			this.selector.selectNode(mainNode);
			Logic.getInstance().getCityController().updateRelationButtons();
		}
	}

	/**
	 * Unselects the currently selected node, i.e. restores its original coloring. If no node is currently selected, this method will have no effect.
	 */
	public void unselect() {

		if (this.selector.getSelectedNode() != null) {
			this.selector.unselectNode(this.getSelectedNode());
			Logic.getInstance().getMenuBarController().setShowLocalRelationsItemEnabled(false);
		}
	}

	/**
	 * Opens a pop-up allowing the user to show the picked node's metaphor object's relations. This method has no effect, if the specified node's metaphor object is
	 * no instance of {@link RegularFloor}. Note that only one pop-up may be visible at the same time. So, if another pop-up is visible when invoking this method, it
	 * will be closed before this new pop-up is going to be created.
	 *
	 * @param mouseEvent
	 *            The {@link MouseEvent} to cause the pop-up to open.
	 * @param node
	 *            The node on which the pop-up is supposed to be opened.
	 * @throws IllegalArgumentException
	 *             If either the mouse event or the node passed in is {@code null}.
	 */
	public void openPopup(final MouseEvent mouseEvent, final Primitive node) throws IllegalArgumentException {

		if (mouseEvent == null) {
			throw new IllegalArgumentException("You cannot pass in a null mouse event.");
		}
		if (node == null) {
			throw new IllegalArgumentException("You cannot pass in a null node event.");
		}

		if (node.getUserData() instanceof RegularFloor) {
			this.buildPopUp((RegularFloor) node.getUserData());
			this.popUp.setLocation(mouseEvent.getLocationOnScreen());
			this.popUp.setVisible(true);
		}
	}

	/**
	 * Hides the pop-up opened by {@link #openPopup(MouseEvent, Node)}. This method has no effect, if no pop-up is currently visible.
	 */
	public void hidePopup() {

		this.popUp.setVisible(false);
	}

	/**
	 * Returns the node currently selected or {@code null}, if no node is currently selected.
	 *
	 * @return The currently selected node.
	 */
	public Primitive getSelectedNode() {

		return this.selector.getSelectedNode();
	}

	/**
	 * Returns the main (parent) node containing the specified node or the given node itself, if it is already its main node itself.
	 *
	 * @param node
	 *            The node to get its main node.
	 * @return The main node of the given node.
	 */
	private Primitive getMainNode(final Primitive node) {

		final Primitive retval;
		if (node instanceof BorderedBox) {
			final BorderedBox box = (BorderedBox) node;
			if (box.getParent().getParent() instanceof BorderedBox) {
				retval = (BorderedBox) box.getParent().getParent();
			} else {
				retval = box;
			}
		} else if (node instanceof Pipe || node instanceof Arrow || node instanceof Cone) {
			Node curNode = node.getParent();
			while ((curNode != null && !(curNode instanceof Primitive)) || curNode instanceof Arrow) {
				curNode = curNode.getParent();
			}

			retval = (Primitive) curNode;
		} else {
			retval = node;
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("User selected Java 3D object of class " + retval.getClass().getName() + " matching data object"
					+ LoggerUtils.toLogString((VisualizableElement) ((VisualEntity) retval.getUserData()).getDataObject()));
		}
		return retval;
	}

}

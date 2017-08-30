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

/***************************************************************************
 * java3Dからjavafxへ
 *
 * 改定
 **************************************************************************/

package dev.javacity.core.visual.metaphor.utils;


import dev.javacity.core.visual.metaphor.Arrow;
import dev.javacity.core.visual.metaphor.BendableArrow;
import dev.javacity.core.visual.metaphor.BorderedBox;
import dev.javacity.core.visual.metaphor.DashedArrow;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * A node selector to visually select and unselect any given {@link Primitive}.
 *
 * @author pdo
 *
 */
public class NodeSelector {

	// =========================== Attributes =================================

	/** The color in which the currently selected node will be colored. */
	private static final Color SELECTION_COLOR = Color.GREEN;

	/** The original color of the currently selected node. Will be restore, when unselecting this node. */
	private final Color selectedNodeColor = new Color(0,0,0,1);

	/** The {@link Primitive} currently being selected by the user. */
	private Group selectedNode;

	// ========================== Constructor =================================

	/**
	 * Constructs a new {@link NodeSelector} instance.
	 */
	public NodeSelector() {/* nothing to do */}

	// ============================ Methods ===================================

	/**
	 * Selects the given {@link Node}, i.e. sets its color to {@link #SELECTION_COLOR}. This method has no effect, if the specified node is already selected. Note
	 * that there can only exist one selected node at any time. If another node n is already selected when invoking this method with a different argument node, n
	 * will be unselected automatically.
	 *
	 * @param node
	 *            The node to be selected.
	 * @throws IllegalArgumentException
	 *             If the node passed in is {@code null}.
	 */
	public void selectNode(final Group node) throws IllegalArgumentException {

		if (node == null) {
			throw new IllegalArgumentException("You cannot select a null node.");
		}

		if (node != this.selectedNode) {
			this.unselectNode(this.selectedNode);

			//node.getAppearance().getColoringAttributes().getColor(this.selectedNodeColor);
			this.setColor(node, SELECTION_COLOR);
			this.selectedNode = node;
		}
	}
	/**
	 * Unselects the given {@link Node}, i.e. restores its original coloring. This method has no effect, if the specified node is not selected or is {@code nulls}.
	 *
	 * @param node
	 *            The node to be unselected.
	 */
	public void unselectNode(final Group node) {

		if (node == this.selectedNode && this.selectedNode != null) {
			this.setColor(this.selectedNode, this.selectedNodeColor);
			this.selectedNode = null;
		}
	}

	/**
	 * Returns the node currently selected or {@code null}, if no node is currently selected.
	 *
	 * @return The currently selected node.
	 */
	public Group getSelectedNode() {

		return this.selectedNode;
	}

	/**
	 * Sets the color of the specified node.
	 *
	 * @param node
	 *            The node to set its new color.
	 * @param color
	 *            The new color to set.
	 * @throws IllegalArgumentException
	 *             If the node passed in is no instance of {@link BendableArrow}, {@link BorderedBox}, {@link DashedArrow}, or {@link Arrow}.
	 */
	private void setColor(final Group node, final Color color) throws IllegalArgumentException {

		if (node instanceof BendableArrow) {
			((BendableArrow) node).setColor(color);
		} else if (node instanceof BorderedBox) {
			((BorderedBox) node).setColor(color);
		} else if (node instanceof DashedArrow) {
			((DashedArrow) node).setColor(color);
		} else if (node instanceof Arrow) {
			((Arrow) node).setColor(color);
		} else {
			throw new IllegalArgumentException("You cannot set the color of an " + node.getClass().getName() + " since this node type is not supported.");
		}
	}

}

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
 */

package javacity.models.view;

import javacity.visual.gui.CityCanvas;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;

/**
 * The view model of the Synchrovis application. It contains all Java-3D objects currently being visible on screen.
 *
 * @author pdo
 *
 */
public class ViewModel {

	// =========================== Attributes =================================

	/** The {@link SimpleUniverse} representing the entire visualization on screen. */
//	private SimpleUniverse universe;

	/** The branch graph root instance of this view model. */
//	private BranchGroup root;
	private Group root;
	/** The root's parent {@link BranchGroup} to add all visual entities in the visualization to. */
//	private BranchGroup rootParent;

	/** The current {@link CityCanvas} instance used in this view model. */
//	private CityCanvas canvas;
	private SubScene scene;

	// ========================== Constructor =================================

	/**
	 * Constructs a new {@link ViewModel} instance.
	 */
	public ViewModel() {}

	// ============================ Methods ===================================

	/**
	 * Initializes its {@link ViewModel} instance. This method has to be invoked before any other operation is executed. Otherwise, corresponding exceptions will be
	 * thrown.
	 *
	 * @param cityCanvas
	 *            The {@link CityCanvas} representing the three-dimensional surface, on which all objects added to this view model will be drawn at.
	 * @throws IllegalArgumentException
	 *             If the canvas object passed in is {@code null}.
	 */
	public void init(final SubScene subscene) throws IllegalArgumentException {

		if (subscene == null) {
			throw new IllegalArgumentException("The canvas passed in is null.");
		}

		// add viewpoint
//		ViewPoint.getInstance().init(this.universe);
//		ViewPoint.getInstance().resetViewpoint();

		// add lightning
		final AmbientLight amblight = new AmbientLight(Color.WHITE);

		root = (Group)((Group)subscene.getRoot()).getChildren().get(0);
		root.getChildren().add(amblight);

		// add behaviors
//		this.addBehaviors(cityCanvas);

		//subscene.getCamera().setNearClip(1);
		//subscene.getCamera().setFarClip(100);

		subscene.setFill(Color.WHITE);

		this.scene = subscene;
	}

	/**
	 * Add all behaviors to this view model. This method will add a {@link MouseRotationBehavior}, {@link MouseSelectionBehavior}, {@link MouseWheelZoomBehavior} and
	 * {@link KeyboardBehavior} to the specified canvas or the root branch group {@link #root}.
	 *
	 * @param cityCanvas
	 *            The canvas to add the behaviors to.
	 */
//	private void addBehaviors(final CityCanvas cityCanvas) {
//
//		final BoundingSphere bounds = new BoundingSphere(new Point3d(), Float.MAX_VALUE);
//
//		// add transform group to root (parent) to allow mouse initiated rotations
//		final TransformGroup rootTG = new TransformGroup();
//		rootTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
//		rootTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//
//		rootTG.addChild(this.rootParent);
//		this.root.addChild(rootTG);
//
//		// add selection behavior
//		final MouseSelectionBehavior selectionBehavior = new MouseSelectionBehavior(cityCanvas);
//		selectionBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(selectionBehavior);
//
//		// add keyboard behavior
//		final KeyboardBehavior keyboardBehavior = new KeyboardBehavior(this.universe.getViewingPlatform().getViewPlatformTransform());
//		keyboardBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(keyboardBehavior);
//
//		// add mouse rotation behavior
//		final MouseRotationBehavior rotationBehavior = new MouseRotationBehavior(rootTG);
//		rotationBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(rotationBehavior);
//
//		// add zoom behavior
//		final MouseWheelZoomBehavior zoomBehavior = new MouseWheelZoomBehavior(this.universe.getViewingPlatform().getViewPlatformTransform());
//		zoomBehavior.setEnable(true);
//		zoomBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(zoomBehavior);
//	}

	/**
	 * Clean up all memory used by the underlying simple universe and remove all references from it. This method should typically be invoked when the application is
	 * about to exit.
	 */
//	public void cleanUpScene() {
//
//		this.universe.cleanup();
//	}

	/**
	 * Removes all objects from this view model, i.e. clears the entire visualization.
	 */
	public void clearAll() {
		this.root.getChildren().clear();

//		@SuppressWarnings("unchecked")
//		final Enumeration<Object> children = this.rootParent.getAllChildren();
//		while (children.hasMoreElements()) {
//			final Object next = children.nextElement();
//			if (next instanceof BranchGroup) {
//				this.rootParent.removeChild((Node) next);
//				((BranchGroup) next).detach();
//			}
//		}
//
//		this.universe.cleanup();
//		this.init(this.canvas);
	}

	/**
	 * Adds the the given {@link Node} instance to the visualization, i.e. attaches it to the scene graph.
	 *
	 * @param node
	 *            The node to add to the visualization.
	 * @throws IllegalArgumentException
	 *             If the node passed in is {@code null}.
	 */
	public void addNode(final Node node) throws IllegalArgumentException {

		if (node == null) {
			throw new IllegalArgumentException("You cannot add a null node.");
		}

		this.root.getChildren().add(node);

	}

	/**
	 * Removes the given {@link Node} instance from the visualization, i.e. detaches its parent {@link BranchGroup} from the branch graph.
	 *
	 * @param node
	 *            The node to remove from the visualization.
	 */
	public void removeNode(final Node node) {

		if (node != null) {
//			Node parent = node.getParent();
//			while (!(parent instanceof BranchGroup || parent == null)) {
//				parent = parent.getParent();
//			}

			if(root.getChildren().contains(node)){
				root.getChildren().remove(node);
			}
		}

	}

	/**
	 * Returns the root branch group of this view model instance, i.e. {@link #root}.
	 *
	 * @return The root branch group of this Java3D model's branch graph.
	 */
//	public BranchGroup getRootBranchGroup() {
//
//		return this.root;
//	}

	/**
	 * Returns the {@link SimpleUniverse} instance of this view model.
	 *
	 * @return The simple universe.
	 */
	public SubScene getScene() {

		return this.scene;
	}

}

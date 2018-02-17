package javacity.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javacity.model.DataModel;
import javacity.model.SoftwareEntity;
import javafx.scene.Group;
import javafx.scene.Node;

public class CityView extends Group implements Observer {

	private DataModel testDataModel;
	private Map<SoftwareEntity, VisualizedComposite> allmap = new HashMap<>();

	public CityView() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void innerLayout() {
		this.getChildren().forEach(child -> {
			((VisualizedComposite)child).innerLayout();
		});
	}

	/**
	 * Removes all objects from this view, i.e. clears the entire visualization.
	 */
	public void clearAll() {
		this.getChildren().clear();
	}

	/**
	 * Adds the the given {@link Node} instance to the visualization, i.e. attaches it to the scene graph.
	 *
	 * @param visualizedComponent
	 *            The node to add to the visualization.
	 * @throws IllegalArgumentException
	 *             If the node passed in is {@code null}.
	 */
	public void addNode(final VisualizedComposite visualizedComponent) throws IllegalArgumentException {

		if (visualizedComponent == null) {
			throw new IllegalArgumentException("You cannot add a null node.");
		}

		this.getChildren().add(visualizedComponent);

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

			if(this.getChildren().contains(node)){
				this.getChildren().remove(node);
			}
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
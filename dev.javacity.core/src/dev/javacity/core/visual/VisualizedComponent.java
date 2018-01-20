package dev.javacity.core.visual;

import java.util.List;

import javacity.model.SoftwareEntity;
import javafx.scene.Group;

public interface VisualizedComponent {

//	public boolean isVisible();
//	public void isSelected();
	public SoftwareEntity getEntity();
	public default void add(VisualizedComponent child) {;
		throw new UnsupportedOperationException("this component can't have any children");
	}

	public default boolean hasChild() {
		return false;
	}

	public default List<VisualizedComponent> getChildren() {
		throw new UnsupportedOperationException("this component can't have any children");
	}

	public default void remove(VisualizedComponent child) {
		throw new UnsupportedOperationException("this component can't have any children");
	}

	public void layout();

	public ViewBounds coputeSize();

	public Group fxView();

}

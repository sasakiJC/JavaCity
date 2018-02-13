package dev.javacity.core.visual;

import javacity.model.SoftwareEntity;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Shape3D;

public class VisualizedComposite extends Group {

	private SoftwareEntity entity;
	private InnerLayout layout;
//	private Shape3D shape;


	public VisualizedComposite(SoftwareEntity entity, InnerLayout layout, Shape3D shape) {
		this.entity = entity;
		this.layout = layout;
//		this.shape = shape;
		this.getChildren().add(shape);
	}

	public void add(VisualizedComposite compoite) {
		this.getChildren().add(compoite);
	}

	public SoftwareEntity getEntity() {
		return this.entity;
	}


	public boolean hasChild() {
		return this.getChildren().size() > 0;
	}

	public void remove(VisualizedComposite child) {
		if(this.getChildren().contains(child))
			this.getChildren().remove(child);
	}

	public void innerLayout() {
		for(Node child : this.getChildren()) {
			VisualizedComposite comp = (VisualizedComposite)child;
			this.layout.layout(comp);
			comp.innerLayout();
		}
	}

//	public ViewBounds coputeSize() {
//		for(Node child : this.getChildren()) {
//			VisualizedComposite comp = (VisualizedComposite)child;
//			this.layout.computeSize(child);
//		}
//		return null;
//	}

	public Group createFxView() {
//		return this.glyph
		return null;
	}

}

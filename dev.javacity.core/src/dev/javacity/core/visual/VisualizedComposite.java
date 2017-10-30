package dev.javacity.core.visual;

import java.util.LinkedList;
import java.util.List;

import dev.javacity.core.models.TargetEntity;
import javafx.scene.Group;

public abstract class VisualizedComposite implements VisualizedComponent {

	private TargetEntity entity;
	private Group fxView;
	private List<VisualizedComponent> children;
	private VisLayout layout;

	public VisualizedComposite(TargetEntity entity, VisLayout layout) {
		this.entity = entity;
		this.layout = layout;
		this.children = new LinkedList<VisualizedComponent>();
	}

	@Override
	public TargetEntity getEntity() {
		return this.entity;
	}
	@Override
	public void add(VisualizedComponent child) {;
		this.children.add(child);
	}

	@Override
	public boolean hasChild() {
		return this.children.size() > 0;
	}

	@Override
	public List<VisualizedComponent> getChildren() {
		return this.children;
	}

	@Override
	public void remove(VisualizedComponent child) {
		if(this.children.contains(child))
			this.children.remove(child);
	}

	@Override
	public void layout() {
		for(VisualizedComponent child : this.children) {
			child.layout();
		}
	}

	@Override
	public Group fxView() {
		return this.fxView;
	}

}

package dev.javacity.core.visual;

import java.util.LinkedList;
import java.util.List;

import javacity.model.SoftwareEntity;
import javafx.scene.Group;

public abstract class VisualizedComposite implements VisualizedComponent {

	protected SoftwareEntity entity;
	protected Group fxView;
	protected List<VisualizedComponent> children;
	protected VisLayout layout;

	protected Mappings mappings;
	protected boolean needsRecreate = false;

	public VisualizedComposite(SoftwareEntity entity, VisLayout layout) {
		this.entity = entity;
		this.layout = layout;
		this.children = new LinkedList<VisualizedComponent>();
	}

	public VisualizedComposite(SoftwareEntity entity, Mappings mappings) {
		this.entity = entity;
		this.mappings = mappings;
	}


	@Override
	public SoftwareEntity getEntity() {
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
			this.layout.layout(child);
			child.layout();
		}
	}

	@Override
	public Group fxView() {
		if(this.fxView == null || this.needsRecreate) {
			this.fxView = this.createFxView();
			this.needsRecreate = false;
		}
		return this.fxView;
	}

	@Override
	public ViewBounds coputeSize() {
		for(VisualizedComponent child : this.children) {
			this.layout.computeSize(child);
		}
		return null;
	}

	abstract Group createFxView();

}

package dev.javacity.core.visual;

import dev.javacity.core.visual.metaphor.BorderedBox;
import javacity.model.TargetEntity;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Building extends VisualizedComposite {

	private Color color;
	private double length;
	private double width;
	private double height;

	public Building(TargetEntity entity, VisLayout layout) {
		super(entity, layout);
	}

	public Building(TargetEntity entity, Mappings mappings) {
		super(entity, mappings);
	}


	public Group createFxView() {
		this.color = (Color)this.mappings.mapToAttribute("color", this.entity);
		this.color = this.color.deriveColor(0, this.color.getSaturation(), this.color.getBrightness(), (double)this.mappings.mapToAttribute("alpha", this.entity));
		this.length = (double)this.mappings.mapToAttribute("length", this.entity);
		this.width = (double)this.mappings.mapToAttribute("width", this.entity);
		this.height = (double)this.mappings.mapToAttribute("height", this.entity);
		BorderedBox box = new BorderedBox(this.length, this.height, this.width, this.color);
		return box;
	}

}

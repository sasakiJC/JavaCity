package dev.javacity.core.visual;

import dev.javacity.core.models.TargetEntity;
import dev.javacity.core.visual.metaphor.BorderedBox;
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
		this.color = (Color)this.mappings.getMapper("color").toAttribute();
		this.color = this.color.deriveColor(0, this.color.getSaturation(), this.color.getBrightness(), (double)this.mappings.getMapper("alpha").toAttribute());
		this.length = (double)this.mappings.getMapper("length").toAttribute();
		this.width = (double)this.mappings.getMapper("width").toAttribute();
		this.height = (double)this.mappings.getMapper("height").toAttribute();
		BorderedBox box = new BorderedBox(this.length, this.height, this.width, this.color);
		return box;
	}

}

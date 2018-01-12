package dev.javacity.core.visual;

import dev.javacity.core.visual.metaphor.BorderedBox;
import javacity.model.TargetEntity;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class District extends VisualizedComposite {

	private Color color;
	private double length;
	private double width;
	private double height;

	public District(TargetEntity entity, VisLayout layout) {
		super(entity, layout);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public District(TargetEntity entity, Mappings mappings) {
		super(entity, mappings);
	}

	@Override
	Group createFxView() {
		this.color = (Color)this.mappings.getMapper("color").toAttribute();
		this.color = this.color.deriveColor(0, this.color.getSaturation(), this.color.getBrightness(), (double)this.mappings.getMapper("alpha").toAttribute());
		this.length = (double)this.mappings.getMapper("length").toAttribute();
		this.width = (double)this.mappings.getMapper("width").toAttribute();
		this.height = 0.5;
		BorderedBox box = new BorderedBox(this.length, this.height, this.width, this.color);
		return box;
	}




}

package dev.javacity.core.visual;

import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetEntity;
import dev.javacity.core.visual.metaphor.BorderedBox;
import javafx.scene.Group;

public class Building implements VisualizedComponent {

	private BorderedBox fxBuilding;
	private TargetClass clazz;

	public Building(TargetClass clazz) {
		this.clazz = clazz;

	}

	@Override
	public boolean isVisible() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void isSelected() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public TargetEntity getEntity() {
		return this.clazz;
	}

	public Group getFxNode() {
		return this.fxBuilding;
	}

}

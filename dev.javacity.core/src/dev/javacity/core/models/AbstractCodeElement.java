package dev.javacity.core.models;

import java.util.List;

public abstract class AbstractCodeElement implements TargetEntity, Modifiable {

	private String name;


	protected AbstractCodeElement(String name) {
		this.name = name;
	}

	@Override
	public void setModifiers(List<?> modifiers) {


	}

	@Override
	public void addChild(TargetEntity child) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<TargetEntity> getChildren() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void removeChild(TargetEntity child) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setParent(TargetEntity parent) {
		// TODO 自動生成されたメソッド・スタブ

	}

}

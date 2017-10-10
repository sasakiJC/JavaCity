package dev.javacity.core.models;

import java.util.List;

import org.eclipse.jdt.core.dom.Modifier;

public abstract class AbstractCodeElement implements TargetEntity, Modifiable {

	private String name;


	protected AbstractCodeElement(String name) {
		this.name = name;
	}

	@Override
	public void setModifier(Modifier modifier) {


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

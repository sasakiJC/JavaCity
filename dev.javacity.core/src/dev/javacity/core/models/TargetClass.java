package dev.javacity.core.models;

import java.util.List;

public class TargetClass implements TargetEntity {

	public enum ClassType {
		INTERFACE, ABSTRACT, CONCRETE, ENUM
	}

	private String name;
	private ClassType type;
	public TargetClass(String name, ClassType type) {
		this.name = name;
		this.type = type;
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

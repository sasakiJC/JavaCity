package dev.javacity.core.models;

import java.util.List;

public class TargetMethod implements TargetEntity {

	private String name;
//	private String signature;
	public TargetMethod(String name) {
		this.name = name;
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

//	public void setSignature(String signature) {
//
//	}

}

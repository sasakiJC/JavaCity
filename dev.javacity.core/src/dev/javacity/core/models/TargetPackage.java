package dev.javacity.core.models;

import java.util.List;

public class TargetPackage implements TargetEntity {

	private String name;
	private String parentPackageName;
	public TargetPackage(String fullName) {
		if(fullName.contains(".")) {
			this.name = fullName.substring(fullName.lastIndexOf(".")+1, fullName.length());
			this.parentPackageName = fullName.substring(0,fullName.lastIndexOf("."));
		} else {
			this.name = fullName;
			this.parentPackageName = "";
		}
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

	public boolean isParentPackage(TargetPackage pack) {
		if(this.parentPackageName.equals(this.name))
			return false;
		else
			return this.parentPackageName.equals(pack.fullName());
	}

	public String fullName() {
		if(this.parentPackageName.equals("") || this.name.equals(""))
			return this.name;
		else
			return this.parentPackageName+"."+this.name;
	}


}

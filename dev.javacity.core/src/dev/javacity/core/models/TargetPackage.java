package dev.javacity.core.models;

import java.util.List;

public class TargetPackage implements TargetEntity {

	private String name;
	private String parentPackageName;
	private final EntityIdentifier identifier;

	public TargetPackage(EntityIdentifier identifier, String fullName) {
		this.identifier = identifier;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityIdentifier getIdentifier() {
		return this.identifier;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>この実装では識別子のハッシュ・コード値を返す。
	 */
    @Override
    public final int hashCode() {
        return identifier.hashCode();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj instanceof TargetEntity == false) {
            return false;
        }
        return identifier.equals(((TargetEntity) obj).getIdentifier());
    }


}

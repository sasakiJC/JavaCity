package dev.javacity.core.models;

import java.util.List;

public class TargetPackage implements TargetEntity<TargetPackage> {

	private String fullName;
	private String[] names;
	private final EntityIdentifier<TargetPackage> identifier;

	public TargetPackage(EntityIdentifier<TargetPackage> identifier, String fullName) {
		this.identifier = identifier;
		this.fullName = fullName;
		this.names = fullName.split(".");
	}

	@Override
	public void addChild(EntityIdentifier<TargetPackage> child) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<EntityIdentifier<TargetPackage>> getChildren() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void removeChild(EntityIdentifier<TargetPackage> child) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setParent(EntityIdentifier<TargetPackage> parent) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public boolean isParentPackage(String packName) {
		String[] tmp = packName.split(".");
		if(this.names.length-1 != tmp.length)
			return false;

		for(int i=0;i<tmp.length;i++) {
			if(this.names[i].equals(tmp[i]))
				return false;
		}
		return true;
	}

	public String getName() {
		return this.fullName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityIdentifier<TargetPackage> getIdentifier() {
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

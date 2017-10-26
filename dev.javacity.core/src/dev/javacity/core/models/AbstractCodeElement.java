package dev.javacity.core.models;

import java.util.List;

public abstract class AbstractCodeElement implements TargetEntity, Modifiable {

	protected String name;
	private TargetEntity parent;
	private List<TargetEntity> children;

	/**
	 * このエンティティの識別子
	 */
	protected final EntityIdentifier identifier;

	/**
	 * 指定された識別子を使用してエンティティを作成します。
	 * @param identifier エンティティの識別子
	 * @throws NullPointerException 引数に{@code null}を与えた場合
	 */
	protected AbstractCodeElement(EntityIdentifier identifier, String name) {
		if(identifier==null)
			throw new NullPointerException("Identifier cannot be null");
		this.identifier = identifier;
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final EntityIdentifier getIdentifier() {
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


	@Override
	public void setModifiers(List<?> modifiers) {

	}

	@Override
	public void addChild(TargetEntity child) {
		this.children.add(child);
	}

	@Override
	public List<TargetEntity> getChildren() {
		return this.children;
	}

	@Override
	public void removeChild(TargetEntity child) {
		if(this.children.contains(child)) {
			this.children.remove(child);
		}
	}

	@Override
	public void setParent(TargetEntity parent) {
		this.parent = parent;
	}

}
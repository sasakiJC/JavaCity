package javacity.model;

import java.util.LinkedList;
import java.util.List;

public class SoftwareEntity {

	private final SoftwareElementType type;
	private final String name;

	private CodeMetrics metrics;
	/**
	 * このエンティティの識別子
	 */
	private final EntityIdentifier identifier;

	private SoftwareEntity parent;
	private List<SoftwareEntity> children;

	/**
	 * 指定された識別子を使用してエンティティを作成します。
	 * @param identifier エンティティの識別子
	 * @throws NullPointerException 引数に{@code null}を与えた場合
	 */
	public SoftwareEntity(String name, EntityIdentifier identifier, SoftwareElementType type) {
		if(identifier==null)
			throw new NullPointerException("Identifier cannot be null");
		this.identifier = identifier;
		this.name = name;
		this.type = type;
		this.children = new LinkedList<>();
	}

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

	public void addChild(SoftwareEntity child) {
		this.children.add(child);
	}

	public List<SoftwareEntity> getChildren() {
		return this.children;
	}

	public void removeChild(SoftwareEntity child) {
		if(this.children.contains(child)) {
			this.children.remove(child);
		}
	}

	public void setParent(SoftwareEntity parent) {
		this.parent = parent;
	}

}

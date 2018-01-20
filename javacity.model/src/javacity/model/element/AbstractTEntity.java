package javacity.model.element;

import java.util.LinkedList;
import java.util.List;

import javacity.model.CodeMetrics;
import javacity.model.EntityIdentifier;
import javacity.model.SoftwareEntity;



public abstract class AbstractTEntity implements SoftwareEntity {

	protected String name;
	private SoftwareEntity parent;
	private List<SoftwareEntity> children;

	private CodeMetrics metrics;

	/**
	 * このエンティティの識別子
	 */
	protected final EntityIdentifier identifier;

	/**
	 * 指定された識別子を使用してエンティティを作成します。
	 * @param identifier エンティティの識別子
	 * @throws NullPointerException 引数に{@code null}を与えた場合
	 */
	protected AbstractTEntity(EntityIdentifier identifier, String name, CodeMetrics metrics) {
		if(identifier==null)
			throw new NullPointerException("Identifier cannot be null");
		this.identifier = identifier;
		this.name = name;
		this.metrics = metrics;
		this.children = new LinkedList<>();
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
        if (obj == null || obj instanceof SoftwareEntity == false) {
            return false;
        }
        return identifier.equals(((SoftwareEntity) obj).getIdentifier());
    }

	@Override
	public void addChild(SoftwareEntity child) {
		this.children.add(child);
	}

	@Override
	public List<SoftwareEntity> getChildren() {
		return this.children;
	}

	@Override
	public void removeChild(SoftwareEntity child) {
		if(this.children.contains(child)) {
			this.children.remove(child);
		}
	}

	@Override
	public void setParent(SoftwareEntity parent) {
		this.parent = parent;
	}

}
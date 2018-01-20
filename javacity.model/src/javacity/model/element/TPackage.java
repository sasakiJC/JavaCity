package javacity.model.element;

import java.util.List;

import javacity.model.CodeMetrics;
import javacity.model.EntityIdentifier;
import javacity.model.SoftwareEntity;

public class TPackage implements SoftwareEntity {

	private final EntityIdentifier identifier;
	private String fullName;
	private String[] names;
	private CodeMetrics metrics;
	private List<SoftwareEntity> classes;

	public TPackage(EntityIdentifier identifier, String fullName, CodeMetrics metrics) {
		this.identifier = identifier;
		this.fullName = fullName;
		this.names = fullName.split(".");
		this.metrics = metrics;
	}

	@Override
	public void addChild(SoftwareEntity child) {
		this.classes.add(child);
	}

	@Override
	public List<SoftwareEntity> getChildren() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void removeChild(SoftwareEntity child) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setParent(SoftwareEntity parent) {
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
        if (obj == null || obj instanceof SoftwareEntity == false) {
            return false;
        }
        return identifier.equals(((SoftwareEntity) obj).getIdentifier());
    }


}
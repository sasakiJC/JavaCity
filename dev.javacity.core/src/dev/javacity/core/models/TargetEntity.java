package dev.javacity.core.models;

import java.util.List;

/**
 * このインターフェースを実装するオブジェクトは{@link EntityIdentifier}を用いて同一性を判断します。
 * また、このインターフェースを実装するクラスはコピーコンストラクタを提供しなければいけません。
 */
public interface TargetEntity<T extends TargetEntity<T>> {
	public default void addChild(EntityIdentifier<T> child) {
		throw new UnsupportedOperationException(this.toString() + " can't have children");
	}
	public default List<EntityIdentifier<T>> getChildren() {
		throw new UnsupportedOperationException(this.toString() + " can't have children");
	}
	public default boolean hasChild() {
		return false;
	}
	public default void removeChild(EntityIdentifier<T> child) {
		throw new UnsupportedOperationException(this.toString() + " can't have children");
	}
	public void setParent(EntityIdentifier<T> parent);

	/**
	 * このエンティティの識別子を返します。
	 * @return {@link EntityIdentifier}
	 */
	public EntityIdentifier<T> getIdentifier();

	/**
	 * 識別子を用いて指定されたオブジェクトとこのエンティティが等しいかどうか比較します。
	 * 識別子以外の属性が一致していなくても同一だと判断されます。
	 *
	 * @param obj このエンティティと等しいかどうかが比較されるオブジェクト
	 * @return 識別子が一致する場合に{@code true}
	 * @see java.lang.Object#equals(Object)
	 */

	public boolean equals(Object obj);

	/**
	 * このエンティティのハッシュ・コード値を返します。
	 *
	 * <p>Object.equalsメソッドをオーバーライドするクラスは、Object.hashCodeメソッドの一般規約を満たすために
	 * Object.hashCodeメソッドもオーバーライドしなければならないことに注意してください。
	 * @return このエンティティのハッシュ・コード値
	 * @see java.lang.Object#hashCode()
	 * @see java.lang.Object#equals(Object)
	 */
	public int hashCode();
}

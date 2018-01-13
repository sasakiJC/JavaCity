package javacity.model;

/**
 * エンティティの識別子を表すためのインターフェースです。
 */
public interface EntityIdentifier {
	public String toKind();

	/**
	 * 保持している全ての属性の等価性を用いて指定されたオブジェクトとこのバリューオブジェクトが等しいかどうか比較します。
	 * @param obj このバリューオブジェクトと等しいかどうかが比較されるオブジェクト
	 * @return 全ての属性が等価である場合に{@code true}
	 * @see java.lang.Object#equals(Object)
	 */
	boolean equals(Object obj);

	/**
	 * このバリューオブジェクトのハッシュ・コード値を返します。
	 *
	 * <p>Object.equalsメソッドをオーバーライドするクラスは、Object.hashCodeメソッドの一般規約を満たすために
	 * Object.hashCodeメソッドもオーバーライドしなければならないことに注意してください。
	 * @return このバリューオブジェクトのハッシュ・コード値
	 * @see java.lang.Object#hashCode()
	 * @see java.lang.Object#equals(Object)
	 */
	int hashCode();
}

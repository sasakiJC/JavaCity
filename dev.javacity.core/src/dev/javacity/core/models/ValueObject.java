package dev.javacity.core.models;

/**
 * DDDにおけるValueObjectを表すためのインターフェースです。
 * このインターフェースを実装するオブジェクトは自身が保持している全ての属性の等価性で同一性を判断します。
 * また、このインターフェースを実装するオブジェクトは不変オブジェクトとして実装しなければいけません。
 */
public interface ValueObject {

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

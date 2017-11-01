package dev.javacity.core.models;

/**
 * このクラスは、EntityIdentifierインタフェースの整数識別子の実装です。
 * 整数値が識別子の本体です。
 */
public class DefaultEntityIdentifier implements EntityIdentifier {
	private int id;
	private String kind;

	/**
	 * 指定された整数値を使用して識別子を作成します。
	 * @param id この識別子の本体
	 * @throws IllegalArgumentException 引数に正の値以外を与えた場合
	 */
	public DefaultEntityIdentifier(int id, String kind) {
		if(id <= 0) {
			 throw new IllegalArgumentException("Identifier must be positive");
		}
        this.id = id;
        this.kind = kind;
    }

	public int toValue() {
		return this.id;
	}


	/**
	 * この識別子の文字列表現を返します。文字列表現は "id : この識別子の整数値" という形で表現されます。
	 * @return この識別子の文字列表現
	 */
	@Override
	public String toString() {
		return "id: " + this.id + ", className" + this.kind;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + id;
		return result;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultEntityIdentifier other = (DefaultEntityIdentifier) obj;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toKind() {
		return this.kind;
	}
}

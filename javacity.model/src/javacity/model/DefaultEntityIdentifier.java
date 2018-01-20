package javacity.model;

/**
 * このクラスは、EntityIdentifierインタフェースの整数識別子の実装です。
 * 整数値が識別子の本体です。
 */
public class DefaultEntityIdentifier implements EntityIdentifier {
	private int id;
	private SoftwareElementType type;

	/**
	 * 指定された整数値を使用して識別子を作成します。
	 * @param id この識別子の本体
	 * @throws IllegalArgumentException 引数に正の値以外を与えた場合
	 */
	public DefaultEntityIdentifier(int id, SoftwareElementType type) {
		if(id <= 0) {
			 throw new IllegalArgumentException("Identifier must be positive");
		}
        this.id = id;
        this.type = type;
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
		return "id: " + this.id + ", elementType" + this.type;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}

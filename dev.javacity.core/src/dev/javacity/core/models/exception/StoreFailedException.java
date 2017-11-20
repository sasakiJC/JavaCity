package dev.javacity.core.models.exception;

/**
 * エンティティが永続化されない場合にスローされる実行時例外です。
 *
 */
public class StoreFailedException extends RuntimeException {
	/**
	 * 詳細メッセージなしでStoreFailedExceptionを構築します。
	 */
	public StoreFailedException() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 * 詳細メッセージを持つStoreFailedExceptionを構築します。
	 * @param message 詳細メッセージ
	 */
	public StoreFailedException(String message) {
		super(message);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 * 指定された詳細メッセージ及び原因を使用してStoreFailedExceptionを構築します。
	 *
	 * <p><code>cause</code>と関連付けられた詳細メッセージが、この例外の詳細メッセージに自動的に統合されることは<i>ありません</i>。
	 * @param message 詳細メッセージ(あとで {@link Throwable#getMessage()}メソッドで取得できるように保存される)
	 * @param cause 原因(あとで{@link Throwable#getCause()}メソッドで取得できるように保存される)。(<tt>null</tt>値が許可されており、原因が存在しないか不明であることを示す。)
	 */
	public StoreFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 * 指定された原因と詳細メッセージ<tt>(cause==null ? null : cause.toString())</tt>を持つ新しい例外を構築します(通常、<tt>cause</tt>のクラスと詳細メッセージを含みます)。
	 * このコンストラクタは、例外がほかのスロー可能オブジェクト{@link java.security.PrivilegedActionException}など)のラッパーである場合に有用です。
	 * @param cause 原因(あとで{@link Throwable#getCause()}メソッドで取得できるように保存される)。(<tt>null</tt>値が許可されており、原因が存在しないか不明であることを示す。)
	 */
	public StoreFailedException(Throwable cause) {
		super(cause);
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
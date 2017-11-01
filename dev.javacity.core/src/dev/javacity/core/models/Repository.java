package dev.javacity.core.models;

import java.util.Collection;

import dev.javacity.core.models.exception.EntityNotFoundException;
import dev.javacity.core.models.exception.PersistentException;
import dev.javacity.core.models.exception.StoreFailedException;



/**
 * DDDにおけるRepositoryを表すためのインターフェースです。
 * このインターフェースのユーザーはエンティティの永続化と永続化されたエンティティを検索することができます。
 * @param <ID> EntityIdentifierの型
 * @param <T> Entityの型
 */
public interface Repository<T extends TargetEntity> {

	/**
	 * このリポジトリに格納されている全てのエンティティを返します。
	 * エンティティが見つからなかった場合は例外を返します。
	 * @return エンティティのコレクション
	 * @throws EntityNotFoundException エンティティが見つからなかった場合
	 * @throws PersistentException 永続化技術で何か問題があった場合
	 */
	public Collection<T> findAll();
	/**
	 * 指定された識別子に該当するエンティティを返します。
	 * エンティティが見つからなかった場合は例外を返します。
	 * @param identifier 検索に使用するキー
	 * @return 識別子に該当するエンティティ
	 * @throws EntityNotFoundException エンティティが見つからなかった場合
	 * @throws PersistentException 永続化技術で何か問題があった場合
	 */
	public T findById(EntityIdentifier identifier);
	/**
	 * 指定されたエンティティを永続化します。
	 * @param entity 永続化するエンティティ
	 * @throws StoreFailedException エンティティを永続化できなかった場合
	 * @throws PersistentException 永続化技術で何か問題があった場合
	 */
	public void store(T entity);

	public EntityIdentifier nextIndentifier();

	public Collection<EntityIdentifier> getAllIds();

}

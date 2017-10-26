package dev.javacity.core.models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DefaultRepository<ID extends EntityIdentifier, T extends TargetEntity> implements Repository<ID, T> {

	private List<T> entities;
	private int lastId;

	public DefaultRepository() {
		this.entities = new LinkedList<>();
		this.lastId = 0;
	}

	@Override
	public Collection<T> findAll() {
		return null;

	}

	@Override
	public T findById(ID identifier) {
		return null;

	}

	@Override
	public void store(T entity) {
		this.entities.add(entity);
	}

	@Override
	public EntityIdentifier nextIndentifier() {
		return new DefaultEntityIdentifier(++this.lastId);
	}

	@Override
	public List<EntityIdentifier> getAllTrackingIds() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}

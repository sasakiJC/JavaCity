package dev.javacity.core.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DefaultRepository<T extends TargetEntity> implements Repository<T> {

	private Map<EntityIdentifier, T> entities;
	private int lastId;

	public DefaultRepository() {
		this.entities = new HashMap<>();
		this.lastId = 0;
	}

	@Override
	public Collection<T> findAll() {
		return this.entities.values();

	}

	@Override
	public T findById(EntityIdentifier identifier) {
		return this.entities.get(identifier);
	}

	@Override
	public void store(T entity) {
		this.entities.put(entity.getIdentifier(), entity);
	}

	@Override
	public EntityIdentifier nextIndentifier() {
		return new DefaultEntityIdentifier(++this.lastId);
	}

	@Override
	public Collection<EntityIdentifier> getAllIds() {
		return this.entities.keySet();
	}

}

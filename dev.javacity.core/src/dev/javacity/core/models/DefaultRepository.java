package dev.javacity.core.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DefaultRepository<T extends TargetEntity> implements Repository<T> {

	private Map<EntityIdentifier, T> entities;
	private int lastId;
	private Class<T> clazz;

	public DefaultRepository(Class<T> clazz) {
		this.entities = new HashMap<>();
		this.lastId = 0;
		this.clazz = clazz;
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
	public Collection<EntityIdentifier> getAllIds() {
		return this.entities.keySet();
	}

	@Override
	public EntityIdentifier nextIndentifier() {
		return new DefaultEntityIdentifier(++this.lastId, this.clazz.getName());
	}

}

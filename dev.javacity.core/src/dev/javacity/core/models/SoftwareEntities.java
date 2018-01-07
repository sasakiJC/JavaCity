package dev.javacity.core.models;

import java.util.HashMap;
import java.util.Map;

public abstract class SoftwareEntities<T> {
	protected Map<EntityIdentifier, T> elements;
	protected int lastId;
	protected Class<T> clazz;
	protected SoftwareEntities(Class<T> clazz) {
		this.elements = new HashMap<>();
		this.clazz = clazz;
		this.lastId = 0;
	}

	public EntityIdentifier nextIdentifier() {
		return new DefaultEntityIdentifier(++lastId, this.clazz.getName());
	}
}

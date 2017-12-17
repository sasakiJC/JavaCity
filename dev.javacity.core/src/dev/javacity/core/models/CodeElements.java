package dev.javacity.core.models;

import java.util.HashMap;
import java.util.Map;

public abstract class CodeElements<T> {
	protected Map<EntityIdentifier, T> elements;
	protected int lastId;
	protected Class<T> clazz;
	protected CodeElements(Class<T> clazz) {
		this.elements = new HashMap<>();
		this.clazz = clazz;
	}

	public EntityIdentifier nextIdentifier() {
		return new DefaultEntityIdentifier(++lastId, this.clazz.getName());
	}
}

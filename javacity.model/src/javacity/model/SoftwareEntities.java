package javacity.model;

import java.util.HashMap;
import java.util.Map;

public abstract class SoftwareEntities<T extends TargetEntity> {
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

	public void add(T entity) {
		this.elements.put(entity.getIdentifier(), entity);
	}
}

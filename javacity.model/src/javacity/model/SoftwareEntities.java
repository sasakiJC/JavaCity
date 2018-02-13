package javacity.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SoftwareEntities {
	private Map<EntityIdentifier, SoftwareEntity> elements;
	private int lastId;
	private Class<?> entityClass;

	public SoftwareEntities(Class<?> entityClass) {
		this.elements = new HashMap<>();
		this.entityClass = entityClass;
		this.lastId = 0;
	}

	public EntityIdentifier nextIdentifier() {
		return new DefaultEntityIdentifier(++lastId, this.entityClass);
	}

	public void add(SoftwareEntity entity) {
		this.elements.put(entity.getIdentifier(), entity);
	}

	public SoftwareEntity get(EntityIdentifier identifier) {
		return this.elements.get(identifier);
	}

	public Collection<SoftwareEntity> getElements() {
		return this.elements.values();
	}

	public List<SoftwareEntity> getRootEntities() {
		return this.elements.values().stream().filter(entity->!entity.hasParent()).collect(Collectors.toList());
	}
}

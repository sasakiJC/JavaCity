package javacity.model;

import java.util.HashMap;
import java.util.Map;

public class SoftwareEntities {
	private Map<EntityIdentifier, SoftwareEntity> elements;
	private int lastId;
	private SoftwareElementType type;

	public SoftwareEntities(SoftwareElementType type) {
		this.elements = new HashMap<>();
		this.type = type;
		this.lastId = 0;
	}

	public EntityIdentifier nextIdentifier() {
		return new DefaultEntityIdentifier(++lastId, this.type);
	}

	public void add(SoftwareEntity entity) {
		this.elements.put(entity.getIdentifier(), entity);
	}
}

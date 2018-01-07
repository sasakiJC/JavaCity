package dev.javacity.core.models;

import java.util.Map;

public class Fields extends SoftwareEntities<TField>{
	private Map<EntityIdentifier, TField> fields;

	public Fields() {
		super(TField.class);
	}

	public TField newField() {
		return null;
	}
}

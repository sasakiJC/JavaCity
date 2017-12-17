package dev.javacity.core.models;

import java.util.Map;

public class Fields extends CodeElements<TargetField>{
	private Map<EntityIdentifier, TargetField> fields;

	public Fields() {
		super(TargetField.class);
	}

	public TargetField newField() {
		return null;
	}
}

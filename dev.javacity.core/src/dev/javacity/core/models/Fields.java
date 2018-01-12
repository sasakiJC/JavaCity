package dev.javacity.core.models;

import java.util.Map;

import javacity.model.EntityIdentifier;
import javacity.model.SoftwareEntities;
import javacity.model.TField;

public class Fields extends SoftwareEntities<TField>{
	private Map<EntityIdentifier, TField> fields;

	public Fields() {
		super(TField.class);
	}

	public TField newField() {
		return null;
	}
}

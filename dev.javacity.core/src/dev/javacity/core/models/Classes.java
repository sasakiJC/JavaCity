package dev.javacity.core.models;

import javacity.model.SoftwareEntities;
import javacity.model.TClass;

public class Classes extends SoftwareEntities<TClass>{
//	private Map<EntityIdentifier, TargetClass> classes;

	public Classes() {
		super(TClass.class);
	}

	public TClass newClass() {
		return null;
	}

}

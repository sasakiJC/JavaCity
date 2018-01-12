package dev.javacity.core.models;

import javacity.model.SoftwareEntities;
import javacity.model.TMethod;

public class Methods extends SoftwareEntities<TMethod>{
//	private Map<EntityIdentifier, TargetMethod> methods;

	public Methods() {
		super(TMethod.class);
	}

	public TMethod newMethod() {
		return null;
	}
}

package dev.javacity.core.models;

public class TargetClass extends AbstractCodeElement {

	public enum ClassType {
		INTERFACE, ABSTRACT, CONCRETE, ENUM
	}

	private ClassType type;
	public TargetClass(EntityIdentifier identifier, String name, ClassType type) {
		super(identifier, name);
		this.type = type;
	}
}

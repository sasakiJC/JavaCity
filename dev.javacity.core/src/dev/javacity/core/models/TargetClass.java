package dev.javacity.core.models;

public class TargetClass extends AbstractCodeElement {

	public enum ClassType {
		INTERFACE, ABSTRACT, CONCRETE, ENUM
	}

	private String name;
	private ClassType type;
	public TargetClass(String name, ClassType type) {
		super(name);
		this.type = type;
	}
}

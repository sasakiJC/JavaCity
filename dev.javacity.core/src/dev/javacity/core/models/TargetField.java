package dev.javacity.core.models;

public class TargetField extends AbstractCodeElement {

	private String className;
	protected TargetField(EntityIdentifier identifier, String name) {
		this(identifier, name, "");
	}

	public TargetField(EntityIdentifier identifier, String name, String className) {
		super(identifier, name);
		this.className = className;
	}

}

package dev.javacity.core.models;

public class TargetField extends AbstractCodeElement<TargetField> {

	private String className;
	public TargetField(EntityIdentifier<TargetField> identifier, String name) {
		this(identifier, name, "");
	}

	public TargetField(EntityIdentifier<TargetField> identifier, String name, String className) {
		super(identifier, name);
		this.className = className;
	}

}

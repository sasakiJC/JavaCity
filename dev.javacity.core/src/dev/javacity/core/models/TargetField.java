package dev.javacity.core.models;

public class TargetField extends AbstractCodeElement {

	private String className;
	protected TargetField(String name) {
		this(name, "");
	}

	public TargetField(String name, String className) {
		super(name);
		this.className = className;
	}

}

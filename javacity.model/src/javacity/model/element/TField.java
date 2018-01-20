package javacity.model.element;

import javacity.model.EntityIdentifier;

public class TField extends AbstractTEntity {

	private String className;
	public TField(EntityIdentifier identifier, String name) {
		this(identifier, name, "");
	}

	public TField(EntityIdentifier identifier, String name, String className) {
		super(identifier, name);
		this.className = className;
	}

}

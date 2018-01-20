package javacity.model.elementType;

import javacity.model.SoftwareElementType;

public abstract class AbstractSoftwareElement implements SoftwareElementType {

	private String name;

	protected AbstractSoftwareElement() {
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}


}

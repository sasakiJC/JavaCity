package javacity.model.element;

import javacity.model.CodeMetrics;
import javacity.model.EntityIdentifier;

public class TClass extends AbstractTEntity {

	public enum ClassType {
		INTERFACE, ABSTRACT, CONCRETE, ENUM
	}

	public TClass(EntityIdentifier identifier, String name, CodeMetrics metrics) {
		super(identifier, name, metrics);
	}


}

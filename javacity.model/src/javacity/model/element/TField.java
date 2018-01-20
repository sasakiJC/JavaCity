package javacity.model.element;

import javacity.model.CodeMetrics;
import javacity.model.EntityIdentifier;

public class TField extends AbstractTEntity {

	private String className;
	public TField(EntityIdentifier identifier, String name, CodeMetrics metrics) {
		super(identifier, name, metrics);
	}

}

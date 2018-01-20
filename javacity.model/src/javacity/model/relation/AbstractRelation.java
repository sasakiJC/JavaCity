package javacity.model.relation;

import javacity.model.EntityIdentifier;
import javacity.model.TargetRelation;

public abstract class AbstractRelation implements TargetRelation {

	protected final EntityIdentifier depart;
	protected EntityIdentifier dest;

	protected AbstractRelation(EntityIdentifier depart) {
		if(depart == null)
			throw new IllegalArgumentException("departuer can't be null");
		this.depart = depart;
	}


}

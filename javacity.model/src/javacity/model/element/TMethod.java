package javacity.model.element;

import java.util.List;

import javacity.model.CodeMetrics;
import javacity.model.EntityIdentifier;

public class TMethod extends AbstractTEntity {

//	private String signature;
	private boolean isConstructor;
//	private Block body;
//	private Type returnType;
	private List<?> typeParameters;
	private List<?> parameters;

	public TMethod(EntityIdentifier identifier, String name, CodeMetrics metrics) {
		super(identifier, name, metrics);
//		this.isConstructor = isConstructor;
	}

	public void setTypeParameters(List<?> typeParameters) {
		this.typeParameters = typeParameters;
	}

	public void setParameters(List<?> parameters) {
		this.parameters = parameters;
	}



//	public void setSignature(String signature) {
//
//	}

}

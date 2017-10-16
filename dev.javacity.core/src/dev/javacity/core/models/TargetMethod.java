package dev.javacity.core.models;

import java.util.List;

import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Type;

public class TargetMethod extends AbstractCodeElement {

//	private String signature;
	private boolean isConstructor;
	private Block body;
	private Type returnType;
	private List<?> typeParameters;
	private List<?> parameters;

	public TargetMethod(String name) {
		super(name);
	}

	public TargetMethod(String name, boolean isConstructor) {
		super(name);
		this.isConstructor = isConstructor;
	}

	public void setBody(Block body) {
		this.body = body;
	}

	public void setReturnType(Type returnType) {
		this.returnType = returnType;

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

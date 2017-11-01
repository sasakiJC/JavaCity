package dev.javacity.core.models;

public class TargetClass extends AbstractCodeElement {

	public enum ClassType {
		INTERFACE, ABSTRACT, CONCRETE, ENUM
	}

	private ClassType type;
	private int loc;
	private int nom;
	private int noa;

//	public TargetClass(EntityIdentifier identifier, String name, ClassType type) {
//		super(identifier, name);
//		this.type = type;
//	}

	public TargetClass(EntityIdentifier identifier, String name, ClassType type, int loc, int nom, int noa) {
		super(identifier, name);
		this.type = type;
		this.loc = loc;
		this.nom = nom;
		this.noa = noa;
	}

	public int getLOC() {
		return this.loc;
	}

	public int getNOM() {
		return this.nom;
	}

	public int getNOA() {
		return this.noa;
	}


}

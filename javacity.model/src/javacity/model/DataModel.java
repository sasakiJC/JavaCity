package javacity.model;

import java.util.Observable;

import dev.javacity.core.models.Classes;
import dev.javacity.core.models.Fields;
import dev.javacity.core.models.Methods;
import dev.javacity.core.models.Packages;

public class DataModel extends Observable {

	private Packages packages;
	private Classes classes;
	private Methods methods;
	private Fields fields;

	public DataModel() {
		this.packages = new Packages();
		this.classes = new Classes();
		this.methods = new Methods();
		this.fields = new Fields();
	}

	public void addPackages() {

	}

	public void addPackage() {

	}

	public TPackage newPackage(String packName) {
		TPackage pack = new TPackage(
				this.packages.nextIdentifier(),
				packName);

		this.packages.add(pack);
		return pack;
	}


	public TClass newClass(String className, ClassType type, int loc, int nom, int noa) {
		TClass clazz =
				new TClass(
						this.classes.nextIdentifier(),
						className,
						type,
						loc,
						nom,
						noa);

		this.classes.add(clazz);
		return clazz;
	}

	public TField newField(String fieldName, String className) {
		TField field = new TField(
				this.fields.nextIdentifier(),
				fieldName);

		this.fields.add(field);
		return field;
	}

	public TMethod newMethod(String methodName, boolean isConstructor) {
		TMethod method = new TMethod(
				this.methods.nextIdentifier(),
				methodName,
				isConstructor);

		this.methods.add(method);
		return method;
	}

//	public void solvePackageRelation() {
//		for(TPackage child : this.packages.findAll()) {
//			for(TPackage parent : this.packages.findAll()) {
//				if(child.isParentPackage(parent.getName())) {
//					child.setParent(parent);
//					parent.addChild(child);
//				}
//			}
//		}
//	}
//
//	public void addEntities(List<TPackage> entities) {
//		this.entities.addAll(entities);
//	}
//
//	public void addEntity(TargetEntity Entity, TargetEntity ParentEntity) {
//
//	}


}

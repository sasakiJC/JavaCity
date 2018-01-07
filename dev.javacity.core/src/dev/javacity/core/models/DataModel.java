package dev.javacity.core.models;

import java.util.List;
import java.util.Observable;

import dev.javacity.core.models.TClass.ClassType;

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



		this.packageRepository.store(pack);
		return pack;
	}


	public TClass newClass(String className, ClassType type, int loc, int nom, int noa) {

		TClass clazz =
				new TClass(
						this.classRepository.nextIndentifier(),
						className,
						type,
						loc,
						nom,
						noa);

		this.classRepository.store(clazz);
		return clazz;
	}

	public TField newField(String fieldName, String className) {
		TField field = new TField(
				this.fieldRepository.nextIndentifier(),
				fieldName);

		this.fieldRepository.store(field);
		return field;
	}

	public TMethod newMethod(String methodName, boolean isConstructor) {
		TMethod method = new TMethod(
				this.methodRepository.nextIndentifier(),
				methodName,
				isConstructor);

		this.methodRepository.store(method);
		return method;
	}


	public void solvePackageRelation() {
		for(TPackage child : this.packageRepository.findAll()) {
			for(TPackage parent : this.packageRepository.findAll()) {
				if(child.isParentPackage(parent.getName())) {
					child.setParent(parent);
					parent.addChild(child);
				}
			}
		}
	}

	public void addEntities(List<TPackage> entities) {
		this.entities.addAll(entities);
	}

	public void addEntity(TargetEntity Entity, TargetEntity ParentEntity) {

	}


}

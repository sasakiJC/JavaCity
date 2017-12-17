package dev.javacity.core.models;

import java.util.List;
import java.util.Observable;

import dev.javacity.core.models.TargetClass.ClassType;

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

	public TargetPackage newPackage(String packName) {
		TargetPackage pack = new TargetPackage(
				this.packages.nextIdentifier(),
				packName);



		this.packageRepository.store(pack);
		return pack;
	}


	public TargetClass newClass(String className, ClassType type, int loc, int nom, int noa) {

		TargetClass clazz =
				new TargetClass(
						this.classRepository.nextIndentifier(),
						className,
						type,
						loc,
						nom,
						noa);

		this.classRepository.store(clazz);
		return clazz;
	}

	public TargetField newField(String fieldName, String className) {
		TargetField field = new TargetField(
				this.fieldRepository.nextIndentifier(),
				fieldName);

		this.fieldRepository.store(field);
		return field;
	}

	public TargetMethod newMethod(String methodName, boolean isConstructor) {
		TargetMethod method = new TargetMethod(
				this.methodRepository.nextIndentifier(),
				methodName,
				isConstructor);

		this.methodRepository.store(method);
		return method;
	}


	public void solvePackageRelation() {
		for(TargetPackage child : this.packageRepository.findAll()) {
			for(TargetPackage parent : this.packageRepository.findAll()) {
				if(child.isParentPackage(parent.getName())) {
					child.setParent(parent);
					parent.addChild(child);
				}
			}
		}
	}

	public void addEntities(List<TargetPackage> entities) {
		this.entities.addAll(entities);
	}

	public void addEntity(TargetEntity Entity, TargetEntity ParentEntity) {

	}


}

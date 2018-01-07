package dev.javacity.core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import dev.javacity.core.models.DefaultRepository;
import dev.javacity.core.models.EntityIdentifier;
import dev.javacity.core.models.Repository;
import dev.javacity.core.models.TClass;
import dev.javacity.core.models.TClass.ClassType;
import dev.javacity.core.models.TargetEntity;
import dev.javacity.core.models.TField;
import dev.javacity.core.models.TMethod;
import dev.javacity.core.models.TPackage;
import dev.javacity.core.visual.ViewMapper;
import dev.javacity.core.visual.VisualizedComponent;

public class CodeElementApplicationService {

	private Repository<TPackage> packageRepository;
	private Repository<TClass> classRepository;
	private Repository<TField> fieldRepository;
	private Repository<TMethod> methodRepository;

	private ViewMapper mapper;

//	public CodeElementApplicationService(Repository<EntityIdentifier, TargetPackage> packageRepository,
//										  Repository<EntityIdentifier, TargetClass> classRepository,
//										  Repository<EntityIdentifier, TargetField> fieldRepository,
//										  Repository<EntityIdentifier, TargetMethod> methodRepository) {
//		this.packageRepository = packageRepository;
//        this.classRepository = classRepository;
//        this.fieldRepository = fieldRepository;
//        this.methodRepository = methodRepository;
//	}

	public CodeElementApplicationService() {
		this.packageRepository = new DefaultRepository<TPackage>(TPackage.class);
		this.classRepository = new DefaultRepository<TClass>(TClass.class);
		this.fieldRepository = new DefaultRepository<TField>(TField.class);
		this.methodRepository = new DefaultRepository<TMethod>(TMethod.class);
	}

	public TPackage newPackage(String packName) {
		TPackage pack = new TPackage(
				this.packageRepository.nextIndentifier(),
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

	public Collection<TPackage> packages() {
		return this.packageRepository.findAll();
	}

	public Collection<TClass> classes() {
		return this.classRepository.findAll();
	}

	public Collection<TField> fields() {
		return this.fieldRepository.findAll();
	}

	public Collection<TMethod> methods() {
		return this.methodRepository.findAll();
	}


	public TargetEntity findById(EntityIdentifier identifier) {
		if(identifier.toKind().equals(TPackage.class.getName()))
			return this.packageRepository.findById(identifier);
		else if(identifier.toKind().equals(TClass.class.getName()))
			return this.classRepository.findById(identifier);
		else if(identifier.toKind().equals(TField.class.getName()))
			return this.fieldRepository.findById(identifier);
		else if(identifier.toKind().equals(TMethod.class.getName()))
			return this.methodRepository.findById(identifier);
		else
			return null;
	}

	public Collection<VisualizedComponent> visualizePackages() {
		List<VisualizedComponent> list = new LinkedList<>();
		for(TPackage pack : this.packageRepository.findAll()) {
			list.add(this.mapper.mapPackage(pack));
		}
		return list;
	}
//
//	public Collection<TargetClass> classes() {
//		return this.classRepository.findAll();
//	}
//
//	public Collection<TargetField> fields() {
//		return this.fieldRepository.findAll();
//	}
//
//	public Collection<TargetMethod> methods() {
//		return this.methodRepository.findAll();
//	}



}

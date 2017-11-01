package dev.javacity.core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import dev.javacity.core.models.DefaultRepository;
import dev.javacity.core.models.EntityIdentifier;
import dev.javacity.core.models.Repository;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetClass.ClassType;
import dev.javacity.core.models.TargetEntity;
import dev.javacity.core.models.TargetField;
import dev.javacity.core.models.TargetMethod;
import dev.javacity.core.models.TargetPackage;
import dev.javacity.core.visual.ViewMapper;
import dev.javacity.core.visual.VisualizedComponent;

public class CodeElementApplicationService {

	private Repository<TargetPackage> packageRepository;
	private Repository<TargetClass> classRepository;
	private Repository<TargetField> fieldRepository;
	private Repository<TargetMethod> methodRepository;

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
		this.packageRepository = new DefaultRepository<TargetPackage>(TargetPackage.class);
		this.classRepository = new DefaultRepository<TargetClass>(TargetClass.class);
		this.fieldRepository = new DefaultRepository<TargetField>(TargetField.class);
		this.methodRepository = new DefaultRepository<TargetMethod>(TargetMethod.class);
	}

	public TargetPackage newPackage(String packName) {
		TargetPackage pack = new TargetPackage(
				this.packageRepository.nextIndentifier(),
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

	public Collection<TargetPackage> packages() {
		return this.packageRepository.findAll();
	}

	public Collection<TargetClass> classes() {
		return this.classRepository.findAll();
	}

	public Collection<TargetField> fields() {
		return this.fieldRepository.findAll();
	}

	public Collection<TargetMethod> methods() {
		return this.methodRepository.findAll();
	}


	public TargetEntity findById(EntityIdentifier identifier) {
		if(identifier.toKind().equals(TargetPackage.class.getName()))
			return this.packageRepository.findById(identifier);
		else if(identifier.toKind().equals(TargetClass.class.getName()))
			return this.classRepository.findById(identifier);
		else if(identifier.toKind().equals(TargetField.class.getName()))
			return this.fieldRepository.findById(identifier);
		else if(identifier.toKind().equals(TargetMethod.class.getName()))
			return this.methodRepository.findById(identifier);
		else
			return null;
	}

	public Collection<VisualizedComponent> visualizePackages() {
		List<VisualizedComponent> list = new LinkedList<>();
		for(TargetPackage pack : this.packageRepository.findAll()) {
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

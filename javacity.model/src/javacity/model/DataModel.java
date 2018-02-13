package javacity.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataModel implements SoftwareEntity {

//	private Map<SoftwareElementType, SoftwareEntities> entities;
	private Map<Class<?>, SoftwareEntities> entities;
	private Class<?>[] paramTypes = {EntityIdentifier.class, String.class, CodeMetrics.class};
	private List<SoftwareEntity> rootEntities;

	public DataModel() {
		this.entities = new HashMap<>();
		for(Class<?> clazz : Activator.getExtensionLoader().getElementExtensionClasses().keySet()) {
			this.entities.put(clazz, new SoftwareEntities(clazz));
		}
	}

	public SoftwareEntity newEntity(String name, Class<?> entityClass, CodeMetrics metrics) {
		SoftwareEntities softwareEntities = this.entities.get(entityClass);
		SoftwareEntity entity=null;
		try {
			entity = (SoftwareEntity) entityClass.getConstructor(this.paramTypes).newInstance(softwareEntities.nextIdentifier(), name, metrics);
		} catch (ReflectiveOperationException  e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		SoftwareEntity entity = new SoftwareEntity(name, softwareEntities.nextIdentifier(), type);
		softwareEntities.add(entity);
		return entity;
	}

//	public Map<Class<?>, SoftwareEntities> getEntities() {
//		return this.entities;
//	}

	public SoftwareEntities getEntities(Class<?> clazz) {
		return this.entities.get(clazz);
	}

	public List<SoftwareEntity> getRootEntities() {
		if(this.rootEntities != null) {
			return this.rootEntities;
		}
		this.rootEntities = new LinkedList<>();
		this.entities.values().forEach(entities->this.rootEntities.addAll(entities.getRootEntities()));

		return this.rootEntities;
	}

	@Override
	public void setParent(SoftwareEntity parent) {

	}

	@Override
	public SoftwareEntity getParent() {
		return null;
	}

	@Override
	public boolean hasParent() {
		return false;
	}

	@Override
	public EntityIdentifier getIdentifier() {
		return null;
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

package javacity.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class DataModel extends Observable {

//	private Map<SoftwareElementType, SoftwareEntities> entities;
	private Map<Class<?>, SoftwareEntities> entities;
	private Class<?>[] paramTypes = {EntityIdentifier.class, String.class, CodeMetrics.class};

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

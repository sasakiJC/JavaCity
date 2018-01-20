package javacity.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class DataModel extends Observable {

	private Map<SoftwareElementType, SoftwareEntities> entities;

	public DataModel() {
		this.entities = new HashMap<>();
		for(SoftwareElementType element : Activator.getExtensionLoader().getElementTypeExtensions().values()) {
			this.entities.put(element, new SoftwareEntities(element));
		}
	}

	public SoftwareEntity newEntity(String name, SoftwareElementType type, CodeMetrics metrics) {
		SoftwareEntities softwareEntities = this.entities.get(type);
		SoftwareEntity entity = new SoftwareEntity(name, softwareEntities.nextIdentifier(), type);
		softwareEntities.add(entity);
		return entity;
	}

	public SoftwareEntities getEntities(SoftwareElementType type) {
		return this.entities.get(type);
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

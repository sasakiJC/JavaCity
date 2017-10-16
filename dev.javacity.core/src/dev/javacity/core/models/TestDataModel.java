package dev.javacity.core.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class TestDataModel extends Observable {

	private List<TargetEntity> entities;

	public TestDataModel() {
		this.entities = new LinkedList<TargetEntity>();
	}

	public void addEntities(List<TargetPackage> entities) {
		this.entities.addAll(entities);
	}

	public void addEntity(TargetEntity Entity, TargetEntity ParentEntity) {

	}


}

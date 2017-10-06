package dev.javacity.core.models;

import java.util.List;

public interface TargetEntity {
	public void addChild(TargetEntity child);
	public List<TargetEntity> getChildren();
	public void removeChild(TargetEntity child);
	public void setParent(TargetEntity parent);
}

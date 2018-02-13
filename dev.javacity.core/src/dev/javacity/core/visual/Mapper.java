package dev.javacity.core.visual;

import javacity.model.SoftwareEntity;

public interface Mapper {
	public Object toAttribute(SoftwareEntity entity);

	public void setName(String name);
	public String getName();
}

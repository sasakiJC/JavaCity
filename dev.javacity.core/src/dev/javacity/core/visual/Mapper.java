package dev.javacity.core.visual;

import javacity.model.SoftwareEntity;

public interface Mapper {
	public MappedValue toAttribute(SoftwareEntity entity);

	public void setName(String name);
	public String getName();
}

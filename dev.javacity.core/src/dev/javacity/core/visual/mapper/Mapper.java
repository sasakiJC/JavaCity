package dev.javacity.core.visual.mapper;

import javacity.model.TargetEntity;

public interface Mapper<T> {
	public T toAttribute(TargetEntity entity);
}

package dev.javacity.core.visual.mapper;

import dev.javacity.core.models.TargetEntity;

public interface Mapper<T> {
	public T toAttribute(TargetEntity entity);
}

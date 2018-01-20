package dev.javacity.core.visual;

import javacity.model.SoftwareEntity;

public class ModelToViewConverter {

	private Class<?> glyphClazz;
	private Object metricsMappers;
	private InnerLayout layout;

	public ModelToViewConverter(Class<?> glyphClazz, Object metricsMappers, InnerLayout layout) {
		this.glyphClazz = glyphClazz;
		this.metricsMappers = metricsMappers;
		this.layout = layout;
	}

	public Object convert(SoftwareEntity entity) {
		return null;
	}
}

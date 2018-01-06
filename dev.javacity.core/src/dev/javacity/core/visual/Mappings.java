package dev.javacity.core.visual;

import java.util.Map;

import dev.javacity.core.models.TargetEntity;
import dev.javacity.core.visual.mapper.Mapper;

public class Mappings {

	private Map<String, Mapper<?>> map;
	private boolean isVisible;
	private VisLayout innerLayout;

	public Mappings(Map<String, Mapper<?>> map, boolean isVisible, VisLayout innerLayout) {
		this.map = map;
		this.isVisible = isVisible;
		this.innerLayout = innerLayout;
	}

	public Object mapToAttribute(String key, TargetEntity entity) {
		return this.map.get(key).toAttribute(entity);
	}

	public boolean visible() {
		return this.isVisible;
	}

	public VisLayout innerLayout() {
		return this.innerLayout;
	}

}

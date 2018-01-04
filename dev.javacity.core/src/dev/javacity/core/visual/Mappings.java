package dev.javacity.core.visual;

import java.util.Map;

import dev.javacity.core.visual.mapper.Mapper;

public class Mappings {

	private Map<String, Mapper<?>> map;
	private boolean isVisible;
	private VisLayout layout;

	public Mappings(Map<String, Mapper<?>> map, boolean isVisible, VisLayout layout) {
		this.map = map;
		this.isVisible = isVisible;
		this.layout = layout;
	}

	public Mapper<?> getMapper(String key) {
		return this.map.get(key);
	}


}

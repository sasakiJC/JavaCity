package dev.javacity.core.visual;

import java.util.Map;

import dev.javacity.core.visual.mapper.Mapper;

public class Mappings {

	private Map<String, Mapper> map;
	private boolean isVisible;
//	private Layout layout;

	public Mappings(Map<String, Mapper> map) {
		this.map = map;
	}
}

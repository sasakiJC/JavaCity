package dev.javacity.core.visual.mapper;

import dev.javacity.core.visual.Mapper;

public abstract class AbstractMapper implements Mapper {

	protected String name;
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}

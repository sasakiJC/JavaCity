package dev.javacity.core.visual.layout;

import dev.javacity.core.visual.InnerLayout;

public class AbstractLayout implements InnerLayout {

	private String name;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}

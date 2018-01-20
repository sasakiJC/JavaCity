package dev.javacity.core;

public class BuildingGlyph implements Glyph {
	private GlyphAttribute[] attributes;
	private String name;

	public BuildingGlyph() {

	}

	@Override
	public String[] getAttributes() {
		return new String[]{"color", "alpha", "width", "depth", "height"};
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}

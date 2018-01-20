package dev.javacity.core;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.shape.Box;

public class DistrictGlyph implements Glyph {

	private Map<String, GlyphAttribute> attributes;
	private String name;

	public DistrictGlyph() {
		this.attributes = new HashMap<>();
	}

	public void setGlyphAttributes(String attrName, GlyphAttribute glyphAttr) {

	}

	@Override
	public String[] getAttributes() {
		return new String[]{"color", "alpha", "width", "depth", "terrainThickness"};
	}

	public Group fxView() {
		Box box = new Box();

		return null;
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

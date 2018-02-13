package dev.javacity.core;

import java.util.HashMap;
import java.util.Map;

import dev.javacity.core.visual.InnerLayout;
import dev.javacity.core.visual.Mapper;
import dev.javacity.core.visual.VisualizedComposite;
import javacity.model.SoftwareEntity;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
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

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public VisualizedComposite createViewNode(SoftwareEntity entity, Map<String, Mapper> mapper, InnerLayout layout) {
		double x = (double) mapper.get("width").toAttribute(entity);
		double y = (double) mapper.get("terrainThickness").toAttribute(entity);
		double z = (double) mapper.get("depth").toAttribute(entity);
		Color color = (Color) mapper.get("color").toAttribute(entity);
		Box district = new Box(x,y,z);

		PhongMaterial material = new PhongMaterial();
		material.setDiffuseColor(color);
		district.setMaterial(material);
		return new VisualizedComposite(entity, layout, district);
	}
}

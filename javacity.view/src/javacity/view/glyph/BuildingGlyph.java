package javacity.view.glyph;

import java.util.Map;

import javacity.model.SoftwareEntity;
import javacity.view.Glyph;
import javacity.view.GlyphAttribute;
import javacity.view.InnerLayout;
import javacity.view.Mapper;
import javacity.view.VisualizedComposite;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

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

	@Override
	public VisualizedComposite createViewNode(SoftwareEntity entity, Map<String, Mapper> mapper, InnerLayout layout) {
		double x = (double) mapper.get("width").toAttribute(entity);
		double y = (double) mapper.get("height").toAttribute(entity);
		double z = (double) mapper.get("depth").toAttribute(entity);
		Color color = (Color) mapper.get("color").toAttribute(entity);
		Box building = new Box(x,y,z);

		PhongMaterial material = new PhongMaterial();
		material.setDiffuseColor(color);
		building.setMaterial(material);
		return new VisualizedComposite(entity, layout, building);
	}
}

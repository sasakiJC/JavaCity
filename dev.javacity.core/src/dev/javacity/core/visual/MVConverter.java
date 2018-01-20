package dev.javacity.core.visual;

import javacity.model.SoftwareEntity;

public class MVConverter {

	private String glyphName;
	private Mappings mappings;

	public MVConverter(String glyphName, Mappings mappings) {
		this.glyphName = glyphName;
		this.mappings = mappings;
	}

	public VisualizedComponent createVisualizedComponent(SoftwareEntity entity) {
		switch(this.glyphName) {
			case "cuboid":
				return new Building(entity, this.mappings);
			case "terrain":
				return new District(entity, this.mappings);
			default:
				return new District(entity, this.mappings);
		}
	}
}

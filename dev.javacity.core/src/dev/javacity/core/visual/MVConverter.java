package dev.javacity.core.visual;

import java.util.Map;

import dev.javacity.core.Glyph;
import javacity.model.SoftwareEntity;

public class MVConverter {

	private Glyph glyph;
	private Map<String, Mapper> mapper;
	private InnerLayout layout;

	public MVConverter(Glyph glyph, Map<String, Mapper> mapper, InnerLayout layout) {
		this.glyph = glyph;
		this.mapper = mapper;
		this.layout = layout;
	}

	public VisualizedComponent createVisualizedComponent(SoftwareEntity entity) {

		return null;
	}
}

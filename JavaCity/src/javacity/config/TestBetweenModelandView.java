package javacity.config;

import dev.javacity.core.Activator;

public class TestBetweenModelandView {

	Object elementTypeEntity;
	Object elementTypeRelation;

	public Object[] getGlyph(Object elementTypeRelation) {
//		line, arch

		return Activator.getMetaphorExtensionLoader().getEntityGlyph();
	}

	public Object[] getGlyph(Object[] elementTypeEntity) {
//		building, district

		return Activator.getMetaphorExtensionLoader().getEntityGlyph();
	}
}

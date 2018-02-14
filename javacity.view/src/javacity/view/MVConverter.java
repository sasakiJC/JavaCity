package javacity.view;

import java.util.Map;

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

	public VisualizedComposite createVisualizedComponent(SoftwareEntity entity) {
		return this.glyph.createViewNode(entity, this.mapper, this.layout);
	}
}

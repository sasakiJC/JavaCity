package dev.javacity.core;

import java.util.Map;

import dev.javacity.core.visual.InnerLayout;
import dev.javacity.core.visual.Mapper;
import dev.javacity.core.visual.VisualizedComposite;
import javacity.model.SoftwareEntity;

public interface Glyph {
	public String[] getAttributes();
	public String getName();
	public void setName(String name);
	public VisualizedComposite createViewNode(SoftwareEntity entity, Map<String, Mapper> mapper, InnerLayout layout);
}

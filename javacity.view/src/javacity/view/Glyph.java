package javacity.view;

import java.util.Map;

import javacity.model.SoftwareEntity;

public interface Glyph {
	public String[] getAttributes();
	public String getName();
	public void setName(String name);
	public VisualizedComposite createViewNode(SoftwareEntity entity, Map<String, Mapper> mapper, InnerLayout layout);
}

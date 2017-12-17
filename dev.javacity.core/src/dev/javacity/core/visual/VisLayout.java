package dev.javacity.core.visual;

public interface VisLayout {

	public ViewBounds computeSize(VisualizedComponent component);
	public void layout(VisualizedComponent component);
}

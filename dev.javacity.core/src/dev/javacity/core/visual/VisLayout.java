package dev.javacity.core.visual;

public interface VisLayout {

	public ViewBounds computeSize(VisualizedComposite component);
	public void layout(VisualizedComposite component);
}

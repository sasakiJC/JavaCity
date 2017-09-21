package dev.javacity.core.visual;

import dev.javacity.core.models.TargetEntity;

public interface VisualizedComponent {

	public void draw();
	public boolean isVisible();
	public void isSelected();
	public TargetEntity getEntity();

}

package dev.javacity.core.visual;

public interface InnerLayout {

	public void setName(String attribute);
	public String getName();

	public void setHorizontalMargin(float horizontalMargin);
	public void setHorizontalGap(float horizontalGap);
	public void setVerticalMargin(float verticalMargin);
	public void setVerticalGap(float verticalGap);
	public void layout(VisualizedComposite comp);


}

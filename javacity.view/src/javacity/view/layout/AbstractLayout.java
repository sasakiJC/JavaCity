package javacity.view.layout;

import javacity.view.InnerLayout;

public abstract class AbstractLayout implements InnerLayout {

	private String name;

	float horizontalMargin;
	float horizontalGap;
	float verticalMargin;
	float verticalGap;


	protected AbstractLayout(float horizontalMargin, float horizontalGap, float verticalMargin, float verticalGap) {
		this.horizontalMargin = horizontalMargin;
		this.horizontalGap = horizontalGap;
		this.verticalMargin = verticalMargin;
		this.verticalGap = verticalGap;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setHorizontalMargin(float horizontalMargin) {
		this.horizontalMargin = horizontalMargin;
	}

	@Override
	public void setHorizontalGap(float horizontalGap) {
		this.horizontalGap = horizontalGap;
	}

	@Override
	public void setVerticalMargin(float verticalMargin) {
		this.verticalMargin = verticalMargin;
	}

	@Override
	public void setVerticalGap(float verticalGap) {
		this.verticalGap = verticalGap;
	}



}

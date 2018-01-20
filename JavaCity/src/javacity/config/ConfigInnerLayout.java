package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;

import dev.javacity.core.visual.InnerLayout;
import dev.javacity.core.visual.layout.ChessboardLayout;

public class ConfigInnerLayout {
	@XmlAttribute
	Class<? extends InnerLayout> layoutId;
	@XmlAttribute
	float horizontalMargin;
	@XmlAttribute
	float horizontalGap;
	@XmlAttribute
	float verticalMargin;
	@XmlAttribute
	float verticalGap;

	public ConfigInnerLayout() {
		this.layoutId = ChessboardLayout.class;
		this.horizontalMargin = 0.5f;
		this.horizontalGap = 1;
		this.verticalMargin = 0.2f;
		this.verticalGap = 1;
	}

	public ConfigInnerLayout(Class<? extends InnerLayout> layoutId, float horizontalMargin, float horizontalGap, float verticalMargin, float verticalGap) {
		this.layoutId = layoutId;
		this.horizontalMargin = horizontalMargin;
		this.horizontalGap = horizontalGap;
		this.verticalMargin = verticalMargin;
		this.verticalGap = verticalGap;
	}

}

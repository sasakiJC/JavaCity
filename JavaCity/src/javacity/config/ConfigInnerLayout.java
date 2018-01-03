package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;

public class ConfigInnerLayout {
	@XmlAttribute
	String layoutId;
	@XmlAttribute
	float horizontalMargin;
	@XmlAttribute
	float horizontalGap;
	@XmlAttribute
	float verticalMargin;
	@XmlAttribute
	float verticalGap;

	public ConfigInnerLayout() {

	}

	public ConfigInnerLayout(String layoutId) {
		this.layoutId = layoutId;
	}

	public ConfigInnerLayout(String layoutId, float horizontalMargin, float horizontalGap, float verticalMargin, float verticalGap) {
		this.layoutId = layoutId;
		this.horizontalMargin = horizontalMargin;
		this.horizontalGap = horizontalGap;
		this.verticalMargin = verticalMargin;
		this.verticalGap = verticalGap;
	}

}

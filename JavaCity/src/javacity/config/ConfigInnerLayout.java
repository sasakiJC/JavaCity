package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;

public class ConfigInnerLayout {
	@XmlAttribute
	private String layoutId;
	@XmlAttribute
	private float horizontalMargin = 0.5f;
	@XmlAttribute
	private float horizontalGap = 1;
	@XmlAttribute
	private float verticalMargin = 0.2f;
	@XmlAttribute
	private float verticalGap = 1;

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

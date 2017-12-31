package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

class ConfigModelElement {
	@XmlAttribute
	private String name;
	@XmlAttribute
	private boolean isVisible;
	@XmlElement
	private ConfigGlyph configGlyph;
	@XmlElement
	private ConfigMapping[] configMappings;
	@XmlElement
	private ConfigInnerLayout configInnerLayout;

	ConfigModelElement(String name, boolean isVisible, ConfigGlyph configGlyph, ConfigMapping[] configMappings, ConfigInnerLayout configInnerLayout) {
		this.name = name;
		this.isVisible = isVisible;
		this.configGlyph = configGlyph;
		this.configMappings = configMappings;
		this.configInnerLayout = configInnerLayout;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}

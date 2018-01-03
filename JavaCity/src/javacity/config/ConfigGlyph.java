package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;

public class ConfigGlyph {
	@XmlAttribute
	String name;
	@XmlAttribute
	String[] attributes;

	private ConfigGlyph() {

	}

	public ConfigGlyph(String name, String[] attributes) {
		this.name = name;
	}
}

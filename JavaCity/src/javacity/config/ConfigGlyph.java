package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;

public class ConfigGlyph {
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String[] attributes;

	public ConfigGlyph(String name, String[] attributes) {
		this.name = name;
	}
}

package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class ConfigModelElement {
	@XmlAttribute
	String name;
	@XmlAttribute
	boolean isVisible;

	@XmlElementWrapper(name="array")
	@XmlElement(name="value")
	String[] glyphs;
	@XmlElement
	ConfigGlyph configGlyph;
	@XmlElement
	ConfigMapping[] configMappings;
	@XmlElement
	ConfigInnerLayout configInnerLayout;

	public final static String[] GLYPHS = new String[]{"terrain", "well", "cuboid", "rooftop"};
	public final static String[] ARCH_GLYPHS = new String[]{"line", "arch"};

	ConfigModelElement() {

	}

	ConfigModelElement(String name, boolean isVisible, String[] glyphs, ConfigGlyph configGlyph, ConfigMapping[] configMappings, ConfigInnerLayout configInnerLayout) {
		this.name = name;
		this.isVisible = isVisible;
		this.glyphs = glyphs;
		this.configGlyph = configGlyph;
		this.configMappings = configMappings;
		this.configInnerLayout = configInnerLayout;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getName() {
		return this.name;
	}

}

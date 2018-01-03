package javacity.config.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import javacity.config.ConfigModelElement;

class MapElements {
	@XmlAttribute
	public String key;
	@XmlElement
	public ConfigModelElement value;

	private MapElements() {
	} //Required by JAXB

	public MapElements(String key, ConfigModelElement value) {
		this.key = key;
		this.value = value;
	}
}

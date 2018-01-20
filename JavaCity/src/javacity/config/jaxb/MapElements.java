package javacity.config.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import javacity.config.ElementConfig;

class MapElements {
	@XmlAttribute
	public String key;
	@XmlElement
	public ElementConfig value;

	private MapElements() {
	} //Required by JAXB

	public MapElements(String key, ElementConfig value) {
		this.key = key;
		this.value = value;
	}
}

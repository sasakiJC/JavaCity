package javacity.config.jaxb;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javacity.config.ElementConfig;

public class ConfigDao {
	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement
	Map<String, ElementConfig> elements;
}

package javacity.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javacity.config.jaxb.MapAdapter;
import javacity.model.Activator;
import javacity.view.MVConverter;
import javacity.view.TestConverter;

public class CityConfig {
	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement
	Map<String, ElementConfig> elements;

	public CityConfig() {
		this.elements = new HashMap<String, ElementConfig>();
	}

	public ElementConfig getElm(String key) {
		return this.elements.get(key);
	}

	public String[] getElementNames() {
		return this.elements.keySet().toArray(new String[]{});
	}

	public void normalize() {
		Collection<String> extTemp = Activator.getExtensionLoader().getElementExtensionClassNames().values();

		List<String> diffExtConf = ConfigUtils.diff(extTemp, this.elements.keySet());
		List<String> diffConfExt = ConfigUtils.diff(this.elements.keySet(), extTemp);

		if(!diffExtConf.isEmpty()) {
			diffExtConf.forEach(item -> this.elements.put(item, this.createDefaultElm(item)));
		}
		if(!diffConfExt.isEmpty()) {
			diffConfExt.forEach(item -> this.elements.remove(item));
		}
		this.elements.forEach((key,value) -> value.normalize());
	}

	private ElementConfig createDefaultElm(String name) {
		if(name.equals("package") || name.equals("class"))
			return new ElementConfig(true);
		else
			return new ElementConfig();
	}

	public TestConverter converter() {
		Map<Class<?>, MVConverter> convertMap = new HashMap<>();
		for(Map.Entry<Class<?>, String> entry : Activator.getExtensionLoader().getElementExtensionClassNames().entrySet()) {
			MVConverter converter = this.elements.get(entry.getValue()).createConverter();
			if(converter == null) continue;
			convertMap.put(entry.getKey(), converter);
		}
		return new TestConverter(convertMap);
	}


//	public MVConverter toConverter(String key) {
//		TestConfigModel confMElm = this.elements.get(key);
//		String glyphName = confMElm.glyphName();
//		Mappings mappings = new Mappings(confMElm.toMappings(), confMElm.isVisible, confMElm.layout());
//		MVConverter converter = new MVConverter(glyphName, mappings);
//		return converter;
//	}
//
//	public ModelToViewConverter toMTVConv() {
//		for(Map.Entry<String, TestConfigModel> entry : this.elements.entrySet()) {
//			ModelToViewConverter conv = new ModelToViewConverter(entry.getValue().glyph);
//		}
//
//
//		return null;
//	}
}

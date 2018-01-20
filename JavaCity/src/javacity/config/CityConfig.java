package javacity.config;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javacity.config.jaxb.MapAdapter;
import javacity.model.Activator;

public class CityConfig {
	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement
	Map<String, ElementConfig> elements;

	public CityConfig() {}

	public ElementConfig getElm(String key) {
		return this.elements.get(key);
	}

	public String[] getElementNames() {
		return this.elements.keySet().toArray(new String[]{});
	}

	public void normalize() {
		List<String> extTemp = Activator.getExtensionLoader().getElementTypeExtensions().values().stream()
				.map(item->item.getName())
				.collect(Collectors.toList());

		List<String> diffExtConf = ConfigUtils.diff(extTemp, this.elements.keySet());
		List<String> diffConfExt = ConfigUtils.diff(this.elements.keySet(), extTemp);

		if(!diffExtConf.isEmpty()) {
			diffExtConf.forEach(item -> this.elements.put(item, this.createDefaultElm()));
		}
		if(!diffConfExt.isEmpty()) {
			diffConfExt.forEach(item -> this.elements.remove(item));
		}
		this.elements.forEach((key,value) -> value.normalize());
	}

	private ElementConfig createDefaultElm() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
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

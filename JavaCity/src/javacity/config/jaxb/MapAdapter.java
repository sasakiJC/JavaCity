package javacity.config.jaxb;

import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import javacity.config.ConfigModelElement;

public class MapAdapter extends XmlAdapter<MapElements[], Map<String, ConfigModelElement>> {
	public MapAdapter() {
	}

	public MapElements[] marshal(Map<String, ConfigModelElement> arg0) throws Exception {
		MapElements[] mapElements = new MapElements[arg0.size()];
		int i = 0;
		for (Map.Entry<String, ConfigModelElement> entry : arg0.entrySet())
			mapElements[i++] = new MapElements(entry.getKey(), entry.getValue());

		return mapElements;
	}

	public Map<String, ConfigModelElement> unmarshal(MapElements[] arg0) throws Exception {
		Map<String, ConfigModelElement> r = new TreeMap<String, ConfigModelElement>();
		for (MapElements mapelement : arg0)
			r.put(mapelement.key, mapelement.value);
		return r;
	}
}
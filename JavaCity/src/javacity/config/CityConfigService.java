package javacity.config;

import java.net.URL;

import javax.xml.bind.JAXB;

import javacity.Activator;
import javacity.view.TestConverter;

public class CityConfigService {

	private CityConfig conf;

	public CityConfigService() {
//		this.loadDefault();
	}

	public CityConfig loadDefault() {
		URL entry = Activator.getDefault().getBundle().getEntry("/resource/config.xml");
		this.conf = JAXB.unmarshal(entry, CityConfig.class);
		this.conf = new CityConfig();
		this.conf.normalize();
		return this.conf;
	}

	public void load() {

	}

	public void save() {

	}

	public TestConverter getConverter() {
		return this.conf.converter();
	}
}

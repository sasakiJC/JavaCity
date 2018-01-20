package javacity.config;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import dev.javacity.core.visual.MVConverter;
import dev.javacity.core.visual.Mappings;
import javacity.config.jaxb.ConfigDao;
import javacity.config.jaxb.MapAdapter;

public class ViewConfig {
//	@XmlElementWrapper(name="array")
//	@XmlElement(name="value")
//	private ConfigModelElement[] elements;
	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement
	Map<String, ConfigModelElement> elements;

	public ViewConfig() {
	}

	public ViewConfig(ConfigDao tempConf) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ConfigModelElement getElm(String key) {
		return this.elements.get(key);
	}

	public String[] getElementNames() {
//		Map<Class<?>, SoftwareElementType> temp = javacity.model.Activator.getExtensionLoader().getElementTypeExtensions();
//		String[] strTemp = temp.values().stream().map(item -> {return item.getName();}).toArray(String[]::new);
//		list.setItems(strTemp);
		return this.elements.keySet().toArray(new String[]{});
	}


	@Override
	public String toString() {
		return DEFAULT_COLOR_MAPPER.toString();
	}

	public MVConverter toConverter(String key) {
		ConfigModelElement confMElm = this.elements.get(key);
		String glyphName = confMElm.glyphName();
		Mappings mappings = new Mappings(confMElm.toMappings(), confMElm.isVisible, confMElm.layout());
		MVConverter converter = new MVConverter(glyphName, mappings);
		return converter;
	}

//	Glyph
//	wall.attributes = color,alpha,width,length,wallThickness,wallHeight
//	cuboid.attributes = color,alpha,width,length,height
//	rooftop.attributes = color,alpha,width,length,roofTopThickness
//	terrain.attributes = color,alpha,width,length,terrainThickness
//	arch.attributes = color,alpha;
//	line.attributes = color,alpha;



////default

	public static ConfigMapping DEFAULT_COLOR_MAPPER;
	public static ConfigMapping DEFAULT_ALPHA_MAPPER;
	public static ConfigMapping DEFAULT_WIDTH_MAPPER;
	public static ConfigMapping DEFAULT_LENGTH_MAPPER;
	public static ConfigMapping DEFAULT_HEIGHT_MAPPER;

	public static ConfigMapping DEFAULT_WALL_THICKNESS_MAPPER;
	public static ConfigMapping DEFAULT_WALL_HEIGHT_MAPPER;
	public static ConfigMapping DEFAULT_ROOFTOP_THICKNESS_MAPPER;
	public static ConfigMapping DEFAULT_TERRAIN_THICKNESS_MAPPER;

	public static ConfigInnerLayout DEFAULT_INNER_LAYOUT;


	@XmlElement(name="default_color_mapper")
	private void setDEFAULT_COLOR_MAPPER(ConfigMapping default_color_mapper) {
		ViewConfig.DEFAULT_COLOR_MAPPER = default_color_mapper;
	}

	@XmlElement(name="default_alpha_mapper")
	private void setDEFAULT_ALPHA_MAPPER(ConfigMapping default_alpha_mapper) {
		ViewConfig.DEFAULT_ALPHA_MAPPER = default_alpha_mapper;
	}

	@XmlElement(name="default_width_mapper")
	private void setDEFAULT_WIDTH_MAPPER(ConfigMapping default_width_mapper) {
		ViewConfig.DEFAULT_WIDTH_MAPPER = default_width_mapper;
	}

	@XmlElement(name="default_length_mapper")
	private void setDEFAULT_LENGTH_MAPPER(ConfigMapping default_length_mapper) {
		ViewConfig.DEFAULT_LENGTH_MAPPER = default_length_mapper;
	}

	@XmlElement(name="default_height_mapper")
	private void setDEFAULT_HEIGHT_MAPPER(ConfigMapping default_height_mapper) {
		ViewConfig.DEFAULT_HEIGHT_MAPPER = default_height_mapper;
	}


	@XmlElement(name="default_wall_thickness_mapper")
	private void setDEFAULT_WALL_THICKNESS_MAPPER(ConfigMapping default_wall_thickness_mapper) {
		ViewConfig.DEFAULT_WALL_THICKNESS_MAPPER = default_wall_thickness_mapper;
	}

	@XmlElement(name="default_wall_height_mapper")
	private void setDEFAULT_WALL_HEIGHT_MAPPER(ConfigMapping default_wall_height_mapper) {
		ViewConfig.DEFAULT_WALL_HEIGHT_MAPPER = default_wall_height_mapper;
	}

	@XmlElement(name="default_rooftop_thickness_mapper")
	private void setDEFAULT_ROOFTOP_THICKNESS_MAPPER(ConfigMapping default_rooftop_thickness_mapper) {
		ViewConfig.DEFAULT_ROOFTOP_THICKNESS_MAPPER = default_rooftop_thickness_mapper;
	}

	@XmlElement(name="default_terrain_thickness_mapper")
	private void setDEFAULT_TERRAIN_THICKNESS_MAPPER(ConfigMapping default_terrain_thickness_mapper) {
		ViewConfig.DEFAULT_TERRAIN_THICKNESS_MAPPER = default_terrain_thickness_mapper;
	}


	@XmlElement(name="default_inner_layout")
	private void setDEFAULT_INNER_LAYOUT(ConfigInnerLayout default_inner_layout) {
		ViewConfig.DEFAULT_INNER_LAYOUT = default_inner_layout;
	}


	private ConfigMapping getDEFAULT_COLOR_MAPPER() {
		return ViewConfig.DEFAULT_COLOR_MAPPER;
	}

	private ConfigMapping getDEFAULT_ALPHA_MAPPER() {
		return ViewConfig.DEFAULT_ALPHA_MAPPER;
	}

	private ConfigMapping getDEFAULT_WIDTH_MAPPER() {
		return ViewConfig.DEFAULT_WIDTH_MAPPER;
	}

	private ConfigMapping getDEFAULT_LENGTH_MAPPER() {
		return ViewConfig.DEFAULT_LENGTH_MAPPER;
	}

	private ConfigMapping getDEFAULT_HEIGHT_MAPPER() {
		return ViewConfig.DEFAULT_HEIGHT_MAPPER;
	}


	private ConfigMapping getDEFAULT_WALL_THICKNESS_MAPPER() {
		return ViewConfig.DEFAULT_WALL_THICKNESS_MAPPER;
	}

	private ConfigMapping getDEFAULT_WALL_HEIGHT_MAPPER() {
		return ViewConfig.DEFAULT_WALL_HEIGHT_MAPPER;
	}

	private ConfigMapping getDEFAULT_ROOFTOP_THICKNESS_MAPPER() {
		return ViewConfig.DEFAULT_ROOFTOP_THICKNESS_MAPPER;
	}

	private ConfigMapping getDEFAULT_TERRAIN_THICKNESS_MAPPER() {
		return ViewConfig.DEFAULT_TERRAIN_THICKNESS_MAPPER;
	}


	private ConfigInnerLayout getDEFAULT_INNER_LAYOUT() {
		return ViewConfig.DEFAULT_INNER_LAYOUT;
	}

}

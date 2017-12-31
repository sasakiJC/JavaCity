package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ConfigMapping {
	@XmlAttribute
	private String name;
	@XmlElement
	private String mapperClassId;
	@XmlElement
	private String[] modelProperties;

	public static final ConfigMapping DEFAULT_COLOR_MAPPING = new ConfigMapping("color", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"gray"});
	public static final ConfigMapping DEFAULT_ALPHA_MAPPING = new ConfigMapping("alpha", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});
	public static final ConfigMapping DEFAULT_WIDTH_MAPPING = new ConfigMapping("width", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});
	public static final ConfigMapping DEFAULT_LENGTH_MAPPING = new ConfigMapping("length", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});
	public static final ConfigMapping DEFAULT_HEIGHT_MAPPING = new ConfigMapping("height", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});

	public static final ConfigMapping DEFAULT_WALL_THICKNESS_MAPPING = new ConfigMapping("wallThickness", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});
	public static final ConfigMapping DEFAULT_WALL_HEIGHT_MAPPING = new ConfigMapping("wallHeight", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"2"});
	public static final ConfigMapping DEFAULT_ROOFTOP_THICKNESS_MAPPING = new ConfigMapping("roofTopThickness", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});
	public static final ConfigMapping DEFAULT_TERRAIN_THICKNESS_MAPPING = new ConfigMapping("terrainThickness", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"2"});

	public ConfigMapping(String name, String mapperClassId, String[] modelProperties) {
		this.name = name;
		this.mapperClassId = mapperClassId;
		this.modelProperties = modelProperties;
	}
}

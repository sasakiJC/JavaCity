package javacity.config;

import javax.xml.bind.annotation.XmlElement;

import dev.javacity.core.visual.Mapper;
import dev.javacity.core.visual.mapper.ConstantMapper;

public class ConfigMapping {
	@XmlElement
	Class<? extends Mapper> mapperClassId;
	@XmlElement
	String[] modelProperties;

//	color, alpha, width, length, height

//	public static final ConfigMapping DEFAULT_COLOR_MAPPING = new ConfigMapping("color", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"gray"});

//	public static final ConfigMapping DEFAULT_WALL_THICKNESS_MAPPING = new ConfigMapping("wallThickness", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});
//	public static final ConfigMapping DEFAULT_WALL_HEIGHT_MAPPING = new ConfigMapping("wallHeight", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"2"});
//	public static final ConfigMapping DEFAULT_ROOFTOP_THICKNESS_MAPPING = new ConfigMapping("roofTopThickness", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"1"});
//	public static final ConfigMapping DEFAULT_TERRAIN_THICKNESS_MAPPING = new ConfigMapping("terrainThickness", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"2"});

	public ConfigMapping() {
		this.mapperClassId = ConstantMapper.class;
		this.modelProperties = new String[]{"1"};
	}

	public ConfigMapping(Class<? extends Mapper> mapperClassId, String[] modelProperties) {
		this.mapperClassId = mapperClassId;
		this.modelProperties = modelProperties;
	}

	public String toString() {
		return "mapperClassId: " + this.mapperClassId + ", modelProp: " + modelProperties.toString();
	}
}

package javacity.config;

import javax.xml.bind.annotation.XmlElement;

import javacity.view.Mapper;
import javacity.view.mapper.ConstantMapper;
import javafx.scene.paint.Color;

public class ConfigMapping {
	@XmlElement
	Class<? extends Mapper> mapperClassId;
	@XmlElement
	Class<?> valueClass;
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
		this.valueClass = Double.class;
		this.modelProperties = new String[]{"1"};
	}

	public ConfigMapping(String name) {
		this.mapperClassId = ConstantMapper.class;
		if(name.equals("color")) {
			this.valueClass = Color.class;
			this.modelProperties = new String[]{"gray"};
		}else{
		this.valueClass = Double.class;
		this.modelProperties = new String[]{"1"};
		}
	}

	public ConfigMapping(Class<? extends Mapper> mapperClassId, Class<?> valueClass, String[] modelProperties) {
		this.mapperClassId = mapperClassId;
		this.valueClass = valueClass;
		this.modelProperties = modelProperties;
	}

	public String toString() {
		return "mapperClassId: " + this.mapperClassId + ", valueClass: " + this.valueClass + ", modelProp: " + modelProperties.toString();
	}

	public Mapper createMapper() {
		Class<?>[] paramTypes = new Class<?>[]{this.valueClass.getClass(), String[].class};
//		paramTypes[0] = this.valueClass.getClass();
		Mapper mapper = null;
		Object[] args = new Object[]{this.valueClass, this.modelProperties};

		try {
			mapper = (Mapper) this.mapperClassId.getConstructor(paramTypes).newInstance(args);
		} catch (ReflectiveOperationException  e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return mapper;
	}
}

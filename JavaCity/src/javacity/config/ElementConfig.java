package javacity.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import dev.javacity.core.Activator;
import dev.javacity.core.BuildingGlyph;
import dev.javacity.core.Glyph;
import dev.javacity.core.visual.Mapper;
import dev.javacity.core.visual.mapper.ConstantMapper;

public class ElementConfig {

	@XmlAttribute
	boolean isVisible;

	@XmlElement
	Class<? extends Glyph> glyphClass;
	@XmlElement
//	Map<String, Mapper> mappers;
	Map<String, ConfigMapping> mappings;
	@XmlElement
	ConfigInnerLayout configInnerLayout;

	ElementConfig() {
		this.isVisible = false;
		this.glyphClass = BuildingGlyph.class;
		this.mappings = new HashMap<>();
		Glyph glyph = Activator.getMetaphorExtensionLoader().getGlyph(this.glyphClass);
		for(String str : glyph.getAttributes()) {
			this.mappings.put(str, new ConfigMapping());
		}
		this.configInnerLayout = new ConfigInnerLayout();
	}

	ElementConfig(boolean isVisible, Class<? extends Glyph> glyphClass, Map<String, ConfigMapping> mappings, ConfigInnerLayout configInnerLayout) {
		this.isVisible = isVisible;
		this.glyphClass = glyphClass;
		this.mappings = mappings;
		this.configInnerLayout = configInnerLayout;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void normalize() {
//		validate this.glyph
//		validate this.configInnerLayout
		Set<String> extTemp = Activator.getMetaphorExtensionLoader().allGlyphAttriutes();

		List<String> diffExtConf = ConfigUtils.diff(extTemp, this.mappings.keySet());
		List<String> diffConfExt = ConfigUtils.diff(this.mappings.keySet(), extTemp);

		if(!diffExtConf.isEmpty()) {
			diffExtConf.forEach(item -> this.mappings.put(item, new ConfigMapping()));
		}
		if(!diffConfExt.isEmpty()) {
			diffConfExt.forEach(item -> this.mappings.remove(item));
		}
//		validate this.mappers
//		this.mappers.forEach((key,value) -> value.normalize());
	}

	private Mapper createDefaultMapper() {
		return new ConstantMapper();
	}

//	public Map<String, Mapper<?>> toMappings() {
//		Map<String, Mapper<?>> map = new HashMap<>();
//
//		try {
//			for(ConfigMapping confMapping: configMappings) {
//				Class<?> clazz = Class.forName(confMapping.mapperClassId);
//				Class<?>[] types = {String[].class};
//				Object[] args = {confMapping.modelProperties};
//				Mapper<?> mapper = (Mapper<?>) clazz.getConstructor(types).newInstance(args);
//				map.put(confMapping.name, mapper);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//
//		return map;
//	}
//
//	public VisLayout layout() {
//		try {
//			Class<?> clazz = Class.forName(this.configInnerLayout.layoutId);
//			VisLayout layout = (VisLayout) clazz.newInstance();
//			return layout;
//		} catch (ClassNotFoundException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		return null;
//	}
}

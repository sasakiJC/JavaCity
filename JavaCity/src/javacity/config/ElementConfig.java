package javacity.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import dev.javacity.core.Activator;
import dev.javacity.core.Glyph;
import dev.javacity.core.visual.Mapper;
import dev.javacity.core.visual.mapper.ConstantMapper;

public class ElementConfig {
	@XmlAttribute
	String name;
	@XmlAttribute
	boolean isVisible;

	@XmlElement
	Glyph glyph;
	@XmlElement
	Map<String, Mapper> mappers;
//	ConfigMapping[] configMappings;
	@XmlElement
	ConfigInnerLayout configInnerLayout;

	ElementConfig() {

	}

	ElementConfig(String name, boolean isVisible, Glyph glyph, ConfigMapping[] configMappings, ConfigInnerLayout configInnerLayout) {
		this.name = name;
		this.isVisible = isVisible;
		this.glyph = glyph;
//		this.configMappings = configMappings;
		this.configInnerLayout = configInnerLayout;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getName() {
		return this.name;
	}

	public void normalize() {
//		validate this.glyph
//		validate this.configInnerLayout
		Set<String> extTemp = Activator.getMetaphorExtensionLoader().allGlyphAttriutes();

		List<String> diffExtConf = ConfigUtils.diff(extTemp, this.mappers.keySet());
		List<String> diffConfExt = ConfigUtils.diff(this.mappers.keySet(), extTemp);

		if(!diffExtConf.isEmpty()) {
			diffExtConf.forEach(item -> this.mappers.put(item, this.createDefaultMapper()));
		}
		if(!diffConfExt.isEmpty()) {
			diffConfExt.forEach(item -> this.mappers.remove(item));
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

package javacity.config;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import dev.javacity.core.visual.VisLayout;
import dev.javacity.core.visual.mapper.Mapper;

public class ConfigModelElement {
	@XmlAttribute
	String name;
	@XmlAttribute
	boolean isVisible;

	@XmlElementWrapper(name="array")
	@XmlElement(name="value")
	String[] glyphs;
	@XmlElement
	ConfigGlyph configGlyph;
	@XmlElement
	ConfigMapping[] configMappings;
	@XmlElement
	ConfigInnerLayout configInnerLayout;

	public final static String[] GLYPHS = new String[]{"terrain", "wall", "cuboid", "rooftop"};
	public final static String[] ARCH_GLYPHS = new String[]{"line", "arch"};

	ConfigModelElement() {

	}

	ConfigModelElement(String name, boolean isVisible, String[] glyphs, ConfigGlyph configGlyph, ConfigMapping[] configMappings, ConfigInnerLayout configInnerLayout) {
		this.name = name;
		this.isVisible = isVisible;
		this.glyphs = glyphs;
		this.configGlyph = configGlyph;
		this.configMappings = configMappings;
		this.configInnerLayout = configInnerLayout;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getName() {
		return this.name;
	}

	public String glyphName() {
		return this.configGlyph.name;
	}

	public Map<String, Mapper<?>> toMappings() {
		Map<String, Mapper<?>> map = new HashMap<>();

		try {
			for(ConfigMapping confMapping: configMappings) {
				Class<?> clazz = Class.forName(confMapping.mapperClassId);
				Class<?>[] types = {String[].class};
				Object[] args = {confMapping.modelProperties};
				Mapper<?> mapper = (Mapper<?>) clazz.getConstructor(types).newInstance(args);
				map.put(confMapping.name, mapper);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		return map;
	}

	public VisLayout layout() {
		try {
			Class<?> clazz = Class.forName(this.configInnerLayout.layoutId);
			VisLayout layout = (VisLayout) clazz.newInstance();
			return layout;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}

}

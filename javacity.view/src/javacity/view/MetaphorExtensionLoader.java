package javacity.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

public class MetaphorExtensionLoader {

	private static final String EXAMPLE_EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".glyph";	//拡張ポイントID

//	private List<SoftwareElementType> list;
//
//	public List<SoftwareElementType> getElementTypeExtensions() {
//		if (this.list != null) {
//			return this.list;
//		}
//
//		IExtensionRegistry registory = Platform.getExtensionRegistry();
//		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
//		if (point == null) {
//			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
//		}
//
//		this.list = new ArrayList<SoftwareElementType>();
//		for (IExtension extension : point.getExtensions()) {
//			for (IConfigurationElement element : extension.getConfigurationElements()) {
//				try {
////					element.getAttribute("class");
//					Object obj = element.createExecutableExtension("class");	//class属性
//					if (obj instanceof SoftwareElementType) {
//						this.list.add((SoftwareElementType) obj);
//					}
//				} catch (CoreException e) {
//					Activator.getDefault().getLog().log(e.getStatus());
//				}
//			}
//		}
//		return this.list;
//	}

	private Map<Class<?>, Glyph> glyphMap;
	private Map<Class<?>, Mapper> mapperMap;
	private Map<Class<?>, InnerLayout> layoutMap;


	private Map<Class<?>, String> mapperClassMap;
	private Map<Class<?>, String> layoutClassMap;

	public Map<Class<?>, String> getMapperExtensionClasses() {
		if (this.mapperClassMap != null) {
			return this.mapperClassMap;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
		}

		this.mapperClassMap = new HashMap<>();
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					Class<?> clazz = Class.forName(element.getAttribute("class"));
					if(Mapper.class.isAssignableFrom(clazz)) {
						String name = element.getAttribute("name");
						this.mapperClassMap.put(clazz, name);
					}
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return this.mapperClassMap;
	}

	public Map<Class<?>, String> getLayoutExtensionClasses() {
	if (this.layoutClassMap != null) {
		return this.layoutClassMap;
	}

	IExtensionRegistry registory = Platform.getExtensionRegistry();
	IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
	if (point == null) {
		throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
	}

	this.layoutClassMap = new HashMap<Class<?>, String>();
	for (IExtension extension : point.getExtensions()) {
		for (IConfigurationElement element : extension.getConfigurationElements()) {
			try {
				Class<?> clazz = Class.forName(element.getAttribute("class"));
				if(InnerLayout.class.isAssignableFrom(clazz)) {
					String name = element.getAttribute("name");
					this.layoutClassMap.put(clazz, name);
				}
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	return this.layoutClassMap;
}





	public Map<Class<?>, Glyph> getGlyphExtensions() {
		if (this.glyphMap != null) {
			return this.glyphMap;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
		}

		this.glyphMap = new HashMap<Class<?>, Glyph>();
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					Class<?> clazz = Class.forName(element.getAttribute("class"));
					if(Glyph.class.isAssignableFrom(clazz)) {
						Object obj = element.createExecutableExtension("class");	//class属性
						Glyph glyph = (Glyph)obj;
						glyph.setName(element.getAttribute("name"));
						this.glyphMap.put(clazz, glyph);
					}
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return this.glyphMap;
	}

//	public Map<Class<?>, Mapper> getMapperExtensions() {
//		if (this.mapperMap != null) {
//			return this.mapperMap;
//		}
//
//		IExtensionRegistry registory = Platform.getExtensionRegistry();
//		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
//		if (point == null) {
//			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
//		}
//
//		this.mapperMap = new HashMap<Class<?>, Mapper>();
//		for (IExtension extension : point.getExtensions()) {
//			for (IConfigurationElement element : extension.getConfigurationElements()) {
//				try {
//					Class<?> clazz = Class.forName(element.getAttribute("class"));
//					Object obj = element.createExecutableExtension("class");	//class属性
//					if (obj instanceof Mapper) {
//						Mapper mapper = (Mapper)obj;
//						mapper.setName(element.getAttribute("name"));
//						this.mapperMap.put(clazz, mapper);
//					}
//				} catch (CoreException e) {
//					Activator.getDefault().getLog().log(e.getStatus());
//				} catch (ClassNotFoundException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				} catch (InvalidRegistryObjectException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//			}
//		}
//		return this.mapperMap;
//	}

//	public Map<Class<?>, InnerLayout> getInnerLayoutExtensions() {
//		if (this.layoutMap != null) {
//			return this.layoutMap;
//		}
//
//		IExtensionRegistry registory = Platform.getExtensionRegistry();
//		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
//		if (point == null) {
//			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
//		}
//
//		this.layoutMap = new HashMap<Class<?>, InnerLayout>();
//		for (IExtension extension : point.getExtensions()) {
//			for (IConfigurationElement element : extension.getConfigurationElements()) {
//				try {
//					Class<?> clazz = Class.forName(element.getAttribute("class"));
//					Object obj = element.createExecutableExtension("class");	//class属性
//					if (obj instanceof InnerLayout) {
//						InnerLayout layout = (InnerLayout)obj;
//						layout.setName(element.getAttribute("name"));
//						this.layoutMap.put(clazz, layout);
//					}
//				} catch (CoreException e) {
//					Activator.getDefault().getLog().log(e.getStatus());
//				} catch (ClassNotFoundException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				} catch (InvalidRegistryObjectException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//			}
//		}
//		return this.layoutMap;
//	}


	public Glyph getGlyph(Class<?> clazz) {
		Glyph result = this.getGlyphExtensions().get(clazz);
//		if(result == null)
//			throw new ElementTypeNotFoundException(clazz + "で指定されたElementTypeは存在しません。");
		return result;
	}

	public Glyph[] getEntityGlyph() {
		return this.glyphMap.values().toArray(new Glyph[]{});
	}

	public Set<String> allGlyphAttriutes() {
		Set<String> set = new HashSet<String>();
		Map<Class<?>, Glyph> map = this.getGlyphExtensions();
		map.values().forEach(item -> set.addAll(Arrays.asList(item.getAttributes())));
		return set;
	}

	public InnerLayout getInnerLayout(Class<? extends InnerLayout> layoutId) {
		return this.layoutMap.get(layoutId);
	}

	public String getInnerLayoutName(Class<?> layoutId) {
		return this.layoutClassMap.get(layoutId);
	}





























//	public Map<Class<?>, String> getGlyphExtensionClasses() {
//	if (this.glyphClassMap != null) {
//		return this.glyphClassMap;
//	}
//
//	IExtensionRegistry registory = Platform.getExtensionRegistry();
//	IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
//	if (point == null) {
//		throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
//	}
//
//	this.glyphClassMap = new HashMap<Class<?>, String>();
//	for (IExtension extension : point.getExtensions()) {
//		for (IConfigurationElement element : extension.getConfigurationElements()) {
//			try {
//				Class<?> clazz = Class.forName(element.getAttribute("class"));
//				if(Glyph.class.isAssignableFrom(clazz)) {
//					String name = element.getAttribute("name");
//					this.glyphClassMap.put(clazz, name);
//				}
//			} catch (ClassNotFoundException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
//		}
//	}
//	return this.glyphClassMap;
//}


}

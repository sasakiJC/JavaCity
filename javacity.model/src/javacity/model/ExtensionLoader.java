package javacity.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

import javacity.model.exception.ElementTypeNotFoundException;

public class ExtensionLoader {

	private static final String EXAMPLE_EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".entity";	//拡張ポイントID

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

	private Map<Class<?>, SoftwareElementType> map;
	private Map<Class<?>, String> classMap;

	public Map<Class<?>, String> getElementExtensionClasses() {
		if (this.classMap != null) {
			return this.classMap;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
		}

		this.classMap = new HashMap<Class<?>, String>();
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					Class<?> clazz = Class.forName(element.getAttribute("class"));
					String name = element.getAttribute("name");
					this.classMap.put(clazz, name);
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return this.classMap;
	}

	public Map<Class<?>, SoftwareElementType> getElementTypeExtensions() {
		if (this.map != null) {
			return this.map;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
		}

		this.map = new HashMap<Class<?>, SoftwareElementType>();
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					Class<?> clazz = Class.forName(element.getAttribute("class"));
					Object obj = element.createExecutableExtension("class");	//class属性
					if (obj instanceof SoftwareElementType) {
						SoftwareElementType elementType = (SoftwareElementType)obj;
						elementType.setName(element.getAttribute("name"));
						this.map.put(clazz, elementType);
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
		return this.map;
	}

	public SoftwareElementType get(Class<?> clazz) {
		SoftwareElementType result = this.map.get(clazz);
		if(result == null)
			throw new ElementTypeNotFoundException(clazz + "で指定されたElementTypeは存在しません。");
		return result;
	}

}

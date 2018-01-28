package javacity.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

import javacity.model.exception.ElementTypeNotFoundException;

public class ExtensionLoader {

	private static final String ENTITY_EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".entity";	//拡張ポイントID
	private static final String METRIC_EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".metrics";

	private Map<Class<?>, Map<Class<?>, IConfigurationElement>> entityMetricClassMap;


	private Map<Class<?>, SoftwareElementType> map;
	private Map<Class<?>, IConfigurationElement> entityClassMap;
	private Map<Class<?>, IConfigurationElement> relationClassMap;

	public ExtensionLoader() {
		this.entityMetricClassMap = new HashMap<>();
	}

	public Map<Class<?>, IConfigurationElement> getMetricsExtensionClasses(Class<?> entityClazz) {
		if (this.entityMetricClassMap.get(entityClazz) != null) {
			return this.entityMetricClassMap.get(entityClazz);
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(METRIC_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(METRIC_EXTENSION_POINT_ID);
		}

		IConfigurationElement entityElemnt = this.getElementExtensionClasses().get(entityClazz);
		Map<Class<?>, IConfigurationElement> metricClassMap = new HashMap<>();
		this.entityMetricClassMap.put(entityClazz, metricClassMap);
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					if(element.getAttribute("elementId").equals(entityElemnt.getAttribute("id"))) {
						Class<?> clazz = Class.forName(element.getAttribute("class"));
						if(CodeMetric.class.isAssignableFrom(clazz)) {
							metricClassMap.put(clazz, element);
						}
					}
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return metricClassMap;
	}

	public Map<Class<?>, String> getMetricsExtensionClassNames(Class<?> entityClazz) {
		return this.getMetricsExtensionClasses(entityClazz).entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue().getAttribute("name")));
	}


	public Map<Class<?>, IConfigurationElement> getRelationExtensionClasses() {
		if (this.relationClassMap != null) {
			return this.relationClassMap;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(ENTITY_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(ENTITY_EXTENSION_POINT_ID);
		}

		this.relationClassMap = new HashMap<>();
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					Class<?> clazz = Class.forName(element.getAttribute("class"));
					if(SoftwareRelation.class.isAssignableFrom(clazz)) {
//						String name = element.getAttribute("name");
						this.relationClassMap.put(clazz, element);
					}
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return this.relationClassMap;
	}



	public Map<Class<?>, IConfigurationElement> getElementExtensionClasses() {
		if (this.entityClassMap != null) {
			return this.entityClassMap;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(ENTITY_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(ENTITY_EXTENSION_POINT_ID);
		}

		this.entityClassMap = new HashMap<>();
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					Class<?> clazz = Class.forName(element.getAttribute("class"));
					if(SoftwareEntity.class.isAssignableFrom(clazz)) {
//						String name = element.getAttribute("name");
						this.entityClassMap.put(clazz, element);
					}
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return this.entityClassMap;
	}

	public String[] getElementExtensionNames() {
		return this.getElementExtensionClasses().values().stream().map(item -> item.getAttribute("name")).toArray(String[]::new);
	}

	public Map<Class<?>, String> getElementExtensionClassNames() {
		return this.getElementExtensionClasses().entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue().getAttribute("name")));
	}

	public Map<Class<?>, SoftwareElementType> getElementTypeExtensions() {
		if (this.map != null) {
			return this.map;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(ENTITY_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(ENTITY_EXTENSION_POINT_ID);
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

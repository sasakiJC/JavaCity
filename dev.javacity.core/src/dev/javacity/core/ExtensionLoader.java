package dev.javacity.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import dev.javacity.core.models.TargetEntity;

public class ExtensionLoader {

	private static final String EXAMPLE_EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".model.entity";	//拡張ポイントID

	private List<TargetEntity> list;
	public List<TargetEntity> getExampleExtensions() {
		if (list != null) {
			return list;
		}

		IExtensionRegistry registory = Platform.getExtensionRegistry();
		IExtensionPoint point = registory.getExtensionPoint(EXAMPLE_EXTENSION_POINT_ID);
		if (point == null) {
			throw new IllegalStateException(EXAMPLE_EXTENSION_POINT_ID);
		}

		list = new ArrayList<TargetEntity>();
		for (IExtension extension : point.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				try {
					Object obj = element.createExecutableExtension("class");	//class属性
					if (obj instanceof TargetEntity) {
						list.add((TargetEntity) obj);
					}
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				}
			}
		}
		return list;
	}

}

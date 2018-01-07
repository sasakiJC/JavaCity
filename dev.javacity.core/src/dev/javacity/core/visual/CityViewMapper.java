package dev.javacity.core.visual;

import dev.javacity.core.models.TClass;
import dev.javacity.core.models.TField;
import dev.javacity.core.models.TMethod;
import dev.javacity.core.models.TPackage;

public class CityViewMapper implements ViewMapper{

	private ColorMapper colorMapper;
	private DimensionMapper dimensionMapper;
	private LayoutMapper layoutMapper;

	public VisualizedComponent mapPackage(TPackage pack) {
//		(x,y,z) = layout.layout(pack.children);
//		District district = new District(pack, layout);
		District district = new District(pack, new CityViewLayout());
		return null;
	}

	public VisualizedComponent mapClass(TClass clazz) {
		Building building = new Building(clazz, new CityViewLayout());
		return null;
	}

	public VisualizedComponent mapMethod(TMethod method) {
		return null;
	}

	public VisualizedComponent mapField(TField field) {
		return null;
	}

	public VisualizedComponent mapClassRelation(Object obj) {
		return null;
	}

//	public Group map(TargetEntity entity) {
//		if(entity instanceof TargetPackage) {
//			return null;
//		}else if(entity instanceof TargetClass) {
//			return null;
//		}else{
//			return null;
//		}
//	}
}

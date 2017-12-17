package dev.javacity.core.visual;

import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetField;
import dev.javacity.core.models.TargetMethod;
import dev.javacity.core.models.TargetPackage;

public class CityViewMapper implements ViewMapper{

	private ColorMapper colorMapper;
	private DimensionMapper dimensionMapper;
	private LayoutMapper layoutMapper;

	public VisualizedComponent mapPackage(TargetPackage pack) {
//		(x,y,z) = layout.layout(pack.children);
//		District district = new District(pack, layout);
		District district = new District(pack, new CityViewLayout());
		return null;
	}

	public VisualizedComponent mapClass(TargetClass clazz) {
		Building building = new Building(clazz, new CityViewLayout());
		return null;
	}

	public VisualizedComponent mapMethod(TargetMethod method) {
		return null;
	}

	public VisualizedComponent mapField(TargetField field) {
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

package dev.javacity.core.visual;

import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetField;
import dev.javacity.core.models.TargetMethod;
import dev.javacity.core.models.TargetPackage;

public class CityViewMapper implements ViewMapper{

	public VisualizedComponent mapPackage(TargetPackage pack) {
//		(x,y,z) = layout.layout(pack.children);
//		District district = new District(pack, layout);
		District district = new District(pack);
		return null;
	}

	public VisualizedComponent mapClass(TargetClass clazz) {
		Building building = new Building(clazz);
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
package dev.javacity.core;

import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetField;
import dev.javacity.core.models.TargetMethod;
import dev.javacity.core.models.TargetPackage;
import dev.javacity.core.visual.District;
import javafx.scene.Group;

public class ViewMapper {

	public Group mapPackage(TargetPackage pack) {
		District district = new District(pack);
		return null;
	}

	public Group mapClass(TargetClass clazz) {
		return null;
	}

	public Group mapMethod(TargetMethod method) {
		return null;
	}

	public Group mapField(TargetField field) {
		return null;
	}

	public Group mapRelation(Object obj) {
		return null;
	}
}

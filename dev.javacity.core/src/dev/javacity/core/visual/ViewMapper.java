package dev.javacity.core.visual;

import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetField;
import dev.javacity.core.models.TargetMethod;
import dev.javacity.core.models.TargetPackage;

public interface ViewMapper {
	public VisualizedComponent mapPackage(TargetPackage pack);

	public VisualizedComponent mapClass(TargetClass clazz);

	public VisualizedComponent mapMethod(TargetMethod method);

	public VisualizedComponent mapField(TargetField field);

	public VisualizedComponent mapClassRelation(Object obj);
}

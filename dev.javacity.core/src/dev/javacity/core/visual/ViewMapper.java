package dev.javacity.core.visual;

import dev.javacity.core.models.TClass;
import dev.javacity.core.models.TField;
import dev.javacity.core.models.TMethod;
import dev.javacity.core.models.TPackage;

public interface ViewMapper {
	public VisualizedComponent mapPackage(TPackage pack);

	public VisualizedComponent mapClass(TClass clazz);

	public VisualizedComponent mapMethod(TMethod method);

	public VisualizedComponent mapField(TField field);

	public VisualizedComponent mapClassRelation(Object obj);
}

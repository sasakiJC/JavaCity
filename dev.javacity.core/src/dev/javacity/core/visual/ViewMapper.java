package dev.javacity.core.visual;

import javacity.model.TClass;
import javacity.model.TField;
import javacity.model.TMethod;
import javacity.model.TPackage;

public interface ViewMapper {
	public VisualizedComponent mapPackage(TPackage pack);

	public VisualizedComponent mapClass(TClass clazz);

	public VisualizedComponent mapMethod(TMethod method);

	public VisualizedComponent mapField(TField field);

	public VisualizedComponent mapClassRelation(Object obj);
}

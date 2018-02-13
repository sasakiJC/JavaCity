package dev.javacity.core.visual;

import javacity.model.element.TClass;
import javacity.model.element.TField;
import javacity.model.element.TMethod;
import javacity.model.element.TPackage;

public interface ViewMapper {
	public VisualizedComposite mapPackage(TPackage pack);

	public VisualizedComposite mapClass(TClass clazz);

	public VisualizedComposite mapMethod(TMethod method);

	public VisualizedComposite mapField(TField field);

	public VisualizedComposite mapClassRelation(Object obj);
}

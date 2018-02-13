package dev.javacity.core.visual.mapper;

import java.lang.reflect.Method;

import dev.javacity.core.visual.Mapper;
import javacity.model.SoftwareEntity;

public class ConstantMapper extends AbstractMapper implements Mapper {

	private Object value;

	public ConstantMapper(Class<?> valueClazz, String[] modelProperties) {
		Method method;
		try {
			method = valueClazz.getMethod("valueOf", String.class);
			this.value = method.invoke(null, modelProperties[0]);
		} catch (ReflectiveOperationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Override
	public Object toAttribute(SoftwareEntity entity) {
		return this.value;
	}

}

package javacity.view.mapper;

import java.lang.reflect.Method;

import javacity.model.SoftwareEntity;
import javacity.view.Mapper;

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

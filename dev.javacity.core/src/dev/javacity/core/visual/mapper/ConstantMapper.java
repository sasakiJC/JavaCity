package dev.javacity.core.visual.mapper;

public class ConstantMapper<T> implements Mapper<T> {

	private T value;

	@Override
	public T toAttribute() {
		return value;
	}

}

package dev.javacity.core.visual.mapper;

import javacity.model.TargetEntity;

public class ConstantMapper<T> implements Mapper<T> {

	private T value;

	@Override
	public T toAttribute(TargetEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		return this.value;
	}

}

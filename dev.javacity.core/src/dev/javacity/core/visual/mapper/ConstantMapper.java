package dev.javacity.core.visual.mapper;

import dev.javacity.core.visual.MappedValue;
import dev.javacity.core.visual.Mapper;
import javacity.model.SoftwareEntity;

public class ConstantMapper extends AbstractMapper implements Mapper {

	private MappedValue value;

	@Override
	public MappedValue toAttribute(SoftwareEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		return this.value;
	}

}

package dev.javacity.core.visual.mapper;

import dev.javacity.core.visual.MappedValue;

public class IntValue implements MappedValue<Integer> {

	private int value;

	public IntValue(String string) {
		this.value = Integer.valueOf(string);
	}

	@Override
	public Integer toRawValue() {
		return value;
	}

}

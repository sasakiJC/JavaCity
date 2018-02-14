package javacity.view.mapper;

import javacity.view.Mapper;

public abstract class AbstractMapper implements Mapper {

	protected String name;
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}

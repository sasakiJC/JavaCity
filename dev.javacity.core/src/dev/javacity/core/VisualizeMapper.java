package dev.javacity.core;

import dev.javacity.core.models.CityView;
import dev.javacity.core.models.TestDataModel;

public class VisualizeMapper {

	private LayoutMapper layoutMapper;
	private CodeElementApplicationService service;

	public VisualizeMapper(CodeElementApplicationService service) {
		this.service = service;
	}

	public CityView map(TestDataModel dataModel) {
		CityView view = new CityView();
		return null;
	}

	private void mapToArrow() {

	}

	private void mapToBuilding() {

	}

	private void mapToDistrict() {

	}
}

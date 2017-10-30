package dev.javacity.core.visual;

import dev.javacity.core.CodeElementApplicationService;
import dev.javacity.core.LayoutMapper;
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

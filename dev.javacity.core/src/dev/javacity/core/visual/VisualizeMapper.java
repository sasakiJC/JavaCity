package dev.javacity.core.visual;

import dev.javacity.core.CodeElementApplicationService;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetEntity;
import dev.javacity.core.models.TargetPackage;

public class VisualizeMapper {

	private CodeElementApplicationService service;

	public VisualizeMapper(CodeElementApplicationService service) {
		this.service = service;
	}

	public CityView map() {
		CityView view = new CityView();
		for(TargetPackage pack : this.service.packages()) {
			view.addNode(this.map(pack).fxView());
		}
		return null;
	}

	private District map(TargetPackage pack) {
		for(TargetEntity entity : pack.getChildren()) {
			map(entity);
		}
		return null;
	}

	private Building map(TargetClass clazz) {
		return null;
	}

	private VisualizedComposite map(TargetEntity entity) {
		return null;
	}

	private void mapToDistrict() {

	}
}

package dev.javacity.core.visual;

import javacity.model.CodeElementApplicationService;
import javacity.model.TClass;
import javacity.model.TPackage;
import javacity.model.TargetEntity;

public class VisualizeMapper {

	private CodeElementApplicationService service;

	public VisualizeMapper(CodeElementApplicationService service) {
		this.service = service;
	}

	public CityView map() {
		CityView view = new CityView();
		for(TPackage pack : this.service.packages()) {
			view.addNode(this.map(pack).fxView());
		}
		return null;
	}

	private District map(TPackage pack) {
		for(TargetEntity entity : pack.getChildren()) {
			map(entity);
		}
		return null;
	}

	private Building map(TClass clazz) {
		return null;
	}

	private VisualizedComposite map(TargetEntity entity) {
		return null;
	}

	private void mapToDistrict() {

	}
}

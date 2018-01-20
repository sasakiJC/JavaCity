package dev.javacity.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dev.javacity.core.visual.CityView;
import dev.javacity.core.visual.MVConverter;
import dev.javacity.core.visual.VisualizedComponent;
import javacity.model.DataModel;

public class TestConverter {

	private Map<Class<?>, MVConverter> convertMap;

	public TestConverter(Map<Class<?>, MVConverter> convertMap) {
		this.convertMap = convertMap;
	}

	public CityView convert(DataModel dataModel) {
//		List<VisualizedComponent> list = null;
		this.convertMap.forEach((key, value) -> {
			List<VisualizedComponent> list = dataModel.getEntities(key).getElements().stream().map(item -> value.createVisualizedComponent(item)).collect(Collectors.toList());
		});


//		dataModel.getEntities(entityClass)

//		dataModel.getEntities(type)



		return null;
	}
}

package javacity.view.structure;

import java.util.Map;

import javacity.model.DataModel;
import javacity.model.SoftwareEntity;
import javacity.model.element.TPackage;
import javacity.view.CityView;
import javacity.view.MVConverter;
import javacity.view.Structure;
import javacity.view.VisualizedComposite;

public class CodeCityStructure implements Structure {

//	@Override
//	public void structure(DataModel dataModel, Map<SoftwareEntity, VisualizedComponent> allmap) {
//		dataModel.getRootEntities().forEach(entity-> this.recursiveStructure(entity, allmap));
//	}

	@Override
		public CityView structure(DataModel dataModel, Map<Class<?>, MVConverter> convertMap) {
			CityView city = new CityView();
			dataModel.getEntities(TPackage.class).getRootEntities().forEach(entity -> city.addNode(this.recursiveStructure(entity, convertMap)));
			return city;
		}

	private VisualizedComposite recursiveStructure(SoftwareEntity entity, Map<Class<?>, MVConverter> convertMap) {

		VisualizedComposite composite = convertMap.get(entity.getClass()).createVisualizedComponent(entity);
		if(entity.hasChild()) {
			entity.getChildren().forEach(item -> composite.add(this.recursiveStructure(item, convertMap)));
		}
		return composite;
	}

//	private void recursiveStructure(SoftwareEntity entity, Map<SoftwareEntity, VisualizedComponent> allmap) {
//		VisualizedComponent parent = allmap.get(entity);
//		entity.getChildren().forEach(child -> {
//			parent.add(allmap.get(child));
//			this.recursiveStructure(child, allmap);
//		});
//	}
}

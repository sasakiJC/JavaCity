package javacity.view;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javacity.model.DataModel;
import javacity.model.SoftwareEntity;
import javacity.view.structure.CodeCityStructure;

public class TestConverter {

	private Map<Class<?>, MVConverter> convertMap;
	private CityView rootGlyph;

	public TestConverter(Map<Class<?>, MVConverter> convertMap) {
		this.convertMap = convertMap;
	}

	public CityView convert(DataModel dataModel) {
//		1. 各エンティティのViewを作成(葉に当たるViewの大きさはここで確定)
		Map<SoftwareEntity, VisualizedComposite> allmap = new HashMap<>();
		this.convertMap.forEach((key, value) -> {
			Map<SoftwareEntity, VisualizedComposite> map = dataModel.getEntities(key).getElements().stream().collect(Collectors.toMap(e->e, e->value.createVisualizedComponent(e)));
//			List<VisualizedComponent> list = dataModel.getEntities(key).getElements().stream().map(item -> value.createVisualizedComponent(item)).collect(Collectors.toList());
			allmap.putAll(map);
		});

//		2. StructorがViewの階層構造を作成(e.g. 親：packageDistrict, 子:classBuilding)
		Structure structure = new CodeCityStructure();
		rootGlyph = structure.structure(dataModel, this.convertMap);

//		3. layout
		rootGlyph.layout();

		return rootGlyph;
	}

	public VisualizedComposite buildGlyph() {
		return null;
	}
}

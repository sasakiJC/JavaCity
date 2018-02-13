package dev.javacity.core.visual;

import java.util.Map;

import javacity.model.DataModel;

public interface Structure {
//	1. 各エンティティのViewを作成(葉に当たるViewの大きさはここで確定)
//	2. StructorがViewの階層構造を作成(e.g. 親：packageDistrict, 子:classBuilding)
//	3. layout
//	void structure(DataModel dataModel, Map<SoftwareEntity, VisualizedComponent> allmap);

	CityView structure(DataModel dataModel, Map<Class<?>, MVConverter> convertMap);

}

package dev.javacity.core;

import dev.javacity.core.importer.kdm.KDMImporter;
import dev.javacity.core.logic.Logic;
import dev.javacity.core.models.city.CityModel;
import dev.javacity.core.models.data.DataModel;
import dev.javacity.core.models.metaphor.MetaphorImporter;
import dev.javacity.core.models.metaphor.MetaphorModel;
import dev.javacity.core.models.view.ViewImporter;
import dev.javacity.core.models.view.ViewModel;
import dev.javacity.core.observer.ObserverManager;
import javafx.scene.SubScene;

public class Core {

	private DataModel dataModel;
	private MetaphorModel metaphorModel;
	private ViewModel viewModel;
	private CityModel sceneModel;
	private KDMImporter kdmImporter;
	private MetaphorImporter metaphorImporter;
	private ViewImporter viewImporter;


	public void init(SubScene subscene) {
		// create model instances

		this.dataModel = new DataModel();
		this.metaphorModel = new MetaphorModel();
		this.viewModel = new ViewModel();
		this.sceneModel = new CityModel();


		// create data model importers
		this.kdmImporter = new KDMImporter(dataModel);
		Logic.getInstance().getSavesManager().init(dataModel);

		// create and initialize model to model importers
		this.metaphorImporter = new MetaphorImporter(metaphorModel);
		this.viewImporter = new ViewImporter(viewModel);
		Logic.getInstance().getCityController().init(sceneModel);

		// connect by observer pattern
		ObserverManager.getInstance().connect(dataModel, sceneModel, metaphorModel, metaphorImporter, viewImporter);
		viewModel.init(subscene);
	}

	public void importFile() {

	}

}

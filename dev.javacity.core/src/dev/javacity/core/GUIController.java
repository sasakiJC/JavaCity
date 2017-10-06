package dev.javacity.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;

import dev.javacity.core.importer.kdm.KDMImporter;
import dev.javacity.core.logic.Logic;
import dev.javacity.core.models.city.CityModel;
import dev.javacity.core.models.data.DataModel;
import dev.javacity.core.models.metaphor.MetaphorImporter;
import dev.javacity.core.models.metaphor.MetaphorModel;
import dev.javacity.core.models.view.ViewImporter;
import dev.javacity.core.models.view.ViewModel;
import dev.javacity.core.observer.ObserverManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.layout.StackPane;


public class GUIController implements Initializable{
	@FXML
	MenuBarController menubarController;
	@FXML
	StackPane pane1;

	@FXML
	StackPane pane3;

	private static final Logger LOGGER = Logger.getLogger(GUIController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

		// create model instances
		final DataModel dataModel = new DataModel();
		final MetaphorModel metaphorModel = new MetaphorModel();
		final ViewModel viewModel = new ViewModel();
		final CityModel sceneModel = new CityModel();

		// create data model importers
		final KDMImporter kdmImporter = new KDMImporter(dataModel);
		Logic.getInstance().getSavesManager().init(dataModel);

		// create and initialize model to model importers
		final MetaphorImporter metaphorImporter = new MetaphorImporter(metaphorModel);
		final ViewImporter viewImporter = new ViewImporter(viewModel);
		Logic.getInstance().getCityController().init(sceneModel);

		// connect by observer pattern
		ObserverManager.getInstance().connect(dataModel, sceneModel, metaphorModel, metaphorImporter, viewImporter);

		Group root = new Group();
		SubScene subscene = new SubScene(root, 640, 320);
		pane1.getChildren().add(subscene);

		//final PerspectiveCamera camera = new PerspectiveCamera(true);
		TestCamera tes = new TestCamera();
		final PerspectiveCamera camera = TestCamera.build(root);

		subscene.setCamera(camera);
		tes.handleMouse(subscene, root);
		viewModel.init(subscene);

    	menubarController.set(dataModel, kdmImporter);

    	Bundle bundle = Activator.getDefault().getBundle();
    	try {
			InputStream stream = bundle.getEntry("resource/sample/KDMSample.xml").openStream();
			kdmImporter.importFromFile(stream);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//    	System.out.println(bundle.getEntry("resource/sample/KDMSample.xml"));
//    	System.out.println(bundle.getDataFile("resource/sample/KDMSample.xml"));
    	}
}

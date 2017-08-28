package javacity;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javacity.importer.kdm.KDMImporter;
import javacity.logic.Logic;
import javacity.models.city.CityModel;
import javacity.models.data.DataModel;
import javacity.models.metaphor.MetaphorImporter;
import javacity.models.metaphor.MetaphorModel;
import javacity.models.view.ViewImporter;
import javacity.models.view.ViewModel;
import javacity.observer.ObserverManager;
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
		Group g = new Group();
		root.getChildren().add(g);
		SubScene subscene = new SubScene(root, 640, 320);
		pane1.getChildren().add(subscene);

		//final PerspectiveCamera camera = new PerspectiveCamera(true);
		TestCamera tes = new TestCamera();
		final PerspectiveCamera camera = TestCamera.build(root);

		subscene.setCamera(camera);
		tes.handleMouse(subscene, root);
		viewModel.init(subscene);

    	menubarController.set(dataModel, kdmImporter);

    }
}

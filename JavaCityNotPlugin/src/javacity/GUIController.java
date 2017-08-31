package javacity;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import dev.javacity.core.Core;
import dev.javacity.core.TestCamera;
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

		Group root = new Group();
		Group g = new Group();
		root.getChildren().add(g);
		SubScene subscene = new SubScene(root, 640, 320);
		pane1.getChildren().add(subscene);

		//final PerspectiveCamera camera = new PerspectiveCamera(true);
		TestCamera tes = new TestCamera();
		final PerspectiveCamera camera = TestCamera.build(root);

		Core core = new Core();
		core.init(subscene);
		subscene.setCamera(camera);
		tes.handleMouse(subscene, root);

//    	menubarController.set(dataModel, kdmImporter);

    }
}

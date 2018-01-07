package javacity.views;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import dev.javacity.core.visual.CityView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class TestGUIController implements Initializable{
//	@FXML
//	MenuBarController menubarController;
	@FXML
	StackPane pane1;

	private CityView cityView;

	private static final Logger LOGGER = Logger.getLogger(TestGUIController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void showCityView(CityView cityView) throws CoreException {
    	this.cityView = cityView;
//    	CityScene scene = new CityScene(this.cityView, 640, 320);
//    	this.pane1.getChildren().add(scene);
    }

}

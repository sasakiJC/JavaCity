package javacity.views;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import dev.javacity.core.CodeElementApplicationService;
import dev.javacity.core.visual.CityScene;
import dev.javacity.core.visual.CityView;
import dev.javacity.core.visual.VisualizeMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class TestGUIController implements Initializable{
//	@FXML
//	MenuBarController menubarController;
	@FXML
	StackPane pane1;

	private CityView cityView;

	private VisualizeMapper visualizeMapper;

	private CodeElementApplicationService service;

	private static final Logger LOGGER = Logger.getLogger(TestGUIController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.service = new CodeElementApplicationService();
    	this.visualizeMapper = new VisualizeMapper(this.service);
   }

    public void importData(IProject project) throws CoreException {
    	this.cityView = this.visualizeMapper.map();
    	CityScene scene = new CityScene(this.cityView, 640, 320);
    	this.pane1.getChildren().add(scene);
    }

    public CodeElementApplicationService getService() {
    	return this.service;
    }
}

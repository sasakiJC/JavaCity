package dev.javacity.core;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import dev.javacity.core.importer.Importer;
import dev.javacity.core.models.CityView;
import dev.javacity.core.models.TestDataModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class TestGUIController implements Initializable{
	@FXML
	MenuBarController menubarController;
	@FXML
	StackPane pane1;

	private Importer importer;
	private CitySceneBuilder citySceneBuilder;

	private TestDataModel testDataModel;
	private CityView cityView;

	private VisualizeMapper visualizeMapper;

	private ProjectAnalyzer analyzer;



	private static final Logger LOGGER = Logger.getLogger(GUIController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.importer = new Importer();
    	this.analyzer = new ProjectAnalyzer();
    }

    public void importData(IProject project) {
    	try {
			this.analyzer.analyzeFrom(project);
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//    	this.testDataModel = this.importer.importFromFile(null);
//    	this.cityView = this.visualizeMapper.map(this.testDataModel);
//
//    	CityScene scene = new CityScene(this.cityView, 640, 320);
//    	this.pane1.getChildren().add(scene);



    }
}

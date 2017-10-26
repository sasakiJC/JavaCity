package dev.javacity.core;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import dev.javacity.core.infra.ProjectAnalyzer;
import dev.javacity.core.models.CityScene;
import dev.javacity.core.models.CityView;
import dev.javacity.core.models.DefaultEntityIdentifier;
import dev.javacity.core.models.DefaultRepository;
import dev.javacity.core.models.Repository;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetPackage;
import dev.javacity.core.models.TestDataModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class TestGUIController implements Initializable{
	@FXML
	MenuBarController menubarController;
	@FXML
	StackPane pane1;

	private TestDataModel testDataModel;
	private CityView cityView;

	private VisualizeMapper visualizeMapper;

//	private TestFacade facade;
	private Repository<DefaultEntityIdentifier, TargetPackage> packageRepository;
	private Repository<DefaultEntityIdentifier, TargetClass> classRepository;
	private ProjectAnalyzer analyzer;



	private static final Logger LOGGER = Logger.getLogger(GUIController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		this.packageRepository = new DefaultRepository<DefaultEntityIdentifier, TargetPackage>();
		this.classRepository = new DefaultRepository<DefaultEntityIdentifier, TargetClass>();
    	this.analyzer = new ProjectAnalyzer(this.packageRepository, this.classRepository);
    }

    public void importData(IProject project) throws CoreException {
    	this.analyzer.analyzeFrom(project);
		this.testDataModel = this.analyzer.analyzeFrom(project);
    	this.cityView = this.visualizeMapper.map(this.testDataModel);
    	CityScene scene = new CityScene(this.cityView, 640, 320);
    	this.pane1.getChildren().add(scene);



    }
}

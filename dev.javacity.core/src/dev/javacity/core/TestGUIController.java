package dev.javacity.core;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import dev.javacity.core.importer.Importer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class TestGUIController implements Initializable{
	@FXML
	MenuBarController menubarController;
	@FXML
	StackPane pane1;

	@FXML
	StackPane pane3;

	private Importer importer;



	private static final Logger LOGGER = Logger.getLogger(GUIController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.importer = new Importer();

    }

    public void importData(URL importFileURL) {

    }
}

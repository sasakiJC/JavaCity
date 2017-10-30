package dev.javacity.core.tmp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import dev.javacity.core.configuration.Language;
import dev.javacity.core.importer.kdm.AbstractKDMImporter;
import dev.javacity.core.logic.Logic;
import dev.javacity.core.logic.SavesController;
import dev.javacity.core.logic.SnapshotManager;
import dev.javacity.core.models.data.DataModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class MenuBarController implements Initializable {
	@FXML
	MenuItem menuitem_IS;
	@FXML
	MenuItem menuitem_S;
	@FXML
	CheckMenuItem checkmenuitem;

	SimpleBooleanProperty ISproperty;
	SimpleBooleanProperty IDproperty;
	SimpleBooleanProperty Sproperty;

	private DataModel model;
	private AbstractKDMImporter kdmImporter;
	private SnapshotManager snapshotManager;


	private static final Logger LOGGER = Logger.getLogger(MenuBarController.class);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
		//checkmenuitem.setSelected(configuration.Configuration.getInstance().isShowExecPathEnabled());
    }

    public void set(DataModel datamodel, AbstractKDMImporter kdmImporter) {
    	this.model = datamodel;
    	this.kdmImporter = kdmImporter;
    }

    /*======================================================================================
    FILE MENU
    ========================================================================================*/
    public void importStaticsAction (ActionEvent event){

//    	this.kdmImporter.importFromFile(Activator.getDefault().getBundle().getDataFile("/resource/sample/KDMSample.xml").getAbsolutePath());

//    	final FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Staticsファイル選択");
//		fileChooser.setInitialDirectory(new File("C:\\Source\\java"));
//		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(Language.getInstance().get("filefilter.xml.description"), "xml"));
//
//		// start importing
//		File selectedFile = fileChooser.showOpenDialog(null);
//		if (selectedFile != null) {
//			try {
//				//Logic.getInstance().getPropertiesController().removeAllContent();
//				menuitem_IS.setDisable(true);
//				this.kdmImporter.importFromFile(selectedFile.getAbsolutePath());
//				menuitem_S.setDisable(false);
//				//Logic.getInstance().getMenuBarController().setSearchItemEnabled(true);
//				if (LOGGER.isDebugEnabled()) {
//					LOGGER.debug("Successfully imported statics from file " + selectedFile.getAbsolutePath() + ".");
//				}
//			} catch (KDMImportException | IllegalStateException e) {
//				LOGGER.error("Failed to import KDM file", e);
//				//JOptionPane.showMessageDialog(null, Language.getInstance().get("kdm.error.message"), Language.getInstance().get("kdm.error.title"),
//						//JOptionPane.ERROR_MESSAGE);
//			} finally {
//				menuitem_IS.setDisable(false);
//			}
//
//		}
    }

    public void loadAction (ActionEvent event){
    	final FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("loadファイル選択");
		fileChooser.setInitialDirectory(new File("C:\\Source\\java"));
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(Language.getInstance().get("filefilter." + SavesController.SAVES_ENDING + ".description"),SavesController.SAVES_ENDING));

		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			try {
				Logic.getInstance().getSavesManager().load(selectedFile);
			} catch (IllegalArgumentException | ClassNotFoundException | IOException e) {
				LOGGER.error("Failed to load visualization.", e);
//				JOptionPane.showMessageDialog(this.menuBar, Language.getInstance().get("file.load.error.message"),
//						Language.getInstance().get("file.load.error.title"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

    public void saveAction (ActionEvent event){
    	final FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("saveファイル選択");
		fileChooser.setInitialDirectory(new File("C:\\Source\\java"));
		fileChooser.setInitialFileName("save." + SavesController.SAVES_ENDING);
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(Language.getInstance().get("filefilter." + SavesController.SAVES_ENDING + ".description"),
				SavesController.SAVES_ENDING));


   		// start saving

		File selectedFile = fileChooser.showSaveDialog(null);
		if (selectedFile != null) {
			String filename = selectedFile.getAbsolutePath();
			try {
				final String fileEnding = "." + SavesController.SAVES_ENDING;
				if (!filename.endsWith(fileEnding)) {
					filename += fileEnding;
				}
				Logic.getInstance().getSavesManager().save(new File(filename));
			} catch (IllegalArgumentException | IOException e) {
				LOGGER.error("Failed to save visualization.", e);
//				DataModelUtils.restoreMappings(this.model.getRoot(), this.model.getTraces());
//				new File(filename).delete();
//				JOptionPane.showMessageDialog(this.menuBar, Language.getInstance().get("file.save.error.message"),
//						Language.getInstance().get("file.save.error.title"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

    public void exitAction (ActionEvent event){
		//Logic.getInstance().getCanvasController().cleanUp();
		System.exit(0);
    }


    /*======================================================================================
    EDIT MENU
    ========================================================================================*/


	public void searchAction() {

		Stage stage = new Stage();
		Stage TestAlert = new TestAlert(stage, "The deadline is coming closer.");
		TestAlert.show();

		//this.searchWindow.rebuild();
		//this.searchWindow.setVisible(true);
	}

	public void settingAction() {
		//this.settingsWindow.rebuild();
		//this.settingsWindow.setVisible(true);

		Stage stage = new Stage();
		Parent root=null;
		try {
			root = FXMLLoader.load(getClass().getResource("setting_color.fxml"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void showExecPathAction(){
	    checkmenuitem.selectedProperty().addListener(
	            (ObservableValue<? extends Boolean> ov, Boolean old_val,
	            Boolean new_val) -> {
//	    			Configuration.getInstance().setShowExecutionPath(new_val);
//	    			Logic.getInstance().getCityController().setShowExecutionPath(new_val);
	        });
	}

    /*======================================================================================
    SNAPSHOT MENU
    ========================================================================================*/

	public void saveSnapshotAction(ActionEvent event) {

    	final FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Snapshotファイル選択");
		fileChooser.setInitialDirectory(new File("C:\\Source\\java"));
		fileChooser.setInitialFileName("snapshot." + SnapshotManager.getImageFormat());
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(Language.getInstance().get("filefilter." + SnapshotManager.getImageFormat() + ".description"),
				SnapshotManager.getImageFormat()));


   		// start saving

		File selectedFile = fileChooser.showSaveDialog(null);
		if (selectedFile != null) {
			String filename = selectedFile.getAbsolutePath();
			try {
				final String fileEnding = "." + SavesController.SAVES_ENDING;
				if (!filename.endsWith(fileEnding)) {
					filename += fileEnding;
				}
				this.snapshotManager.saveSnapshot(filename);
			} catch (IllegalArgumentException | IOException e) {
				LOGGER.error("Failed to take or save snapshot.", e);
//				JOptionPane.showMessageDialog(this.menuBar, Language.getInstance().get("snapshot.save.error.message"),
//						Language.getInstance().get("snapshot.save.error.title"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void printSnapshotAction(ActionEvent event) {
		this.snapshotManager.printSnapshot();
	}

    /*======================================================================================
    RELATION MENU
    ========================================================================================*/


	public void showLocalRelationsAction(ActionEvent event) {

//		final Node selected = Logic.getInstance().getSelectionController().getSelectedNode();
//		if (selected != null && selected.getUserData() instanceof RegularFloor) {
//
//			// show relations
//			Logic.getInstance().getSelectionController().hidePopup();
//			Logic.getInstance().getCityController().showLocalRelations((SClass) ((RegularFloor) selected.getUserData()).getBuilding().getDataObject());
//		}
	}

	/**
	 * Display all relations of the application currently visible on screen.
	 */
	public void showGlobalRelationsAction(ActionEvent event) {

		// show relations
		Logic.getInstance().getSelectionController().hidePopup();
		Logic.getInstance().getCityController().showGlobalRelations();
	}

	/**
	 * Hides all relations currently visible on screen.
	 */
	public void hideAllRelationsAction(ActionEvent event) {

		Logic.getInstance().getCityController().removeVisibleRelations();
	}


}

package javacity.views;

import java.io.IOException;
import java.net.URL;

import org.eclipse.fx.ui.workbench3.FXViewPart;

import dev.javacity.core.Activator;
import dev.javacity.core.TestGUIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MyViewPart extends FXViewPart {

	private Parent root = new Group();
	private TestGUIController controller;

	@Override
	protected Scene createFxScene() {
		URL entry = Activator.getDefault().getBundle().getEntry("/resource/fxml/GUI.fxml");
		FXMLLoader loader = new FXMLLoader(entry);


		try {
			root = loader.load();
			this.controller = loader.getController();
		} catch (IOException e) {
//			 TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if(root == null)
			root = new BorderPane();

		Scene scene = new Scene(root);
		return scene;
	}

	@Override
	protected void setFxFocus() {
//		this.root.requestFocus();
	}

	public TestGUIController getController() {
		return this.controller;
	}


}
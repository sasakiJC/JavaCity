package javacity.views;

import java.io.IOException;
import java.net.URL;

import org.eclipse.fx.ui.workbench3.FXViewPart;

import javacity.Activator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class CityViewPart extends FXViewPart {

	private Parent root = new Group();
	private GUIController controller;

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
		this.root.requestFocus();
		System.out.println(this.root.getOnKeyPressed());
	}

	public GUIController getController() {
		return this.controller;
	}


}
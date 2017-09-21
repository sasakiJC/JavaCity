package dev.javacity.core;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class WindowBuilder {

	public Scene createScene() {
		return this.createScene( Activator.getDefault().getBundle().getEntry("/resource/fxml/GUI.fxml"));
	}

	public Scene createScene(URL url) {
		Parent root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
//			 TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if(root == null)
			root = new BorderPane();

		Scene scene = new Scene(root);
		return scene;

	}
}
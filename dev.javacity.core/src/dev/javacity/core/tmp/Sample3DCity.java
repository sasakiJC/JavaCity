package dev.javacity.core.tmp;

import java.io.IOException;
import java.net.URL;

import dev.javacity.core.Activator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Sample3DCity {

	public Scene createScene() {
		Parent root = null;
//		try {
//			System.out.println(getClass().getResource("GUI.fxml"));
//			root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

		URL entry = Activator.getDefault().getBundle().getEntry("/resource/fxml/GUI.fxml");
		try {
			root = FXMLLoader.load(entry);
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

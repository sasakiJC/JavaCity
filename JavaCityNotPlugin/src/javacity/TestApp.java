package javacity;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TestApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		URL entry = this.getClass().getResource("/fxml/GUI.fxml");

//		URL entry = Activator.getDefault().getBundle().getEntry("/resource/fxml/GUI.fxml");
		Parent root = null;
		try {
			root = FXMLLoader.load(entry);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(root == null)
			root = new BorderPane();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		launch(args);
	}

}

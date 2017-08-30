package javacity.views;

import org.eclipse.fx.ui.workbench3.FXViewPart;

import dev.javacity.core.Sample3DCity;
import javafx.scene.Group;
import javafx.scene.Scene;

public class MyViewPart extends FXViewPart {

	private Group root = new Group();

	@Override
	protected Scene createFxScene() {

//		Test3DModel model = new Test3DModel();
		Sample3DCity model = new Sample3DCity();
//		Parent root = null;
//		try {
//			System.out.println(getClass().getResource("GUI.fxml"));
//			root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

//		URL entry = Activator.getDefault().getBundle().getEntry("/resource/fxml/GUI.fxml");
//		try {
//			root = FXMLLoader.load(entry);
//		} catch (IOException e) {
////			 TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//		if(root == null)
//			root = new BorderPane();
//
//		Scene scene = new Scene(root);

		return model.createScene();
	}

	@Override
	protected void setFxFocus() {
//		this.root.requestFocus();
	}
}
package javacity.views;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import dev.javacity.core.visual.CityScene;
import dev.javacity.core.visual.CityView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Box;

public class GUIController implements Initializable{
//	@FXML
//	MenuBarController menubarController;
	@FXML
	StackPane pane1;

	private CityView cityView;

	private static final Logger LOGGER = Logger.getLogger(GUIController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void showCityView(CityView cityView) {
    	this.cityView = cityView;
    	Box box = new Box();
//    	box.addEventHandler(arg0, arg1);

    	box.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				switch(event.getButton()) {
				case MIDDLE:
					break;
				case NONE:
					break;
				case PRIMARY:
					box.setHeight(box.getHeight() * 1.5);
					break;
				case SECONDARY:
					box.setHeight(box.getHeight() / 1.5 );
					break;
				default:
					break;

				}

			}
    	});
    	this.cityView.addNode(box);
    	CityScene scene = new CityScene(this.cityView, 640, 320);
    	this.pane1.getChildren().add(scene);
    }

}

package dev.javacity.core.tmp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;


public class TestAlert extends Stage {
	public TestAlert(Window owner, String message){
		initStyle(StageStyle.DECORATED);
		initOwner(owner);
		initModality(Modality.APPLICATION_MODAL);
		
		Label content = new Label(message, createIcon());
		content.setGraphicTextGap(10);
		
		Button okButton = new Button("OK");
		okButton.setPrefWidth(80);
		okButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				close();
			}
		});
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setSpacing(20);
		root.getChildren().addAll(content, okButton);
		
		setScene(new Scene(root));
		
	}
	
	private Node createIcon() {
		double width = 48;
		double height = Math.sqrt(Math.pow(width, 2) - Math.pow(width/2, 2));
		
		Polygon shape = new Polygon(new double[] { 0, height, width/2, 0, width, height});
		shape.setFill(Color.BLACK);
		
		Text text = new Text("CAUTION");
		text.setStroke(Color.WHITE);
		text.setFont(Font.font(8));
		text.relocate((width - text.getLayoutBounds().getWidth())/2, height - text.getLayoutBounds().getHeight());
		
		return new Group(shape, text);
	}
}

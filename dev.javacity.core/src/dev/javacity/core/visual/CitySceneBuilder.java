package dev.javacity.core.visual;

import javafx.scene.AmbientLight;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;

public class CitySceneBuilder {


	void build(SubScene subScene) {
		subScene.setFill(Color.WHITE);
	}

	private void light(SubScene subScene) {
		// add lightning
		final AmbientLight amblight = new AmbientLight(Color.WHITE);
		this.addNode(amblight);
	}

	private void camera(SubScene subScene) {
		//subScene.getCamera().setNearClip(1);
		//subScene.getCamera().setFarClip(100);
	}
}

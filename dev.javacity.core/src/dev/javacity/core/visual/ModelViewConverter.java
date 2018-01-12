package dev.javacity.core.visual;

import javacity.model.TargetEntity;

public class ModelViewConverter {

	private TargetEntity entity;
	private String glyph;
	private VisLayout layout;


	public VisualizedComponent toView() {
		switch(this.glyph) {
			case "cuboid":
				return new Building(this.entity, this.layout);




				break;
			case "terrain":
				break;
			default :
				System.out.println(this.glyph);

		}

		return null;
	}

}

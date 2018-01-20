package dev.javacity.core.visual;

import javacity.model.SoftwareEntity;

public class ModelViewConverter {

	private SoftwareEntity entity;
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

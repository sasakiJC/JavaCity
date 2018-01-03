package javacity.config;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

public class GlyphGroup extends Group {

//	Group glyphGroup = new Group(container, SWT.NONE);

	Combo glyphCombo;
	Label label;
	List mappingList;

	private ConfigModelElement modelElement;


//	ConfigModelElement modelElm = conf.getDefaultModelElement();
//	ConfigGlyph confGlyph = modelElm.configGlyph;


	public GlyphGroup(Composite parent, int style) {
		super(parent, style);
		this.setText("Glyph");
		this.setLayout(new GridLayout());
		this.glyphCombo = new Combo (this, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
		this.label = new Label (this, SWT.LEFT);
		this.label.setText("Mappings");
		this.mappingList = new List(this, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
	}

	public void addGlyphs(ConfigModelElement modelElement) {
		this.modelElement = modelElement;
		this.glyphCombo.setItems(modelElement.glyphs);
		this.glyphCombo.setText(modelElement.configGlyph.name);
	}

	public void addMappings(ConfigGlyph confGlyph) {
		this.mappingList.setItems(confGlyph.attributes);
	}


	public void updateGlyphs(ConfigModelElement modelElement) {
		this.glyphCombo.removeAll();
		this.addGlyphs(modelElement);
		this.updateMappings(modelElement.configGlyph);
	}

	public void updateMappings(ConfigGlyph confGlyph) {
		this.mappingList.removeAll();
		this.addMappings(confGlyph);
	}

	public void test() {
		this.glyphCombo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
//				eventもしくはthis.glyphCombo.getSelectionIndex()?などでセレクトされたものを取得

//				取得されたものの名前Stringを取得してそれで、mappingを取得し、updateMappingで
//				updateMappings();


			}

		});
	}

}

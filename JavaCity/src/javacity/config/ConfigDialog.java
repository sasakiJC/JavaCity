package javacity.config;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ConfigDialog extends Dialog {

	private ViewConfig conf;

	public ConfigDialog(Shell parent, ViewConfig conf) {
		super(parent);
		this.conf = conf;
	}


	@Override
	protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);

//		Stream<ConfigModelElement> test = Arrays.stream(modelElementList);
//		String[] str = test.map(item->item.getName()).toArray(size->new String[size]);
//		JAXB.marshal(conf, System.out);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);

		this.createModelListGroup(container, conf);
		this.createGlyphGroup(container, conf);
		this.createInnerLayoutGroup(container, conf);


//        Button button = new Button(modelListGroup, SWT.PUSH);
//        button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
//                false));
//        button.setText("Press me");
//        button.addSelectionListener(new SelectionAdapter() {
//            @Override
//            public void widgetSelected(SelectionEvent e) {
//                System.out.println("Pressed");
//            }
//        });

        return container;
	}

	private void createInnerLayoutGroup(Composite container, ViewConfig conf) {
		Group innerLayoutGroup = new Group(container, SWT.NONE);
		innerLayoutGroup.setText("Inner Layout");
		innerLayoutGroup.setLayout(new GridLayout());

		ConfigInnerLayout layout = conf.getDefaultModelElement().configInnerLayout;

		Combo layoutCombo = new Combo(innerLayoutGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
		layoutCombo.setItems(getInnerLayout());
	}


	private void createGlyphGroup(Composite container, ViewConfig conf) {

		Group glyphGroup = new Group(container, SWT.NONE);
		glyphGroup.setText("Glyph");
		glyphGroup.setLayout(new GridLayout());

		ConfigModelElement modelElm = conf.getDefaultModelElement();
		ConfigGlyph confGlyph = modelElm.configGlyph;

		Combo glyphCombo = new Combo (glyphGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
		glyphCombo.setItems(modelElm.glyphs);
		glyphCombo.setText(confGlyph.name);


		Label label = new Label (glyphGroup, SWT.LEFT);
		label.setText("Mappings");
		List mappingList = new List(glyphGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		mappingList.setItems(confGlyph.attributes);
	}

// 	private void createGlyphGroup(Composite container, ViewConfig conf) {
//		GlyphGroup glyphGroup = new GlyphGroup(container, SWT.NONE);
//
//		ConfigModelElement modelElm = conf.getDefaultModelElement();
//		ConfigGlyph confGlyph = modelElm.configGlyph;
//
//		glyphGroup.addModelElements(modelElm);
//
//		glyphCombo.setItems(modelElm.glyphs);
//		glyphCombo.setText(confGlyph.name);
//
//		label.setText("Mappings");
//		List mappingList = new List(glyphGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
//		mappingList.setItems(confGlyph.attributes);
////		mappingList.setItems(getTerrainMappings());
//
// 	}


	private void createModelListGroup(Composite parent, ViewConfig conf) {

		Group modelListGroup = new Group(parent, SWT.NONE);
		modelListGroup.setText("Model Element");
		modelListGroup.setLayout(new GridLayout());
//		modelListGroup.setLayoutData (new GridData (SWT.LEFT, SWT.LEFT, true, true));


		List list = new List(modelListGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		list.setItems(conf.getElementNames());
		ConfigModelElement defaultElm = conf.getDefaultModelElement();

		list.setSelection(list.indexOf(defaultElm.name));

		list.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				// TODO 自動生成されたメソッド・スタブ
				System.out.println(event);
			}
		});


		Button checkButton = new Button(modelListGroup, SWT.CHECK);
		checkButton.setText("Visib");
		checkButton.setSelection(defaultElm.isVisible);
//		checkButton.addSelectionListener (new SelectionAdapter () {
//			public void widgetSelected (SelectionEvent event) {
//				setExampleWidgetVisibility ();
//			}
//		});
	}


    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Selection dialog");
    }

    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }

//	public String[] getModelElements() {
//	return new String[]{"system", "package", "class", "method", "attribute", "inheritance", "invocation", "access"};
//}
//
//
public String[] getTerrainMappings() {
	return new String[]{"color", "alpha", "width", "length", "terrainThickness"};
}
//
//public String[] getCuboidMappings() {
//	return new String[]{"color", "alpha", "width", "length", "height"};
//}
//
//public String[] getLineMappings() {
//	return new String[] {"color", "alpha"};
//}
//
public String[] getInnerLayout() {
	return new String[]{"chessboard", "circle", "rectangle packing", "concentrical", "quadratic", "line", "spiral", "progressive bricks", "bricks"};
}

//    private void createTemp() {
//		ConfigModelElement systemElm = new ConfigModelElement("system", true, ConfigModelElement.GLYPHS,
//				new ConfigGlyph("terrain", getTerrainMappings()),
//				new ConfigMapping[]{
//						ViewConfig.DEFAULT_COLOR_MAPPER,
//						new ConfigMapping("alpha", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"0"}),
//						ViewConfig.DEFAULT_WIDTH_MAPPER,
//						ViewConfig.DEFAULT_LENGTH_MAPPER,
//						ViewConfig.DEFAULT_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_WALL_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_WALL_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_ROOFTOP_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_TERRAIN_THICKNESS_MAPPER
//						},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.RectanglePackingLayout", 8, 8, 0.2f, 1)
//			);
//
//		ConfigModelElement packageElm = new ConfigModelElement("package", true, ConfigModelElement.GLYPHS,
//				new ConfigGlyph("terrain", getTerrainMappings()),
//				new ConfigMapping[]{
//						new ConfigMapping("color", "dev.javacity.core.visual.mapper.CcolorLinearMapper", new String[]{"#DIH", "gray,white","linear"}),
//						ViewConfig.DEFAULT_ALPHA_MAPPER,
//						new ConfigMapping("width", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"15"}),
//						new ConfigMapping("length", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"15"}),
//						ViewConfig.DEFAULT_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_WALL_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_WALL_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_ROOFTOP_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_TERRAIN_THICKNESS_MAPPER
//				},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.RectanglePackingLayout", 8, 8, 0.2f, 1)
//			);
//
//		ConfigModelElement classElm = new ConfigModelElement("class", true, ConfigModelElement.GLYPHS,
//				new ConfigGlyph("cuboid", getCuboidMappings()),
//				new ConfigMapping[]{
//						new ConfigMapping("color", "dev.javacity.core.visual.mapper.CcolorLinearMapper", new String[]{"#LOC", "gray,blue","linear"}),
//						ViewConfig.DEFAULT_ALPHA_MAPPER,
//						new ConfigMapping("width", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
//						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
//						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOM"}),
//						ViewConfig.DEFAULT_WALL_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_WALL_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_ROOFTOP_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_TERRAIN_THICKNESS_MAPPER
//				},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.ChessboardLayout", 4, 8, 0.2f, 1)
//			);
//
//		ConfigModelElement methodElm = new ConfigModelElement("method", false, ConfigModelElement.GLYPHS,
//				new ConfigGlyph("cuboid", getCuboidMappings()),
//				new ConfigMapping[]{
//						new ConfigMapping("color", "dev.javacity.core.visual.mapper.CcolorLinearMapper", new String[]{"#LOC", "gray,blue","linear"}),
//						ViewConfig.DEFAULT_ALPHA_MAPPER,
//						new ConfigMapping("width", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
//						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
//						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOM"}),
//						ViewConfig.DEFAULT_WALL_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_WALL_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_ROOFTOP_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_TERRAIN_THICKNESS_MAPPER
//				},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.ChessboardLayout")
//			);
//
//		ConfigModelElement attributesElm = new ConfigModelElement("attributes", false, ConfigModelElement.GLYPHS,
//				new ConfigGlyph("cuboid", getCuboidMappings()),
//				new ConfigMapping[]{
//						ViewConfig.DEFAULT_COLOR_MAPPER,
//						ViewConfig.DEFAULT_ALPHA_MAPPER,
//						ViewConfig.DEFAULT_WIDTH_MAPPER,
//						ViewConfig.DEFAULT_LENGTH_MAPPER,
//						ViewConfig.DEFAULT_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_WALL_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_WALL_HEIGHT_MAPPER,
//						ViewConfig.DEFAULT_ROOFTOP_THICKNESS_MAPPER,
//						ViewConfig.DEFAULT_TERRAIN_THICKNESS_MAPPER
//				},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.ChessboardLayout")
//			);
//
//		ConfigModelElement inheritanceElm = new ConfigModelElement("inheritance", false, ConfigModelElement.ARCH_GLYPHS,
//				new ConfigGlyph("line", getLineMappings()),
//				new ConfigMapping[]{
//						ViewConfig.DEFAULT_COLOR_MAPPER,
//						ViewConfig.DEFAULT_ALPHA_MAPPER,
//				},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.ChessboardLayout")
//			);
//
//		ConfigModelElement invocationElm = new ConfigModelElement("invocation", false, ConfigModelElement.ARCH_GLYPHS,
//				new ConfigGlyph("line", getLineMappings()),
//				new ConfigMapping[]{
//						ViewConfig.DEFAULT_COLOR_MAPPER,
//						ViewConfig.DEFAULT_ALPHA_MAPPER,
//				},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.ChessboardLayout")
//			);
//
//		ConfigModelElement accessElm = new ConfigModelElement("access", false, ConfigModelElement.ARCH_GLYPHS,
//				new ConfigGlyph("line", getLineMappings()),
//				new ConfigMapping[]{
//						ViewConfig.DEFAULT_COLOR_MAPPER,
//						ViewConfig.DEFAULT_ALPHA_MAPPER,
//				},
//				new ConfigInnerLayout("dev.javacity.core.visual.layout.ChessboardLayout")
//			);
//		ConfigModelElement[] modelElementList = new ConfigModelElement[]{systemElm, packageElm, classElm, methodElm, attributesElm, inheritanceElm, invocationElm, accessElm};
//
//		Map<String, ConfigModelElement> elements = new HashMap<String, ConfigModelElement>();
//		elements.put("system", systemElm);
//		elements.put("package", packageElm);
//		elements.put("class", classElm);
//		elements.put("method", methodElm);
//		elements.put("attributes", attributesElm);
//		elements.put("inheritance", inheritanceElm);
//		elements.put("invocation", invocationElm);
//		elements.put("access", accessElm);
//
//    }


}

package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import javacity.Activator;

public class ConfigDialog extends Dialog {

	public ConfigDialog(Shell parent) {
		super(parent);
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public String[] getModelElements() {
		return new String[]{"system", "package", "class", "method", "attribute", "inheritance", "invocation", "access"};
	}

	public String[] getGlyph() {
		return new String[]{"terrain", "well", "cuboid", "rooftop"};
	}

	public String[] getTerrainMappings() {
		return new String[]{"color", "alpha", "width", "length", "terrainThickness"};
	}

	public String[] getInnerLayout() {
		return new String[]{"chessboard", "circle", "rectangle packing", "concentrical", "quadratic", "line", "spiral", "progressive bricks", "bricks"};
	}

	public String[] getArchGlyph() {
		return new String[]{"line", "arch"};
	}



	@Override
	protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();


		store.setValue("test", "test");
		System.out.println(store.getString("test"));

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);

		ModelElement modelElm = new ModelElement();
		modelElm.modelListGroup(container);



		Group glyphGroup = new Group(container, SWT.NONE);
		glyphGroup.setText("Glyph");
		glyphGroup.setLayout(new GridLayout());

		Combo glyphCombo = new Combo (glyphGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
		String[] temp = getGlyph();
		glyphCombo.setItems (temp);
		if (temp.length >= 3) {
			glyphCombo.setText(temp[2]);
		}

		Label label = new Label (glyphGroup, SWT.LEFT);
		label.setText("Mappings");


		List mappingList = new List(glyphGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		mappingList.setItems(getTerrainMappings());

		Group innerLayoutGroup = new Group(container, SWT.NONE);
		innerLayoutGroup.setText("Inner Layout");
		innerLayoutGroup.setLayout(new GridLayout());

		Combo layoutCombo = new Combo(innerLayoutGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
		layoutCombo.setItems(getInnerLayout());




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

		ConfigModelElement systemElm = new ConfigModelElement("system", true,
				new ConfigGlyph("terrain", getTerrainMappings()),
				new ConfigMapping[]{
						ConfigMapping.DEFAULT_COLOR_MAPPING,
						new ConfigMapping("alpha", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"0"}),
						ConfigMapping.DEFAULT_WIDTH_MAPPING,
						ConfigMapping.DEFAULT_LENGTH_MAPPING,
						ConfigMapping.DEFAULT_HEIGHT_MAPPING,
						ConfigMapping.DEFAULT_WALL_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_WALL_HEIGHT_MAPPING,
						ConfigMapping.DEFAULT_ROOFTOP_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_TERRAIN_THICKNESS_MAPPING
						},
				new ConfigInnerLayout("dev.javacity.core.visual.layout.RectanglePackingLayout", 8, 8, 0.2f, 1)
			);

		ConfigModelElement packageElm = new ConfigModelElement("package", true,
				new ConfigGlyph("terrain", getTerrainMappings()),
				new ConfigMapping[]{
						new ConfigMapping("color", "dev.javacity.core.visual.mapper.CcolorLinearMapper", new String[]{"#DIH", "gray,white","linear"}),
						ConfigMapping.DEFAULT_ALPHA_MAPPING,
						new ConfigMapping("width", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"15"}),
						new ConfigMapping("length", "dev.javacity.core.visual.mapper.ConstantMapper", new String[]{"15"}),
						ConfigMapping.DEFAULT_HEIGHT_MAPPING,
						ConfigMapping.DEFAULT_WALL_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_WALL_HEIGHT_MAPPING,
						ConfigMapping.DEFAULT_ROOFTOP_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_TERRAIN_THICKNESS_MAPPING
				},
				new ConfigInnerLayout("dev.javacity.core.visual.layout.RectanglePackingLayout", 8, 8, 0.2f, 1)
			);

		ConfigModelElement classElm = new ConfigModelElement("class", true,
				new ConfigGlyph("cuboid", getTerrainMappings()),
				new ConfigMapping[]{
						new ConfigMapping("color", "dev.javacity.core.visual.mapper.CcolorLinearMapper", new String[]{"#LOC", "gray,blue","linear"}),
						ConfigMapping.DEFAULT_ALPHA_MAPPING,
						new ConfigMapping("width", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOM"}),
						ConfigMapping.DEFAULT_WALL_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_WALL_HEIGHT_MAPPING,
						ConfigMapping.DEFAULT_ROOFTOP_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_TERRAIN_THICKNESS_MAPPING
				},
				new ConfigInnerLayout("dev.javacity.core.visual.layout.RectanglePackingLayout", 4, 8, 0.2f, 1)
			);

		ConfigModelElement methodElm = new ConfigModelElement("method", false,
				new ConfigGlyph("cuboid", getTerrainMappings()),
				new ConfigMapping[]{
						new ConfigMapping("color", "dev.javacity.core.visual.mapper.CcolorLinearMapper", new String[]{"#LOC", "gray,blue","linear"}),
						ConfigMapping.DEFAULT_ALPHA_MAPPING,
						new ConfigMapping("width", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOA"}),
						new ConfigMapping("length", "dev.javacity.core.visual.mapper.IdentityMapper", new String[]{"#NOM"}),
						ConfigMapping.DEFAULT_WALL_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_WALL_HEIGHT_MAPPING,
						ConfigMapping.DEFAULT_ROOFTOP_THICKNESS_MAPPING,
						ConfigMapping.DEFAULT_TERRAIN_THICKNESS_MAPPING
				},
				new ConfigInnerLayout("dev.javacity.core.visual.layout.RectanglePackingLayout", 4, 8, 0.2f, 1)
			);
//
//        return container;
	}


	@XmlAttribute
	private String layoutId;
	@XmlAttribute
	private float HorizontalMargin;
	@XmlAttribute
	private float HorizontalGap;
	@XmlAttribute
	private float VerticalMargin;
	@XmlAttribute
	private float VerticalGap;

	class ModelElement {
		private String[] items = new String[]{"system", "package", "class", "method", "attribute", "inheritance", "invocation", "access"};

		public void modelListGroup(Composite parent) {

			Group modelListGroup = new Group(parent, SWT.NONE);
			modelListGroup.setText("Model Element");
			modelListGroup.setLayout(new GridLayout());
//			modelListGroup.setLayoutData (new GridData (SWT.LEFT, SWT.LEFT, true, true));


			List list = new List(modelListGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
			list.setItems(items);

			Button checkButton = new Button(modelListGroup, SWT.CHECK);
			checkButton.setText("Visib");
//			checkButton.addSelectionListener (new SelectionAdapter () {
//				public void widgetSelected (SelectionEvent event) {
//					setExampleWidgetVisibility ();
//				}
//			});
		}
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


}

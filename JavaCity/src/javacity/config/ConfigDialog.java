package javacity.config;

import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

import dev.javacity.core.Activator;
import dev.javacity.core.Glyph;

public class ConfigDialog extends Dialog {

	private CityConfig conf;

	private CityConfigService service;

	private ElementConfig nowSelectedElementConfig;

	public ConfigDialog(Shell parent, CityConfigService service) {
		super(parent);
		this.service = service;
		this.conf = this.service.loadDefault();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);

//		this.createModelListGroup(container, conf);
//		this.createGlyphGroup(container, conf);
//		this.createInnerLayoutGroup(container, conf);

		this.createTestM(container);
		this.createTestG(container);
		this.createTestI(container, conf);

        return container;
	}

	private void update(String elementName) {

	}

	private void createTestM(Composite container) {
		Group modelListGroup = new Group(container, SWT.NONE);
		modelListGroup.setText("Model Element");
		modelListGroup.setLayout(new GridLayout());
//		modelListGroup.setLayoutData (new GridData (SWT.LEFT, SWT.LEFT, true, true));

		List list = new List(modelListGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		list.setItems(this.conf.getElementNames());


		list.addSelectionListener(new SelectionAdapter () {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = list.getSelection()[0];
				System.out.println(e);
			}
		});

		this.nowSelectedElementConfig = this.conf.getElm(list.getItem(0));

		Button checkButton = new Button(modelListGroup, SWT.CHECK);
		checkButton.setText("Visib");
//		checkButton.setSelection(defaultElm.isVisible);
//		checkButton.addSelectionListener (new SelectionAdapter () {
//			public void widgetSelected (SelectionEvent event) {
//				setExampleWidgetVisibility ();
//			}
//		});
	}

	private void createTestG(Composite container) {
		Group glyphGroup = new Group(container, SWT.NONE);
		glyphGroup.setText("Glyph");
		glyphGroup.setLayout(new GridLayout());

//		ConfigModelElement modelElm = conf.getDefaultModelElement();
//		ConfigGlyph confGlyph = modelElm.configGlyph;

		Combo glyphCombo = new Combo (glyphGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
		Map<Class<?>, Glyph> glyphMap = Activator.getMetaphorExtensionLoader().getGlyphExtensions();
		String[] strTemp = glyphMap.values().stream().map(item -> {return item.getName();}).toArray(String[]::new);
		glyphCombo.setItems(strTemp);

		glyphCombo.setText(Activator.getMetaphorExtensionLoader().getGlyph(this.nowSelectedElementConfig.glyphClass).getName());
		Label label = new Label (glyphGroup, SWT.LEFT);
		label.setText("Mappings");
		List mappingList = new List(glyphGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		mappingList.setItems(Activator.getMetaphorExtensionLoader().getGlyph(this.nowSelectedElementConfig.glyphClass).getAttributes());
	}

	private void createTestI(Composite container, CityConfig conf) {
		Group innerLayoutGroup = new Group(container, SWT.NONE);
		innerLayoutGroup.setText("Inner Layout");
		innerLayoutGroup.setLayout(new GridLayout());

		ConfigInnerLayout layout = this.nowSelectedElementConfig.configInnerLayout;

		Combo layoutCombo = new Combo(innerLayoutGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);

		Map<Class<?>, String> layoutMap = Activator.getMetaphorExtensionLoader().getLayoutExtensionClasses();

//		Map<Class<?>, InnerLayout> layoutMap = Activator.getMetaphorExtensionLoader().getInnerLayoutExtensions();
//		String[] strTemp = layoutMap.values().stream().map(item -> {return item.getName();}).toArray(String[]::new);
		layoutCombo.setItems(layoutMap.values().toArray(new String[]{}));

		layoutCombo.setText(Activator.getMetaphorExtensionLoader().getInnerLayoutName(layout.layoutId));
	}


	private void createInnerLayoutGroup(Composite container, CityConfig conf) {
		Group innerLayoutGroup = new Group(container, SWT.NONE);
		innerLayoutGroup.setText("Inner Layout");
		innerLayoutGroup.setLayout(new GridLayout());

//		ConfigInnerLayout layout = conf.getDefaultModelElement().configInnerLayout;

		Combo layoutCombo = new Combo(innerLayoutGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
		layoutCombo.setItems(getInnerLayout());
	}


//	private void createGlyphGroup(Composite container, ViewConfig conf) {
//
//		Group glyphGroup = new Group(container, SWT.NONE);
//		glyphGroup.setText("Glyph");
//		glyphGroup.setLayout(new GridLayout());
//
//		ConfigModelElement modelElm = conf.getDefaultModelElement();
//		ConfigGlyph confGlyph = modelElm.configGlyph;
//
//		Combo glyphCombo = new Combo (glyphGroup, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SIMPLE);
//		glyphCombo.setItems(modelElm.glyphs);
//		glyphCombo.setText(confGlyph.name);
//
//
//		Label label = new Label (glyphGroup, SWT.LEFT);
//		label.setText("Mappings");
//		List mappingList = new List(glyphGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
//		mappingList.setItems(confGlyph.attributes);
//	}

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


	private void createModelListGroup(Composite parent, CityConfig conf) {

		Group modelListGroup = new Group(parent, SWT.NONE);
		modelListGroup.setText("Model Element");
		modelListGroup.setLayout(new GridLayout());
//		modelListGroup.setLayoutData (new GridData (SWT.LEFT, SWT.LEFT, true, true));

		List list = new List(modelListGroup, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
//		list.setItems(conf.getElementNames());

		String[] strTemp = javacity.model.Activator.getExtensionLoader().getElementExtensionClassNames().values().toArray(new String[]{});

//		String[] strTemp = javacity.model.Activator.getExtensionLoader().getElementExtensionNames();
		list.setItems(strTemp);

		list.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				// TODO 自動生成されたメソッド・スタブ
				System.out.println(event);
			}
		});


		Button checkButton = new Button(modelListGroup, SWT.CHECK);
		checkButton.setText("Visib");
//		checkButton.setSelection(defaultElm.isVisible);
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


}

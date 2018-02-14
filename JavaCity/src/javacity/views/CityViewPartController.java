package javacity.views;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import javacity.config.CityConfigService;
import javacity.config.ConfigDialog;
import javacity.model.DataModel;
import javacity.view.CityView;
import javacity.view.TestConverter;

public class CityViewPartController {

	final static String ID = "javacity.views.CityViewPart";
	private int i=0;

	private DataModel dataModel;
	private CityView cityView;


	public CityViewPartController(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void execute() {
//		Map<String, MVConverter> map = this.showConfigViewPart();
		TestConverter conv = this.showConfigViewPart();

		this.cityView = conv.convert(this.dataModel);

//		map.get("package").createVisualizedComponent(entity)
		this.showCityViewPart();
	}


	public TestConverter showConfigViewPart() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();

//		URL entry = Activator.getDefault().getBundle().getEntry("/resource/config.xml");
//		ViewConfig conf = JAXB.unmarshal(entry, ViewConfig.class);
        CityConfigService service = new CityConfigService();
        Dialog dialog = new ConfigDialog(activeWindow.getShell(), service);
        int result = dialog.open();

        if(result == 0) {

//        	MVConverter systemConverter = conf.toConverter("system");
//        	MVConverter packageConverter = conf.toConverter("package");
//        	MVConverter classConverter = conf.toConverter("class");
//
//        	Map<String, MVConverter> map = new HashMap<String, MVConverter>();
//        	map.put("system", systemConverter);
//        	map.put("package", packageConverter);
//        	map.put("class", classConverter);

//        	return map;
        	return service.getConverter();
        }else{
        	return null;
        }
	}

	public void showCityViewPart() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
//        IWorkbenchWindow activeWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchPage page = activeWindow.getActivePage();
		try {
			CityViewPart view =  (CityViewPart)page.showView(ID, "secondID"+i++, IWorkbenchPage.VIEW_VISIBLE);
			view.getController().showCityView(this.cityView);
			System.out.println("解析終了");
		} catch (PartInitException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}

}

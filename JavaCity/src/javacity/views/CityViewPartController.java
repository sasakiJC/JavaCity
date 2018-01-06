package javacity.views;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXB;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import dev.javacity.core.CodeElementApplicationService;
import dev.javacity.core.infra.ProjectAnalyzer;
import dev.javacity.core.visual.MVConverter;
import javacity.Activator;
import javacity.config.ConfigDialog;
import javacity.config.ViewConfig;

public class CityViewPartController {

	final static String ID = "javacity.views.CityViewPart";
	private int i=0;
	private IJavaProject selectedProject;

	private CodeElementApplicationService service;


	public CityViewPartController(IJavaProject selectedProject) {
		this.selectedProject = selectedProject;
		this.service = new CodeElementApplicationService();
	}

	public void execute() {
		this.analyzeProject();
		Map<String, MVConverter> map = this.showConfigViewPart();
//		CityView cityView = new CityView();

//		map.get("package").createVisualizedComponent(entity)
		this.showCityViewPart();
	}


	public Map<String, MVConverter> showConfigViewPart() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();

		URL entry = Activator.getDefault().getBundle().getEntry("/resource/config.xml");
		ViewConfig conf = JAXB.unmarshal(entry, ViewConfig.class);

        Dialog dialog = new ConfigDialog(activeWindow.getShell(), conf);
        int result = dialog.open();

        if(result == SWT.OK) {
        	MVConverter systemConverter = conf.toConverter("system");
        	MVConverter packageConverter = conf.toConverter("package");
        	MVConverter classConverter = conf.toConverter("class");

        	Map<String, MVConverter> map = new HashMap<String, MVConverter>();
        	map.put("system", systemConverter);
        	map.put("package", packageConverter);
        	map.put("class", classConverter);

        	return map;
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
//			view.getController().showCityView(cityView);
			System.out.println("解析終了");
		} catch (PartInitException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

	}

	public void analyzeProject() {
		ProjectAnalyzer analyzer = new ProjectAnalyzer(this.service);
		try {
			analyzer.analyzeFrom(selectedProject.getProject());
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

package javacity.views;

import java.net.URL;

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

import dev.javacity.core.infra.ProjectAnalyzer;
import javacity.Activator;
import javacity.config.ConfigDialog;
import javacity.config.ViewConfig;

public class CityViewPartController {

	final static String ID = "javacity.views.CityViewPart";
	private int i=0;
	private IJavaProject selectedProject;


	public CityViewPartController(IJavaProject selectedProject) {
		this.selectedProject = selectedProject;
	}


	public void showConfigViewPart() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();

		URL entry = Activator.getDefault().getBundle().getEntry("/resource/config.xml");
		ViewConfig conf = JAXB.unmarshal(entry, ViewConfig.class);

        Dialog dialog = new ConfigDialog(activeWindow.getShell(), conf);
        int result = dialog.open();

        if(result == SWT.OK) {

//        	SystemMapper systemMapper = new SystemMapper();
//        	PackageMapper packageMapper = new PackageMapper();
//        	ClassMapper classMapper = new ClassMapper();

        }else{

        }
	}


	public void showCityViewPart() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
//        IWorkbenchWindow activeWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchPage page = activeWindow.getActivePage();
		try {
			CityViewPart view =  (CityViewPart)page.showView(ID, "secondID"+i++, IWorkbenchPage.VIEW_VISIBLE);
			ProjectAnalyzer analyzer = new ProjectAnalyzer(view.getController().getService());
			analyzer.analyzeFrom(selectedProject.getProject());
			System.out.println("解析終了");
		} catch (PartInitException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}

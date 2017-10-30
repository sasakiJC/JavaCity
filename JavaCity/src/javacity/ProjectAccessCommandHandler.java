package javacity;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import dev.javacity.core.infra.ProjectAnalyzer;
import javacity.views.MyViewPart;

public class ProjectAccessCommandHandler extends AbstractHandler {

	final static String ID = "javacity.views.MyViewPart";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		TreeSelection treeSelection = (TreeSelection)selection;
		IJavaProject selectedProject = (IJavaProject)treeSelection.getFirstElement();

        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchPage page = activeWindow.getActivePage();

		try {
			MyViewPart view =  (MyViewPart)page.showView(ID, null, IWorkbenchPage.VIEW_VISIBLE);
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

		return null;
	}

}

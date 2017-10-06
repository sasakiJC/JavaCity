package javacity;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
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

import javacity.views.MyViewPart;

public class ProjectAccessCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		TreeSelection treeSelection = (TreeSelection)selection;
		IJavaProject selectedProject = (IJavaProject)treeSelection.getFirstElement();

		String ID = "javacity.views.MyViewPart";

        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchPage page = activeWindow.getActivePage();

		try {
			MyViewPart view =  (MyViewPart)page.showView(ID, null, IWorkbenchPage.VIEW_VISIBLE);
			view.getController().importData(selectedProject.getProject());
		} catch (PartInitException e) {
			/* IViewPart view = */ page.findView(ID);
		}

		return null;
	}

	private IProject[] getProjects(IJavaProject selectedProject) throws CoreException {
		IProject[] projects = selectedProject.getProject().getReferencedProjects();
		return projects;
	}




}

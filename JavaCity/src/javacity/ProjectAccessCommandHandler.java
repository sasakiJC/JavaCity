package javacity;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import javacity.views.CityViewPartController;

public class ProjectAccessCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		TreeSelection treeSelection = (TreeSelection)selection;
		IJavaProject selectedProject = (IJavaProject)treeSelection.getFirstElement();

		CityViewPartController controller = new CityViewPartController(selectedProject);
		controller.showConfigViewPart();

		return null;
	}

}

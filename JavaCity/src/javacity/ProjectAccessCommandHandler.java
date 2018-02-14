package javacity;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import javacity.infra.ModelImporter;
import javacity.infra.importer.JavaProjectImporter;
import javacity.model.DataModel;
import javacity.views.CityViewPartController;
import javacity.views.ProjectSelectView;

public class ProjectAccessCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		TreeSelection treeSelection = (TreeSelection)selection;
		IJavaProject selectedProject = (IJavaProject)treeSelection.getFirstElement();

		ProjectSelectView projectSelectView = new ProjectSelectView();
		List<IProject> projects = projectSelectView.getProjects(selectedProject);

		ModelImporter importer = new JavaProjectImporter(projects);
		DataModel model = importer.toModel();
		CityViewPartController controller = new CityViewPartController(model);
		controller.execute();

		return null;
	}

}

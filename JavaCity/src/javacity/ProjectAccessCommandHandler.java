package javacity;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import dev.javacity.core.Activator;

public class ProjectAccessCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		TreeSelection treeSelection = (TreeSelection)selection;
		IJavaProject selectedProject = (IJavaProject)treeSelection.getFirstElement();


		System.out.println(Activator.getExtensionLoader().getEntityExtensions());

//		ProjectSelectView projectSelectView = new ProjectSelectView();
//		List<IProject> projects = projectSelectView.getProjects(selectedProject);
//
//		ModelImporter importer = new JavaProjectImporter(projects);
//		DataModel model = importer.toModel();
//		CityViewPartController controller = new CityViewPartController(model);
//		controller.execute();

		return null;
	}

}

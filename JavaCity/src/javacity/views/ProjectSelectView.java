package javacity.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;

public class ProjectSelectView {

	private ProjectSelectDialog dialog;

	public List<IProject> getProjects(IJavaProject selectedProject) {
//        int result = this.dialog.open();
//
//        if(result == SWT.OK) {
//
//        }


		List<IProject> list = new ArrayList<IProject>();
		list.add(selectedProject.getProject());
		try {
			for(IProject project : selectedProject.getProject().getReferencedProjects()) {
				list.add(project);
			}
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return list;
	}

}

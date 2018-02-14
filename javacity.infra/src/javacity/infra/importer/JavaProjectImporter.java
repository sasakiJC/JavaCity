package javacity.infra.importer;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import javacity.infra.ModelImporter;
import javacity.model.DataModel;

public class JavaProjectImporter implements ModelImporter {

	private List<IProject> projects;

	public JavaProjectImporter(List<IProject> projects2) {
		this.projects = projects2;
	}

	@Override
	public DataModel toModel() {
		ProjectAnalyzer analyzer = new ProjectAnalyzer();
		try {
			return analyzer.analyzeFrom(this.projects);
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}

}

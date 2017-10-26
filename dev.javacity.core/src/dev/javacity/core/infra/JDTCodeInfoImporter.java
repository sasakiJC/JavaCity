package dev.javacity.core.infra;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import dev.javacity.core.CodeInfoImportException;
import dev.javacity.core.CodeInfoImporter;

public class JDTCodeInfoImporter implements CodeInfoImporter {

	private IProject project;
	private ProjectAnalyzer analyzer;

	public JDTCodeInfoImporter(IProject project) {
		this.project = project;
	}

	@Override
	public void importInfo() {
		try {
			this.analyzer.analyzeFrom(this.project);
		} catch (CoreException e) {
			throw new CodeInfoImportException("コード情報のインポートに失敗しました。", e);
		}
	}


}

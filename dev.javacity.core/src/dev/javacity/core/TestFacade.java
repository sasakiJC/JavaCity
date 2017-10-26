package dev.javacity.core;

import org.eclipse.core.resources.IProject;

import dev.javacity.core.infra.ProjectAnalyzer;
import dev.javacity.core.models.DefaultEntityIdentifier;
import dev.javacity.core.models.DefaultRepository;
import dev.javacity.core.models.Repository;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetPackage;

public class TestFacade {

	private Repository<DefaultEntityIdentifier, TargetPackage> packageRepository;
	private Repository<DefaultEntityIdentifier, TargetClass> classRepository;
	private ProjectAnalyzer analyzer;

	public TestFacade() {
		this.packageRepository = new DefaultRepository<DefaultEntityIdentifier, TargetPackage>();
		this.classRepository = new DefaultRepository<DefaultEntityIdentifier, TargetClass>();
	}

	public void showViewPage(String id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void analyzeFrom(IProject project) {
//		this.analyzer.analyzeFrom(project, this.packageRepository, this.classRepository);
	}

}

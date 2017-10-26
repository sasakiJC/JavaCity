package dev.javacity.core.infra;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import dev.javacity.core.models.DefaultEntityIdentifier;
import dev.javacity.core.models.Repository;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetPackage;
import dev.javacity.core.models.TestDataModel;

public class ProjectAnalyzer {

	private ASTParser parser;
	private Repository<DefaultEntityIdentifier, TargetPackage> packageRepository;
	private Repository<DefaultEntityIdentifier, TargetClass> classRepository;

//	public ProjectAnalyzer() {
//		this.parser = ASTParser.newParser(AST.JLS8);
//        parser.setKind(ASTParser.K_COMPILATION_UNIT);
//        parser.setResolveBindings(true);
//	}

	public ProjectAnalyzer(Repository<DefaultEntityIdentifier, TargetPackage> packageRepository,
			Repository<DefaultEntityIdentifier, TargetClass> classRepository) {
		this.parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setResolveBindings(true);
        this.packageRepository = packageRepository;
        this.classRepository = classRepository;

	}

	public TestDataModel analyzeFrom(IProject project) throws CoreException {
		TestDataModel dataModel = new TestDataModel();
		for (IProject proj : project.getReferencedProjects()) {
			dataModel.addEntities(analyzeProject(proj));
		}
		dataModel.addEntities(analyzeProject(project));
		return dataModel;
	}

	private  List<TargetPackage> analyzeProject(IProject project) throws JavaModelException {
//		Map<String, TargetPackage> map = new HashMap<String, TargetPackage>();
		List<TargetPackage> list = new LinkedList<TargetPackage>();
		IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
		IPackageFragmentRoot[] packageRoots = JavaCore.create(project).getPackageFragmentRoots();
		for(IPackageFragmentRoot packageRoot : packageRoots) {
			if(packageRoot.getKind() == IPackageFragmentRoot.K_SOURCE) {
				for(IJavaElement pack : packageRoot.getChildren()) {
					TargetPackage targetPack = this.analyzePackage((IPackageFragment)pack);
					list.add(targetPack);
				}
			}
		}
		this.solvePackageRelation(list);
		return list;
	}

	private void solvePackageRelation(List<TargetPackage> packageList) {
		for(TargetPackage child : packageList) {
			for(TargetPackage parent : packageList) {
				if(child.isParentPackage(parent)) {
					child.setParent(parent);
					parent.addChild(child);
				}
			}
		}
	}

	private TargetPackage analyzePackage(IPackageFragment packageFragment) throws JavaModelException {
		TargetPackage targetPack = new TargetPackage(this.packageRepository.nextIndentifier(), packageFragment.getElementName());
		for (ICompilationUnit unit : packageFragment.getCompilationUnits()) {
			TargetClass clazz = this.analyzeClass(unit);
		}
		this.packageRepository.store(targetPack);
		return targetPack;
	}

	private TargetClass analyzeClass(ICompilationUnit unit) {
//		System.out.println(" " + unit.getElementName());
		CompilationUnit parse = parse(unit);
		ClassAnalyzeVisitor visitor = new ClassAnalyzeVisitor();
		parse.accept(visitor);
		return visitor.getTargetClass();
	}

	private CompilationUnit parse(ICompilationUnit unit) {
		this.parser.setSource(unit);
		return (CompilationUnit) this.parser.createAST(null);
	}

}

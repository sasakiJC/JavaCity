package dev.javacity.core.infra;

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

import dev.javacity.core.CodeElementApplicationService;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetPackage;

public class ProjectAnalyzer {

	private ASTParser parser;
	private CodeElementApplicationService codeElementAppService;

//	public ProjectAnalyzer() {
//		this.parser = ASTParser.newParser(AST.JLS8);
//        parser.setKind(ASTParser.K_COMPILATION_UNIT);
//        parser.setResolveBindings(true);
//	}

	public ProjectAnalyzer(CodeElementApplicationService codeElementAppService) {
		this.parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setResolveBindings(true);
        this.codeElementAppService = codeElementAppService;
	}

	public void analyzeFrom(IProject project) throws CoreException {
		for (IProject proj : project.getReferencedProjects()) {
			analyzeProject(proj);
		}
		analyzeProject(project);
	}

	private void analyzeProject(IProject project) throws JavaModelException {
//		List<TargetPackage> list = new LinkedList<TargetPackage>();
		IPackageFragmentRoot[] packageRoots = JavaCore.create(project).getPackageFragmentRoots();
		for(IPackageFragmentRoot packageRoot : packageRoots) {
			if(packageRoot.getKind() == IPackageFragmentRoot.K_SOURCE) {
				for(IJavaElement pack : packageRoot.getChildren()) {
					TargetPackage targetPack = this.analyzePackage((IPackageFragment)pack);
//					list.add(targetPack);
				}
			}
		}
//		this.solvePackageRelation(list);
	}


	private TargetPackage analyzePackage(IPackageFragment packageFragment) throws JavaModelException {
		TargetPackage pack = this.codeElementAppService.newPackage(packageFragment.getElementName());
		for (ICompilationUnit unit : packageFragment.getCompilationUnits()) {
			TargetClass clazz = this.analyzeClass(unit);
		}
		return pack;
	}

	private TargetClass analyzeClass(ICompilationUnit unit) {
//		System.out.println(" " + unit.getElementName());
		CompilationUnit parse = parse(unit);
		ClassAnalyzeVisitor visitor = new ClassAnalyzeVisitor(this.codeElementAppService, parse);
		parse.accept(visitor);
		return visitor.getTargetClass();
	}

	private CompilationUnit parse(ICompilationUnit unit) {
		this.parser.setSource(unit);
		return (CompilationUnit) this.parser.createAST(null);
	}

}

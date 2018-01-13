package javacity.model.importer;

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

import dev.javacity.core.DataModel;
import javacity.model.TClass;
import javacity.model.TPackage;

public class ProjectAnalyzer {

	private ASTParser parser;
//	private CodeElementApplicationService codeElementAppService;
	private DataModel dataModel;

	public ProjectAnalyzer() {
		this.parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setResolveBindings(true);
        this.dataModel = new DataModel();
	}

	public DataModel analyzeFrom(List<IProject> projects) throws CoreException {
		for(IProject proj : projects) {
			this.analyzeProject(proj);
		}
		return this.dataModel;
	}

	private void analyzeProject(IProject project) throws JavaModelException {
//		List<TargetPackage> list = new LinkedList<TargetPackage>();
		IPackageFragmentRoot[] packageRoots = JavaCore.create(project).getPackageFragmentRoots();
		for(IPackageFragmentRoot packageRoot : packageRoots) {
			if(packageRoot.getKind() == IPackageFragmentRoot.K_SOURCE) {
				for(IJavaElement pack : packageRoot.getChildren()) {
					TPackage targetPack = this.analyzePackage((IPackageFragment)pack);
//					list.add(targetPack);
				}
			}
		}
//		this.solvePackageRelation(list);
	}


	private TPackage analyzePackage(IPackageFragment packageFragment) throws JavaModelException {
//		TPackage pack = this.codeElementAppService.newPackage(packageFragment.getElementName());
		TPackage pack = this.dataModel.newPackage(packageFragment.getElementName());
		for (ICompilationUnit unit : packageFragment.getCompilationUnits()) {
			TClass clazz = this.analyzeClass(unit);
		}
		return pack;
	}

	private TClass analyzeClass(ICompilationUnit unit) {
		CompilationUnit parse = parse(unit);
		ClassAnalyzeVisitor visitor = new ClassAnalyzeVisitor(this.dataModel, parse);
		parse.accept(visitor);
		return visitor.getTargetClass();
	}

	private CompilationUnit parse(ICompilationUnit unit) {
		this.parser.setSource(unit);
		return (CompilationUnit) this.parser.createAST(null);
	}

}

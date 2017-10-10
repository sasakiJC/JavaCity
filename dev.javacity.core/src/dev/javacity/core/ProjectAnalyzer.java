package dev.javacity.core;

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

import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetPackage;
import dev.javacity.core.models.TestDataModel;

public class ProjectAnalyzer {

	private ASTParser parser;

	public ProjectAnalyzer() {
		this.parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setResolveBindings(true);
	}

	public TestDataModel analyzeFrom(IProject project) throws CoreException {
		for(IProject proj : project.getReferencedProjects()) {
			this.analyzeProject(proj);
		}
		this.analyzeProject(project);
		return null;
	}

	private void analyzeProject(IProject project) throws JavaModelException {
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
//		System.out.println(packageFragment.getElementName());

		TargetPackage targetPack = new TargetPackage(packageFragment.getElementName());
		for (ICompilationUnit unit : packageFragment.getCompilationUnits()) {
			TargetClass clazz = this.analyzeClass(unit);
		}

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




//    private static CompilationUnit parse(ICompilationUnit unit) {
//        ASTParser parser = ASTParser.newParser(AST.JLS8);
//        parser.setKind(ASTParser.K_COMPILATION_UNIT);
//        parser.setSource(unit);
//        parser.setResolveBindings(true);
//        return (CompilationUnit) parser.createAST(null); // parse
//    }

	public void temp(IProject[] projects) throws JavaModelException, CoreException {
		for (IProject project : projects) {
			if (project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
				System.out.println("project : " + project);

				IPackageFragmentRoot[] packageRoots = JavaCore.create(project).getPackageFragmentRoots();

				// for(IPackageFragmentRoot packageRoot : packageRoots) {
				// if(!packageRoot.isArchive()) {
				// System.out.println("rootName : " +
				// packageRoot.getElementName());
				// for(IJavaElement mypackage : packageRoot.getChildren()) {
				// System.out.println(" packageName : " +
				// mypackage.getElementName());
				// }
				// }
				// }

				IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
				// parse(JavaCore.create(project));
				for (IPackageFragment mypackage : packages) {

					if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
						System.out.println("  " + mypackage.getElementName());

						for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
							// System.out.println(" " + unit.getElementName());
							// Now create the AST for the ICompilationUnits
							CompilationUnit parse = parse(unit);

							// MethodVisitor visitor = new MethodVisitor();
							// parse.accept(visitor);

							/*
							 * for (MethodDeclaration method :
							 * visitor.getMethods()) {
							 * System.out.print("Method name: " +
							 * method.getName() + " Return type: " +
							 * method.getReturnType2()); }
							 */

						}
					}
				}
			}
		}
	}
}

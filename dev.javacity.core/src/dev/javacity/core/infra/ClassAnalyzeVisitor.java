package dev.javacity.core.infra;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import dev.javacity.core.CodeElementApplicationService;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetClass.ClassType;
import dev.javacity.core.models.TargetField;
import dev.javacity.core.models.TargetMethod;

public class ClassAnalyzeVisitor extends ASTVisitor {

	private TargetClass clazz;
	private CodeElementApplicationService codeElementAppService;
	private CompilationUnit compilationUnit;
	private MetricsMeasure metricsMeasure;

	public ClassAnalyzeVisitor(CodeElementApplicationService codeElementAppService, CompilationUnit compilationUnit) {
		this.codeElementAppService = codeElementAppService;
		this.compilationUnit = compilationUnit;
		this.metricsMeasure = new MetricsMeasure(this.compilationUnit);
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		ClassType type;
		if(node.isInterface()) type = ClassType.INTERFACE;
		else if(Flags.isAbstract(node.getModifiers())) type = ClassType.ABSTRACT;
		else type = ClassType.CONCRETE;

		int loc = this.metricsMeasure.classLineOfCode(node);
		int nom = this.metricsMeasure.numberOfMethods(node);
		int noa = this.metricsMeasure.numberOfAttributes(node);

		this.clazz = this.codeElementAppService.newClass(
				node.getName().getIdentifier(),
				type,
				loc,
				nom,
				noa);
		this.clazz.setModifiers(node.modifiers());

		return true;
	}

	@Override
	public boolean visit(EnumDeclaration node) {
		this.clazz = this.codeElementAppService.newClass(
				node.getName().getIdentifier(),
				ClassType.ENUM,
				this.metricsMeasure.enumLineOfCode(node),
				this.metricsMeasure.numberOfMethods(node),
				this.metricsMeasure.numberOfAttributes(node));
		this.clazz.setModifiers(node.modifiers());

		return true;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		TargetMethod method = this.codeElementAppService.newMethod(node.getName().getIdentifier(), node.isConstructor());
		method.setBody(node.getBody());
		method.setReturnType(node.getReturnType2());
		method.setTypeParameters(node.typeParameters());
//		node.thrownExceptionTypes();
		method.setParameters(node.parameters());
//		可変長引数かどうか
//		node.isVarargs();
		method.setModifiers(node.modifiers());
		this.clazz.addChild(method);
//		System.out.println("MethodDeclaration");
		return true;
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		for(Object obj : node.fragments()) {
			VariableDeclarationFragment fragment = (VariableDeclarationFragment)obj;
			fragment.getClass();

			// Object obj[][] のときfragment.getExtraDimensions()==2
			// if(fragment.getExtraDimensions() > 0) TargetField field = new TargetField(fragment.getName().getIndentifier(), node.getType().toString()+fragment.extraDimensions().sum
			TargetField field = this.codeElementAppService.newField(fragment.getName().getIdentifier(), node.getType().toString());
			field.setModifiers(node.modifiers());
			this.clazz.addChild(field);
		}
		return true;
	}

	@Override
	public boolean visit(EnumConstantDeclaration node) {
		// TODO 自動生成されたメソッド・スタブ
		return super.visit(node);
	}

	@Override
	public boolean visit(Block node) {
		return super.visit(node);
	}

	@Override
	public boolean visit(AnonymousClassDeclaration node) {
		// TODO 自動生成されたメソッド・スタブ
		return super.visit(node);
	}


	public TargetClass getTargetClass() {
		return this.clazz;
	}

}

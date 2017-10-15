package dev.javacity.core;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetClass.ClassType;
import dev.javacity.core.models.TargetField;

public class ClassAnalyzeVisitor extends ASTVisitor {

	private TargetClass clazz;

	public ClassAnalyzeVisitor() {
//		this.clazz = new TargetClass();
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		if(node.isInterface()) {
			this.clazz = new TargetClass(node.getName().getIdentifier(), ClassType.INTERFACE);
		}else{
			if(Flags.isAbstract(node.getModifiers())) {
				this.clazz = new TargetClass(node.getName().getIdentifier(), ClassType.ABSTRACT);
			}else{
				this.clazz = new TargetClass(node.getName().getIdentifier(), ClassType.CONCRETE);
			}
		}
		this.clazz.setModifiers(node.modifiers());
		return true;
	}

	@Override
	public boolean visit(EnumDeclaration node) {
		this.clazz = new TargetClass(node.getName().getIdentifier(), ClassType.ENUM);
		this.clazz.setModifiers(node.modifiers());
		return true;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
//		System.out.println("MethodDeclaration");
		return super.visit(node);
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		for(Object obj : node.fragments()) {
			VariableDeclarationFragment fragment = (VariableDeclarationFragment)obj;
			fragment.getClass();

			// Object obj[][] のときfragment.getExtraDimensions()==2
			// if(fragment.getExtraDimensions() > 0) TargetField field = new TargetField(fragment.getName().getIndentifier(), node.getType().toString()+fragment.extraDimensions().sum
			TargetField field = new TargetField(fragment.getName().getIdentifier(),  node.getType().toString());
			field.setModifiers(node.modifiers());
			this.clazz.addChild(field);
		}
		return super.visit(node);
	}

	@Override
	public boolean visit(EnumConstantDeclaration node) {
		// TODO 自動生成されたメソッド・スタブ
		return super.visit(node);
	}

	@Override
	public boolean visit(Block node) {
		// TODO 自動生成されたメソッド・スタブ
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

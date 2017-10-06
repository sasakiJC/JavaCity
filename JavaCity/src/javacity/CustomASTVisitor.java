package javacity;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ReturnStatement;

public class CustomASTVisitor extends ASTVisitor {

	public CustomASTVisitor() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
	
	@Override
	public boolean visit(ReturnStatement node) {
		// TODO 自動生成されたメソッド・スタブ
		return super.visit(node);
	}
}

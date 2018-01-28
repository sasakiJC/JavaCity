package javacity.model.metrics;

import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class LOC extends AbstractIntCodeMetric {

	@Override
	public void compute(BodyDeclaration bodyDeclaration, CompilationUnit compilationUnit) {
		int endPos = compilationUnit.getLineNumber(bodyDeclaration.getStartPosition() + bodyDeclaration.getLength());
		int startPos = compilationUnit.getLineNumber(bodyDeclaration.getStartPosition());
		this.value = endPos - startPos;
	}

}

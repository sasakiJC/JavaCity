package javacity.model.metrics;

import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class NOA extends AbstractIntCodeMetric {

	@Override
	public void compute(BodyDeclaration bodyDeclaration, CompilationUnit compilationUnit) {
		if(bodyDeclaration instanceof TypeDeclaration)
			this.value = this.compute((TypeDeclaration)bodyDeclaration);
		else if(bodyDeclaration instanceof EnumDeclaration)
			this.value = this.compute((EnumDeclaration)bodyDeclaration);
		else
			this.value = 0;
	}

	private int compute(TypeDeclaration node) {
		return node.getFields().length;
	}

	private int compute(EnumDeclaration node) {
		int noa=0;
		for(Object obj : node.bodyDeclarations()) {
			if(obj instanceof FieldDeclaration)
				noa++;
		}
		return noa;
	}
}
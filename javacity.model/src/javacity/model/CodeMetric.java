package javacity.model;

import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;

public interface CodeMetric<T> extends Comparable<T>{
	public void compute(BodyDeclaration bodyDeclaration, CompilationUnit compilationUnit);
}

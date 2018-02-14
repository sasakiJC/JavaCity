package javacity.infra;

import java.util.Map;

import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import javacity.model.Activator;
import javacity.model.CodeMetric;
import javacity.model.CodeMetrics;
import javacity.model.EntityIdentifier;

public class MetricsMeasure {
	private CompilationUnit compilationUnit;
	private Class<?>[] paramTypes = {EntityIdentifier.class, String.class, CodeMetrics.class};
	public MetricsMeasure(CompilationUnit compilationUnit) {
		this.compilationUnit = compilationUnit;
	}

	public CodeMetrics mesure(BodyDeclaration body, Class<?> entityClass) {
		CodeMetrics metrics = new CodeMetrics();
		for(Map.Entry<Class<?>, String> entry : Activator.getExtensionLoader().getMetricsExtensionClassNames(entityClass).entrySet()){
			try {
				CodeMetric metric = (CodeMetric) entry.getKey().newInstance();
				metric.compute(body, compilationUnit);
				metrics.put(entry.getValue(), metric);
			} catch (ReflectiveOperationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return metrics;
	}

	public int classLineOfCode(TypeDeclaration node) {
		int endPos = this.compilationUnit.getLineNumber(node.getStartPosition() + node.getLength());
		int startPos = this.compilationUnit.getLineNumber(node.getStartPosition());
		if(node.getJavadoc() == null) {
			return endPos - startPos;
		}else{
			int javaDocEndPos = this.compilationUnit.getLineNumber(node.getJavadoc().getStartPosition() + node.getJavadoc().getLength());
			int javaDocStartPos = this.compilationUnit.getLineNumber(node.getJavadoc().getStartPosition());
			return endPos - startPos - ( javaDocEndPos - javaDocStartPos);
		}
	}

	public int numberOfMethods(TypeDeclaration node) {
		return node.getMethods().length;
	}

	public int numberOfAttributes(TypeDeclaration node) {
		return node.getFields().length;
	}

	public int enumLineOfCode(EnumDeclaration node) {
		int endPos = this.compilationUnit.getLineNumber(node.getStartPosition() + node.getLength());
		int startPos = this.compilationUnit.getLineNumber(node.getStartPosition());
		if(node.getJavadoc() == null) {
			return endPos - startPos;
		}else{
			int javaDocEndPos = this.compilationUnit.getLineNumber(node.getJavadoc().getStartPosition() + node.getJavadoc().getLength());
			int javaDocStartPos = this.compilationUnit.getLineNumber(node.getJavadoc().getStartPosition());
			return endPos - startPos - ( javaDocEndPos - javaDocStartPos);
		}
	}

	public int numberOfMethods(EnumDeclaration node) {
		int nom=0;
		for(Object obj : node.bodyDeclarations()) {
			if(obj instanceof MethodDeclaration)
				nom++;
		}
		return nom;
	}

	public int numberOfAttributes(EnumDeclaration node) {
		int noa=0;
		for(Object obj : node.bodyDeclarations()) {
			if(obj instanceof FieldDeclaration)
				noa++;
		}
		return noa;
	}
}

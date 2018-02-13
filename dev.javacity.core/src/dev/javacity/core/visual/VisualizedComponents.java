package dev.javacity.core.visual;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VisualizedComponents implements Iterable<VisualizedComposite> {

	private List<VisualizedComposite> list;

	public void sortedBy(Comparator<VisualizedComposite> comparator) {
		Collections.sort(list, comparator);
	}

	@Override
	public Iterator<VisualizedComposite> iterator() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public double widthSum() {
		return 0;
	}

	public double heightSum() {
		return 0;
	}

	public double depthSum() {
		return 0;
	}

}

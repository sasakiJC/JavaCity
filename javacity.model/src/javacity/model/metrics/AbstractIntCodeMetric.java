package javacity.model.metrics;

import javacity.model.CodeMetric;

public abstract class AbstractIntCodeMetric implements CodeMetric<AbstractIntCodeMetric> {

	protected int value;

	@Override
	public int compareTo(AbstractIntCodeMetric o) {
		return this.value - o.value;
	}
}

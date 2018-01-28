package javacity.model.metrics;

import javacity.model.CodeMetric;

public abstract class AbstractFloatCodeMetric implements CodeMetric<AbstractFloatCodeMetric> {

	private float value;

	@Override
	public int compareTo(AbstractFloatCodeMetric o) {
		return (int) (this.value - o.value);
	}

}

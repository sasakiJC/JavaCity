package javacity.model;

import java.util.HashMap;
import java.util.Map;

public class CodeMetrics {
	private Map<String, CodeMetric> metrics;

	public CodeMetrics() {
		this.metrics = new HashMap<>();
	}

	public CodeMetric put(String key, CodeMetric value) {
		return this.metrics.put(key, value);
	}

	public CodeMetric get(String key) {
		return this.metrics.get(key);
	}
}

package javacity.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigUtils {

	private ConfigUtils(){}

	public static <T> List<T> diff(Collection<T> col1, Collection<T> col2) {
		return col1.stream()
				.filter(x -> col2.stream().noneMatch(y -> y.equals(x)))
				.collect(Collectors.toList());
	}
}

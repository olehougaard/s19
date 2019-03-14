package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Collections2 {
	public static<T, U> List<U> map(List<T> ts, Function<T, U> f) {
		List<U> us = new ArrayList<>();
		for(T t: ts) us.add(f.apply(t));
		return us;
	}
}

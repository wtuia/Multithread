package my_executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable1 implements Callable<List<String>> {
	@Override
	public List<String> call() throws Exception {
		List<String> strings = new ArrayList<>();
		strings.add("1");
		strings.add("2");
		return strings;
	}
}

package executors.java_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int i = 0 ; i < 4 ; i++) {
            final int index = 1;
            fixedThreadPool.execute(new ThreadPool(index));
        }
		System.out.println("执行完成");
    }
}

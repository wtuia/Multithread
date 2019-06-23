package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class fixedThreadPool {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int i = 0 ; i < 4 ; i++) {
            final int index = 1;
            fixedThreadPool.execute(new ThreadPool(index));
        }
    }
}

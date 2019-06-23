package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class singleThreadPool {
    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        for (int i = 0 ; i < 4 ; i++) {
            final int index = 1;
            singleThreadPool.execute(new ThreadPool(index));
        }
    }
}

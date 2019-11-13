package executors.java_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool {

    public static void main(String[] args) {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

        for (int i = 0 ; i < 4 ; i++) {
            final int index = 1;
            cacheThreadPool.execute(new ThreadPool(index));
        }
    }
}

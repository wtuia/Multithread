package executor.threadpool_executor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 四种拒绝策略测试
 */
public class RejectedTest {

    public static void main(String[] args) {
        rejectedTest();
    }

    public static void rejectedTest() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ExecutorService service =
                new ThreadPoolExecutor(1,2,1,
                        TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future> results = new ArrayList<>();
        for (int i = 1 ; i < 10 ; i++) {
            Runnable runnable = new MyRunable(i);
            results.add(service.submit(runnable));
        }
        service.shutdown();
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
        if (service.isTerminated()) {
            for (Future future : results) {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

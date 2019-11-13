package executor.threadpool_executor;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 在线程池中传入call的测试
 */
public class CallableThreadPoolTest {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSSS");

    /**
     *Callable 不保证线程一定执行，可能会阻塞
     */
    @Test
    public void callTest() throws ExecutionException, InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ExecutorService service =
                new ThreadPoolExecutor(1, 2, 1,
                        TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.DiscardPolicy());

        List<Future> results = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            System.out.println(workQueue.size() + " | " + i + " | " + formatter.format(LocalDateTime.now()));
            Callable<String> runnable = new MyCallable(i);
            results.add(service.submit(runnable));
        }

       /* for (Future future : results) {
            if (!future.isDone()) {
                System.out.println(future.get());
            }
        }*/
    }

    @Test
    public void callTest1() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ExecutorService service =
                new ThreadPoolExecutor(1,2,1,
                        TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 1 ; i < 10 ; i++) {
            Callable<String> runnable = new MyCallable(i);
            System.out.println(i);
            service.submit(runnable);
        }
    }
}

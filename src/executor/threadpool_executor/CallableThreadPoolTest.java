package executor.threadpool_executor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 在线程池中传入call的测试
 */
public class CallableThreadPoolTest {


    /**
     * <p>若在线程池中传入Callable，则非调用线程执行的任务会等待
     * (单独例子参:{@link #callTest1}),
     * 需要再调用返回结果Future时才会执行，且异步。<p/>
     * <p>并且，如果不调用future的get方法，则非调用线程执行的任务
     * 的完成状态永远为false（见下第二个for的状态）,即一直等待。<p/>
     */
    @Test
    public void callTest() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ExecutorService service =
                new ThreadPoolExecutor(1,2,1,
                        TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());


        List<Future> results = new ArrayList<>();
        for (int i = 1 ; i < 10 ; i++) {
            Callable<String> runnable = new MyCallable(i);
            results.add(service.submit(runnable));
        }

        service.shutdown();
        for (Future future: results) {
            System.out.println(future.isDone());
            //System.out.println(future.get());
            System.out.println();
        }
        System.out.println("--------------------------");
        for (Future future: results) {
            System.out.println(future.isDone());
            //System.out.println(future.get());
            System.out.println(Thread.currentThread());
        }
    }

    @Test
    public void callTest1() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ExecutorService service =
                new ThreadPoolExecutor(1,2,1,
                        TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 1 ; i < 10 ; i++) {
            Callable<String> runnable = new MyCallable(i);
            service.submit(runnable);
        }

        service.shutdown();
    }
}

package executor.threadpool_executor;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        rejectedTest();
    }

    /**
     * 四种拒绝策略测试
     */
    public static void rejectedTest() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ExecutorService service = new ThreadPoolExecutor(1,2,1, TimeUnit.SECONDS, workQueue,
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0 ; i < 10 ; i++) {
            Runnable runnable = new MyRunable(i);
            service.execute(runnable);
        }
        service.shutdown();
    }
}

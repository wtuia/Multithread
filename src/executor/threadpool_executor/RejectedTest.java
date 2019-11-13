package executor.threadpool_executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * 四种拒绝策略测试
 */
public class RejectedTest {

    public static void main(String[] args) {
        Collection collection = new LinkedBlockingQueue();
        Queue  queue = new LinkedBlockingQueue();

        rejectedTest();
    }

    public static void rejectedTest() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3);
        ExecutorService service =
                new ThreadPoolExecutor(1,2,1,
                        TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 1 ; i < 10 ; i++) {
            Runnable runnable = new MyRunable(i);
            service.submit(runnable);
        }
    }

}

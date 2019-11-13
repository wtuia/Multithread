package executors.simple_threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPoolTest {

    public static void main(String[] args) {
        Executor threadPool = new MyThreadPoolExecutor("test", 5, 10,
                new ArrayBlockingQueue<>(15), new DiscardRejectPolicy());
        AtomicInteger num = new AtomicInteger(0);

        for (int i = 0; i < 100; i++) {
            threadPool.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println("running: " +System.identityHashCode(Thread.currentThread()) + ": " + num.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}

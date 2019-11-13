package executors.simple_threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPoolExecutor implements Executor {

    /**
     * 线程池名称
     */
    private String name;

    /**
     * 核心线程
     * 1，当线程池的线程数未到达核心线程时，对于新增的任务可以新启线程(提高执行效率)，
     * 2，当线程池的线程数达到核心线程时，对于新增的任务，添加进队列，若核心线程很快执行完
     *    则无需新开线程。
     * 3，当队列中的任务已满，对于新增的任务新开线程
     */
    private int coreSize;

    /**
     * 最大线程
     * 线程池不能无限制的添加
     */
    private int maxSize;

    /**
     * 任务队列
     */
    private BlockingQueue<Runnable> taskQueue;

    private AtomicInteger runningCount = new AtomicInteger(0);

    /**
     * 拒绝策略
     * 当队列已满且线程数达最大线程数，此时对于新任务走拒绝策略
     * 常用的策略有丢弃最老的，丢弃当前的，调用者自己处理，抛出异常
     */
    private RejectPolicy rejectPolicy;

    public MyThreadPoolExecutor(String name, int coreSize, int maxSize,
                                BlockingQueue<Runnable> taskQueue,
                                RejectPolicy rejectPolicy) {
        this.name = name;
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.taskQueue = taskQueue;
        this.rejectPolicy = rejectPolicy;
    }

    @Override
    public void execute(Runnable task) {
        // 正在运行的线程数
        int count = runningCount.get();
        // 如果正在运行的线程数小于核心线程数，直接加一个线程
        if (count < coreSize) {
            // 注意，这里不一定添加成功，addWorker()方法里面还要判断一次是不是确实小
            if (addWorker(task, true)) {
                return;
            }
        }

        // 如果达到了核心线程数，先尝试让任务入队
        // 这里之所以使用offer()，是因为如果队列满了offer()会立即返回false
        if (taskQueue.offer(task)) {
            // do nothing，为了逻辑清晰这里留个空if
        } else {
            // 如果入队失败，说明队列满了，那就添加一个非核心线程
            if (!addWorker(task, false)) {
                // 如果添加非核心线程失败了，那就执行拒绝策略
                rejectPolicy.reject(task, this);
            }
        }
    }

    private boolean addWorker(Runnable runnable, boolean core) {
        while (true) {
            // 正在运行的线程数
            int count = runningCount.get();
            // 是否为核心线程
            int max = core ? coreSize : maxSize;
            if (count >= max) {
                return false;
            }
            // 修改runningCount成功
            if (runningCount.compareAndSet(count, count + 1)) {
                String threadName = (core ? "core_" : "") + name;
                // 创建线程并启动
                new Thread(() -> {
                    System.out.println("thread name: " + Thread.currentThread().getName() +
                            ":" + System.identityHashCode(Thread.currentThread()));
                    Runnable task = runnable;
                    while (task != null || (task = getTask()) != null) {
                        try {
                            // 执行任务
                            task.run();
                        } finally {
                            // 任务执行完成，置为空
                            task = null;
                        }
                    }
                }, threadName).start();
                break;
            }
        }
        return true;
    }

    private Runnable getTask() {
        try {
            // take()方法会一直阻塞直到取到任务为止
            return taskQueue.take();
        } catch (InterruptedException e) {
            // 线程中断了，返回null可以结束当前线程
            // 当前线程都要结束了，理应要把runningCount的数量减一
            runningCount.decrementAndGet();
            return null;
        }
    }
}

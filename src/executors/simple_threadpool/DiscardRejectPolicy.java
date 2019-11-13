package executors.simple_threadpool;

/**
 * 拒绝策略 丢弃
 */
public class DiscardRejectPolicy implements RejectPolicy{
    @Override
    public void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor) {
        //System.out.println("discard task");
    }
}

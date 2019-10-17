package executor.threadpool_executor;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private int index;
    public MyCallable(int index) {
        this.index = index;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("callName:%s ,callId:%s callIndex:%d%n",Thread.currentThread(),
                System.identityHashCode(Thread.currentThread()), index);
        return "over "+ index;
    }
}

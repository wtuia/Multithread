package executor.threadpool_executor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private int index;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSSS");
    public MyCallable(int index) {
        this.index = index;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("callName:%s ,callId:%s callIndex:%d, time:%s,%n",
                Thread.currentThread().getName(),
                System.identityHashCode(Thread.currentThread()), index,
                formatter.format(LocalDateTime.now()));
        return "over "+ index;
    }
}

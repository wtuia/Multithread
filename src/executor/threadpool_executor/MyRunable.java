package executor.threadpool_executor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyRunable implements Runnable{

    private int index;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSSS");

    public MyRunable(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.printf("ThreadName:%s ,ThreadId:%s RunableIndex:%d, time:%s%n",
                Thread.currentThread().getName(),
                System.identityHashCode(Thread.currentThread()), index,
                formatter.format(LocalDateTime.now()));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

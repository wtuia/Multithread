package scheduled_executor_service;

import java.text.SimpleDateFormat;

public class OtherMyThread implements Runnable{


    private static SimpleDateFormat formatter =
            new SimpleDateFormat("yyyy-MM-dd HH mm ss SSSS");


    @Override
    public void run() {
        try {
            System.out.printf("Thread: %s, Thread 2: date:%s %n", Thread.currentThread(),
                    formatter.format(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

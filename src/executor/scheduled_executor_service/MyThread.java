package executor.scheduled_executor_service;

import java.text.SimpleDateFormat;

public class MyThread implements Runnable{


    private static SimpleDateFormat formatter =
            new SimpleDateFormat("yyyy-MM-dd HH mm ss SSSS");


    @Override
    public void run() {
        try {
            System.out.printf("Thread: %s, Thread 1: date:%s %n", Thread.currentThread(),
                    formatter.format(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}

package scheduled_executor_service;

public class MyThread implements Runnable{



    @Override
    public void run() {
        System.out.println("task running");
    }
}

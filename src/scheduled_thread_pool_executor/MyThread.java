package scheduled_thread_pool_executor;

public class MyThread implements Runnable{



    @Override
    public void run() {
        System.out.println("task running");
    }
}

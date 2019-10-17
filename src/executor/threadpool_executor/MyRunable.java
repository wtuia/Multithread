package executor.threadpool_executor;

public class MyRunable implements Runnable{

    private int index;
    public MyRunable(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.printf("ThreadName:%s ,ThreadId:%s RunableIndex:%d%n",Thread.currentThread(),
                System.identityHashCode(Thread.currentThread()), index);
    }
}

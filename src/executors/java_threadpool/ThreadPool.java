package executors.java_threadpool;

/**
 * 线程池处理的线程
 */
public class ThreadPool implements Runnable{

    private Integer index;

    public ThreadPool(Integer index) {
        this.index = index;
    }

    @Override
    public void run() {

        try {
            System.out.println("处理线程开始...");

            Thread.sleep(index*1000);

            System.out.println("线程标识："+System.identityHashCode(Thread.currentThread()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

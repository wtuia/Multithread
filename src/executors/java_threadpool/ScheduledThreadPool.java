package executors.java_threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorPool =
                Executors.newScheduledThreadPool(2);

        for (int i = 0 ; i < 4 ; i++) {
            final int index = 1;

            /*
                延时3s 后执行
             * 指定延时方式
             * delay ： 延时时间，TimeUnit：延时单位
             */
            scheduledExecutorPool.schedule(new ThreadPool(index),3, TimeUnit.SECONDS);
        }
    }
}

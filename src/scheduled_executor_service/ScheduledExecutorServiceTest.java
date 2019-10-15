package scheduled_executor_service;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor 启动的定时任务
 * 除非抛出抛出异常，否则只能通过程序的关闭停止执行
 * 该方法优于 Timer
 * 1， Timer 基于系统时间，修改系统时间会影响程序的执行时间，
 *     ScheduledThreadPoolExecutor使用的是基于System#nanoTime实现的相对时间
 *     {@link System#nanoTime()}该方法返回的时间与JVM相关，与系统时间无关
 *     不会因为系统时间的修改而改变执行时间
 * 2，Timer 单线程，当其中一个任务抛出异常时，会导致其他任务的中断
 *
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduled =
                new ScheduledThreadPoolExecutor(16);
        scheduled.scheduleWithFixedDelay(new MyThread(), 1, 10, TimeUnit.SECONDS);
    }
}

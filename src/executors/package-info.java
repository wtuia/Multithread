/**
 * 此包中所定义的 Executor、ExecutorService、ScheduledExecutorService、
 * ThreadFactory 和 Callable 类的工厂和实用方法。此类支持以下各种方法：
 *<br/><br/>
 * 创建并返回设置有常用配置字符串的 ExecutorService 的方法。
 * 创建并返回设置有常用配置字符串的 ScheduledExecutorService 的方法。
 * 创建并返回“包装的”ExecutorService 方法，它通过使特定于实现的方法不可访问来禁用重新配置。
 * 创建并返回 ThreadFactory 的方法，它可将新创建的线程设置为已知的状态。
 * 创建并返回非闭包形式的 Callable 的方法，这样可将其用于需要 Callable 的执行方法中。
 */
package executors;
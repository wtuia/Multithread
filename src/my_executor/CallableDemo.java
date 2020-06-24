package my_executor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Future<List<String>> future = service.submit(new MyCallable());
		Future<List<String>> future1 = service.submit(new MyCallable1());
		List<Future<List<String>>> futureList = new ArrayList<>();
		futureList.add(future);
		futureList.add(future1);
		service.shutdown(); // 在shutdown之后启动新线程会抛出异常
		List<String> result = new ArrayList<>();
		while (true){
			Iterator<Future<List<String>>> iterator = futureList.iterator();
			while (iterator.hasNext()) {
				// 需要在循环内捕获线程抛出的异常，避免一个线程抛出异常，导致主线程提前结束
				try {
					Future<List<String>> task = iterator.next();
					if (task.isDone()) {
						result.addAll(task.get());
						iterator.remove();
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("线程抛出异常");
				}
			}
			//使用isTerminated作为结束条件，则判断不能在所有future的get方法之前，因为可能所有线程都运行完成了，但还没获取结果就结束
			//demo1是一个错误的实现
			if (service.isTerminated()) {
				System.out.println("任务执行完成");
				break;
			}
		}
		System.out.println(result);
	}

	public static void demo1() {
		ExecutorService service = Executors.newCachedThreadPool();
		Future<List<String>> future = service.submit(new MyCallable());
		Future<List<String>> future1 = service.submit(new MyCallable1());
		List<Future<List<String>>> futureList = new ArrayList<>();
		futureList.add(future);
		futureList.add(future1);
		service.shutdown();
		List<String> result = new ArrayList<>();
		try {
			while (!service.isTerminated()){
				Iterator<Future<List<String>>> iterator = futureList.iterator();
				while (iterator.hasNext()) {
					try {
						Future<List<String>> task = iterator.next();
						if (task.isDone()) {
							result.addAll(task.get());
							iterator.remove();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
}

package futuretask;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo implements Runnable{

	@Override
	public void run() {
		System.out.println("running");
	}

	public static void main(String[] args) {
		FutureTask<String> demoFutureTask = new FutureTask < String>(new FutureTaskDemo(), "success");
		ExecutorService exec = Executors.newFixedThreadPool(1);
		exec.execute(demoFutureTask);
		boolean done = false;
		while (!done) {
			done = demoFutureTask.isDone();
			System.out.println(done);
			exec.shutdownNow();
		}
	}
}

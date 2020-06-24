package futuretask;

import java.util.concurrent.*;

public class FutureTaskDemo implements Callable<ResultObj> {


	public static void main(String[] args) {
		FutureTaskDemo demo = new FutureTaskDemo();
		ResultObj objT = new ResultObj();
		demo.setResultObj(objT);
		FutureTask<ResultObj> demoFutureTask = new FutureTask<>(demo);
		ExecutorService exec = Executors.newFixedThreadPool(1);
		exec.execute(demoFutureTask);
		boolean done = false;
		while (!done) {
			done = demoFutureTask.isDone();
			try {
				ResultObj obj = demoFutureTask.get();
				System.out.println(obj);
				ResultObj obj1 = demo.getResultObj();
				obj1.setContent("obj1");
				System.out.println(obj);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println(done);
			exec.shutdownNow();
		}
	}

	private ResultObj resultObj;

	public ResultObj getResultObj() {
		return resultObj;
	}

	public void setResultObj(ResultObj resultObj) {
		this.resultObj = resultObj;
	}

	@Override
	public ResultObj call() throws Exception {
		System.out.println("running");
		ResultObj r = this.getResultObj();
		r.setFlag(0);
		setResultObj(r);
		return r;
	}

	@Override
	public String toString() {
		return "FutureTaskDemo{" +
				"resultObj=" + resultObj +
				'}';
	}
}

package productor_consumer.pc_blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
            ExecutorService service = Executors.newFixedThreadPool(2);
            service.submit(new PutRunable(queue));
            service.submit(new TackRunable(queue));
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

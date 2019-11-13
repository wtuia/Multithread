package productor_consumer.pc_blockingqueue;

import java.util.concurrent.BlockingQueue;

public class PutRunable implements Runnable{

    private BlockingQueue<Integer> queue;

    private int i = 0;

    public PutRunable(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.put(++i);
                System.out.println("size: " + queue.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

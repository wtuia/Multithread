package productor_consumer.pc_blockingqueue;

import java.util.concurrent.BlockingQueue;

public class TackRunable implements Runnable{
    private BlockingQueue<Integer> queue;

    private int i = 0;

    public TackRunable(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

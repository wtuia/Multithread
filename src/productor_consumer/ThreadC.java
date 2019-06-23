package productor_consumer;

public class ThreadC implements Runnable{

    private Consumer consumer;

    public ThreadC(Consumer consumer) {
        this.consumer = consumer;
    }


    @Override
    public void run() {
        while (true) {
            consumer.getValue();
        }
    }
}



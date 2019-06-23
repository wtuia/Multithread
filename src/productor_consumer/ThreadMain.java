package productor_consumer;

public class ThreadMain {

    public static void main(String[] args) {
        String lock = new String("");
        ObjectPool pool = new ObjectPool();
        Propdctor propdctor = new Propdctor(pool,lock);
        Consumer consumer = new Consumer(pool,lock);

        ThreadP threadP = new ThreadP(propdctor);
        ThreadC threadC = new ThreadC(consumer);

        Thread p = new Thread(threadP);
        Thread c = new Thread(threadC);

        p.start();
        c.start();

    }
}

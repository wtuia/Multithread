package productor_consumer.pc_thread;

public class ThreadP implements  Runnable{

    private Propdctor propdctor;

    public ThreadP(Propdctor propdctor) {
        this.propdctor = propdctor;
    }

    @Override
    public void run() {
        while (true) {
            propdctor.setValue();
        }
    }
}

package productor_consumer.pc_thread;

public class Propdctor   {
    private ObjectPool pool;
    private String lock;

    public  Propdctor(ObjectPool pool,String lock) {
        this.pool = pool;
        this.lock = lock;

    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (pool.getPool() == 0 ){
                    pool.setPool(pool.getPool() + 1);
                    System.out.println("生产者"+pool.getPool()+" "+Thread.currentThread().getName()+
                            System.currentTimeMillis());
                }else{
                    lock.wait();
                }
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 }

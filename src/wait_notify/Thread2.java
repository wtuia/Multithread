package wait_notify;

public class Thread2 extends Thread{

    String lock;
    ObjectNum num;

    public Thread2(String lock , ObjectNum num) {
        this.lock = lock;
        this.num = num;
    }

    @Override
    public void run() {
        while (num.getNum() > 0) {
            synchronized (lock) {
                try {
                    if (num.getNum() % 2 == 1) {
                        num.setNum(num.getNum()-1);
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}

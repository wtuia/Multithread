package wait_notify;

public class Thread1 extends Thread{

    String lock;
    ObjectNum num;

    public Thread1(String lock , ObjectNum num) {
        this.lock = lock;
        this.num = num;
    }

    @Override
    public void run() {
        while (num.getNum() > 0) {
            synchronized (lock){
                if (num.getNum() % 2 != 1) {
                    num.setNum(num.getNum()-1);
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

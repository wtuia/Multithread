package wait_notify;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        String lock = "";
        ObjectNum num = new ObjectNum();
        Thread t1 = new Thread1(lock, num);
        Thread t2 = new Thread2(lock, num);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("调用set= " + num.count);
    }
}

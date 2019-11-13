package threadlocal.mythreadlocal.question;


// 共享变量读写不一致的测试
public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        IntObj obj = new IntObj();
        myRunable t1 = new myRunable(obj);
        myRunable t2 = new myRunable(obj);
        t1.start();
        t2.start();
    }
}

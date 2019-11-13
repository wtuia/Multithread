package threadlocal.mythreadlocal.threadmap;


// 共享变量读写不一致的测试
public class ThreadTest {


    public static void main(String[] args) {
        IntObj obj = new IntObj();
        myThread run1 = new myThread(obj);
        myThread run2 = new myThread(obj);
        run1.start();
        run2.start();
    }
}

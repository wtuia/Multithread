package threadlocal.mythreadlocal.threadmap;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


class myThread extends Thread{

    private static Map<Thread, IntObj> threadLocalMap = new HashMap<>();

    private IntObj intObj;

    public myThread(IntObj obj) {
        this.intObj = obj;
    }

    @Override
    public void run() {
        IntObj obj = threadLocalMap.get(this);
        if (obj == null) {
            // 覆盖或新增
            try {
                threadLocalMap.put(this, (IntObj) intObj.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() +" "+
                threadLocalMap.get(Thread.currentThread()).getValue());
        int a = ThreadLocalRandom.current().nextInt(10);
        threadLocalMap.get(this).setValue(a);
        System.out.println(this.getName() + " set,,," + a);
        System.out.println(this.getName() + " run,,," +
                threadLocalMap.get(this).getValue());
    }
}

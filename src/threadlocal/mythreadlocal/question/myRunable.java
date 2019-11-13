package threadlocal.mythreadlocal.question;

import java.util.concurrent.ThreadLocalRandom;

class myRunable extends Thread{

    public myRunable(IntObj obj) {
        this.obj = obj;
    }

    private IntObj obj;
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName() +" "+obj.getValue());
            int a = ThreadLocalRandom.current().nextInt(10);
            obj.setValue(a);
            System.out.println(Thread.currentThread().getName() + " set,,," + a);
            System.out.println(Thread.currentThread().getName() + " run,,," + obj.getValue());
    }
}

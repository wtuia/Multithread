package threadlocal;

/**
 * ThreadLocal的用法
 */
public class MyThreadLocal {

    private static final ThreadLocal<Object> threadLocal =  new ThreadLocal<>();

    public static void main(String[] args) {
            new Thread(new MyIntegerTask("IntegerTask1")).start();
            new Thread(new MyIntegerTask("IntegerTask2")).start();
    }



   public static class MyIntegerTask implements Runnable{

        private String name;

        public MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0 ; i < 5 ; i++ ) {

                // ThreadLocal.get 获取线程变量
                if (null == MyThreadLocal.threadLocal.get() ) {
                   //set 设置变量
                   MyThreadLocal.threadLocal.set(0);
                    System.out.println("线程" + name + ": 0");

                } else {

                    int num = (Integer)MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(num + 1);
                    System.out.println("线程" + name + ":" + MyThreadLocal.threadLocal.get() );
                    if (i == 3) {
                        MyThreadLocal.threadLocal.remove();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}




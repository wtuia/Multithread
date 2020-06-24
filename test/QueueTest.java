import org.junit.Test;

import java.io.InputStream;
import java.sql.Time;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  2(7) + 2(5) + 2(2) + 1
 *  *   = 2 (2(6) + 2(4) + 2(1) ) + 1
 *  *   = 2 x 2(2(5)+2(3) + 2(0)) + 1
 *  * 1010 0101 165
 *  * 1010 10 0101 5
 */
public class QueueTest {

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static int ctlOf(int rs, int wc) { return rs | wc; }
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        System.out.printf("COUNT_BITS:%d%n", COUNT_BITS);
        System.out.printf("CAPACITY:%d%n", CAPACITY);
        System.out.printf("RUNNING:%d%n", RUNNING);
        System.out.printf("SHUTDOWN:%d%n", SHUTDOWN);
        System.out.printf("STOP:%d%n", STOP);
        System.out.printf("TIDYING:%d%n", TIDYING);
        System.out.printf("TERMINATED:%d%n", TERMINATED);
        System.out.printf("ctl:%s%n", ctl);
        System.out.printf("isRunning:%d%n", ctl.get() & CAPACITY);
        System.out.printf("workCount:%d%n", ctl.get() +1 & CAPACITY);
        System.out.printf("workCount:%d%n", ctl.get() +2 & CAPACITY);
    }

    @Test
    public void test1() {
    	String exp = "a1==0";
		System.out.println(exp);
		exp = exp.replaceAll("a\\d+(!?=.++)", "$1");
		System.out.println(exp);
    }
}

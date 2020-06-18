package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    CountDownLatch countDownLatch = new CountDownLatch(1);
    CyclicBarrier barrier = new CyclicBarrier(2);

    public void foo(Runnable printFoo) throws InterruptedException{
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            countDownLatch.countDown();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            countDownLatch.await();
            countDownLatch = new CountDownLatch(1);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();

            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

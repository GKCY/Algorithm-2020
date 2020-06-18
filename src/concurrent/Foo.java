package concurrent;

import java.util.concurrent.CountDownLatch;

public class Foo {

    CountDownLatch countDownLatch1 = new CountDownLatch(1);
    CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

//class Foo {
//
//    public Foo() {
//
//    }
//
//    volatile boolean firstFinished = false;
//    volatile boolean secondFinished = false;
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        firstFinished = true;
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (!firstFinished) {
//
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        secondFinished = true;
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (!secondFinished) {
//
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}

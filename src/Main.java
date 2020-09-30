import java.util.Scanner;

class thread {
    static synchronized void print() throws InterruptedException {
        System.out.println("hello1");
        Thread.sleep(100001111);
    }

    synchronized  void print1() {
        System.out.println("hello");
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        thread t = new thread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

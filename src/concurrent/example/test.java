package concurrent.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });
        executorService.shutdown();
    }
}

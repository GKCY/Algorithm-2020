package concurrent.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {

    public static void main(String[] args) {
        here:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(String.format("%d %d", i, j));
//                break here;
            }
        }
    }
}

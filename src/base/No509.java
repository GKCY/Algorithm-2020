package base;

public class No509 {
    public int fib(int N) {
        if (N <= 1)
            return N;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= N; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}

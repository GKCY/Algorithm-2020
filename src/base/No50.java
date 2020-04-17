package base;

public class No50 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = - N;
            x = 1/x;
        }
        return fastPow(x, N);
    }

    public double fastPow(double x, long n) {
        if (n == 0)
            return 1.0;
        double half = fastPow(x, n/2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    public double solution2(double x, long n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = - N;
        }
        double res = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {    // 或者 (N & 1) == 1
                res *= x;
            }
            x = x * x;
            N /= 2;   // 或者 N >>= 1 (位运算）
        }
        return res;
    }

    public static void main(String[] args) {
        No50 t = new No50();
        System.out.println(t.myPow(1.0, Integer.MIN_VALUE));
    }


}

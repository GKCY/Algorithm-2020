package base;

public class No201 {
    public int rangeBitwiseAnd1(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            shift++;
            m >>= 1;
            n >>= 1;
        }
        return m << shift;
    }
}

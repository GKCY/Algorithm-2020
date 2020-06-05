package base;

public class No264 {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        int[] res = new int[1691];
        res[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int two = res[i2] * 2;
            int three = res[i3] * 3;
            int five = res[i5] * 5;
            int newUglyNumber = Math.min(Math.min(two, three), five);
            if (newUglyNumber == two) i2++;
            if (newUglyNumber == three) i3++;
            if (newUglyNumber == five) i5++;
            res[i] = newUglyNumber;
        }
        return res[n];
    }
}

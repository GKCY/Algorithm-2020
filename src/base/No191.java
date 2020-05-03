package base;

import java.util.HashMap;

public class No191 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n-1);
        }
        return sum;
    }
}

package base;

import tool.Utils;

public class No338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0)
                res[i] = res[i >> 1];
            else
                res[i] = res[i-1] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Utils.printArrays(new No338().countBits(2));
    }
}

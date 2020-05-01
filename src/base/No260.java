package base;

import java.util.Arrays;

public class No260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int value = 0;
        for (int num : nums) {
            value ^= num;
        }
        int bit = 1;
        while ((value & bit) == 0)
            bit <<= 1;
        for (int num : nums) {
            if ((num & bit) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}

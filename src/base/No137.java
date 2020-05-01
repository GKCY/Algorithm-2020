package base;

public class No137 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 31; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                count[i] += nums[j] & 1;
                nums[j] >>= 1;
            }
            count[i] %= 3;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | count[i];
        }
        return res;
    }
}

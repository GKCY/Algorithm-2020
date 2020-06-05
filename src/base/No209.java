package base;

public class No209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, length = Integer.MAX_VALUE, sum = 0;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= s) {
                if (r - l < length)
                    length = r - l;
                sum -= nums[l++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(No209.minSubArrayLen(7, nums));
    }
}

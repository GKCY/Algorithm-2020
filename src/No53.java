public class No53 {
    public int maxSubArray(int[] nums) {
        int pre, max;
        pre = max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre < 0)
                pre = nums[i];
            else
                pre = nums[i] + pre;
            max = Math.max(pre, max);
        }
        return max;
    }
}

package base;

public class No209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int minStep = 0, sum = 0;
        int l = 0, r = -1;
        while (r < nums.length) {
            if (sum < s) {
                if (r == nums.length-1)
                    break;
                sum += nums[++r];
            } else if (sum >= s) {
                int step = r - l + 1;
                if (minStep == 0 || step < minStep)
                    minStep = step;
                sum -= nums[l];
                l++;
            }
        }
        return minStep;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(No209.minSubArrayLen(7, nums));
    }
}

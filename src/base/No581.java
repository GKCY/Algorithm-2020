package base;

public class No581 {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int max = nums[0], min = nums[length-1];
        int left = length - 1, right = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= max)
                max = nums[i];
            else
                right = i;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] <= min)
                min = nums[i];
            else
                left = i;
        }

        int res = right - left + 1;
        return res <= 0 ? 0 : res;

    }
}

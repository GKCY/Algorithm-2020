package base;

import java.util.Arrays;

public class No31 {
    public void nextPermutation(int[] nums) {
        int k = nums.length-1;
        while (k > 0 && nums[k-1] >= nums[k])
            k--;
        if (k == 0){
            Arrays.sort(nums);
            return;
        }
        int j = k;
        while (j < nums.length && nums[j] > nums[k-1])
            j++;
        j--;
        int temp = nums[j];
        nums[j] = nums[k-1];
        nums[k-1] = temp;
        Arrays.sort(nums, k, nums.length);
        //这题的两个sort可以换成reverse操作，要排序的部分一定是倒序的，复杂度降到O(n)
    }
}

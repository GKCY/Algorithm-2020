package base;

import tool.Utils;

public class No215 {

    public int findKthLargest(int[] nums, int k) {
        partion(nums, 0, nums.length-1, k-1);
        return nums[k-1];
    }

    public void partion(int[] nums, int i, int j, int k) {
        if (i >= j)
            return;
        int left = i, right = j;
        int target = nums[i];
        while (left < right) {
            while (nums[left] >= target && left < j)
                left++;
            while (nums[right] <= target && right > i)
                right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[i] = nums[right];
        nums[right] = target;
        if (right == k)
            return;
        else if (right > k)
            partion(nums, i, right-1, k);
        else if (right < k)
            partion(nums, right+1, j, k);

    }

    public static void main(String[] args) {
        No215 t = new No215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(t.findKthLargest(nums, 4));
        Utils.printArrays(nums);
    }
}



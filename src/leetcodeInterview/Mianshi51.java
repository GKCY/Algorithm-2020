package leetcodeInterview;

import tool.Utils;

public class Mianshi51 {
    int res = 0;
    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        merge(nums, 0, nums.length-1);
        Utils.printArrays(nums);
        return res;
    }

    public void merge(int[] nums, int i, int j) {
        int size = (j - i) + 1;
        if (size <= 1)
            return;
        int mid = (i + j) / 2;
        merge(nums, i, mid);
        merge(nums, mid + 1, j);
        int l = i, r = mid + 1, ptr = 0;
        while (l <= mid && r <= j) {
            if (nums[l] <= nums[r]) {
                temp[ptr] = nums[l++];
                res += r - mid - 1;
            } else {
                temp[ptr] = nums[r++];
            }
            ptr++;
        }

        while (l <= mid) {
            temp[ptr++] = nums[l++];
            res += j - mid;
        }
        while (r <= j)
            temp[ptr++] = nums[r++];
        for (int k = 0; k < size; k++) {
            nums[i + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(new Mianshi51().reversePairs(nums));
    }
}

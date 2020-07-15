package sort.array;

import tool.Utils;

public class Merge {
    public void merge(int[] nums, int i, int j) {
        if (i == j)
            return;
        int mid = (i + j) / 2;
        merge(nums, i, mid);
        merge(nums, mid + 1, j);
        int size = j - i + 1;
        int lptr = i, rptr = mid + 1, ptr = 0;
        while (lptr <= mid && rptr <= j) {
            if (nums[lptr] <= nums[rptr]) {
                tmp[ptr] = nums[lptr];
                lptr++;
            } else {
                tmp[ptr] = nums[rptr];
                rptr++;
            }
            ptr++;
        }
        while (lptr <= mid)
            tmp[ptr++] = nums[lptr++];
        while (rptr <= j)
            tmp[ptr++] = nums[rptr++];
        for (int k = 0; k < size; k++)
            nums[i + k] = tmp[k];
        return;
    }

    int[] tmp;
    public void merge(int[] nums) {
        tmp = new int[nums.length];
        merge(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {6,5,1,9,0,2,8,1};
        new Merge().merge(nums);
        Utils.printArrays(nums);
    }

}

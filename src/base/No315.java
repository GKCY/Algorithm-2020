package base;

import tool.Utils;

import java.util.*;

public class No315 {
    int[] copy;
    int[] temp;
    Integer[] res;
    int[] nums;
    private boolean compare(int i, int j) {
        return nums[copy[i]] <= nums[copy[j]];
    }
    public List<Integer> countSmaller(int[] nums) {
        this.nums = nums;
        copy = new int[nums.length];
        temp = new int[nums.length];
        res = new Integer[nums.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < nums.length; i++) {
            copy[i] = i;
        }
        merge(0, nums.length-1);
        return Arrays.asList(res);
    }

    private void merge(int i, int j) {
        if (j <= i)
            return;
        int size = j - i + 1;
        int mid = (i + j) / 2;
        merge(i, mid);
        merge(mid+1, j);
        int l = i, r = mid + 1, ptr = 0;
        while (l <= mid && r <= j) {
            if (compare(l, r)) {
                res[copy[l]] += r - mid - 1;
                temp[ptr] = copy[l++];
            } else
                temp[ptr] = copy[r++];
            ptr++;
        }
        while (l <= mid) {
            res[copy[l]] += j - mid;
            temp[ptr++] = copy[l++];
        }
        while (r <= j)
            temp[ptr++] = copy[r++];
        for (int k = 0; k < size; k++) {
            copy[i+k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new No315().countSmaller(nums));
    }
}

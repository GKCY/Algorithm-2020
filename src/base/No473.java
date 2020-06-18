package base;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class No473 {
    public boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        if (nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0)
            return false;
        int sideLength = sum / 4;
        int[] sides = new int[4];

        return backtrack(nums, sides, 0, sideLength);
    }

    public boolean backtrack(int[] nums, int[] sides, int start, int sideLength) {
        if (start == nums.length) {
            if (sides[0] == sideLength && sides[1] == sideLength
                        && sides[2] == sideLength && sides[3] == sideLength)
            return true;
        }

        if (nums[start] > sideLength)
            return false;

        for (int i = 0; i < 4; i++) {
            if (sides[i] + nums[start] <= sideLength) {
                sides[i] += nums[start];
                if (backtrack(nums, sides, start + 1, sideLength))
                    return true;
                sides[i] -= nums[start];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2};
        System.out.println(new No473().makesquare(nums));
    }
}
package base;

import java.util.Random;

public class No384 {
    int[] original;
    int[] res;
    Random rand;
    public No384(int[] nums) {
        rand = new Random();
        original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        res = original.clone();
        for (int i = 0; i < res.length; i++) {
            swap(res, i, randIndex(i, res.length-1));
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int randIndex(int start, int end) {
        return rand.nextInt(end + 1 - start) + start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
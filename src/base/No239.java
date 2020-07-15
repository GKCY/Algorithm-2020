package base;

import tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class No239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> maxQueue = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {
            while (!maxQueue.isEmpty() && maxQueue.getLast() < nums[i])
                maxQueue.pollLast();
            maxQueue.offerLast(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = maxQueue.getFirst();
                if (maxQueue.getFirst() == nums[i - k + 1])
                    maxQueue.pollFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Utils.printArrays(new No239().maxSlidingWindow(nums, 3));
    }
}

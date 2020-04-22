package base;

import tool.Tools;

import java.util.Stack;

public class No503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > stack.peek())
                stack.pop();
            stack.push(nums[i]);
        }
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek())
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}

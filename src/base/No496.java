package base;

import tool.Tools;

import java.util.HashMap;
import java.util.Stack;

public class No496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek())
                stack.pop();
            int value = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], value);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

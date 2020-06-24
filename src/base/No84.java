package base;

import java.util.Arrays;
import java.util.Stack;

public class No84 {
    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int index = i;
            while (index >= 0 && heights[index] >= heights[i]) {
                left = index;
                index--;
            }
            int right = i;
            index = i;
            while (index < heights.length && heights[index] >= heights[i]) {
                right = index;
                index++;
            }
            int area = (right - left + 1) * heights[i];
            max = Math.max(area, max);
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        int[] left = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if (stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();
            stack.push(i);
        }

        int max = 0;
        stack = new Stack<>();
        for (int i = heights.length-1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            int right;
            if (stack.empty())
                right = heights.length;
            else
                right = stack.peek();
            int area = (right - left[i] - 1) * heights[i];
            max = Math.max(max, area);
            stack.push(i);
        }

        return max;
    }

    public int largestRectangleArea3(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                right[index] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (right[i] - left[i] - 1) * heights[i];
            max = Math.max(max, area);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                int area = heights[index] * (i - left[index] - 1);
                max = Math.max(max, area);
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int area = (heights.length - left[index] - 1) * heights[index];
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
//        int[] nums = {1,1};
        System.out.println(new No84().largestRectangleArea(nums));
    }
}

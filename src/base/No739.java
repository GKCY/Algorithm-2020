package base;

import java.util.Stack;

public class No739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length-1; i >= 0; i--) {
            while (!stack.empty() && T[i] > T[stack.peek()])
                stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}

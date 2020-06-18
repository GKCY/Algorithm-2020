package competition;

import tool.Tools;

import java.util.Stack;

public class No5420 {
    public static int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        int[] minus = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()])
                stack.pop();
            if (stack.isEmpty())
                minus[i] = -1;
            else
                minus[i] = prices[stack.peek()];
            stack.push(i);
        }
        for (int i = 0; i < prices.length; i++) {
            res[i] = minus[i] == -1 ? prices[i] : prices[i] - minus[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4};
        Tools.printArrays(No5420.finalPrices(nums));
    }
}

package base;

import java.util.ArrayDeque;
import java.util.Deque;

public class No32 {
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(s.length()+1);
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.size() == 1 || s.charAt(stack.peek()) == ')')
                    stack.push(i);
                else if (s.charAt(stack.peek()) == '(') {
                    int pre = stack.pop();
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                dp[i] = 0;
            else {
                if(s.charAt(i-1) == '(')
                    dp[i] = i - 2 >= 0 ? dp[i-2] + 2 : 2;
                else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    dp[i] = (i - dp[i-1] - 1 > 0 ? dp[i-dp[i-1]-2] : 0) + dp[i-1] + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        return res;
    }

    public static void main(String[] args) {
        String s ="(()(()))";
        System.out.println(new No32().longestValidParentheses(s));
    }
}

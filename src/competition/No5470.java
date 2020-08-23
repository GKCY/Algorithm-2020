package competition;

import java.util.Stack;

public class No5470 {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push('(');
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    if (i + 1 == s.length() || s.charAt(i+1) == '(') {
                        res += 2;
                    } else if (s.charAt(i+1) == ')') {
                        res++;
                        i++;
                    }
                } else if (stack.peek() == '(') {
                    stack.pop();
                    if (i + 1 == s.length() || s.charAt(i+1) == '(')
                        res++;
                    else if (s.charAt(i+1) == ')')
                        i++;
                }

            }
        }
        int left = 0, right = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(')
                left++;
            else
                right++;
        }
        res += right / 2 + (right % 2 * 2);
        res += left * 2;
        return res;
    }

    public static void main(String[] args) {
        // "))(()()))()))))))()())()(())()))))()())(()())))()("
        String s = "))(()()))()))))))()())()(())()))))()())(()())))()(";
        System.out.println(new No5470().minInsertions(s));
    }
}

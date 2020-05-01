package base;

import java.util.Stack;

public class No150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            int a, b;
            switch (str) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(No150.evalRPN(tokens));
    }
}

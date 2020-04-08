import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class No20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.add(')');
            else if (c == '[')
                stack.add(']');
            else if (c == '{')
                stack.add('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

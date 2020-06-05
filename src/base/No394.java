package base;

import java.util.Stack;

public class No394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int multi = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                numStack.add(multi);
                stringStack.add(res.toString());
                res = new StringBuilder();
                multi = 0;
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                temp.append(stringStack.pop());
                int times = numStack.pop();
                String str = res.toString();
                for (int i = 0; i < times; i++)
                    temp.append(str);
                res = temp;
            } else if (ch >= '0' && ch <= '9') {
                multi = multi * 10 + ch - '0';
            } else
                res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        No394 t = new No394();
        String s = "3[a2[c]]";
        System.out.println(t.decodeString(s));
    }
}

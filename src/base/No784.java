package base;

import java.util.ArrayList;
import java.util.List;

public class No784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(res, S, 0, new StringBuilder());
        return res;
    }

    public void backtrack(List<String> res, String s,
                          int cur, StringBuilder builder) {
        if (cur == s.length()) {
            res.add(builder.toString());
            return;
        }
        char ch = s.charAt(cur);

        if ((ch >='a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            String c = String.valueOf(ch).toLowerCase();
            builder.append(c);
            backtrack(res, s, cur+1, builder);
            builder.deleteCharAt(builder.length()-1);

            c = c.toUpperCase();
            builder.append(c);
            backtrack(res, s, cur+1, builder);
            builder.deleteCharAt(builder.length()-1);
        } else {
            builder.append(ch);
            backtrack(res, s, cur+1, builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No784().letterCasePermutation("1"));
    }
}

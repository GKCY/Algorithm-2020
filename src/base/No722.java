package base;

import tool.Utils;

import java.util.ArrayList;
import java.util.List;

public class No722 {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String line : source) {
            int i = 0;
            while (i < line.length()) {
                if (!inBlock && line.charAt(i) == '/'
                        && i+1 < line.length() && line.charAt(i+1) == '*') {
                    i += 2;
                    inBlock = true;
                } else if (!inBlock && line.charAt(i) == '/'
                        && i+1 < line.length() && line.charAt(i+1) == '/') {
                    break;
                } else if (!inBlock) {
                    builder.append(line.charAt(i));
                    i++;
                } else if (inBlock && line.charAt(i) == '*'
                        && i+1 < line.length() && line.charAt(i+1) == '/') {
                    i += 2;
                    inBlock = false;
                } else if (inBlock)
                    i++;
            }
            if (!inBlock && builder.length() > 0) {
                res.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] source = {"a/*comment", "line", "more_comment*/b"};
        String[] s2 = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        System.out.println(new No722().removeComments(s2));
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class No71 {
    public String mysolution(String path) {
        String[] directory = path.split("/");
        LinkedList<String> builder = new LinkedList<>();
        for (String str : directory) {
            if (str.equals("."))
                continue;
            else if (str.equals("..")) {
                if (builder.isEmpty())
                    continue;
                else {
                    builder.removeLast();
                }
            } else if (!str.equals(""))
                builder.add(str);
        }
        StringBuilder res = new StringBuilder();
        if (builder.isEmpty())
            res.append("/");
        for (String str :
                builder) {
            res.append("/");
            res.append(str);
        }
        return res.toString();
    }

    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : s) {
            if (!stack.isEmpty() && str.equals(".."))
                stack.pop();
            else if (!str.equals("") && !str.equals(".") && !str.equals(".."))
                stack.push(str);
        }

        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        No71 t = new No71();
        System.out.println(t.simplifyPath("/a//b////c/d//././/.."));
    }
}

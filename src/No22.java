import java.util.ArrayList;
import java.util.List;

public class No22 {
    static public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        if (n == 1)
            res.add("()");
        else {
            path(builder, n, n, res);
        }
        return res;
    }

    static public void path(StringBuilder builder, int open, int close, List<String> res){
        if (open == 0 && close == 0) {
            res.add(builder.toString());
        }

        if (open > close)
            return;
        if (open > 0){
            builder.append('(');
            path(builder, open-1, close, res);
            builder.delete(builder.length()-1, builder.length());
        }
        if (close > 0){
            builder.append(')');
            path(builder, open, close-1, res);
            builder.delete(builder.length()-1, builder.length());
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }
}

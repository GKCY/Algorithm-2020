package base;

import java.util.ArrayList;
import java.util.List;

public class No241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input.length() == 0)
            return res;
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.valueOf(input));
            return res;
        }

        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, length));
                for (int leftRes: left) {
                    for (int rightRes : right) {
                        switch (c) {
                            case '+':
                                res.add(leftRes+rightRes);
                                break;
                            case '-':
                                res.add(leftRes-rightRes);
                                break;
                            case '*':
                                res.add(leftRes*rightRes);
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        System.out.println(new No241().diffWaysToCompute(input));
    }

}

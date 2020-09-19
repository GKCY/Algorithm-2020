package base;

public class No557 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (res.length() != 0)
                    res.append(" ");
                res.append(word.reverse().toString());
                word = new StringBuilder();
            } else {
                word.append(ch);
            }
        }
        if (word.length() != 0) {
            if (res.length() != 0)
                res.append(" ");
            res.append(word.reverse().toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new No557().reverseWords(s));
    }
}

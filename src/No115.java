import java.util.*;

public class No115 {
//    public String reverseWords(String s) {
//        List<String> strs = Arrays.asList(s.trim().split("\\s+"));
//        Collections.reverse(strs);
//        return String.join(" ", strs);
//    }
    public String reverseWords(String s) {
        int left = 0, right = s.length()-1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        while (left <= right) {
            if (s.charAt(left) == ' ') {
                if (builder.length() != 0) {
                    deque.offerFirst(builder.toString());
                    builder.delete(0, builder.length());
                }
            } else {
                builder.append(s.charAt(left));
            }
            left++;
        }
        deque.offerFirst(builder.toString());
        return String.join(" ", deque);
    }

    public static void main(String[] args) {
        String str = "   a   b  c d   e  ";
        No115 t = new No115();
        System.out.println(t.reverseWords(str));
    }


}

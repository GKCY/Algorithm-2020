package base;

import java.util.LinkedList;

public class No402 {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (char c : num.toCharArray()) {
            int digit = Character.getNumericValue(c);
            while (!queue.isEmpty() && queue.getLast() > digit && k > 0) {
                queue.removeLast();
                k--;
            }
            queue.offerLast(digit);
        }

        while (k-- > 0)
            queue.pollLast();

        while (!queue.isEmpty() && queue.getFirst() == 0)
            queue.pollFirst();

        StringBuilder builder = new StringBuilder();
        for (int digit : queue)
            builder.append(digit);

        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 2;
        System.out.println(new No402().removeKdigits(num, k));
    }
}

package competition;

public class No5396 {
    public static int maxPower(String s) {
        if (s.length() == 0)
            return 0;
        char ch = '1';
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            if (c != ch) {
                count = 1;
                ch = c;
            } else {
                count++;
            }
            if (count > max)
                max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(No5396.maxPower("tourist"));
    }
}

package base;

public class No168 {
    public static String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        char ch;
        while (n > 0) {
            int ascii = n % 26;
            if (ascii == 0) {
                ch = 'Z';
                n = n / 26 - 1;
            }
            else {
                ch = (char) (n % 26 - 1 + 'A');
                n /= 26;
            }
            builder.insert(0, ch);

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(No168.convertToTitle(701));
    }
}

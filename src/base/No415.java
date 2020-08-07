package base;

public class No415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int l = Math.max(l1, l2);
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= l; i++) {
            int c1 = l1 - i >= 0 ? num1.charAt(l1-i) - '0' : 0;
            int c2 = l2 - i >= 0 ? num2.charAt(l2-i) - '0' : 0;
            int sum = c1 + c2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            res.insert(0, sum);
        }
        if (carry != 0)
            res.insert(0, carry);
        return res.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "123";
        System.out.println(new No415().addStrings(num1, num2));
    }
}

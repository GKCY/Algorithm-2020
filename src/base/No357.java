package base;

public class No357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int res = 9;
        int carry = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            carry = carry * (10 - i + 1);
            res = res + carry;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(new No357().countNumbersWithUniqueDigits(3));
    }
}

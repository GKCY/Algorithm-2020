package base;

public class No367 {
    public static boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        long left = 1, right = num / 2;
        while (left <= right) {
            long mid = (left + right) / 2;
            long square = mid * mid;
            if (square == num)
                return true;
            else if (square > num)
                right = mid - 1;
            else if (square < num)
                left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(536848900 * 536848900);
        System.out.println(No367.isPerfectSquare(2147395600));
    }
}

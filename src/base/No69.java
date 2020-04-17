package base;

public class No69 {
      // 会逸出
//    public int mySqrt(int x) {
//        if (x == 0)
//            return 0;
//        int low = 1, high = x;
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            int temp = mid * mid;
//            if (temp == x)
//                return mid;
//            else if (temp > x)
//                high = mid - 1;
//            else if (temp < x)
//                low = mid + 1;
//        }
//        return high;
//    }

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        double a = x;
        double b = (a + x / a) / 2;
        while (a - b > 0.1) {
            a = b;
            b = (a + x / a) / 2;
        }
        return (int)Math.floor(b);
    }
}

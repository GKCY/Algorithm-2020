package base;

import java.util.HashSet;

public class No202 {
    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = calculate(slow);
            fast = calculate(fast);
            fast = calculate(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public int calculate(int n) {
        int res = 0;
        while (n != 0) {
            int num = n % 10;
            res += num * num;
            n /= 10;
        }
        return res;
    }
}

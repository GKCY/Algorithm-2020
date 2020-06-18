package leetcodeInterview;

import java.util.Arrays;
import java.util.HashMap;

public class Mianshi46 {

    public int translateNum1(int num) {
        String nums = String.valueOf(num);
        int[] dp = new int[nums.length()+1];
        dp[1] = dp[0] = 1;
        for (int i = 2; i < nums.length()+1; i++) {
            int pre = (nums.charAt(i-2) - '0') * 10 + nums.charAt(i-1) - '0';
            if (pre > 25 || nums.charAt(i-2) == '0')
                dp[i] = dp[i-1];
            else
                dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length()];
    }

    public int translateNum(int num) {
        int pre = 1, cur = 1, y = num % 10;
        num /= 10;
        while (num != 0) {
            int n = num % 10;
            int r;
            if (n * 10 + y <= 25 && n * 10 + y >= 10)
                r = pre + cur;
            else
                r = cur;
            pre = cur;
            cur = r;
            y = n;
            num /= 10;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Mianshi46().translateNum(624));
    }
}

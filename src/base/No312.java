package base;

import tool.Utils;

import java.util.Arrays;

public class No312 {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length+2];
        arr[0] = arr[length+1] = 1;
        for (int i = 1; i <= length; i++)
            arr[i] = nums[i-1];
        int[][] dp = new int[length+2][length+2];

        for (int i = length+1; i >= 0; i--) {
            for (int j = i+1; j <= length+1; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k] + dp[k][j] + arr[i]*arr[k]*arr[j]);
                }
            }
        }
        Utils.printMatrix(dp);
        return dp[0][length+1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(new No312().maxCoins(nums));
    }
}

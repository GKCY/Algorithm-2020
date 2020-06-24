package base;

public class No494 {
    int res = 0;
    int target;
    public int findTargetSumWays(int[] nums, int S) {
        this.target = S;
        dfs(nums, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int curSum, int start) {
        if (start == nums.length) {
            if (curSum == target)
                res++;
            return;
        }
        dfs(nums, curSum + nums[start], start + 1);
        dfs(nums, curSum - nums[start], start + 1);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int offset = 0;
        for (int num : nums)
            offset += num;
        if (S < -offset || S > offset)
            return 0;

        offset++;
        int size = offset * 2 + 1;
        int[][] dp = new int[nums.length][size];
        //不直接赋值
        //防止nums[0]==0
        dp[0][nums[0] + offset]++;
        dp[0][-nums[0] + offset]++;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < size-1; j++) {
                int dp1 = j - nums[i] >= 0 ? dp[i-1][j-nums[i]] : 0;
                int dp2 = j + nums[i] < size ? dp[i-1][j+nums[i]]: 0;
                dp[i][j] = dp1 + dp2;
            }
        }
        return dp[nums.length-1][S+offset];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(new No494().findTargetSumWays2(nums, 0));
    }
}

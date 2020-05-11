package base;

public class No416 {

    //二维dp
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        boolean[][] dp = new boolean[nums.length][sum/2+1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < sum/2 + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    if (j == nums[0])
                        dp[i][j] = true;
                    continue;
                }
                boolean formula1 = dp[i-1][j];
                boolean formula2 = j - nums[i] >= 0 ? dp[i-1][j-nums[i]] : false;
                dp[i][j] = formula1 || formula2;
            }
        }
        return dp[nums.length-1][sum/2];
    }



    //一维dp
    private int total = 0;
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        total = sum >> 1;
        boolean[] dp = new boolean[total+1];
        dp[0] = true;
        if (nums[0] <= total)
            dp[nums[0]] = true;
        else
            return false;

        for (int i = 1; i < nums.length; i++) {
            for (int j = total; j >= nums[i]; j--) {
                if (dp[total])
                    return true;
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[total];
    }

    //DFS 暴力,超时
    private int target = 0;
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        target = sum / 2;
        return dfs(nums, 0, 0);
    }

    public boolean dfs(int[] nums, int curSum, int start) {
        if (curSum > target)
            return false;
        if (curSum == target)
            return true;

        if (start == nums.length)
            return false;

        return dfs(nums, curSum, start+1)
                || dfs(nums, curSum+nums[start], start+1);
    }

    public static void main(String[] args) {
        int[] nums = {100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100,100,
                100,100,100,100,100};
        System.out.println(new No416().canPartition3(nums));
    }

}

public class No300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        int[] dp = new int[length];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < length; i++) {
            int max = 0; // max初始化为0， 不可以是Integer.MIN_VALUE!!!
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max+1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int solution2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num: nums) {
            int i = 0, j = res;
            while (i < j){
                int mid = (i + j) / 2;
                if (tails[mid] < num)
                    i = mid +1;
                else if (tails[mid] >= num)
                    j = mid;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }

}

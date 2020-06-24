package base;

public class No45 {
//    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        Tools.printArrays(dp);
//        for (int i = nums.length-2; i >= 0; i--) {
//            int min = Integer.MAX_VALUE-100;
//            int step = nums[i];
//            for (int j = i + 1; j <= i + step && j < nums.length; j++) {
//                min = Math.min(min, dp[j] + 1);
//            }
//            dp[i] = min;
//            Tools.printArrays(dp);
//        }
//        return dp[0];
//    }
    public int jump(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(new No45().jump(nums));
    }
}

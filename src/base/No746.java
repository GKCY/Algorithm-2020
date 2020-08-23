package base;

public class No746 {
    public int minCostClimbingStairs(int[] cost) {
        int pre = cost[0], cur = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = cur;
            cur = Math.min(pre, cur) + cost[i];
            pre = temp;
        }
        return Math.min(pre, cur);
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new No746().minCostClimbingStairs(cost));
    }
}

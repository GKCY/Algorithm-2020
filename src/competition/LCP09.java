package competition;

public class LCP09 {
    public static int minJump(int[] jump) {
        int[] dp = new int[jump.length];
        int left = jump.length;
        for (int i = jump.length - 1; i >= 0; i--) {
            if (i + jump[i] > jump.length - 1) {
                left = i;
                dp[i] = 1;
            }
        }
        /** 注意点：
         *  1. 新的left既可能在旧left的左边也可能在右边，不是一定在左边
         *  2. left左边的可能已经有结果了
         *     所以要判断if (dp[i] != 0) continue;
         *  3. 每次循环只找到值为count+1的index，所以在left左边搜索时
         *     一定要满足dp[dst] == count
         */
        int count = 1;
        while (dp[0] == 0) {
            int temp = -1;
            for (int i = jump.length - 1; i > left; i--) {
                if (dp[i] == 0) {
                    dp[i] = count + 1;
                    temp = i;
                }
            }
            for (int i = left - 1; i >= 0; i--) {
                if (dp[i] != 0)
                    continue;
                int dst = i + jump[i];
                if (dp[dst] == count) {
                    dp[i] = dp[dst] + 1;
                    temp = i;
                }
            }
            left = temp;
            count++;
        }
        return dp[0];
    }
}

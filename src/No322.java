import java.util.Arrays;

public class No322 {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        res[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin :
                    coins) {
                if (i-coin >= 0 && res[i-coin] != Integer.MAX_VALUE) {
                    min = Math.min(res[i-coin]+1, min);
                }
                }
            res[i] = min;
        }
        return res[amount];
    }



    public static void main(String[] args) {
        No322 t = new No322();
        int[] num = {1, 2, 5};
        System.out.println(t.coinChange(num, 11));

    }

}

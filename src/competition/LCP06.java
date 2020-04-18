package competition;

public class LCP06 {
    public static int minCount(int[] coins) {
        if (coins.length == 0)
            return 0;
        int res = 0;
        for (int coin:
             coins) {
            if (coin % 2 == 0)
                res += coin / 2;
            else
                res += coin / 2 + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(LCP06.minCount(new int[]{2,3,10}));
    }
}

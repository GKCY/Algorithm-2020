public class No70 {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int index = 2;
        int p1 = 1, p2 = 2;
        int res = -1;
        while (index != n) {
            index++;
            res = p1 + p2;
            p1 = p2;
            p2 = res;
        }
        return res;
    }
}

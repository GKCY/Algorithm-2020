package base;

public class No1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = Integer.MIN_VALUE;
        int max = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, max + A[i] - i);
            max = Math.max(max, A[i] + i);
        }
        return res;
    }
}

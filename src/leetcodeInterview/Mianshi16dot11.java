package leetcodeInterview;

public class Mianshi16dot11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)
            return new int[0];
        if (shorter == longer)
            return new int[]{shorter * k};
        int[] res = new int[k+1];
        for (int i = 0; i < k + 1; i++) {
            res[i] = (k - i) * shorter + i * longer;
        }
        return res;
    }
}

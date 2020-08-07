package base;

public class No413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int res = 0, dist = A[1] - A[0], count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i-1] == dist) {
                count++;
            } else {
                dist = A[i] - A[i-1];
                res += cal(count);
                count = 1;
            }
        }
        res += cal(count);
        return res;
    }

    public int cal(int count) {
        if (count < 2)
            return 0;
        count += 1;
        int res = (count - 1) * (count - 2) / 2;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new No413().numberOfArithmeticSlices(nums));
    }
}

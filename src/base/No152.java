package base;

public class No152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num :
                nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(num, imax * num);
            imin = Math.min(num, imin * num);

            max = Math.max(max, imax);
        }
        return max;
    }
}

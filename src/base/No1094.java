package base;

public class No1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] count = new int[1001];
        for (int[] trip :
                trips) {
            count[trip[1]] += trip[0];
            count[trip[2]] -= trip[0];
        }

        int sum = 0;
        for (int i = 0; i < 1001; i++) {
            sum += count[i];
            if (sum > capacity)
                return false;
        }
        return true;
    }
}

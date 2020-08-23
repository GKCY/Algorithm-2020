package base;

public class No495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1 || timeSeries[i] + duration < timeSeries[i+1])
                res += duration;
            else
                res += timeSeries[i+1] - timeSeries[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        int duration = 2;
        System.out.println(new No495().findPoisonedDuration(timeSeries, duration));
    }
}

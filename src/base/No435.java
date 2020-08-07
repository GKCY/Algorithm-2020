package base;

import java.util.Arrays;

public class No435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (l >= end) {
                end = r;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2}};
        System.out.println(new No435().eraseOverlapIntervals(intervals));
    }
}
